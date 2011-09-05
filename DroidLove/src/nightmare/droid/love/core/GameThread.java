package nightmare.droid.love.core;

import nightmare.droid.love.views.GameScreen;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
	private SurfaceHolder surfaceHolder;
	private GameScreen gameScreen;
	private boolean running = false;
	long timestep = 25;
	long currentTime;
	long elapsedTime;
	long fps;
	int loops=0;
	
	public void setRunning(boolean running) {
		this.running = running;
	}

	public GameThread(GameScreen gameScreen, SurfaceHolder surfaceHolder) {
		this.gameScreen = gameScreen;
		this.surfaceHolder = surfaceHolder;
		currentTime = System.currentTimeMillis()+timestep;
		elapsedTime = System.currentTimeMillis();
	}

	@Override
	public void run() {
		Canvas c;
		while (running) {
			c = null;
			try {
				c = surfaceHolder.lockCanvas(null);				
				synchronized (surfaceHolder) {		
					
					currentTime = System.currentTimeMillis();					
					gameScreen.getGameWorld().Update();
				    
				    elapsedTime = System.currentTimeMillis();				    
				    float interpolation = (currentTime - elapsedTime);
				    
				    gameScreen.draw(c,interpolation);
				    
			        /*next_game_tick += SKIP_TICKS;
			        sleep_time = next_game_tick - GetTickCount();
			        if( sleep_time >= 0 ) {
			            Sleep( sleep_time );
			        }
			        else {
			            // Shit, we are running behind!
			        }*/
					
			        
					/*fps = 1000 / (elapsedTime - currentTime+timestep);					
					gameScreen.draw(c);
					
					if(elapsedTime > currentTime+timestep){												
						currentTime = System.currentTimeMillis();
						elapsedTime=System.currentTimeMillis();
						gameScreen.getGameWorld().Update();
					}else{
						
					}*/
				}
			} finally {
				// do this in a finally so that if an exception is thrown
				// during the above, we don't leave the Surface in an
				// inconsistent state
				if (c != null) {
					surfaceHolder.unlockCanvasAndPost(c);
				}
			}
		}
	}

	public long getFps() {
		return fps;
	}
}
