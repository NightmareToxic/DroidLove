package nightmare.droid.love.views;

import nightmare.droid.love.core.GameObject;
import nightmare.droid.love.core.GameThread;
import nightmare.droid.love.core.GameWorld;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameScreen implements SurfaceHolder.Callback{
	private GameThread gameThread;
	private GameWorld gameWorld;
	private SurfaceView surfaceView;
	
	public GameScreen(Context context, GameWorld world) {
		surfaceView = new SurfaceView(context);
		surfaceView.getHolder().addCallback(this);
		this.gameThread = new GameThread(this,surfaceView.getHolder());
		this.gameWorld = world;
	}
	
	public GameWorld getGameWorld() {
		return gameWorld;
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}
	
	public SurfaceView getSurfaceView() {
		return surfaceView;
	}

	public void draw(Canvas canvas, float interpolation) {
		canvas.drawColor(Color.WHITE, Mode.SCREEN);
		
		for(GameObject obj: gameWorld.getGameObjects()){
			obj.draw(canvas,interpolation);
		}

	}
	
	public void surfaceCreated(SurfaceHolder holder) {
		gameThread.setRunning(true);
		gameThread.start();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
	    boolean retry = true;
	    gameThread.setRunning(false);
	    while (retry) {
	        try {
	        	gameThread.join();
	            retry = false;
	        } catch (InterruptedException e) {}
	    }
	}
}
