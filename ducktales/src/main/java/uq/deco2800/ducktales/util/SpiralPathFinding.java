/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uq.deco2800.ducktales.util;

import java.util.ArrayList;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.util.Coordinate;

/**
 * class will be used to find a free surrounding tile given a specified tile.
 * 
 * @author Eduardo and Nicolas Turner
 */
public class SpiralPathFinding {

	/**
	 * Generates a list of all possible coordinates that an object can be placed
	 * at the front of a building
	 *
	 * @param x
	 *            The x coordinate of the building
	 * @param y
	 *            The y coordinate of the building
	 * @param sizex
	 *            The length of the building
	 * @param sizey
	 *            The height of the building
	 */
	private static ArrayList<Coordinate> getAllPossibleCoordinates(int x, int y, int sizex, int sizey) {
		int i;
		int j;

		ArrayList<Coordinate> possibleCoordinates = new ArrayList<>();

		possibleCoordinates.add(new Coordinate(x + 1, y + 1));

		for (i = 1; i <= sizex + 1; i++) {
			possibleCoordinates.add(new Coordinate(x + 1 - i, y + 1));
		}
		for (j = 1; j <= sizey + 1; j++) {
			possibleCoordinates.add(new Coordinate(x + 1, y + 1 - j));
		}

		return possibleCoordinates;
	}

	/**
	 * Finds the next avaliable space that an object can be placed on the game
	 * board
	 *
	 * @param x
	 *            The x coordinate of the building
	 * @param y
	 *            The y coordinate of the building
	 * @param sizex
	 *            The length of the building
	 * @param sizey
	 *            The height of the building
	 * @param world
	 *            The Game world
	 */
	public Coordinate getFrontCoordinate(int x, int y, int sizex, int sizey, World world) {

		ArrayList<Coordinate> allPossibleCoordinates = getAllPossibleCoordinates(x, y, sizex, sizey);

		int i;
		for (i = 0; i < allPossibleCoordinates.size(); i++) {
			if (world.checkTileAvailability(allPossibleCoordinates.get(i).getX(), allPossibleCoordinates.get(i).getY(),
					1, 1)) {
				return allPossibleCoordinates.get(i);
			}
		}
		return null;
	}

}
