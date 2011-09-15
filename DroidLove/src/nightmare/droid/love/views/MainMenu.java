package nightmare.droid.love.views;

import javax.microedition.khronos.opengles.GL10;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.background.SpriteBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.util.GLHelper;

public class MainMenu extends GameScreen{

	@Override
	public void createScene() {
		final Scene scene = this.getScene();
		final Engine engine = this.getEngine();
		
		TextureRegion background = LoadBmpToEngine(512, 1024, "img/bgMenu.png", 0, 0);
		final Sprite sprBgMenu = new Sprite(0f, 0f, background){
			
		protected void onInitDraw(final GL10 pGL)
	    {
		       super.onInitDraw(pGL);
		       GLHelper.enableTextures(pGL);
		       GLHelper.enableTexCoordArray(pGL);
		       GLHelper.enableDither(pGL);
		    }
		};
		
		scene.registerUpdateHandler(new IUpdateHandler(){
			public void onUpdate(float pSecondsElapsed) {
				sceneElapsedTime.setValue(sceneElapsedTime.getValue()+pSecondsElapsed);						
				int st = sceneState.getValue(); 
				
				switch(st){
				case 0:	
					TextureRegion logo = LoadBmpToEngine(512,512, "img/DroidLoveLogo.png", 0, 0);
					float halfScreenWidth = engine.getCamera().getWidth() / 2
							- logo.getWidth() / 2;
					
					Sprite spr = new Sprite(halfScreenWidth,50,logo);
					spr.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
					
					final int newdroidy = 400;
					
					final TextureRegion newdroidtex = LoadBmpToEngine(512,512, "img/btn_newdroid.png", 0, 0);
					final float ndhalfScreenWidth = engine.getCamera().getWidth() / 2
							- newdroidtex.getWidth() / 1.5f;
					
					final Sprite newdroid = new Sprite(ndhalfScreenWidth,400,newdroidtex);
					
					final TextureRegion newdroidtexc = LoadBmpToEngine(512,512, "img/btn_newdroidclicked.png", 0, 0);
					final float ndhalfScreenWidthc = engine.getCamera().getWidth() / 2
							- newdroidtexc.getWidth() / 1.5f;
					
					final Sprite newdroidc = new Sprite(ndhalfScreenWidthc,newdroidy,newdroidtexc);
					
					newdroidc.setVisible(false);
					
					scene.setOnSceneTouchListener(new IOnSceneTouchListener(){
						public boolean onSceneTouchEvent(Scene pScene,
								TouchEvent pSceneTouchEvent) {
							float pTouchAreaLocalX = pSceneTouchEvent.getX();
							float pTouchAreaLocalY = pSceneTouchEvent.getY();
							if (pSceneTouchEvent.isActionDown()){
								if (pTouchAreaLocalX > ndhalfScreenWidth && pTouchAreaLocalX < ndhalfScreenWidth+newdroidtex.getWidth()
										&& pTouchAreaLocalY > newdroidy && pTouchAreaLocalY < newdroidy+newdroidtex.getHeight()){
									newdroidc.setVisible(true);
									newdroid.setVisible(false);
								}	
							}
							if (pSceneTouchEvent.isActionUp()){
								if (pTouchAreaLocalX > ndhalfScreenWidth && pTouchAreaLocalX < ndhalfScreenWidth+newdroidtex.getWidth()
										&& pTouchAreaLocalY > newdroidy && pTouchAreaLocalY < newdroidy+newdroidtex.getHeight()){
									
								}
								newdroidc.setVisible(false);
								newdroid.setVisible(true);									
							}								
							return true;
						}
						
					});
					
					newdroid.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);					
					
					scene.setBackground(new SpriteBackground(sprBgMenu));
					scene.attachChild(newdroid);
					scene.attachChild(newdroidc);
					scene.attachChild(spr);				
					
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
	}
}
