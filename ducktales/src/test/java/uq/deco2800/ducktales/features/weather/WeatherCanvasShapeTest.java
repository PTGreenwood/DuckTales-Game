package uq.deco2800.ducktales.features.weather;

import org.junit.Test;
import org.junit.Assert;

public class WeatherCanvasShapeTest {
	@Test
	public void testShapeGetAndSet() {
		int x = 0;
		int y = 0;
		int direction = 0;
		int acceleration = 0;

		WeatherCanvasShape shape = new WeatherCanvasShape(x, y, direction,
				acceleration);

		Assert.assertEquals(shape.getX(), 0);
		Assert.assertEquals(shape.getY(), 0);
		Assert.assertEquals(shape.getDirection(), 0);
		Assert.assertEquals(shape.getAcceleration(), 0);
		Assert.assertEquals(shape.toString(),
				"Shape configuration (x: 0, y: 0, "
						+ "direction: 0, acceleration: 0)");

		shape.setX(-5);
		shape.setY(-10);
		shape.setDirection(-6);
		shape.setAcceleration(-3);

		Assert.assertEquals(shape.getX(), -5);
		Assert.assertEquals(shape.getY(), -10);
		Assert.assertEquals(shape.getDirection(), -6);
		Assert.assertEquals(shape.getAcceleration(), -3);
		Assert.assertEquals(shape.toString(),
				"Shape configuration (x: -5, y: -10, "
						+ "direction: -6, acceleration: -3)");

		shape.setX(16);
		shape.setY(335);
		shape.setDirection(123);
		shape.setAcceleration(900);

		Assert.assertEquals(shape.getX(), 16);
		Assert.assertEquals(shape.getY(), 335);
		Assert.assertEquals(shape.getDirection(), 123);
		Assert.assertEquals(shape.getAcceleration(), 900);
		Assert.assertEquals(shape.toString(),
				"Shape configuration (x: 16, y: 335, "
						+ "direction: 123, acceleration: 900)");

	}
	
	@Test
	public void testPositiveShapeCreation() {
		int x = 9;
		int y = 5;
		int direction = 12;
		int acceleration = 99;

		WeatherCanvasShape shape = new WeatherCanvasShape(x, y, direction,
				acceleration);

		Assert.assertEquals(shape.getX(), 9);
		Assert.assertEquals(shape.getY(), 5);
		Assert.assertEquals(shape.getDirection(), 12);
		Assert.assertEquals(shape.getAcceleration(), 99);
		Assert.assertEquals(shape.toString(),
				"Shape configuration (x: 9, y: 5, "
						+ "direction: 12, acceleration: 99)");
	}
	
	@Test
	public void testNegativeShapeCreation() {
		int x = -9;
		int y = -5;
		int direction = -12;
		int acceleration = -99;

		WeatherCanvasShape shape = new WeatherCanvasShape(x, y, direction,
				acceleration);

		Assert.assertEquals(shape.getX(), -9);
		Assert.assertEquals(shape.getY(), -5);
		Assert.assertEquals(shape.getDirection(), -12);
		Assert.assertEquals(shape.getAcceleration(), -99);
		Assert.assertEquals(shape.toString(),
				"Shape configuration (x: -9, y: -5, "
						+ "direction: -12, acceleration: -99)");
	}
}
