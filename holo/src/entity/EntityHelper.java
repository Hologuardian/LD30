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
		case 1:
			try
			{
				return new EntityMelee((int)pos.getX(), (int)pos.getY(), world, "src/res/textures/entity/MeleeDark.png", new Rectangle(0, 0, 14, 16), "Melee Dark", 34, 6, 0.015F);
			}
			catch (SlickException e)
			{
				e.printStackTrace();
			}
		case 2:
			try
			{
				return new EntityMelee((int)pos.getX(), (int)pos.getY(), world, "src/res/textures/entity/Ray.png", new Rectangle(0, 0, 24, 14), "Ray", 18, 0, 0.045F);
			}
			catch (SlickException e)
			{
				e.printStackTrace();
			}
		case 3:
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
