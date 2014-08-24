package holo.src.entity;

import holo.src.entity.ai.Path;
import holo.src.item.ItemWeapon;
import holo.src.worlds.World;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;

public class EntityMelee extends EntityLiving
{
	public float maxHealth;
	public float maxArmor;
	public String entityName;
	public float moveSpeed;
	public Path path;
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param world
	 * @param texture
	 * @param bb
	 * @param name
	 * @param hp
	 * @param arm
	 * @param speed
	 * @throws SlickException
	 */
	public EntityMelee(int x, int y, World world, String texture, Shape bb, String name, float hp, float arm, float speed) throws SlickException
	{
		super(x, y, world, texture);
		entityName = name;
		maxHealth = hp;
		maxArmor = arm;
		moveSpeed = speed;
		this.bb = bb;
	}
	
	public void update(int delta)
	{
		super.update(delta);
		
		EntityLiving e = world.findTarget(400, this.getCenterPosition());
		if(e != null)
		{
			if(this.path == null)
			{
				this.path = new Path(this.world, this.getCenterPosition(), e.getCenterPosition());
			}
			this.path.updatePath(this.getCenterPosition(), e.getCenterPosition());
		}
		
		if(this.path != null)
		{
			if(this.path.getPath().get(0).distance(this.getCenterPosition()) <= this.getBB().getBoundingCircleRadius() * 1.5)
			{
				this.path.getPath().remove(0);
			}
			
			this.lookAt(this.path.getPath().get(0));
			this.faceAt(this.path.getPath().get(0));
			Vector2f v = this.looking.copy().normalise().negate().scale(this.getMoveSpeed());
			this.setSpeed(v.getX(), v.getY());
		}
		
	}

	@Override
	public void attack(EnumItemType itemType, ItemWeapon weapon, Shape attackBox)
	{
		
	}

	@Override
	public String getTextureName()
	{
		return this.texture.getName();
	}

	@Override
	public float getMoveSpeed()
	{
		return moveSpeed;
	}

	@Override
	public float getHealth()
	{
		return maxHealth;
	}

	@Override
	public float getArmor()
	{
		return maxArmor;
	}

	@Override
	public String getName()
	{
		return entityName;
	}

	@Override
	public boolean isCollidable()
	{
		return true;
	}

	@Override
	public Shape getBB()
	{
		return this.bb;
	}

	@Override
	public int getWieght()
	{
		return 5;
	}

}
