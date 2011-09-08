package nightmare.droid.love;

import nightmare.droid.core.GameCore;
import nightmare.droid.event.GameStateEvent;
import nightmare.droid.event.GameStateListener;
import nightmare.droid.exceptions.InvalidGameStateException;
import nightmare.droid.love.core.DroidLoveGameStates;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.ui.activity.BaseGameActivity;

public class DroidLoveActivity extends BaseGameActivity {

	private static final int CAMERA_WIDTH = 480;
    private static final int CAMERA_HEIGHT = 800;
    
	private final Camera mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
    private GameCore gameCore;
	
	public Engine onLoadEngine() {
		gameCore = new GameCore(new DroidLoveGameStates());
		return new Engine(new EngineOptions(true, ScreenOrientation.PORTRAIT, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera));        
	}

	public void onLoadResources() {
	}

	public Scene onLoadScene() {
		this.getEngine().registerUpdateHandler(new FPSLogger(0.5f));
			
     	final Scene scene = new Scene();
     	
		gameCore.addGameStateListener(new GameStateListener(){
			public void onGameStateChanged(GameStateEvent e) {
				try{
					gameCore.loadCurrentScene(scene,getEngine(), getAssets());
				}catch(InvalidGameStateException ex){
					ex.printStackTrace();
				}
			}
		});
		
		gameCore.setGameState("OPENING");
     	
		return scene;
	}

	public void onLoadComplete() {	
	}
}