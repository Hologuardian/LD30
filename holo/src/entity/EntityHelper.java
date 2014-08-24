package holo.src.entity;

import holo.src.worlds.World;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class EntityHelper
{
	public static Entity makeEntity(int id, World world, Vector2f pos)
	{
		switch(id)
		{
		case 0:
			try
			{
				return new EntityMelee((int)pos.getX(), (int)pos.getY(), world, "src/res/textures/entity/Melee.png", new Rectangle(0, 0, 16, 16), "Melee", 15, 2, 0.02F);
			}
			catch (SlickException e)
			{
				e.printStackTrace();
			}
		default:
			return null;
		}
	}
}
