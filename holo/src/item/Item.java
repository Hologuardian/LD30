package holo.src.item;

import holo.src.entity.EntityLiving;

import org.newdawn.slick.*;

public abstract class Item
{
	public Image idleImage;
	public Image[] images;
	
	public Item(String[] textures)
	{
		try
		{
			images = new Image[textures.length];
			for(int i = 0; i < textures.length; ++i)
			{
				images[i] = new Image(textures[i]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		idleImage = images[0];
		for(int i = 0; i < images.length - 1; ++i)
		{
			images[i] = images[i + 1];
		}
	}
	
	public abstract void onUse(EntityLiving entity);
	public abstract void render(GameContainer gc, Graphics g, EntityLiving e, float xMod, float yMod);
	
	public Image getIdleImage()
	{
		return idleImage;
	}
	
	public Image[] getAnimation()
	{
		return images;
	}
}
