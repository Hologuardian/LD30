package holo.src.worlds;

import java.util.ArrayList;

import holo.src.entity.*;
import holo.src.lighting.*;
import holo.src.render.*;
import holo.src.tile.*;
import holo.src.worlds.maps.*;

import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.*;

public class World
{
	public Tile[][] tileList;
	public ArrayList<Entity> entityList = new ArrayList<Entity>();
	public ArrayList<Entity> entitiesToAdd = new ArrayList<Entity>();
	
	public ArrayList<Shape> bbList = new ArrayList<Shape>();
	public StateBasedGame game;
	public GameRender render;
	public Map loadedMap;
	public int[][][] lightMap;
	public ArrayList<LightSource> lightArray = new ArrayList<LightSource>();
	
	public World(StateBasedGame game, GameRender render)
	{
		this.game = game;
		this.render = render;
	}
	
	public void update(int delta)
	{
		this.updateLighting();
		for(Entity e : entitiesToAdd)
		{
			entityList.add(e);
		}
		entitiesToAdd.clear();
	}
	
	public void addEntity(Entity e)
	{
		entitiesToAdd.add(e);
		render.addEntityToRenderList(e);
	}
	
	public boolean isColliding(Shape bb)
	{
		for(Shape bbox : bbList)
		{
			if(bb.intersects(bbox) && !bb.equals(bbox))
				return true;
		}
		return false;
	}
	
	public ArrayList<Entity> isCollidingWithEntity(Shape bb)
	{
		ArrayList<Entity> list = new ArrayList<Entity>();
		for(Entity e : entityList)
		{
			if(e.getBBWithLocation().intersects(bb))
			{
				list.add(e);
			}
		}
		return list;
	}
	
	public void updateLighting()
	{
		for(LightSource l : lightArray)
		{
			Vector2f p = l.getPosInArray();
			int x = (int)p.getX();
			int y = (int)p.getY();

			updateLight(x, y, l.getColor().r * 255, l.getColor().g * 255, l.getColor().b * 255, 255 - l.getStrength());
		}
		
		render.lightMapTemp = lightMap;
	}
	
	public void updateLight(int x, int y, float r, float g, float b, int strength)
	{
		if(strength > 255 || y >= lightMap.length || x >= lightMap[0].length)
			return;
		
		int modR = (int)((r / 255) * (255 - strength));
		int modG = (int)((g / 255) * (255 - strength));
		int modB = (int)((b / 255) * (255 - strength));
		int alpha = strength;
		
		if(lightMap[y][x][0] >= modR && lightMap[y][x][1] >= modG && lightMap[y][x][2] >= modB && lightMap[y][x][3] <= alpha)
			return;
		
		lightMap[y][x][0] = Math.max(lightMap[y][x][0], modR);
		lightMap[y][x][1] = Math.max(lightMap[y][x][1], modG);
		lightMap[y][x][2] = Math.max(lightMap[y][x][2], modB);
		lightMap[y][x][3] = Math.min(lightMap[y][x][3], alpha);
		
		if(x - 1 >= 0)
		{
			updateLight(x - 1, y, r, g, b, strength + LightSource.size);
		}
		if(x + 1 < lightMap[0].length)
		{
			updateLight(x + 1, y, r, g, b, strength + LightSource.size);
		}
		if(y - 1 >= 0)
		{
			updateLight(x, y - 1, r, g, b, strength + LightSource.size);
		}
		if(y + 1 < lightMap.length)
		{
			updateLight(x, y + 1, r, g, b, strength + LightSource.size);
		}
	}
	
	public void loadMap(Map map)
	{
		loadedMap = map;
		int[][] tileMap = map.tileMap;
		tileList = new Tile[tileMap.length][tileMap[0].length];
		lightMap = new int[map.lightMap.length][map.lightMap[0].length][4];
		for(LightSource l : map.lightList)
		{
			lightArray.add(l);
		}
		render.lightMap = lightMap.clone();
		render.lightMapTemp = lightMap.clone();
		
		for(int i = 0; i < lightMap.length; ++i)
		{
			for(int j = 0; j < lightMap[0].length; ++j)
			{
				lightMap[i][j][0] = 0;
				lightMap[i][j][1] = 0;
				lightMap[i][j][2] = 0;
				lightMap[i][j][3] = 255;
			}
		}
		
		for(int i = 0; i < tileMap.length; ++i)
		{
			for(int j = 0; j < tileMap[0].length; ++j)
			{
				try
				{
					Tile t = TileGenerator.createTile(tileMap[i][j], j, i);
					tileList[i][j] = t;
					if(t != null)
					{
						render.addTileToRenderList(t);
						if(t.getCollidable() == true)
							bbList.add(t.getBB());
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
