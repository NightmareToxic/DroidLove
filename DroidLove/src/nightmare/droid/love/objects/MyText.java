package nightmare.droid.love.objects;

import nightmare.droid.love.core.GameObject;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class MyText extends GameObject {

	private float x;
	private float y;
	private float z;
	private float w;
	private String text;
	private Paint paint;
	
	public MyText(String text){
		this.text = text;
		paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setStyle(Style.FILL);
		x = 100 + (float) (Math.random() * 185);
		y = 100 + (float) (Math.random() * 185);
		z = 2   + (float) (Math.random() * 3);
		w = 2   + (float) (Math.random() * 3);
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void Update() {
		x+=Math.sin(y/50)*z;
		y+= w;
		if (x>270) x=0;
		if (y>365) y=0;
	}

	public void draw(Canvas canvas, float interpolation) {
		canvas.drawText(text,x+interpolation*0.25f,y+interpolation*0.25f,paint);		
	}

}
