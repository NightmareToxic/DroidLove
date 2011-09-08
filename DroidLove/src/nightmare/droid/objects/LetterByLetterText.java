package nightmare.droid.objects;

import javax.microedition.khronos.opengles.GL10;

import nightmare.droid.core.GameObject;

import org.anddev.andengine.entity.text.TickerText;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.util.HorizontalAlign;

public class LetterByLetterText extends GameObject {
	private TickerText pText;

	public LetterByLetterText(float px, float py, Font font, String text) {
		this.pText = new TickerText(px, py, font, text,HorizontalAlign.LEFT, 5);
		pText.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

		this.setEntity(pText);
	}
}
