package uq.deco2800.ducktales.entities.resourceentities;

import static uq.deco2800.ducktales.resources.ResourceType.*;

import java.util.Random;
import uq.deco2800.ducktales.entities.worldentities.WorldEntity;
import uq.deco2800.ducktales.resources.InventoryManager;
import uq.deco2800.ducktales.entities.agententities.Peon;
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



	private boolean isStump = false;        // Whether the tree was lumbered and Leave a stump

	public int timber = 20;                 //define how many timber peon can get from this tree

	// if the tree is lumbered, increase the amount of wood resources and set the tree to stump
	public void lumber(Peon loggers){

		this.isStump = true;
	}

	//* Returns whether the tree is stump.

	public boolean isStump() {
		return this.isStump;
	}

}
