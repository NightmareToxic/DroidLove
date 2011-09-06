package nightmare.droid.love.views;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.scene.Scene;

public abstract class GameScreen{
	public abstract void createScene();
	public abstract void destroyScene();
	
	protected Scene scene;
	protected Engine engine;
	
	public GameScreen(Scene scene, Engine engine){
		this.scene = scene;
		this.engine = engine;
	}

	public Scene getScene() {
		return scene;
	}

	public Engine getEngine() {
		return engine;
	}

	
}
