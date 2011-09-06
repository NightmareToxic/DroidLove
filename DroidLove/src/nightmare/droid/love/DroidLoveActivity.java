package nightmare.droid.love;

import nightmare.droid.love.core.GameCore;
import nightmare.droid.love.core.GameCore.GameState;
import nightmare.droid.love.event.GameStateEvent;
import nightmare.droid.love.event.GameStateListener;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.ui.activity.BaseGameActivity;

public class DroidLoveActivity extends BaseGameActivity {

	private static final int CAMERA_WIDTH = 720;
    private static final int CAMERA_HEIGHT = 480;
	private final Camera mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
    private GameCore gameCore;
	
	public Engine onLoadEngine() {
		gameCore = new GameCore();
		return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera));        
	}

	public void onLoadResources() {
	}

	public Scene onLoadScene() {
		this.getEngine().registerUpdateHandler(new FPSLogger(0.5f));
			
     	final Scene scene = new Scene();
     	
		gameCore.addGameStateListener(new GameStateListener(){
			public void onGameStateChanged(GameStateEvent e) {
				gameCore.loadCurrentScene(scene,getEngine());
			}
		});
		
		gameCore.setGameState(GameState.OPENING);
     	
		return scene;
	}

	public void onLoadComplete() {	
	}
}