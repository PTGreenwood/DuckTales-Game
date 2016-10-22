package uq.deco2800.ducktales.features.entities.resourceentities;

import static uq.deco2800.ducktales.resources.ResourceType.*;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Tree. Class containing all properties and specifications of a tree.
 * 
 * @author Andrew Georgiou, 4318457
 *
 */
public class Tree extends ResourceEntity {

	// Resource types
	private static final ResourceType[] TYPES = { TREE_1, TREE_2, TREE_3 };

	// Scheduler for growing trees. Set to grow every in game season(24min real
	// time).
	private final ScheduledExecutorService scheduler = 
			Executors.newScheduledThreadPool(1);

	// Logger for the class
	private static final Logger LOGGER = Logger.getLogger(Tree.class.getName());

	/**
	 * Initialise a new tree. Requires the location of the tree to be passed.
	 * 
	 * @param x,
	 *            x location of the tree
	 * @param y,
	 *            y location of the tree
	 * @throws Exception
	 */
	public Tree(double x, double y) {
		super(x, y, 1, 1, rare(TYPES), DEFVALUE);
		// Scheduling the runnable to run every minute in real time.
		scheduler.scheduleAtFixedRate(createRunnable(this), 24, 24, 
				TimeUnit.MINUTES);
		/*
		 * If the tree is the last type in the list, which will always be the
		 * rare, set the value of the Resource to be double.
		 */
		if (this.getType() == TYPES[TYPES.length - 1]) {
			this.setValue(2 * DEFVALUE);
		}
	}

	/**
	 * Runnable that is in charge of growing the tree
	 * 
	 * @param tree,
	 *            the tree to be grown
	 * 
	 * @return the runnable
	 */
	private Runnable createRunnable(Tree tree) {
		Runnable aRunnable = new Runnable() {
			public void run() {
				try {
					tree.increaseValue(50);
				} catch (Exception e) {
					LOGGER.log(Level.SEVERE, e.toString(), e);
				}
			}
		};
		return aRunnable;
	}

	/**
	 * Function added to avoid error in Lumberjack class will possibly be
	 * removed later.
	 * 
	 * @param loggers
	 * 
	 */
	public void lumber(Peon loggers) {
	}

	/**
	 * required implementation of the tick method
	 */
	@Override
	public void tick() {
	}

	/**
	 * required implementation of the ispassable method
	 */
	@Override
	public boolean isPassable() {
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}

		Tree tree = (Tree) o;

		return tree.hashCode() == this.hashCode();

	}

	@Override
	public int hashCode() {
		// this is okay since the location of a tree should not change
		int result = 31 * (int) this.getX();
		result = 31 * result + (int) this.getY();

		return result;
	}
}