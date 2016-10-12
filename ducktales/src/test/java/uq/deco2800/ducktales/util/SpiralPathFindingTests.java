package uq.deco2800.ducktales.util;

import static org.junit.Assert.*;

import java.util.ArrayList;

import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.util.SpiralPathFinding;


public class SpiralPathFindingTests {
	
	public void getAllPossibleCoordinatesTest(){
		ArrayList<Coordinate> possibleCoordinates= SpiralPathFinding.getAllPossibleCoordinates(3,3,2,2);
		assertEquals(possibleCoordinates.get(0), new Coordinate(4,4));
		assertEquals(possibleCoordinates.get(1), new Coordinate(3,4));
		assertEquals(possibleCoordinates.get(2), new Coordinate(2,4));
		assertEquals(possibleCoordinates.get(3), new Coordinate(1,4));
		assertEquals(possibleCoordinates.get(4), new Coordinate(4,3));
		assertEquals(possibleCoordinates.get(5), new Coordinate(4,2));
		assertEquals(possibleCoordinates.get(6), new Coordinate(4,1));
	}
	
	public void getFrontCoordinateTest(){
		Coordinate coordinate = SpiralPathFinding.getFrontCoordinate(3, 3, 2, 2, new World("test", 30, 30));
		assertEquals(coordinate, new Coordinate(4,4));
	}
}
