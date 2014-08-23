package holo.src.render;

import org.newdawn.slick.geom.Vector2f;

public class Camera
{
	public Vector2f pos;
	
	public Camera(float startX, float startY)
	{
		pos = new Vector2f(startX, startY);
	}
	
	public void setPosition(float newX, float newY)
	{
		pos.set(newX, newY);
	}
	
	public void setPosition(Vector2f v)
	{
		pos.set(v);
	}
	
	public void addPosition(float addX, float addY)
	{
		pos.add(new Vector2f(addX, addY));
	}
	
	public void addPosition(Vector2f v)
	{
		pos.add(v);
	}
	
	public Vector2f getCameraPosition()
	{
		return pos;
	}
	
	public float getX()
	{
		return pos.getX();
	}
	
	public float getY()
	{
		return pos.getY();
	}
}
