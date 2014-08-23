package holo.src.entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public abstract class Entity 
{
	public String name;
	public Shape bb;
	public Vector2f pos;
	
	public Entity(int x, int y)
	{
		name = this.getName();;
		bb = this.getBB();
		pos = new Vector2f(x, y);
	}
	
	public abstract String getName();
	
	public abstract void update(int delta);
	
	public abstract boolean isCollidable();
	
	public abstract Shape getBB();
	
	public abstract Image getImage();
	
	public void setPosition(float x, float y)
	{
		this.pos.set(x, y);
	}
	
	public void addPosition(float x, float y)
	{
		this.pos.add(new Vector2f(x, y));
	}
	
	public Vector2f getPosition()
	{
		return pos;
	}
	
	public Vector2f getCenterPosition()
	{
		return pos.copy().add(new Vector2f(this.getBB().getWidth() / 2, this.getBB().getHeight() / 2));
	}
	
	public Shape getBBWithLocation()
	{
		this.getBB().setX(this.pos.getX());
		this.getBB().setY(this.pos.getY());
		return this.getBB();
	}
	
	public Shape getBBWithLocation(Vector2f v)
	{
		Shape bb = this.getBB();
		bb.setX(v.getX());
		bb.setY(v.getY());
		return bb;
	}
	
	public abstract void setDead();
}
