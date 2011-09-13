package nightmare.droid.love.views;

import javax.microedition.khronos.opengles.GL10;

import nightmare.droid.core.GameCore;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.modifier.DelayModifier;
import org.anddev.andengine.entity.modifier.FadeInModifier;
import org.anddev.andengine.entity.modifier.FadeOutModifier;
import org.anddev.andengine.entity.modifier.SequenceEntityModifier;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.ITexture;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class Opening extends GameScreen {


	@Override
	public void createScene() {
		final Scene scene = this.getScene();
		final Engine engine = this.getEngine();
		final GameCore core = this.getCore();
				
		//Black background
		scene.setBackground(new ColorBackground(0,0,0));

		scene.registerUpdateHandler(new IUpdateHandler() {
			public void onUpdate(float pSecondsElapsed) {
				sceneElapsedTime.setValue(sceneElapsedTime.getValue()
						+ pSecondsElapsed);

				int st = sceneState.getValue();

				switch (st) {
				case 0:				
					TextureRegion logo = LoadBmpToEngine(512,256, "img/NightmareToxic.png", 0, 0);
					final TextureRegion upper_bg = LoadBmpToEngine(512,512,"img/fundo_upper.png",0,0);
					final TextureRegion lower_bg = LoadBmpToEngine(512,512,"img/fundo_lower.png",0,0);
					
					float halfScreenWidth = engine.getCamera().getWidth() / 2
							- logo.getWidth() / 2;
					float halfScreenHeight = engine.getCamera().getHeight() / 2
							- logo.getHeight() / 2;

					Sprite spr = new Sprite(halfScreenWidth,halfScreenHeight,logo);
					spr.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
					spr.setColor(1,1,1,0);
					
					spr.registerEntityModifier(new SequenceEntityModifier(
							new DelayModifier(2.0f),
							new FadeInModifier(2.0f),
							new DelayModifier(3.0f),
							new FadeOutModifier(1.0f)));
					 
					scene.attachChild(spr);
					scene.attachChild(new Sprite(0f,0f,upper_bg));
					scene.attachChild(new Sprite(0f,engine.getCamera().getHeight() - lower_bg.getHeight(),lower_bg));
					
					sceneState.setValue(1);
					break;

				case 1:
					if (sceneElapsedTime.getValue() > 8.5f) {
						scene.unregisterUpdateHandler(this);
						core.setGameState("MAINMENU");
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

	public void destroyScene() {
		final Engine engine = this.getEngine();
		final Scene scene = this.getScene();
		
		//Remove Objects
		scene.detachChildren();

		//Clear Handlers
		scene.clearUpdateHandlers();
		scene.clearEntityModifiers();
		
		//Unload Textures and Fonts
		for (ITexture tex : loadedTextures){
			engine.getTextureManager().unloadTexture(tex);	
		}		
		engine.getFontManager().clear();
	}
}
