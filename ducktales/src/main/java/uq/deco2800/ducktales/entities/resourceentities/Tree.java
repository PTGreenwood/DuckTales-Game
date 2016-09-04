package uq.deco2800.ducktales.entities.resourceentities;

import java.util.concurrent.*;

import static uq.deco2800.ducktales.resources.ResourceType.*;
import uq.deco2800.ducktales.resources.ResourceType;

public class Tree extends ResourceEntity{
	private static ResourceType[] TYPES = {TREE_1, TREE_2, TREE_3};	
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	public Tree(double x, double y) {		
		super(x, y, 1, 1, rare(TYPES), defValue);
		scheduler.scheduleAtFixedRate(createRunnable(this), 5, 5, TimeUnit.SECONDS);
		if(this.getType() == TYPES[1]){
			this.setValue(200);
		}
	}
	
	private Runnable createRunnable(Tree tree){	
		Runnable aRunnable = new Runnable(){
			public void run(){
				tree.increaseValue(10);
				//System.out.println(value);
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
