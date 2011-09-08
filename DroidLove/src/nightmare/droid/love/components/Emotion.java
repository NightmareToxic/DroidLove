package nightmare.droid.love.components;

public abstract class Emotion {
	
	private String name;
	private float emotionLevel;	
	private float emotionLevelFloor;
	
	public Emotion(String name, float emotionLevelFloor){
		this.name = name;
		this.emotionLevelFloor = emotionLevelFloor;
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
