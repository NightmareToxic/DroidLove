package nightmare.droid.love.components;

import java.util.Hashtable;
import java.util.Map.Entry;

public class EmotionComposite extends Emotion {
	Hashtable<Emotion,Float> emotionFactors = new Hashtable<Emotion, Float>();

	public EmotionComposite(String name, float emotionLevelFloor) {
		super(name,emotionLevelFloor);
	}
	
	@Override
	public float getEmotionLevel(){
		float emoLevel=0f;
		int count=0;
		for(Entry<Emotion,Float> set : emotionFactors.entrySet()){
			emoLevel+=set.getKey().getEmotionLevel() * set.getValue();
			count++;
		}
		return emoLevel/count;
	}

	@Override
	public void setEmotionLevel(float emotionLevel) {
	}
	
}
