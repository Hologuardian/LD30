package holo.src.item;

import org.newdawn.slick.Image;

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
	
	public abstract void onUpdate();
	
	public Image getIdleImage()
	{
		return idleImage;
	}
	
	public Image[] getAnimation()
	{
		return images;
	}
}
