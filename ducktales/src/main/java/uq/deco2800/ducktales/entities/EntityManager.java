package uq.deco2800.ducktales.entities;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
	
	private static final EntityManager INSTANCE = new EntityManager();
	
	public static EntityManager getInstance(){
		return INSTANCE;
	}
	
	private List<Entity> entities;
	
	private EntityManager(){
		entities = new ArrayList<Entity>();
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	public List<Entity> getEntities() {
		return entities;
	}

}
