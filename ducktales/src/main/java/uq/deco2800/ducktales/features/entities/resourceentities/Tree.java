package uq.deco2800.ducktales.features.entities.resourceentities;

import static uq.deco2800.ducktales.resources.ResourceType.*;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.seasons.SeasonManager;
import uq.deco2800.ducktales.features.time.TimeManager;
import uq.deco2800.ducktales.rendering.sprites.TreeSprite;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Tree. Class containing all properties and specifications of a tree.
 * 
 * @author Andrew Georgiou, 4318457
 *
 */
public class Tree extends ResourceEntity {

	// Resource types
	private static final ResourceType[] SUMMER_TYPES = { TREE_1_SUMMER, TREE_2_SUMMER, TREE_3_SUMMER };
	private static final ResourceType[] AUTUMN_TYPES = { TREE_1_AUTUMN, TREE_2_AUTUMN, TREE_3_AUTUMN };
	private static final ResourceType[] WINTER_TYPES = { TREE_1_WINTER, TREE_2_WINTER, TREE_3_WINTER };
	private static final ResourceType[] SPRING_TYPES = { TREE_1_SPRING, TREE_2_SPRING, TREE_3_SPRING };
	
	// Scheduler for growing trees. Set to grow every in game season(24min real
	// time).
	private final ScheduledExecutorService scheduler = 
			Executors.newScheduledThreadPool(1);
	
	// Manager for the Seasons
    private SeasonManager seasonManager;
	private TimeManager timeManager;
	
	// The ResourceEntityManager
	private ResourceEntityManager resourceEntityManager;

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
		super(x, y, 1, 1, rare(SPRING_TYPES), DEFVALUE);
		// Scheduling the runnable to run every minute in real time.
		scheduler.scheduleAtFixedRate(createRunnable(this), 24, 24, 
				TimeUnit.MINUTES);
		/*
		 * If the tree is the last type in the list, which will always be the
		 * rare, set the value of the Resource to be double.
		 */
		if (this.getType() == SPRING_TYPES[SPRING_TYPES.length - 1]) {
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
					if(tree.getType().equals(TREE_3_AUTUMN) || 
							tree.getType().equals(TREE_3_SUMMER) ||
							tree.getType().equals(TREE_3_SPRING) ||
							tree.getType().equals(TREE_3_WINTER)){
						updateRareSprite();
					}else{
						updateSprite();
					}			
				} catch (Exception e) {
					LOGGER.log(Level.SEVERE, e.toString(), e);
				}
			}
		};
		return aRunnable;
	}
	
	/**
	 * Method that updates the sprite of the tree depending on the season. Used for
	 * trees that are not rare.
	 *  
	 */
	private void updateSprite(){
		String season = seasonManager.getCurrentSeason().getName();
		TreeSprite sprite = resourceEntityManager.getTree(this.hashCode());
		if(season.equals("Summer")){
			sprite.setImage(ResourceSpriteRegister.getInstance().getResourceImage(TREE_1_SUMMER));
		}else if(season.equals("Autumn")){
			sprite.setImage(ResourceSpriteRegister.getInstance().getResourceImage(TREE_1_AUTUMN));
		}else if(season.equals("Winter")){
			sprite.setImage(ResourceSpriteRegister.getInstance().getResourceImage(TREE_1_WINTER));
		}else if(season.equals("Spring")){
			sprite.setImage(ResourceSpriteRegister.getInstance().getResourceImage(TREE_1_SPRING));
		}
	}
	/**
	 * Method that updates the sprite of the tree depending on the season. Used for
	 * trees that arerare.
	 *  
	 */
	private void updateRareSprite(){
		String season = seasonManager.getCurrentSeason().getName();
		TreeSprite sprite = resourceEntityManager.getTree(this.hashCode());
		if(season.equals("Summer")){
			sprite.setImage(ResourceSpriteRegister.getInstance().getResourceImage(TREE_3_SUMMER));
		}else if(season.equals("Autumn")){
			sprite.setImage(ResourceSpriteRegister.getInstance().getResourceImage(TREE_3_AUTUMN));
		}else if(season.equals("Winter")){
			sprite.setImage(ResourceSpriteRegister.getInstance().getResourceImage(TREE_3_WINTER));
		}else if(season.equals("Spring")){
			sprite.setImage(ResourceSpriteRegister.getInstance().getResourceImage(TREE_3_SPRING));
		}
	}
	
	/**
	 * Set the time manager and the season manager based off the time manager.
	 * 
	 * @param timeManager
	 *            the time manager to set
	 */
	public void setTimeManager(TimeManager timeManager) {
		this.timeManager = timeManager;
		this.seasonManager = timeManager.getSeasonManager();
	}
	
	/**
	 * Set the resourceEntitymanager.
	 * 
	 * @param resourceEntityManager
	 *            the manager to set
	 */
	public void setResourceEntityManager(ResourceEntityManager resourceEntityManager) {
		this.resourceEntityManager = resourceEntityManager;
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