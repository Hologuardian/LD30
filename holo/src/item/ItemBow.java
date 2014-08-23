package holo.src.item;

import holo.src.entity.EntityArrow;
import holo.src.entity.EntityLiving;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public class ItemBow extends ItemWeapon
{
	public int attackTimer;
	public Class<?> arrowClass;
	
	public ItemBow(String[] textures, Class<?> arrowClass, int attackTimer)
	{
		super(textures);
		this.attackTimer = attackTimer;
		this.arrowClass = arrowClass;
		;
	}

	@Override
	public void attack(EntityLiving entity)
	{
		Vector2f f = entity.facing.copy().normalise();
		Shape bb = entity.getBBWithLocation();
		Vector2f position = new Vector2f(bb.getCenterX(), bb.getCenterY());
		Vector2f centerPoint = position.copy();//.add(f.getPerpendicular().scale(entity.getBB().getBoundingCircleRadius()).negate());
		centerPoint.add(f.copy().scale(bb.getBoundingCircleRadius()).negate());
		centerPoint.add(f.copy().add(45).negate());
		
		try
		{
			Class<?> arrow = Class.forName(arrowClass.getName());
			EntityArrow a;
			try
			{
				a = (EntityArrow) arrow.newInstance();
				a.setShooter(entity);
				a.setFacing(entity.facing);
				entity.world.addEntity(a);
			}
			catch (InstantiationException | IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public int getAttackTimer()
	{
		return this.attackTimer;
	}

	@Override
	public float getDamage()
	{
		return 0;
	}

	@Override
	public void render(GameContainer gc, Graphics g, EntityLiving e, float xMod, float yMod)
	{
		
	}

}
