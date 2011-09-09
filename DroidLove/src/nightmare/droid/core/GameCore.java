package nightmare.droid.core;

import java.util.Vector;

import nightmare.droid.event.GameStateEvent;
import nightmare.droid.event.GameStateListener;
import nightmare.droid.exceptions.InvalidGameStateException;
import nightmare.droid.helper.Wrapper;
import nightmare.droid.love.views.GameScreen;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.scene.Scene;

import android.content.res.AssetManager;

public class GameCore{

	Vector<GameStateListener> subscribers = new Vector<GameStateListener>();
	Vector<GameScreen> scenes = new Vector<GameScreen>();
	IUpdateHandler screenHandler;
	GameScreen currentScene;
	int currentSceneIndex=0;
	Wrapper<Float> elapsedGameCoreTime = new Wrapper<Float>(0f);
	boolean sequenceMode=false;
	String gameState;
	GameStateMap gameStateMap;
	
	private void OnGameStateChanged(String gameState){
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
	
	
	public GameCore(GameStateMap map){
		this.gameState = "";
		this.gameStateMap = map;
	}
	
	
	
	public String getGameState() {
		return gameState;
	}

	public void setGameStateMap(GameStateMap map){
		this.gameStateMap = map;
	}
	
	public void setGameState(String gameState) {
		if (gameState != this.gameState){
			this.gameState = gameState;
			OnGameStateChanged(gameState);
		}
	}
	
	public void setGameSequence(final Scene scene, final Engine engine, final AssetManager assets, GameScreen... screens) throws InvalidGameStateException {
		for (GameScreen scr : screens){
			scenes.add(scr);
		}
				
		//Init
		currentScene = scenes.get(currentSceneIndex);
		loadCurrentScene(scene,engine,assets);	
		
		if (screenHandler!=null){
			engine.unregisterUpdateHandler(screenHandler);
			screenHandler= new IUpdateHandler(){
				public void onUpdate(float elapsedTimeInSeconds)  {
					if (currentScene.isDone()){
						currentSceneIndex++;
						if (currentSceneIndex == scenes.size()){
							sequenceMode=false;
							engine.unregisterUpdateHandler(this);
						}
						currentScene = scenes.get(currentSceneIndex);
						try {
							loadCurrentScene(scene,engine,assets);
						} catch (InvalidGameStateException e) {
							e.printStackTrace();
						}	
					}
				}
				public void reset() {
				}			
			};
		}
		
		engine.registerUpdateHandler(screenHandler);
		sequenceMode=true;
	}

	public void loadCurrentScene(Scene scene,Engine engine, AssetManager assets) throws InvalidGameStateException{	
		if (currentScene!=null){
			currentScene.destroyScene();
		}
	
		if (!sequenceMode){
			if (gameStateMap.containsKey(gameState)){
				currentScene = gameStateMap.get(gameState);			
			}else{
				throw new InvalidGameStateException(gameState);
			}
		}
		
		currentScene.init(scene, engine, assets,this);
		currentScene.createScene();
	}
}
