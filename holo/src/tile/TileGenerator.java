package holo.src.tile;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;


public class TileGenerator
{
	public static Tile createTile(int id, int x, int y) throws SlickException
	{
		switch(id)
		{
		case 0:
			return new Tile(new Vector2f(x, y), "res/textures/tile/Ground.png", false);
		case 1:
			return new Tile(new Vector2f(x, y), "res/textures/tile/Wall.png", true);
		default:
			return null;
		}
	}
}
