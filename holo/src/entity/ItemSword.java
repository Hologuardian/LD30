package holo.src.entity;

import org.newdawn.slick.geom.*;

import holo.src.item.ItemWeapon;

public class ItemSword extends ItemWeapon
{
	public float length;
	public float arc;
	public int attackTimer;
	public float damage;
	
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
		Vector2f centerPoint = entity.pos.copy().add(new Vector2f(entity.getBB().getWidth(), entity.getBB().getHeight()));
		Vector2f frontPoint = centerPoint.add(f.copy().scale(length));
		Vector2f leftPoint = centerPoint.add(frontPoint.copy().add(-(arc / 2)));
		Vector2f rightPoint = centerPoint.add(frontPoint.copy().add(arc/2));
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
}
