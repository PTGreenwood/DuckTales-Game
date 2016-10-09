package uq.deco2800.ducktales.features.weather;

public class WeatherCanvasShape {
	private int x;
	private int y;
	private int direction;
	private int acceleration;
	
	public WeatherCanvasShape(int x, int y, int direction, int acceleration) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.acceleration = acceleration;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public int getAcceleration() {
		return this.acceleration;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
