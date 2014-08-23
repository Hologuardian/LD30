package holo.src.states;

import holo.src.entity.*;
import holo.src.render.*;
import holo.src.worlds.World;
import holo.src.worlds.maps.Map;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState
{
	public EntityPlayer player;
	public GameRender render;
	public World world;
	
	public GameState(StateBasedGame game)
	{
		render = new GameRender();
		world = new World(game, render);
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException 
	{
		Map map = new Map("test");
		world.loadMap(map);
		player = new EntityPlayer((int)world.loadedMap.spawn.getX(), (int)world.loadedMap.spawn.getY(), world);
		EntityDummy dummy = new EntityDummy(250, 100, world);
		gc.getInput().addListener(player);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException 
	{
		g.clear();
		g.setBackground(Color.black);
		g.scale(GameRender.scale, GameRender.scale);
		render.update(gc, g);
		GameRender.camera.set((int)player.getPosition().getX(), (int)player.getPosition().getY());
		
		render.renderEntityLiving(gc, g, player);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException 
	{
//		player.update(delta);
		world.update(delta);
	}

	@Override
	public int getID() 
	{
		return 2;
	}

}
