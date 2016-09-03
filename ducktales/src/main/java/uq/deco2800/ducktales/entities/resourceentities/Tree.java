package uq.deco2800.ducktales.entities.resourceentities;

import java.util.*;
import java.util.concurrent.*;

import static uq.deco2800.ducktales.resources.ResourceType.*;
import uq.deco2800.ducktales.resources.ResourceType;

public class Tree extends ResourceEntity implements Runnable{
	private static ResourceType[] TYPES = {TREE_1, TREE_2, TREE_3};
	static Random randomGenerator = new Random();
	static int randomInt = randomGenerator.nextInt(100);
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public Tree(double x, double y) {		
		super(x, y, 1, 1, rare(randomInt, TYPES), value);
		 scheduler.scheduleAtFixedRate(createRunnable(this), 60, 60, TimeUnit.SECONDS);
	}
	
	private Runnable createRunnable(final Tree tree){	
		Runnable aRunnable = new Runnable(){
			public void run(){
				grow();
			}
		};
		return aRunnable;
	}
	
	private void grow(){
		this.increaseValue(10);
	}

	private static ResourceType rare(int randomInt, ResourceType[] TYPES){
		if(randomInt < 5){
			value = 200;
			return TYPES[1];
		} else{
			value = 100;
			return TYPES[0];
		}
	}
	
	@Override
	public void run() {
		
	}

	@Override
	public void tick() {
		System.out.println(value);
	}
	
	@Override
	public boolean isPassable() {
		return false;
	}
}
