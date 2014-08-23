package holo.src.item;

import holo.src.entity.EntityLiving;

public abstract class ItemWeapon extends Item
{

	public ItemWeapon(String[] textures)
	{
		super(textures);
	}

	@Override
	public void onUse(EntityLiving entity)
	{
		if(entity.getAttackTimer() <= 0)
		{
			this.attack(entity);
			entity.setAttackTimer(this.getAttackTimer());
		}
	}
	
	public abstract void attack(EntityLiving entity);
	
	public abstract int getAttackTimer();
	public abstract float getDamage();
}
