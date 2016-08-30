package uq.deco2800.ducktales.entities.resourceentities;

import java.util.Random;
import static uq.deco2800.ducktales.resources.ResourceType.*;

import uq.deco2800.ducktales.entities.worldentities.WorldEntity;
import uq.deco2800.ducktales.resources.ResourceType;

public class Tree extends ResourceEntity{
	
	private static ResourceType[] TYPES = {TREE_1, TREE_2, TREE_3};
	
	private int stage;

	public Tree(double x, double y) {
		super(x, y, 1, 1, TYPES[0], value);
		this.stage = 0;
	}

	@Override
	public void tick() {		
	}

	@Override
	public boolean isPassable() {
		return false;
	}

}
