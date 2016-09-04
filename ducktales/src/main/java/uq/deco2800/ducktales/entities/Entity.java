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

	/**
	 * Main constructor of the {@link Entity} class
	 * 
	 * @param x
	 * @param y
	 * @param lengthX
	 * @param lengthY
	 * @param type
	 */
	public Entity(double x, double y, int lengthX, int lengthY, ResourceType type) {
		this.point = new Point(x, y);
		this.lengthX = lengthX;
		this.lengthY = lengthY;
		this.type = type;
		calculateRenderingOrderValues();
	}
	
	/**
	 * Determines rendering order and sets {@code distanceInside, distanceBottom, distanceTop}
	 */
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
		// Fix big of comparing floats by checking difference
		if (this.distanceTop - entity.distanceTop <= 0.0001) {
			// Fix big of comparing floats by checking difference
			if (this.distanceBottom - entity.distanceBottom <= 0.00001) {
				// Fix bug of comparing floats by comparing differences
				// distanceInside are negatives, hence the > -ve
				if (this.distanceInside - entity.distanceInside >= -0.0001) {
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

	/**
	 * Get x position.
	 * 
	 * @return {@code point.getX}
	 */
	public double getX() {
		return point.getX();
	}

	/**
	 * Get y position.
	 * 
	 * @return {@code point.getY}
	 */
	public double getY() {
		return point.getY();
	}

	/**
	 * Get y length.
	 * 
	 * @return {@code lengthY}
	 */
	public int getYLength() {
		return lengthY;
	}

	/**
	 * Get x length.
	 * 
	 * @return {@code lengthX}
	 */
	public int getXLength() {
		return lengthX;
	}
	
	/**
	 * Get entity type.
	 * 
	 * @return {@code this.type}
	 */
	public ResourceType getType(){
		return type;
	}
	
	/**
	 * Set entity type.
	 * 
	 * @param newType New entity type.
	 */
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
