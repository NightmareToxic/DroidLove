package nightmare.droid.love.objects;

import javax.microedition.khronos.opengles.GL10;

import nightmare.droid.love.core.GameObject;

import org.anddev.andengine.entity.modifier.AlphaModifier;
import org.anddev.andengine.entity.modifier.SequenceEntityModifier;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.opengl.font.Font;

public class FadingText extends GameObject {

	private Text pText;

	public FadingText(float px, float py, Font font, String text) {
		this.pText = new Text(px, py, font, text);
		pText.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		this.setEntity(pText);
		this.getEntity().registerEntityModifier(
				new SequenceEntityModifier(new AlphaModifier(10, 1.0f, 0.0f)));
	}

}
