package holo.src.entity;

import java.util.ArrayList;

import org.newdawn.slick.geom.*;


public abstract class EntityArrow extends Entity
{
	public EntityLiving shooter;
	public Vector2f facing = new Vector2f();

	public EntityArrow()
	{
		super(0,0);
	}

	public EntityArrow(int x, int y)
	{
		super(x, y);
	}

	@Override
	public void update(int delta)
	{
		Vector2f s = this.getSpeed().copy().scale(delta);

		Vector2f px = this.getPosition().copy().add(new Vector2f(s.getX(), 0));
		Vector2f py = this.getPosition().copy().add(new Vector2f(0, s.getY()));
		if(!this.shooter.world.isColliding(this.getBBWithLocation(px)))
		{
			this.addPosition(s.getX(), 0);
		}
		else
			this.setDead();
		if(!this.shooter.world.isColliding(this.getBBWithLocation(py)))
		{
			this.addPosition(0, s.getY());
		}
		else
			this.setDead();

		ArrayList<Entity> entities = this.shooter.world.isCollidingWithEntity(this.getBBWithLocation(px));
		for(Entity e : entities)
		{
			if(e != null && e instanceof EntityLiving && e != shooter)
			{
				((EntityLiving)e).takeDamage(this.getDamage(), EnumItemType.BOW, this.shooter);
				this.setDead();
			}
		}

	}

	@Override
	public boolean isCollidable()
	{
		return true;
	}

	public void setShooter(EntityLiving e)
	{
		shooter = e;
	}

	public void setFacing(Vector2f v)
	{
		this.facing.set(v);
	}

	public abstract float getDamage();
	public abstract Vector2f getSpeed();

	public void onCollideWithEntity()
	{

	}

	public void setDead()
	{
		this.shooter.world.removeEntity(this);
	}
}
