package uq.deco2800.ducktales.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class Array2DTest {
	
	/**
	 * Test the get height, width and size methods
	 */
	@Test
	public void basicTest() {
		Array2D testArray = new Array2D(4, 4);
		Array2D testArray2 = new Array2D(9, 20);
		
		assertTrue("get width", testArray.getWidth() == 4);
		assertTrue("get width", testArray2.getWidth() == 9);
		assertTrue("get height", testArray.getHeight() == 4);
		assertTrue("get height", testArray2.getHeight() == 20);
		
		assertTrue("size", testArray.size() == 16);
		assertTrue("size", testArray2.size() == 180);
	}
	
	/**
	 * Test all cases that throw an IndexOutOfBounds Exception
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void getTest() {
		Array2D testArray = new Array2D(4, 4);
		Array2D testArray2 = new Array2D(9, 20);
		
		// Both larger
		testArray.get(9, 9);
		// One larger and one equal
		testArray.get(4, 9);
		//Other larger and equal
		testArray.get(9, 4);
		// larger and 0
		testArray.get(5, 0);
		// smaller and larger
		testArray2.get(7, 90);
		// one -ve
		testArray2.get(-7, 10);
		// both -ve
		testArray2.get(-7, -10);
		// one -ve
		testArray2.get(7, -10);
		
		testArray.get(7, -10);
		
		testArray.get(-7, 10);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=IndexOutOfBoundsException.class)
	public void setTest() {
		Array2D testArray = new Array2D(4, 4);
		Array2D testArray2 = new Array2D(9, 20);
		Object t = testArray.get(3, 2);
		
		// Both larger
		testArray.set(9, 9, t);
		// One larger and one equal
		testArray.set(4, 9, t);
		//Other larger and equal
		testArray.set(9, 4, t);
		// larger and 0
		testArray.set(5, 0, t);
		// smaller and larger
		testArray2.set(7, 90, t);
		// one -ve
		testArray2.set(-7, 10, t);
		// both -ve
		testArray2.set(-7, -10, t);
		// one -ve
		testArray2.set(7, -10, t);
		
		testArray.set(7, -10, t);
		
		testArray.set(-7, 10, t);
	}
}