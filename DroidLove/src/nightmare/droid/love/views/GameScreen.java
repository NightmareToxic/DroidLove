package nightmare.droid.love.views;

import nightmare.droid.core.GameCore;
import nightmare.droid.helper.Wrapper;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.scene.Scene;

import android.content.res.AssetManager;

public abstract class GameScreen{
	public abstract void createScene();
	public abstract void destroyScene();
	
	private Scene scene;
	private Engine engine;
	private AssetManager assets;
	private GameCore core;
	private boolean done;
	protected final Wrapper<Integer> sceneState = new Wrapper<Integer>(0);
	protected final Wrapper<Float> sceneElapsedTime = new Wrapper<Float>(0f);
	
	public AssetManager getAssets() {
		return assets;
	}
	public GameCore getCore() {
		return core;
	}
	public GameScreen(){
		this.done=false;
	}
	
	public void init(Scene scene, Engine engine, AssetManager assets,GameCore core){
		this.scene = scene;
		this.engine = engine;
		this.assets = assets;
		this.core = core;
	}

	public Scene getScene() {
		return scene;
	}

	public Engine getEngine() {
		return engine;
	}

	public boolean isDone(){
		return done;
	}
	
}
