package uq.deco2800.ducktales.features.weather;

/**
 * 
 * WeatherCanvasShape class
 * 
 * Keeps track of the X and Y co-ordinates of the shape and which direction and
 * how fast the shape falls.
 * 
 * @author mattyleggy
 *
 */
public class WeatherCanvasShape {
	// x co-ordinate
	private int x;
	// y co-ordinate
	private int y;
	// direction of travel
	private int direction;
	// acceleration of fall
	private int acceleration;

	/*
	 * invariant:
	 * 
	 * && x, y, direction, acceleration can be any valid number (negative or
	 * positive)
	 * 
	 */

	public WeatherCanvasShape(int x, int y, int direction, int acceleration) {		
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.acceleration = acceleration;
	}

	/**
	 * Gets the X co-ordinate position of the shape to be drawn onto the canvas.
	 * 
	 * @return the x co-ordinate of the shape
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Gets the Y co-ordinate position of the shape to be drawn onto the canvas.
	 * 
	 * @return the Y co-ordinate of the shape
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Gets the direction of the shape to be drawn onto the canvas.
	 * 
	 * @return the direction of the shape
	 */
	public int getDirection() {
		return this.direction;
	}

	/**
	 * Gets the acceleration (falling rate) of the shape to be drawn onto the
	 * canvas.
	 * 
	 * @return the acceleration of the shape
	 */
	public int getAcceleration() {
		return this.acceleration;
	}

	/**
	 * Set the value of the x-coordinate of the shape to be drawn onto the
	 * canvas.
	 * 
	 * @param x
	 *            - X co-ordinate to store
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Set the value of the y-coordinate of the shape to be drawn onto the
	 * canvas.
	 * 
	 * @param y
	 *            - Y co-ordinate to store
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Set the value of the direction of the shape to be drawn onto the canvas.
	 * 
	 * @param direction
	 *            - direction to store
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * Set the value of the acceleration of the shape to be drawn onto the
	 * canvas.
	 * 
	 * @param acceleration
	 *            - acceleration to store
	 */
	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	@Override
	public String toString() {
		return "Shape configuration (x: " + this.getX() + ", y: " + this.getY()
				+ ", direction: " + this.getDirection() + ", acceleration: "
				+ this.getAcceleration() + ")";

	}
}
