package nightmare.droid.event;

import java.util.EventObject;

public class GameStateEvent extends EventObject{
	
	private static final long serialVersionUID = 1L;
	
	public String gameState;

    public GameStateEvent(Object source, String gameState){    
    	super(source); 
    	this.gameState = gameState;
    }
}
