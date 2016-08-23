package uq.deco2800.ducktales.entities.agententities;

import java.util.Random;

import uq.deco2800.ducktales.util.Point;

/**
 * Class representing the worker.
 * 
 * @author Leggy
 *
 */
public class Peon extends AgentEntity {

	private static final Random RANDOM = new Random();

	private final static String TYPE = "peon";

	private Point goalPoint;

	private double speed;

	private int Health = 1000;

	// affinity
	private int strength;
	private int intelligence;

	// affinity bounds
	private static final int DEFAULT_MAX = 10;
	private static final int DEFAULT_MIN = 1;

	/**
	 * @param x
	 * @param y
	 */
	public Peon(int x, int y) {
		super(x, y, 1, 1, TYPE);
		speed = 0.05;
		strength = RANDOM.nextInt((DEFAULT_MAX - DEFAULT_MIN) + 1) + DEFAULT_MIN;
		intelligence = RANDOM.nextInt((DEFAULT_MAX - DEFAULT_MIN) + 1) + DEFAULT_MIN;
		newGoalPoint();
	}

	/**
	 * @param NewValue
	 */
	public void ChangeHealth(int NewValue) {
		if (NewValue > 0) {
			this.Health = NewValue;
		}
	}

	public int GetHealth() {
		return Health;
	}
        public int getStrength(){
            return strength;
        }
        public int getIntelligence(){
            return intelligence;
        }

	@Override
	public void tick() {
		if (point.distance(goalPoint) < speed) {
			point = goalPoint;
			newGoalPoint();
		} else {
			point.moveToward(goalPoint, speed);
		}
		calculateRenderingOrderValues();

	}

	private void newGoalPoint() {
		Random random = new Random();
		goalPoint = new Point(random.nextDouble() * 20, random.nextDouble() * 20);
	}
}
