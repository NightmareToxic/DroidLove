package nightmare.droid.love.core;

import java.util.ArrayList;

public class GameWorld implements IUpdateable {
	
	ArrayList<GameObject> gameObjects;
	
	public GameWorld(){
		gameObjects = new ArrayList<GameObject>();
	}
	
	public void Update(){
		for(GameObject obj: gameObjects){
			obj.Update();
		}
	}

	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}
}
