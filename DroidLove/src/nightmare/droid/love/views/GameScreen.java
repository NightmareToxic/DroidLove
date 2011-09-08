package nightmare.droid.love.views;

import nightmare.droid.helper.Wrapper;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.scene.Scene;

import android.content.res.AssetManager;

public abstract class GameScreen{
	public abstract void createScene();
	public abstract void destroyScene();
	
	protected Scene scene;
	protected Engine engine;
	protected AssetManager assets;
	protected boolean done;
	protected final Wrapper<Integer> sceneState = new Wrapper<Integer>(0);
	protected final Wrapper<Float> sceneElapsedTime = new Wrapper<Float>(0f);
	
	public GameScreen(){
		this.done=false;
	}
	
	public void init(Scene scene, Engine engine, AssetManager assets){
		this.scene = scene;
		this.engine = engine;
		this.assets = assets;
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
