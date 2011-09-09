package nightmare.droid.love.views;

import nightmare.droid.objects.FadingText;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;

import android.graphics.Color;
import android.graphics.Typeface;

public class MainMenu extends GameScreen{

	private final BitmapTextureAtlas pTexe =  new BitmapTextureAtlas(512, 512, TextureOptions.BILINEAR);
	
	@Override
	public void createScene() {
		final Scene scene = this.getScene();
		final Engine engine = this.getEngine();
		scene.setBackground(new ColorBackground(0,1,1));
		
		final Typeface facee = Typeface.create(Typeface.DEFAULT,Typeface.BOLD);
		final Font pFonte = new Font(pTexe, facee, 32, true, Color.WHITE);

		engine.getTextureManager().loadTexture(pTexe);
		engine.getFontManager().loadFont(pFonte);
		
		scene.registerUpdateHandler(new IUpdateHandler(){
			public void onUpdate(float pSecondsElapsed) {
				sceneElapsedTime.setValue(sceneElapsedTime.getValue()+pSecondsElapsed);		
				
				int st = sceneState.getValue(); 
				
				switch(st){
				case 0:					
					String pText = "[Place Main Menu Here]";	
					float halfScreenWidth = engine.getCamera().getWidth()/2-pFonte.getStringWidth(pText)/2;
					float halfScreenHeight = engine.getCamera().getHeight()/2-pFonte.getLineHeight()/2;
					FadingText txt = new FadingText(halfScreenWidth, halfScreenHeight, pFonte, pText);
					scene.attachChild(txt.getEntity());
					sceneState.setValue(1);
					break;
				case 1:
					if (sceneElapsedTime.getValue()>5.0f){
						sceneState.setValue(2);
					}
					break;
				default:
					scene.unregisterUpdateHandler(this);
					break;
				}
			}
			public void reset() {
			}
		});
		
	}
	
	public void destroyScene(){
		final Engine engine = this.getEngine();
		engine.getTextureManager().unloadTexture(pTexe);
		engine.getFontManager().clear();
	}
}
