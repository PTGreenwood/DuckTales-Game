package uq.deco2800.ducktales;

import java.util.LinkedList;
import java.util.List;

import uq.deco2800.ducktales.util.Point;
import uq.deco2800.ducktales.world.World;

/**
 * Manages the interaction between the user and the game.
 * 
 * @author Leggy
 *
 */
public class GameManager {

	private static final GameManager INSTANCE = new GameManager();

	private List<Point> selection;

	private int draggedX = -1;
	private int draggedY = -1;

	private int pressedX = -1;
	private int pressedY = -1;

	private World world;

	/**
	 * Returns the instance of {@link GameManager}.
	 * 
	 * @return Returns an instance of GameManager.
	 */
	public static GameManager getInstance() {
		return INSTANCE;
	}

	private GameManager() {
		selection = new LinkedList<Point>();
	}

	public void setPressed(int x, int y) {
		pressedX = x;
		pressedY = y;
	}

	public void setDragged(int x, int y) {
		if (draggedX != x || draggedY != y) {
			draggedX = x < 0 ? 0 : x;
			draggedY = y < 0 ? 0 : y;

			updateSelection(pressedX, pressedY, draggedX, draggedY);
		}
	}

	public void setReleased(int releasedX, int releasedY) {
		updateSelection(pressedX, pressedY, releasedX, releasedY);
		
		draggedX = -1;
		draggedY = -1;
		pressedX = -1;
		pressedY = -1;
	}

	public List<Point> getSelection() {
		return new LinkedList<Point>(selection);
	}

	private void updateSelection(int x1, int y1, int x2, int y2) {
		if (x1 == -1 || y1 == -1 || x2 == -1 || y2 == -1) {
			return;
		}

		selection = new LinkedList<Point>();

		int minX = Math.min(x1, x2);
		int maxX = Math.max(x1, x2);

		int minY = Math.min(y1, y2);
		int maxY = Math.max(y1, y2);

		for (int j = minY; j < maxY + 1; j++) {
			for (int i = minX; i < maxX + 1; i++) {
				selection.add(new Point(i, j));
			}
		}
	}

	/**
	 * Sets the current world.
	 * 
	 * @param world
	 *            The world to use.
	 */
	public void setWorld(World world) {
		this.world = world;
	}

	/**
	 * Gets the world
	 * 
	 * @return Returns the current world.
	 */
	public World getWorld() {
		return world;
	}
}
