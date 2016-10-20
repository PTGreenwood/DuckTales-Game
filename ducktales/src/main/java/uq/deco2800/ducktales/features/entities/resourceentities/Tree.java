package uq.deco2800.ducktales.features.entities.resourceentities;

import static uq.deco2800.ducktales.resources.ResourceType.*;
import java.util.concurrent.*;

import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.resources.ResourceType;
/**
 * A Tree. Class containing all properties and specifications of a 
 * tree.
 * 
 * @author Andrew Georgiou, 4318457 
 *
 */
public class Tree extends ResourceEntity{
	
	private static final ResourceType[] AUTUMN_TYPES = {TREE_1_AUTUMN, TREE_2_AUTUMN, TREE_3_AUTUMN};
	private static final ResourceType[] SPRING_TYPES = {TREE_1_SPRING, TREE_2_SPRING, TREE_3_SPRING};
	private static final ResourceType[] SUMMER_TYPES = {TREE_1_SUMMER, TREE_2_SUMMER, TREE_3_SUMMER};
	private static final ResourceType[] WINTER_TYPES = {TREE_1_WINTER, TREE_2_WINTER, TREE_3_WINTER};
	
	//Scheduler for growing trees. Set to grow every in game season(24min real time).	
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	/**
	 * Initialise a new tree. Requires the location of the tree 
	 *  to be passed.
	 * @param x, x location of the tree
	 * @param y, y location of the tree
	 */	
	public Tree(double x, double y, ResourceType[] a) {
		super(x, y, 1, 1, rare(a), DEFVALUE);		
		//Scheduling the runnable to run every minute in real time.
		scheduler.scheduleAtFixedRate(createRunnable(this), 24, 24, TimeUnit.MINUTES);
		/*If the tree is the last type in the list, which will always be the rare,
		 * set the value of the Resource to be double.
		 */
		if(this.getType() == a[a.length-1]){
			this.setValue(2*DEFVALUE);
		}
	}
	//Runnable that is in charge of growing the tree
	private Runnable createRunnable(Tree tree){	
		Runnable aRunnable = new Runnable(){
			public void run(){
				tree.increaseValue(50);
				System.out.println(value);
			}
		};
		return aRunnable;
	}

	/*Function added to avoid error in Lumberjack class
	 * will possibly be removed later.
	 */
	public void lumber(Peon loggers){
		
	}

	@Override
	public void tick() {		
	}

	@Override
	public boolean isPassable() {
		return false;
	}
}