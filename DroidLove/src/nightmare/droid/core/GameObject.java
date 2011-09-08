package nightmare.droid.core;

import java.util.Hashtable;
import java.util.Vector;

import org.anddev.andengine.entity.IEntity;

public abstract class GameObject{			
		
	private static int available_id=0;
	private int id;
	private IEntity entity;
	private Vector<GameComponent> composition = new Vector<GameComponent>();
	private Hashtable<String,GameComponent> inventory = new Hashtable<String,GameComponent>();
	
    @SuppressWarnings("unchecked")
	public <T> T GetItem(String component){
		if (inventory.containsKey(component)){
			return (T) inventory.get(component);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends GameComponent> T GetComponent(T component){
		int index = composition.indexOf(component);
		if (index!=-1){
			Object obj = composition.get(index);
			return (T) obj;
		}
		return null;
	}
	
	public <T extends GameComponent> void AddComponent(T component){
		composition.add(component);
	}
	
	public IEntity getEntity() {
		return entity;
	}

	public void setEntity(IEntity entity) {
		this.entity = entity;
	}

	public GameObject(){
		this.id = GameObject.available_id;
		available_id++;			
	}
	
	public int getId() {
		return id;
	}
}
