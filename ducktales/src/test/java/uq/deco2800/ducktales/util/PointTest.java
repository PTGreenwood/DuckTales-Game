package uq.deco2800.ducktales.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {
	
	@Test
	public void pointTypePoint() {
		Point testPoint = new Point(3.0,4.0);
		Point point2 = new Point(testPoint);
		
		assertTrue("x", point2.getX() == 3.00);
		assertTrue("y", point2.getY() == 4.00);
	}
	
	@Test
	public void distanceTest() {
		Point testPoint = new Point(3.0,4.0);
		Point point2 = new Point(5.0,5.0);
		
		assertTrue("distance", testPoint.distance(point2) == (point2.distance(testPoint)));		
	}
	
	@Test
	public void toStringTest() {
		Point testPoint = new Point(3.0,4.0);
		Point point2 = new Point(5.9,0.4);
		
		assertTrue("testPoint string", testPoint.toString().equals("[3.00, 4.00]"));
		assertTrue("point2 string", point2.toString().equals("[5.90, 0.40]"));
	}
	
	@Test
	public void equalsTest() {
		Point testPoint = new Point(3.0,4.0);
		Point testPoint2 = new Point(4.0,4.0);
		Point testPoint3 = new Point(3.0,4.1);
		Object object = new Object();
		Point point2 = new Point(5.9,0.4);
		Point point3 = new Point(5.9,0.4);
		
		assertTrue("not equal wrong type", testPoint.equals(object) == false);
		assertTrue("not equal, different types", point2.equals(testPoint) == false);
		assertTrue("not equal 1st value different", testPoint.equals(testPoint2) == false);
		assertTrue("not equal 2nd value different", testPoint.equals(testPoint3) == false);
		assertTrue("equal to itself", point2.equals(point2) == true);
		assertTrue("equal to same value, different objects", point2.equals(point3) == true);
	}
	
	@Test
	public void hashCodeTest() {
		Point testPoint = new Point(3.0,4.0);
		Point testPoint2 = new Point(3.0,4.0);
		Point point2 = new Point(5.9,0.4);
		
		assertTrue("different locations different", testPoint.hashCode() != point2.hashCode());
		assertTrue("same locations equal", testPoint.hashCode() == testPoint2.hashCode());
	}
		
	@Test
	public void compareToTest() {
		Point testPoint = new Point(3.0,4.0);
		Point testPoint2 = new Point(2.0,4.0);
		Point point2 = new Point(5.9,0.4);
		Point point3 = new Point(5.0,4.0);
		
		assertTrue("check y values", testPoint.compareTo(point2) == 1);
		assertTrue("check y values", point2.compareTo(testPoint) == -1);
		assertTrue("diff y", point2.compareTo(testPoint) == -1);
		assertTrue("same y", testPoint.compareTo(testPoint2) == 1);
		assertTrue("same y", testPoint.compareTo(testPoint) == 0);
		assertTrue("same y", testPoint.compareTo(point3) == -1);
	}
	
	@Test
	public void moveTest() {
		Point testPoint = new Point(3.0,4.0);
		Point testPoint2 = new Point(2.0,4.0);
		Point point2 = new Point(5.9,0.4);
		
		testPoint.moveToward(testPoint2, 10);
		assertTrue("distance(point) < distance", testPoint.getX() == 2);
		assertTrue("distance(point) < distance", testPoint.getY() == 4);
	}
	
	@Test
	public void moveTestTwo() {
		Point testPoint = new Point(3.0,4.0);
		Point testPoint2 = new Point(2.0,4.0);
		Point point2 = new Point(5.9,0.4);
		
		testPoint.moveToward(point2, 1);
		double deltaX = 3.0 - 5.9;
		double deltaY = 4.0 - 0.4;
		double angle;
 
		angle = Math.atan2(deltaY, deltaX) + Math.PI;
 
		double xShift = Math.cos(angle) * 1.0;
		double yShift = Math.sin(angle) * 1.0;
 
		double x = 3.0;
		double y = 4.0;
		x += xShift;
		y += yShift;

		assertTrue("distance(point) > distance", testPoint.getX() == x);
		assertTrue("distance(point) > distance", testPoint.getY() == y);
	}
}