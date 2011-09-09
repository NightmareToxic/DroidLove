package nightmare.droid.love.components;

import java.util.Vector;

import nightmare.droid.core.GameComponent;

public class Mood extends GameComponent {
	private Emotion mood;
	private Vector<Emotion> emotions = new Vector<Emotion>();

	public Mood() {

	}

	public Emotion getMood() {
		return mood;
	}

	public void setMood(Emotion mood) {
		this.mood = mood;
	}

	public String calculateMood() {
		String emoName = "Neutral";
		float emoMax = 0f;
		for (Emotion emo : emotions) {
			float emoLevel = emo.getEmotionLevel();
			if (emoLevel > emoMax && emoLevel > emo.getEmotionLevelFloor()) {
				emoMax = emoLevel;
				emoName = emo.getName();
			}
		}
		return emoName;
	}
}
