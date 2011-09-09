package nightmare.droid.love.components;

import java.util.Vector;

import nightmare.droid.love.event.EmotionFluctuationEvent;
import nightmare.droid.love.event.EmotionFluctuationListener;

import org.anddev.andengine.engine.handler.IUpdateHandler;

public abstract class Emotion {
	
	private String name;
	private float emotionLevel;	
	private float emotionLevelFloor;
	private IUpdateHandler emotionUpdate;
	private Vector<EmotionFluctuationListener> subscribers = new Vector<EmotionFluctuationListener>();

	private void onEmotionChanged(float pSecondsElapsed) {
		for (int i = 0, size = subscribers.size(); i < size; i++) {
			((EmotionFluctuationListener) subscribers.get(i))
					.onEmotionChanged(new EmotionFluctuationEvent(this,
							pSecondsElapsed));
		}
	}

	public IUpdateHandler getEmotionUpdate() {
		return emotionUpdate;
	}

	public void addEmotionFluctuationListener(EmotionFluctuationListener ensl) {
		subscribers.add(ensl);
	}

	public void removeEmotionFluctuationListener(EmotionFluctuationListener ensl) {
		subscribers.remove(ensl);
	}
	
	public Emotion(String name, float emotionLevelFloor){
		this.name = name;
		this.emotionLevelFloor = emotionLevelFloor;
		this.emotionUpdate = new IUpdateHandler(){
			public void onUpdate(float pSecondsElapsed) {
				onEmotionChanged(pSecondsElapsed);
			}
			public void reset() {
			}
		};
	}
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getEmotionLevel(){
		return this.emotionLevel;
	}

	public void setEmotionLevel(float emotionLevel) {
		this.emotionLevel = emotionLevel;
	}

	public float getEmotionLevelFloor() {
		return emotionLevelFloor;
	}

	public void setEmotionLevelFloor(float emotionLevelFloor) {
		this.emotionLevelFloor = emotionLevelFloor;
	}
	
}
