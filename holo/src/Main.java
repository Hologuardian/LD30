package holo.src;

import holo.src.render.GameRender;
import holo.src.states.GameState;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame
{
	public Main()
	{
		super("World Hopper");
	}

	public static void main(String[] args) throws SlickException
	{
		AppGameContainer app = new AppGameContainer(new Main());
		  
        app.setDisplayMode(GameRender.windowWidth, GameRender.windowHeight, false);
        
        app.setShowFPS(true);
        
        if (app.isUpdatingOnlyWhenVisible())
        	app.setUpdateOnlyWhenVisible(false);
        
        app.setVSync(false);

        app.start();
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException 
	{
		this.addState(new GameState(this));
	}

}
