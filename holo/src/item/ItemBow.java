package holo.src.item;

import holo.src.entity.*;

import org.newdawn.slick.*;

public class ItemBow extends ItemWeapon
{
	
	public ItemBow(String[] textures, EntityArrow arrow, int attackTimer, float damage)
	{
		super(textures);
	}

	@Override
	public void attack(EntityLiving entity)
	{
		
	}

	@Override
	public int getAttackTimer()
	{
		return 0;
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
