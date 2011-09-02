package nightmare.droid.love.core;

import nightmare.droid.love.views.GameScreen;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
	private SurfaceHolder surfaceHolder;
	private GameScreen gameScreen;
	private boolean running = false;

	public void setRunning(boolean running) {
		this.running = running;
	}

	public GameThread(GameScreen gameScreen, SurfaceHolder surfaceHolder) {
		this.gameScreen = gameScreen;
		this.surfaceHolder = surfaceHolder;
	}

	@Override
	public void run() {
		Canvas c;
		while (running) {
			c = null;
			try {
				c = surfaceHolder.lockCanvas(null);
				synchronized (surfaceHolder) {
					gameScreen.draw(c);
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
}
