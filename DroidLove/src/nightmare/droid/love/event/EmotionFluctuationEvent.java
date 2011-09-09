package nightmare.droid.love.event;

import java.util.EventObject;

public class EmotionFluctuationEvent extends EventObject {
	
private static final long serialVersionUID = 1L;
	
	public float pElapsedSeconds;

    public EmotionFluctuationEvent(Object source, float pElapsedSeconds){    
    	super(source); 
    	this.pElapsedSeconds = pElapsedSeconds;
    }
}
