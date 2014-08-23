package holo.src.worlds.maps;

import holo.src.lighting.LightSource;
import holo.src.tile.Tile;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Vector2f;

public class Map 
{
	public int width;
	public int height;
	public Vector2f spawn;
	public int[][] lightMap;
	public int[][] tileMap;
	public String[][] entityList;
	public String fileLoc;
	public ArrayList<LightSource> lightList = new ArrayList<LightSource>();
	public String[][] decorList;
	
	public Map(String file)
	{
		fileLoc = file;
		this.loadFile(file);
	}
	
	public void loadFile(String filename)
	{

		Scanner sc = null;
		try
		{
			File file = new File("src/res/maps/" + fileLoc);
			if (!file.exists())
			{
				System.out.println("No File! " + fileLoc);
				return;
			}
			
			sc = new Scanner(file);
			
			{
				String mapInfo = sc.nextLine();
				String[] mapDetails = mapInfo.split(" ");
				int mapWidth = Integer.valueOf(mapDetails[0]);
				int mapHeight = Integer.valueOf(mapDetails[1]);
				
				width = mapWidth;
				height = mapHeight;
				
				lightMap = new int[height * (Tile.size / LightSource.size)][width * (Tile.size / LightSource.size)];
				tileMap = new int[height][width];
				
				int numEntities = Integer.valueOf(mapDetails[2]);
				int numLights = Integer.valueOf(mapDetails[3]);
				int numDecorations = Integer.valueOf(mapDetails[4]);
				spawn = new Vector2f(Integer.valueOf(mapDetails[5]), Integer.valueOf(mapDetails[6]));
				
				entityList = new String[numEntities][3];
				decorList = new String[numLights][3];
				
				for(int i = 0; i < mapHeight; ++i)
				{
					for(int j = 0; j < mapWidth; ++j)
					{
						tileMap[i][j] = sc.nextInt();
					}
				}
				sc.nextLine();
				
				for(int i = 0; i < numEntities; ++i)
				{
					entityList[i] = sc.nextLine().split(" ");
				}
				
				for(int i = 0; i < numLights; ++i)
				{
					String[] s = sc.nextLine().split(" ");
					Vector2f v = new Vector2f(Integer.valueOf(s[0]), Integer.valueOf(s[1]));
					LightSource light = new LightSource(v, Integer.valueOf(s[2]), new Color(Integer.valueOf(s[3]), Integer.valueOf(s[4]), Integer.valueOf(s[5])));
					lightList.add(light);
				}
				
				for(int i = 0; i < numDecorations; ++i)
				{
					decorList[i] = sc.nextLine().split(" ");
				}
			}
			
			sc.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
}
