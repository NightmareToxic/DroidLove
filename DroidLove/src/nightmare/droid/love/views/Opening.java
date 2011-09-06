package nightmare.droid.love.views;

import nightmare.droid.love.objects.FadingText;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;

import android.graphics.Color;
import android.graphics.Typeface;

public class Opening extends GameScreen{

	public Opening(Scene scene, Engine engine) {
		super(scene, engine);
	}

	protected final BitmapTextureAtlas pTex =  new BitmapTextureAtlas(512, 512, TextureOptions.BILINEAR);
	protected final Font pFont = new Font(pTex, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 32, true, Color.WHITE);
	
	@Override
	public void createScene() {
		scene.setBackground(new ColorBackground(0,.55f,1));
		engine.getTextureManager().loadTexture(pTex);
		engine.getFontManager().loadFont(pFont);
		
		String pText = "Hello Droid";	
		FadingText txt = new FadingText(100, 100, pFont, pText);
		
		scene.attachChild(txt.getEntity());
	}
	
	public void destroyScene(){
		engine.getTextureManager().unloadTexture(pTex);
		engine.getFontManager().clear();
	}
}
