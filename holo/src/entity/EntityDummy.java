package holo.src.entity;

import holo.src.item.ItemWeapon;
import holo.src.worlds.World;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class EntityDummy extends EntityLiving
{
	public Shape boundingBox = new Rectangle(0, 0, 16, 16);

	public EntityDummy(int x, int y, World world) throws SlickException
	{
		super(x, y, world, "res/textures/entity/Dummy.png");
	}

	@Override
	public void attack(EnumItemType itemType, ItemWeapon weapon, Shape attackBox)
	{
		
	}

	@Override
	public String getTextureName()
	{
		return "res.textures.entity.Dummy.png";
	}

	@Override
	public float getMoveSpeed()
	{
		return 0.12F;
	}

	@Override
	public float getHealth()
	{
		return 999999;
	}

	@Override
	public float getArmor()
	{
		return 25;
	}

	@Override
	public String getName()
	{
		return "Dummy";
	}

	@Override
	public boolean isCollidable()
	{
		return true;
	}

	@Override
	public Shape getBB()
	{
		return boundingBox;
	}

}
