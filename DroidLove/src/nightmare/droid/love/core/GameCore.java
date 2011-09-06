package nightmare.droid.love.core;

import java.util.Vector;

import nightmare.droid.love.event.GameStateEvent;
import nightmare.droid.love.event.GameStateListener;
import nightmare.droid.love.views.GameScreen;
import nightmare.droid.love.views.Opening;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.scene.Scene;

public class GameCore{

	Vector<GameStateListener> subscribers = new Vector<GameStateListener>(); 
	GameScreen currentScene;
	
	private void OnGameStateChanged(GameState gameState){
		for(int i=0, size = subscribers.size(); i < size; i++){
			((GameStateListener)subscribers.get(i)).onGameStateChanged(new GameStateEvent(this, gameState));
		}
    }
    
    public void addGameStateListener(GameStateListener ensl){

    subscribers.add(ensl); 

    }

     public void removeGameStateListener(GameStateListener ensl){

    subscribers.remove(ensl); 
    }
	
	public enum GameState{
		NONE,
		OPENING,		
		MAINMENU		
	}
	
	public GameCore(){
		this.gameState = GameState.NONE;
	}
	
	GameState gameState;
	
	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		if (gameState != this.gameState){
			this.gameState = gameState;
			OnGameStateChanged(gameState);
		}
	}

	public void loadCurrentScene(Scene scene,Engine engine) {	
		if (currentScene!=null){
			currentScene.destroyScene();
		}
		switch(gameState){
		case OPENING:
			currentScene = new Opening(scene,engine);
			break;
		case MAINMENU:
			break;
		}
		
		currentScene.createScene();
	}
}
