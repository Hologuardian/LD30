package holo.src.entity;

import holo.src.item.Inventory;
import holo.src.item.Item;
import holo.src.worlds.World;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;

public abstract class EntityLiving extends Entity
{
	public Vector2f speed;
	public Vector2f looking;
	public Vector2f facing;
	public World world;
	
	public Inventory inventory;
	public Image texture;

	public EntityLiving(int x, int y, World world) throws SlickException 
	{
		super(x, y);
		this.world = world;
		speed = new Vector2f();
		looking = new Vector2f();
		facing = new Vector2f();
		texture = new Image("res/textures/entity/Player.png");
	}

	public void update(int delta) 
	{
		Vector2f s = this.speed.copy().scale(delta);
		
		Vector2f px = this.getPosition().copy().add(new Vector2f(s.getX(), 0));
		Vector2f py = this.getPosition().copy().add(new Vector2f(0, s.getY()));
		if(!world.isColliding(this.getBBWithLocation(px)))
		{
			this.addPosition(s.getX(), 0);
		}
		if(!world.isColliding(this.getBBWithLocation(py)))
		{
			this.addPosition(0, s.getY());
		}
	}
	
	public void setSpeed(float x, float y)
	{
		this.speed.set(x, y);
	}
	
	public void addSpeed(float x, float y)
	{
		this.speed.add(new Vector2f(x, y));
	}
	
	public void setLooking(float x, float y)
	{
		this.looking.set(x, y);
	}
	
	public void addLooking(float x, float y)
	{
		this.looking.add(new Vector2f(x, y));
	}
	
	public void lookAt(Vector2f v)
	{
		this.looking = this.getCenterPosition().copy().sub(v);
	}
	
	public Vector2f getLooking()
	{
		return this.looking;
	}
	
	public void setFacing(float x, float y)
	{
		this.facing.set(x, y);
	}
	
	public void addFacing(float x, float y)
	{
		this.facing.add(new Vector2f(x, y));
	}
	
	public void faceAt(Vector2f v)
	{
		this.facing = this.getCenterPosition().copy().sub(v);
	}
	
	public Vector2f getFacing()
	{
		return this.facing;
	}
	
	public Item getHeldItem(Item item)
	{
		return inventory.getSelectedItem();
	}
	
	public void selectItem(int slot)
	{
		inventory.selectItem(slot);
	}
	
	public Inventory getInventory()
	{
		return inventory;
	}
	
	public Image getImage()
	{
		return texture;
	}
	
	public World getWorld()
	{
		return world;
	}
	
	public abstract String getTextureName();
	public abstract float getMoveSpeed();
}
