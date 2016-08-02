package uq.deco2800.ducktales.entities;

import java.util.Random;

import uq.deco2800.ducktales.util.Point;

/**
 * Class representing the worker.
 * 
 * @author leggy
 *
 */
public class Peon extends Entity {

	private final static String TYPE = "peon";
	
	private Point goalPoint;
	
	private double speed;

	public Peon(int x, int y) {
		super(x, y, 1, 1, TYPE);
		this.speed = 0.05;
		newGoalPoint();
	}

	@Override
	public void tick() {
		if(point.distance(goalPoint) < speed) {
			point = goalPoint;
			newGoalPoint();
		} else {
			point.moveToward(goalPoint, speed);
		}
		calculateRenderingOrderValues();
		
	}
	
	private void newGoalPoint(){
		Random random = new Random();
		goalPoint = new Point(random.nextDouble() * 20, random.nextDouble() * 20);
	}

}
