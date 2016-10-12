package uq.deco2800.ducktales.util;

/**
 * class will be used to store x and y coordinates
 * 
 * @author Nicolas Turner
 */
public class Coordinate {
	int x = 0;
	int y = 0;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return x and y values of the Coordinate in the form of a list
	 */
	public int[] getCoordinate() {
		int[] coordinates = new int[2];
		coordinates[0] = x;
		coordinates[1] = y;
		return coordinates;
	}
	
	/**
	 * @return x value of the Coordinate in the form of an integer
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return y value of the Coordinate in the form of an integer
	 */
	public int getY() {
		return y;
	}

}
