package uq.deco2800.ducktales.entities.resourceentities;

import java.util.Random;
import static uq.deco2800.ducktales.resources.ResourceType.*;

import uq.deco2800.ducktales.entities.worldentities.WorldEntity;
import uq.deco2800.ducktales.resources.ResourceType;

public class Tree extends ResourceEntity{
	private static ResourceType[] TYPES = {TREE_1, TREE_2, TREE_3};
	private static long _firstCallTimeSeconds = 0;
	static Random randomGenerator = new Random();
	static int randomInt = randomGenerator.nextInt(100);
	

	public Tree(double x, double y) {		
		super(x, y, 1, 1, rare(randomInt, TYPES), value);
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
	public void tick() {
		System.out.println(value);
		/*long TICKS_AT_EPOCH = 621355968000000000L; 
		long tick = System.currentTimeMillis()*10000 + TICKS_AT_EPOCH;
		if(tick%10 == 0){
			value += 5;
		}
		int x = 0;
		if(tickCountInSeconds()%60 == 0 && x == 0){
			value += 5;
			x = 1;
		}*/
	}
	
	/*private synchronized static int tickCountInSeconds() {
	      long currentTimeSeconds = System.currentTimeMillis() / 1000L;
	      if (_firstCallTimeSeconds == 0) {
	         _firstCallTimeSeconds = currentTimeSeconds;
	      }
	      
	      return (int)(currentTimeSeconds - _firstCallTimeSeconds);
	   }*/

	@Override
	public boolean isPassable() {
		return false;
	}
}
