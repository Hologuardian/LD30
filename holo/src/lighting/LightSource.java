package holo.src.lighting;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Vector2f;

public class LightSource
{
	public Color color;
	public int strength;
	public static int size = 6; // width of each light pixel
	public Vector2f pos;
	
	public LightSource(Vector2f pos, int strength, Color color)
	{
		this.pos = pos;
		this.strength = strength;
		this.color = color;
	}
	
	public Vector2f getPosInArray()
	{
		float x = pos.getX() / size;
		float y = pos.getY() / size;
		return new Vector2f(x, y);
	}
	
	public Vector2f getPos()
	{
		return pos;
	}
	
	public void setPos(Vector2f newPos)
	{
		pos = newPos;
	}
	
	public void addPos(Vector2f v)
	{
		pos.add(v);
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public int getStrength()
	{
		return strength;
	}
}
