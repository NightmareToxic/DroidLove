package nightmare.droid.love.views;

import java.util.Vector;

import nightmare.droid.core.GameCore;
import nightmare.droid.helper.Wrapper;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

import android.content.Context;

public abstract class GameScreen{
	public abstract void createScene();
	public abstract void destroyScene();
	
	private Scene scene;
	private Engine engine;
	private Context context;
	private GameCore core;
	private boolean done;
	protected final Wrapper<Integer> sceneState = new Wrapper<Integer>(0);
	protected final Wrapper<Float> sceneElapsedTime = new Wrapper<Float>(0f);
	protected final Vector<BitmapTextureAtlas> loadedTextures = new Vector<BitmapTextureAtlas>();
	
	public Context getContext() {
		return context;
	}
	
	public GameCore getCore() {
		return core;
	}
	public GameScreen(){
		this.done=false;
	}
	
	public void init(Scene scene, Engine engine,Context context,GameCore core){
		this.scene = scene;
		this.engine = engine;
		this.core = core;
		this.context =context;
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
	
	public TextureRegion LoadBmpToEngine(int texWidth, int texHeight, String assetName,int texX, int texY){
		BitmapTextureAtlas bmpTexture = new BitmapTextureAtlas(texWidth,
				texHeight, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

		TextureRegion reg = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(bmpTexture, getContext(),
						assetName,texX, texY);

		getEngine().getTextureManager().loadTexture(reg.getTexture());
		
		loadedTextures.add(bmpTexture);
		
		return reg;
	}
	
}
