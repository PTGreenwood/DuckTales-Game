package uq.deco2800.ducktales.features.entities.resourceentities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import uq.deco2800.ducktales.rendering.sprites.*;
import uq.deco2800.ducktales.resources.ResourceInfoRegister;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.util.exceptions.DroppableResourceNotRegisteredException;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

/**
 * Manager for all the resource entities in the game.
 *
 * @author Damian Maher
 */

public class ResourceEntityManager extends SecondaryManager {

	/**
	 * The list of resource sprites Using an ArrayList
	 * to store the sprites
	 */
	private List<DroppedResourceSprite> resourceSprites;

    /**
     * List of all trees currently rendered into the game
     * The key is the hashcode of the corresponding {@link Tree} object
     */
    private HashMap<Integer, TreeSprite> treeSprites;

    /**
     * Instantiate an empty resource manager
     */
    public ResourceEntityManager() {
        resourceSprites = new ArrayList<DroppedResourceSprite>();
        treeSprites = new HashMap<>(50);
    }

    /**
     * This is a method used for testing purposes: this will create a number
     * of trees based on the given amount
     *
     * @param amount
     *          The number of trees to create randomly
     */
    public void createRandomTrees(int amount) {
        if (gameManager == null || world == null) {
            throw new GameSetupException("ResourceEntityManager does not have" +
                    " a reference on the ");
        }

        // Grab the resource entity manager
        ResourceEntityManager resourceManager = gameManager.
        		 getMainEntityManager()
                .getResourceEntityManager();

        // The bounds to randomize integers with
        int widthBound = this.world.getWidth();
        int heightBound = this.world.getHeight();

        Random random = new Random();
        int randomX;
        int randomY;

        for (int i = 0; i < amount; i++) {
            do {
                randomX = random.nextInt(widthBound);
                randomY = random.nextInt(heightBound);
            } while (!world.checkTileAvailability(
                    randomX, randomY, 1, 1));

            // At this point, randomX and randomY should be available
            // final checks:
            if (world.checkTileAvailability(randomX, randomY, 1, 1)) {
                resourceManager.addTree(ResourceType.TREE_1_SUMMER, randomX, randomY);
            }
        }
        System.err.println("\n\n\n Number of trees in the world:" +
                " " + treeSprites.size() + "\n\n");
    }

    /**
     * Add a tree of the given type to the given location. This code will
     * also instantiate a sprite of the tree and add it to the world
     *
     * @param treeType
     *          The type of the tree to be created and added
     * @param x
     *          The x-coordinate of the tile where the tree should be on
     * @param y
     *          The y-coordinate of that said tile
     */
    public void addTree(ResourceType treeType, int x, int y) {
        // Check for reference on world and game manager
        if (world == null) {
            throw new GameSetupException("ResourceEntityManager does not have" +
                " a handle on the World yet. Please make sure this manager's" +
                " 'world' variable is instantiated before attempting to add" +
                " a tree");
        } else if (gameManager == null) {
           throw new GameSetupException("ResourceEntityManager does not have " +
                   "a handle on GameManager yet before attempt to add a tree");
        }

        // Check if the given x- and y-coordinates are within the bounds
        // of the world map
        if (world.getWidth() < x || world.getHeight() < y) {
            throw new GameSetupException("Location given to add the tree" +
                    " onto is invalid");
        }

        // Instantiate a tree, passing in its location
        Tree tree = new Tree(x, y);

        // Instantiate a sprite with the type of the given tree
        TreeSprite sprite = new TreeSprite(tree.hashCode());
        sprite.setImage(ResourceSpriteRegister.getInstance()
                .getResourceImage(treeType));
        Sprite.setupEntitySprite(sprite, x, y, gameManager
                .getWorldDisplayManager().getTilesManager());

        // Add the tree and its sprites to the corresponding lists
        world.addTree(tree);
        treeSprites.put(tree.hashCode(), sprite);

        // Now add the sprite to the game world
        gameManager.getWorldDisplayManager().getWorldDisplay().getChildren()
                .add(sprite);
    }
    
    /**
     * Return the sprite of a tree given its unique key value
     * 
     * @param key
     * 			The unique identifier of a particular tree, in this case 
     *          the hashcode
     */
	public TreeSprite getTree(int key){
		return treeSprites.get(key);
	}
	
	
    /**
     * Add a resource drop at the location specified, this method mainly is used
     * to drop an animal related resource when an animal dies (e.g. drop 
     * beef resource when a cow dies, etc)
     *
     * @param type
     *          The type of resource to be added
     * @param x
     *          The x-coordinate of the resource in regards to the world size
     * @param y
     *          The y-coordinate of the resource in regards to the world size
     */

	/**
	 * Add a resource drop at the location specified, this method mainly is used
	 * to drop an animal related resource when an animal dies (e.g. drop beef
	 * resource when a cow dies, etc)
	 *
	 * @param type
	 *            The type of resource to be added
	 * @param x
	 *            The x-coordinate of the resource in regards to the world size
	 * @param y
	 *            The y-coordinate of the resource in regards to the world size
	 */
	public void dropResource(ResourceType type, int x, int y) {
		// Construct a new droppable resource from the given type
		DroppableResourceEntity resource = ResourceInfoRegister.
				createDroppableResource(type, x, y);

		// check if the droppable resource has been registered
		if (resource != null) {
			if (this.gameManager != null) {
				resource.setGameManager(this.gameManager);
			} else {
				throw new GameSetupException(
						"Droppable resource class does not have" + 
				        "a reference of Game Manager yet");
			}

			// Add that droppable resource to the droppable resource list
			world.addDroppedResource(resource);

			// Add the sprite of the resource to the sprites list, and set
			// the position of that sprite
			DroppedResourceSprite sprite = SpritesFactory.
					createDroppableResourceSprite(type);

			if (sprite == null) {
				throw new GameSetupException("Sprite of type " + 
			    type + " is not yet registered in SpritesFactory");
			}

			// Setup the sprite
			Sprite.setupEntitySprite(sprite, x, y, gameManager.
					getWorldDisplayManager().getTilesManager());

			// Add the sprite to the array list
			resourceSprites.add(sprite);

			// Add the sprite to the world display
			gameManager.getWorldDisplayManager().getWorldDisplay().
			       getChildren().add(sprite);

		} else {
			throw new DroppableResourceNotRegisteredException(
					"The droppable resource requested" + " "
				    + "is not yet registered in ResourceInfoRegister");
		}
	}

    /**
     * Move all the animal sprites by the given x- and y-amount
     *
     * @param xAmount
     *          The amount to move in x-direction
     * @param yAmount
     *          The amount to move in y-direction
     */
	public void moveAllSprites(double xAmount, double yAmount) {
        for (int key : treeSprites.keySet()) {
            TreeSprite sprite = treeSprites.get(key);

            if (sprite != null) {
                sprite.setLayoutX(sprite.getLayoutX() + xAmount);
                sprite.setLayoutY(sprite.getLayoutY() + yAmount);
            } else {
                throw new GameSetupException("A TREE sprite is not yet " +
                        "instantiated");
            }
        }
    }
}
