package nightmare.droid.love.objects;

import nightmare.droid.core.GameObject;
import nightmare.droid.love.components.Mood;

public class MiniDroid extends GameObject{
	private String name;
	private long life;
	
	public MiniDroid(String name){
		this.setName(name);
		this.life = 0L;
		InitializeMood();		
	}
	
	private void InitializeMood(){
		this.AddComponent(new Mood());
	}
	
	public long getLife() {
		return life;
	}

	public static MiniDroid LoadMiniDroid(){
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
