package nightmare.droid.objects;

import javax.microedition.khronos.opengles.GL10;

import nightmare.droid.core.GameObject;

import org.anddev.andengine.entity.modifier.DelayModifier;
import org.anddev.andengine.entity.modifier.FadeInModifier;
import org.anddev.andengine.entity.modifier.FadeOutModifier;
import org.anddev.andengine.entity.modifier.SequenceEntityModifier;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.opengl.font.Font;

public class FadingText extends GameObject {

	private Text pText;

	public FadingText(float px, float py, Font font, String text) {
		this.pText = new Text(px, py, font, text);
		pText.setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		pText.setColor(1,1,1,0);
		pText.registerEntityModifier(
				new SequenceEntityModifier(
						new DelayModifier(2.0f),
						new FadeInModifier(1.0f),
						new DelayModifier(2.0f),
						new FadeOutModifier(1.0f)));	
		this.setEntity(pText);

	}

}
