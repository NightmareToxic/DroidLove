package nightmare.droid.love.views;

import nightmare.droid.objects.FadingText;
import nightmare.droid.objects.LetterByLetterText;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;

import android.graphics.Color;
import android.graphics.Typeface;

public class Opening extends GameScreen{

	protected final BitmapTextureAtlas pTex =  new BitmapTextureAtlas(512, 512, TextureOptions.BILINEAR);
	
	@Override
	public void createScene() {
		scene.setBackground(new ColorBackground(0,.55f,1));
		
		//final Typeface face = Typeface.createFromAsset(assets, "EARWIGFA.TTF"); 
		final Typeface face = Typeface.create(Typeface.DEFAULT,Typeface.BOLD);
		final Font pFont = new Font(pTex, face, 32, true, Color.WHITE);

		engine.getTextureManager().loadTexture(pTex);
		engine.getFontManager().loadFont(pFont);		
		
		scene.registerUpdateHandler(new IUpdateHandler(){
			public void onUpdate(float pSecondsElapsed) {
				sceneElapsedTime.setValue(sceneElapsedTime.getValue()+pSecondsElapsed);
				
				int st = sceneState.getValue(); 
				float totalSceneTime= sceneElapsedTime.getValue();
				
				switch(st){
				case 0:
					String pText = "Hello Droid";	
					float halfScreenWidth = engine.getCamera().getWidth()/2-pFont.getStringWidth(pText)/2;
					float halfScreenHeight = engine.getCamera().getHeight()/2-pFont.getLineHeight()/2;
					FadingText txt = new FadingText(halfScreenWidth, halfScreenHeight, pFont, pText);
					scene.attachChild(txt.getEntity());
					sceneState.setValue(1);
					break;
				case 1:
					if (totalSceneTime>5f){
						pText = "Goodbye Droid";
						halfScreenWidth = engine.getCamera().getWidth()/2-pFont.getStringWidth(pText)/2;
						halfScreenHeight = engine.getCamera().getHeight()/2-pFont.getLineHeight()/2;
						LetterByLetterText txt2 = new LetterByLetterText(halfScreenWidth, halfScreenHeight, pFont, pText);
						scene.attachChild(txt2.getEntity());
						sceneState.setValue(2);
					}
					break;
				default:
					break;							
				}
			}
			public void reset() {
			}
		});
		
	}
	
	public void destroyScene(){
		engine.getTextureManager().unloadTexture(pTex);
		engine.getFontManager().clear();
	}
}
