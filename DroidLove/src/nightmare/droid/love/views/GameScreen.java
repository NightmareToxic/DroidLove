package nightmare.droid.love.views;

import nightmare.droid.love.core.GameThread;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameScreen extends SurfaceView implements SurfaceHolder.Callback{
	private GameThread gameThread;
	private int x = 100;
	public GameScreen(Context context) {
		super(context);
		this.getHolder().addCallback(this);
		this.gameThread = new GameThread(this,this.getHolder());
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

	}

	@Override
	public void draw(Canvas canvas) {
		Paint txtpaint = new Paint();
		txtpaint.setColor(Color.CYAN);
		txtpaint.setStyle(Paint.Style.FILL);
		canvas.drawColor(Color.WHITE, Mode.CLEAR);
		canvas.drawText("Hello Droid !", x, 100,txtpaint);
		x++;
		if (x>300) x=0;
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
