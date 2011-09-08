package nightmare.droid.love.objects;

import java.util.Vector;

import nightmare.droid.core.GameObject;

public class Room {
	private MiniDroid miniDroid;
	private Vector<GameObject> objects;
	
	public Room(MiniDroid miniDroid, Vector<GameObject> objects){
		this.miniDroid = miniDroid;
		this.objects = objects;
	}

	public MiniDroid getMiniDroid() {
		return miniDroid;
	}

	public void setMiniDroid(MiniDroid miniDroid) {
		this.miniDroid = miniDroid;
	}

	public Vector<GameObject> getObjects() {
		return objects;
	}
	
}
