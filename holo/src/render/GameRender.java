package holo.src.render;

import holo.src.entity.Entity;
import holo.src.entity.EntityLiving;
import holo.src.entity.EntityPlayer;
import holo.src.lighting.LightSource;
import holo.src.tile.Tile;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class GameRender 
{
	public static float scale = 1.0F;
	public static int windowWidth = 1080;
	public static int windowHeight = 720;
	public int[][][] lightMap;
	public int[][][] lightMapTemp;
	
	public static Vector2f camera = new Vector2f(0, 0);
	
	public ArrayList<Tile> tilesToRender = new ArrayList<Tile>();
	public ArrayList<Entity> entitiesToRender = new ArrayList<Entity>();
//	public ArrayList<Decoration> decorationsToRender = new ArrayList<Decoration>();
	
	public ArrayList<Tile> tilesToAdd = new ArrayList<Tile>();
	public ArrayList<Entity> entitiesToAdd = new ArrayList<Entity>();
//	public ArrayList<Decoration> decorationsToAdd = new ArrayList<Decoration>();
	
	public ArrayList<Tile> tilesToRemove = new ArrayList<Tile>();
	public ArrayList<Entity> entitiesToRemove = new ArrayList<Entity>();
//	public ArrayList<Decoration> decorationsToRemove = new ArrayList<Decoration>();
	
	public GameRender()
	{
		
	}
	
	public void addTileToRenderList(Tile tile)
	{
		tilesToAdd.add(tile);
	}
	
	public void addEntityToRenderList(Entity entity)
	{
		entitiesToAdd.add(entity);
	}
	
//	public void addDecorationToRenderList(Decoration decor)
//	{
//		decorationsToAdd.add(decor);
//	}
	
	public void removeTileFromRenderList(Tile tile)
	{
		tilesToRemove.add(tile);
	}
	
	public void removeEntityFromRenderList(Entity entity)
	{
		entitiesToRemove.add(entity);
	}
	
//	public void removeDecorationFromRenderList(Decoration decor)
//	{
//		decorationsToRemove.add(decor)
//	}
	
	public void updateRenderLists()
	{
		for(Tile t : tilesToAdd)
		{
			tilesToRender.add(t);
		}
		tilesToAdd.clear();
		for(Entity e : entitiesToAdd)
		{
			entitiesToRender.add(e);
		}
		entitiesToAdd.clear();
//		for(Decoration d : decorationsToAdd)
//		{
//			decorationsToRender.add(d);
//		}
//		decorationsToAdd.clear();
		
		for(Tile t : tilesToRemove)
		{
			tilesToRender.remove(t);
		}
		tilesToRemove.clear();
		for(Entity e : entitiesToRemove)
		{
			entitiesToRender.remove(e);
		}
		entitiesToRemove.clear();
		
		lightMap = lightMapTemp;
		
//		for(Decoration d : decorationsToRemove)
//		{
//			decorationsToRender.remove(d);
//		}
//		decorationsToRemove.clear();
	}
	
	public void update(GameContainer gc, Graphics g)
	{
		this.updateRenderLists();
		
		for(Tile t : tilesToRender)
		{
			this.renderTile(gc, g, t);
		}
		
		for(Entity e : entitiesToRender)
		{
			if(e instanceof EntityPlayer)
				continue;
			if(e instanceof EntityLiving)
				this.renderEntityLiving(gc, g, (EntityLiving)e);
			else
				this.renderEntity(gc, g, e);
		}
		
//		for(Decoration d : decorationsToRender)
//		{
//			this.renderDecoration(gc, g, d);
//		}
		
		renderLighting(gc, g);
	}
	
	public void renderLighting(GameContainer gc, Graphics g)
	{
		for(int i = 0; i < lightMap.length; ++i)
		{
			for(int j = 0; j < lightMap[0].length; ++j)
			{
				Color c = new Color(lightMap[i][j][0], lightMap[i][j][1], lightMap[i][j][2], lightMap[i][j][3]);
				int s = LightSource.size;
				float x = j * s - camera.getX() + windowWidth / 2;
				float y = i * s - camera.getY() + windowHeight / 2;
				for(int k = 0; k < s; ++ k)
				{
					g.drawGradientLine(x, y + k, c, x + s, y + k, c);
				}
			}
		}
	}
	
	public void renderTile(GameContainer gc, Graphics g, Tile tile)
	{
		Image image = tile.getTexture().copy();
		float x = tile.getCoords().getX() * Tile.size - camera.getX() + windowWidth / 2;
		float y = tile.getCoords().getY() * Tile.size - camera.getY() + windowHeight / 2;
		g.drawImage(image, x, y);
	}
	
	public void renderEntity(GameContainer gc, Graphics g, Entity entity)
	{
		
	}
	
	public void renderEntityLiving(GameContainer gc, Graphics g, EntityLiving entity)
	{
		Image image = entity.getImage().copy();
		image.rotate((float) entity.facing.negate().getTheta());
		
		float x = entity.getPosition().getX() + entity.getBB().getWidth() / 2 - camera.getX() + windowWidth / 2;
		float y =entity.getPosition().getY() + entity.getBB().getHeight() / 2 - camera.getY() + windowHeight / 2;
		
		image.drawCentered(x, y);
		
	}
}
