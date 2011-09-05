package nightmare.droid.love.core;

public class GameCore implements IUpdateable {

	public enum GameState{
		OPENING,		
		MAINMENU		
	}
	
	GameState gameState;
	
	public void Update(){
		switch(gameState){
		case OPENING:
			break;
		case MAINMENU:
			break;
		}
	}
}
