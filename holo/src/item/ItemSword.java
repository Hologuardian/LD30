package holo.src.item;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

import holo.src.entity.EntityLiving;
import holo.src.entity.EnumItemType;

public class ItemSword extends ItemWeapon
{
	public float length;
	public float arc;
	public int attackTimer;
	public float damage;
	
	/**
	 * 
	 * @param textures
	 * @param length
	 * @param arc
	 * @param attackTimer
	 * @param damage
	 */
	public ItemSword(String[] textures, float length, float arc, int attackTimer, float damage)
	{
		super(textures);
		this.length = length;
		this.arc = arc;
		this.attackTimer = attackTimer;
		this.damage = damage;
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
		Vector2f frontPoint = centerPoint.copy().add(f.copy().scale(length).negate());
		Vector2f leftPoint = centerPoint.copy().add(f.copy().scale(length).add(-(arc / 2)).negate());
		Vector2f rightPoint = centerPoint.copy().add(f.copy().scale(length).add(arc/2).negate());
		Polygon poly = new Polygon(new float[]{centerPoint.getX(), centerPoint.getY(),
				leftPoint.getX(), leftPoint.getY(),
				frontPoint.getX(), frontPoint.getY(),
				rightPoint.getX(), rightPoint.getY()});
		
		entity.attack(EnumItemType.SWORD, this, poly);
	}
	
	@Override
	public int getAttackTimer()
	{
		return attackTimer;
	}
	
	@Override
	public float getDamage()
	{
		return damage;
	}

	@Override
	public void render(GameContainer gc, Graphics g, EntityLiving entity, float xMod, float yMod)
	{
		Vector2f f = entity.facing.copy().normalise();
		Shape bb = entity.getBBWithLocation();
		Vector2f position = new Vector2f(bb.getCenterX(), bb.getCenterY());
		Vector2f centerPoint = position.copy();//.add(f.getPerpendicular().scale(entity.getBB().getBoundingCircleRadius()).negate());
		centerPoint.add(f.copy().add(45).scale(bb.getBoundingCircleRadius()).negate());
		Vector2f frontPoint = centerPoint.copy().add(f.copy().scale(length).negate());
		
		if(entity.getAttackTimer() > 0)
		{
			Image i = this.getAnimation()[0].copy();
			i.rotate((float) f.negate().getTheta());
			Vector2f v = new Vector2f(i.getWidth() / 2, i.getHeight() / 2);
			v.add(f.negate().getTheta());
			i.drawCentered(frontPoint.getX() - v.getX() + xMod, frontPoint.getY() - v.getY() + yMod);
		}
		else
		{
			Image i = this.getIdleImage().copy();
			i.rotate((float) f.negate().getTheta());
			i.drawCentered(centerPoint.getX() + xMod, centerPoint.getY() + yMod);
		}
	}
}
