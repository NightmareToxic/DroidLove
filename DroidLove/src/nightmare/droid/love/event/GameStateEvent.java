package nightmare.droid.love.event;

import java.util.EventObject;

import nightmare.droid.love.core.GameCore.GameState;

public class GameStateEvent extends EventObject{
	
	private static final long serialVersionUID = 1L;
	
	public GameState gameState;

    public GameStateEvent(Object source, GameState gameState){    
    	super(source); 
    	this.gameState = gameState;
    }
}
