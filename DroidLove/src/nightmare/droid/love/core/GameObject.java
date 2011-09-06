package nightmare.droid.love.core;

import org.anddev.andengine.entity.IEntity;

public abstract class GameObject{			
		
	private static int available_id=0;
	private int id;
	private IEntity entity;
	
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
