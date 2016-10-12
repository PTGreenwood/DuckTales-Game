package uq.deco2800.ducktales.util;

import static org.junit.Assert.*;

public class CoordinateTest {
	
	public void getCoordinateTest(){
		Coordinate coordinate = new Coordinate(3,3);
		int[] coordinateValues = coordinate.getCoordinate();
		
		assertEquals(coordinateValues[0], 3);
		assertEquals(coordinateValues[1], 3);
	}
	
	public void getXCoordinateTest(){
		Coordinate coordinate = new Coordinate(3,3);
		int xValue = coordinate.getX();
		assertEquals(xValue, 3);
	}
	
	public void getYCoordinateTest(){
		Coordinate coordinate = new Coordinate(3,3);
		int yValue = coordinate.getX();
		assertEquals(yValue, 3);
	}
}
