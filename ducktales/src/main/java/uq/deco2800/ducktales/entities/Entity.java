package uq.deco2800.ducktales.entities;

/**
 * Models an entity in the game.
 * @author Leggy
 *
 */
public class Entity implements Comparable<Entity> {

	private int x;
	private int y;

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
	 */
	public int distanceInside;

	/**
	 * The distance from the top most point of the entity to the point (0, 0).
	 */
	private int distanceTop;
	
	/**
	 * The distance from the bottom most point of the entity to the point (0, 0).
	 */
	private int distanceBottom;

	public Entity(int x, int y, int lengthX, int lengthY) {
		this.x = x;
		this.y = y;
		this.lengthX = lengthX;
		this.lengthY = lengthY;

		if (x > y) {
			distanceInside = (x - y - lengthX);
		} else if (y > x) {
			distanceInside = (y - x - lengthY);
		} else {
			distanceInside = -Math.max(lengthY, lengthX);
		}

		this.distanceBottom = (y + x);
		this.distanceTop = distanceBottom - (lengthX + lengthY);
	}

	@Override
	public int compareTo(Entity entity) {
		if (this.distanceTop == entity.distanceTop) {
			if (this.distanceBottom == entity.distanceBottom) {
				if (this.distanceInside == entity.distanceInside) {
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

	public boolean equals(Object object) {
		if (!(object instanceof Entity)) {
			return false;
		}

		Entity entity = (Entity) object;
		return this.x == entity.x && this.y == entity.y
				&& this.lengthX == entity.lengthX
				&& this.lengthY == entity.lengthY;
	}

	public int hashCode() {
		return 4;
	}

	public String toString() {
		return String.format("[%d %d %d %d    %f]", x, y, lengthX, lengthY,
				distanceInside);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getYLength(){
		return lengthY;
	}
	public int getXLength(){
		return lengthX;
	}
	
	public String getType(){
		return "void";
	}

}
