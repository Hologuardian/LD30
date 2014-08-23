package holo.src.entity;

import holo.src.item.*;
import holo.src.render.*;
import holo.src.worlds.*;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class EntityPlayer extends EntityLiving implements InputListener
{
	public Shape boundingBox = new Rectangle(0, 0, 16, 16);
	
	public EntityPlayer(int x, int y, World world) throws SlickException
	{
		super(x, y, world, "res/textures/entity/Player.png");
	}

	@Override
	public String getName()
	{
		return "Player";
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
	
	public String getTextureName()
	{
		return "res.textures.entity.Player.png";
	}

	@Override
	public float getHealth()
	{
		return 20;
	}

	@Override
	public float getArmor()
	{
		return 0;
	}
	
	@Override
	public void attack(EnumItemType itemType, ItemWeapon weapon, Shape attackBox)
	{
		switch(itemType)
		{
		case SWORD:
			Entity e = world.isCollidingWithEntity(attackBox);
			if(e != null)
			{
				
			}
			break;
		case BOW:
			break;
		case DAGGER:
			break;
		default:
			break;
		}
	}
	
	public void interact()
	{
		
	}
	
	@Override
	public float getMoveSpeed()
	{
		return 0.15F;
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount)
	{
		
	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3)
	{
		
	}

	@Override
	public void mouseWheelMoved(int change)
	{
		
	}

	@Override
	public void mousePressed(int button, int x, int y)
	{
		
	}

	@Override
	public void mouseReleased(int button, int x, int y)
	{
		
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy)
	{
		this.lookAt(new Vector2f(newx + GameRender.camera.getX()- GameRender.windowWidth / 2, newy + GameRender.camera.getY()- GameRender.windowHeight / 2));
		this.faceAt(new Vector2f(newx + GameRender.camera.getX()- GameRender.windowWidth / 2, newy + GameRender.camera.getY()- GameRender.windowHeight / 2));
	}

	@Override
	public void setInput(Input input)
	{
		
	}

	@Override
	public boolean isAcceptingInput()
	{
		return true;
	}

	@Override
	public void inputEnded()
	{
		
	}

	@Override
	public void inputStarted()
	{
		
	}

	@Override
	public void keyPressed(int key, char c)
	{
		if(key == Input.KEY_A)
			this.addSpeed(this.getMoveSpeed() * -1, 0);
		if(key == Input.KEY_D)
			this.addSpeed(this.getMoveSpeed(), 0);
		if(key == Input.KEY_W)
			this.addSpeed(0, this.getMoveSpeed() * -1);
		if(key == Input.KEY_S)
			this.addSpeed(0, this.getMoveSpeed());
		if(key == Input.KEY_E)
			this.interact();
	}

	@Override
	public void keyReleased(int key, char c)
	{
		if(key == Input.KEY_A)
			this.addSpeed(this.getMoveSpeed(), 0);
		if(key == Input.KEY_D)
			this.addSpeed(this.getMoveSpeed() * -1, 0);
		if(key == Input.KEY_W)
			this.addSpeed(0, this.getMoveSpeed());
		if(key == Input.KEY_S)
			this.addSpeed(0, this.getMoveSpeed() * -1);
	}

	@Override
	public void controllerLeftPressed(int controller)
	{
		
	}

	@Override
	public void controllerLeftReleased(int controller)
	{
		
	}

	@Override
	public void controllerRightPressed(int controller)
	{
		
	}

	@Override
	public void controllerRightReleased(int controller)
	{
		
	}

	@Override
	public void controllerUpPressed(int controller)
	{
		
	}

	@Override
	public void controllerUpReleased(int controller)
	{
		
	}

	@Override
	public void controllerDownPressed(int controller)
	{
		
	}

	@Override
	public void controllerDownReleased(int controller)
	{
		
	}

	@Override
	public void controllerButtonPressed(int controller, int button)
	{
		
	}

	@Override
	public void controllerButtonReleased(int controller, int button)
	{
		
	}

}
