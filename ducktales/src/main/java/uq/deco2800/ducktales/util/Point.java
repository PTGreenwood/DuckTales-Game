package uq.deco2800.ducktales.util;

/**
 * This class will hold the information of the position of a tile, in tile-unit.
 * however, the stored value for each coordinate is a double, since this class
 * is also used for moving the entities around on the screen
 *
 * For example, if Point.getX() and getY() returns (1, 3), this means the entity
 * is supposed to be on the tile at x-coordinate 1, and y-coordinate 3
 */
public class Point implements Comparable<Point> {

	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;

	}

	public Point(Point point) {
		this.x = point.x;
		this.y = point.y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double distance(Point point) {
		return Math.sqrt(Math.pow(point.getX() - x, 2)
				+ Math.pow(point.getY() - y, 2));
	}

	public void moveToward(Point point, double distance) {
		if (distance(point) < distance) {
			this.x = point.x;
			this.y = point.y;
			return;
		}
		double deltaX = x - point.x;
		double deltaY = y - point.y;
		double angle;
		
		angle = Math.atan2(deltaY, deltaX) + Math.PI;

		double xShift = Math.cos(angle) * distance;
		double yShift = Math.sin(angle) * distance;

		x += xShift;
		y += yShift;
	}

	@Override
	public String toString() {
		return String.format("[%1$,.2f, %2$,.2f]", x, y);
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Point)) {
			return false;
		}
		Point point = (Point) object;
		// removed code smell due to equality of floats
		return (point.x - this.x <= 0.00001 && point.x - this.x > -0.00001) 
				&& (point.y - this.y <= 0.00001 && point.y - this.y > -0.00001);
	}

	@Override
	public int hashCode() {
		return (int) (((13 * x) + y) * 17);
	}

	@Override
	public int compareTo(Point point) {
		if (this.y < point.y) {
			return -1;
		} // removed code smell due to equality of floats 
		else if (point.y - this.y <= 0.00001 && point.y - this.y > -0.00001) {
			if (this.x < point.x) {
				return -1;
			} // removed code smell due to equality of floats
			else if (point.x - this.x <= 0.00001 && point.x - this.x > -0.00001) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return 1;
		}

	}

}
