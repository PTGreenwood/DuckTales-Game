package uq.deco2800.ducktales.entities;

import java.util.ArrayList;
import java.util.List;

import uq.deco2800.ducktales.util.Tickable;

public class EntityManager implements Tickable{
	
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

	@Override
	public void tick() {
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).tick();
		}
		
	}

}
