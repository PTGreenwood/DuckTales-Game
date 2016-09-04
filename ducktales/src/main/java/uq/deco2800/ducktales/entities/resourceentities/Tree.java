package uq.deco2800.ducktales.entities.resourceentities;

import static uq.deco2800.ducktales.resources.ResourceType.*;
import java.util.concurrent.*;
import uq.deco2800.ducktales.resources.ResourceType;

public class Tree extends ResourceEntity{
	
	private static ResourceType[] TYPES = {TREE_1, TREE_2, TREE_3};
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	public Tree(double x, double y) {
		super(x, y, 1, 1, rare(TYPES), defValue);
		/*Scheduler for growing trees. Currently will grow every minute.	
		 *  
		 * (Can be changed to fit with the methods in Time class when implemented)
		 */
		
		scheduler.scheduleAtFixedRate(createRunnable(this), 60, 60, TimeUnit.SECONDS);
		/*If the tree is the last type in the list, which will always be the rare,
		 * set the value of the Resource to be double.
		 * 
		 * (Hard coded to 200 because a balance of resource values has not been discussed yet.)
		 */
		if(this.getType() == TYPES[TYPES.length-1]){
			this.setValue(200);
		}
	}
	//Runnable that is in charge of growing the tree
	private Runnable createRunnable(Tree tree){	
		Runnable aRunnable = new Runnable(){
			public void run(){
				tree.increaseValue(10);
				System.out.println(value);
			}
		};
		return aRunnable;
	}

	@Override
	public void tick() {		
	}

	@Override
	public boolean isPassable() {
		return false;
	}	
}
