package uq.deco2800.ducktales.entities;

import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Point;
import uq.deco2800.ducktales.util.Tickable;

/**
 * Models an entity in the game.
 * 
 * @author Leggy
 *
 */
public abstract class Entity implements Comparable<Entity>, Tickable{

	protected Point point;
	
	private ResourceType type;

	/**
	 * The length in the direction parallel to the x axis - right.
	 */
	private int lengthX;

	/**
	 * The length in the direction parallel to the y axis - left.
	 */
	private int lengthY;

	/**
	 * The distance from the closest point of the entity to the line where y=x.
	 * Changed to private to fix code smell.
	 */
	private double distanceInside;

	/**
	 * The distance from the top most point of the entity to the point (0, 0).
	 */
	private double distanceTop;

	/**
	 * The distance from the bottom most point of the entity to the point (0,
	 * 0).
	 */
	private double distanceBottom;

	public Entity(double x, double y, int lengthX, int lengthY, ResourceType type) {
		this.point = new Point(x, y);
		this.lengthX = lengthX;
		this.lengthY = lengthY;
		this.type = type;
		calculateRenderingOrderValues();
		
	}
	
	protected void calculateRenderingOrderValues(){
		if (point.getX() > point.getY()) {
			distanceInside = point.getX() - point.getY() - lengthX;
		} else if (point.getY() > point.getX()) {
			distanceInside = point.getY() - point.getX() - lengthY;
		} else {
			distanceInside = -Math.max(lengthY, lengthX);
		}

		this.distanceBottom = point.getY() + point.getX();
		this.distanceTop = distanceBottom - (lengthX + lengthY);
	}

	@Override
	public int compareTo(Entity entity) {
		// Change floats to double just for equality test
		// fix bug of using floats
		if (((double) this.distanceTop) == ((double) entity.distanceTop)) {
			// Change floats to double just for equality test
			// fix bug of using floats
			if (((double) this.distanceBottom) == ((double) entity.distanceBottom)) {
				// Change floats to double just for equality test
				// fix bug of using floats
				if (((double) this.distanceInside) == ((double) entity.distanceInside)) {
					return 0;
				} else if (this.distanceInside < entity.distanceInside) {
					return -1;
				} else {
					return 1;
				}
			} else if (this.distanceBottom < entity.distanceBottom) {
				return -1;
			} else {
				return 1;
			}
		} else if (this.distanceTop < entity.distanceTop) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Entity)) {
			return false;
		}

		Entity entity = (Entity) object;
		return this.point.getX() == entity.point.getX() && this.point.getY()== entity.point.getY()
				&& this.lengthX == entity.lengthX
				&& this.lengthY == entity.lengthY;
	}

	@Override
	public int hashCode() {
		//TODO: fix this
		return 4;
	}

	@Override
	public String toString() {
		return String.format("[%f %f %f %f    %f]", point.getX(), point.getY(), lengthX, lengthY,
				distanceInside);
	}

	public double getX() {
		return point.getX();
	}

	public double getY() {
		return point.getY();
	}

	public int getYLength() {
		return lengthY;
	}

	public int getXLength() {
		return lengthX;
	}
	
	public ResourceType getType(){
		return type;
	}
	
	protected void updateType(ResourceType newType){
		this.type = newType;
	}
	
	/**
	 * Return the double value of distanceInside.
	 * 
	 * To fix code smell of having distanceInside being public. Changed to 
	 * private, and created get method to access. Checked that this does not break 
	 * anything.
	 * 
	 * @return the private distanceInside variable
	 */
	public double getDistanceInside() {
		return distanceInside;
	}

}
