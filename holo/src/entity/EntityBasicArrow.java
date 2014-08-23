package holo.src.entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;

public class EntityBasicArrow extends EntityArrow
{
	public Shape bb = new Rectangle(0, 0, 18, 8);
	public Image image;
	
	public EntityBasicArrow()
	{
		super(0, 0);
		try
		{
			image = new Image("res/textures/entity/Arrow.png");
		}
		catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
	
	public EntityBasicArrow(int x, int y)
	{
		super(x, y);
		try
		{
			image = new Image("res/textures/entity/Arrow.png");
		}
		catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public float getDamage()
	{
		return 1;
	}

	@Override
	public Vector2f getSpeed()
	{
		return this.facing.copy().normalise().scale(0.3F);
	}

	@Override
	public String getName()
	{
		return "Basic Arrow";
	}

	@Override
	public Shape getBB()
	{
		return bb;
	}

	@Override
	public Image getImage()
	{
		return image;
	}

}
