package uq.deco2800.ducktales.entities.agententities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.util.AStar;
import uq.deco2800.ducktales.util.Point;

/**
 * Class representing the worker.
 * 
 * @author Leggy
 *
 */
public class Peon extends AgentEntity {

	private final static String TYPE = "peon";
	
	private List<Point> goalPoints;
	//private Point goalPoint;
	
	private double speed;
	
	private int health =1000;

	public Peon(int x, int y) {
		super(x, y, 1, 1, TYPE);
		this.speed = 0.05;
		//newGoalPoints();
	}
	
	public void ChangeHealth(int newValue){
		if (newValue >0){
			this.health =newValue;
		}
	}
	
	public int GetHealth(){
		return health;
	}

	@Override
	public void tick() {
		if(goalPoints == null){
			goalPoints = newGoalPoints();
		}
		if(point.distance(goalPoints.get(0)) < speed) {
			point = goalPoints.remove(0);
			GameManager.getInstance().getWorld().getTile(point).reset();
			if(goalPoints.isEmpty()){
				this.goalPoints = newGoalPoints();
			}
		} else {
			point.moveToward(goalPoints.get(0), speed);
		}
		calculateRenderingOrderValues();
	}
	
	private List<Point> newGoalPoints(){
		Random random = new Random();
		Point goalPoint = new Point(random.nextDouble() * 20, random.nextDouble() * 20);
		while(!GameManager.getInstance().getWorld().getTile(goalPoint).isPassable()){
			goalPoint = new Point(random.nextDouble() * 20, random.nextDouble() * 20);
		}
		
		List<AStar.Tuple> path = AStar.aStar(point, goalPoint, GameManager.getInstance().getWorld());
		List<Point> goalPoints = new ArrayList<Point>();

		for(AStar.Tuple tuple : path){
			goalPoints.add(new Point(tuple.getX(), tuple.getY()));
			GameManager.getInstance().getWorld().getTile(tuple.getX(), tuple.getY()).makePath();
		}
		return goalPoints;
	}
}
