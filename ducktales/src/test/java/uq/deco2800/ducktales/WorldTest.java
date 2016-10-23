package uq.deco2800.ducktales;


import org.junit.Test;

import uq.deco2800.ducktales.features.entities.agententities.Animal;
import uq.deco2800.ducktales.features.entities.resourceentities.Tree;
import uq.deco2800.ducktales.features.landscape.tiles.Tile;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Point;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

import static org.junit.Assert.*;

/**
 * Test for the {@link World} class, which is the main model of the game
 *
 * Created on 22/10/2016.
 * @author khoiphan21
 * @author Oliver Yule
 */
public class WorldTest {
    private final String NAME = "World name";
    private final int WIDTH = 10;
    private final int HEIGHT = 10;

    @Test
    public void testBasicTreeAddition() {
        World world = new World(NAME, WIDTH, HEIGHT);

        Tree tree = new Tree(5, 5);

        world.addTree(tree);

        assertEquals(tree, world.getTree(tree.hashCode()));
    }

    @Test(expected = GameSetupException.class)
    public void testAddingMultipleTree() {
        World world = new World(NAME, WIDTH, HEIGHT);

        Tree tree = new Tree(5, 5);

        world.addTree(tree);
        world.addTree(tree);

    }

    /** Test boundary cases of constructor. */
    @Test
    public void boundaryTest() {
    	World boundaryWorld1 = new World("1", 0, 0);
    	World boundaryWorld2 = new World("", 1, 1);
    }
    
    /**
     * Typical use case.
     * Test constructor, getName(), getWidth(), getHeight(), getTile(),
     * addAnimal(), getEntitiesNumber(), getAnimal()
     */
    @Test
    public void typicalTest() {
    	World typicalWorld = new World("TestWorld", 30, 40);
    	Animal testAnimal1 = new Animal(2, 2, ResourceType.SHEEP, 25, 25, 25, 25, 2);
    	Animal testAnimal2 = new Animal(4, 4, ResourceType.SHEEP, 25, 25, 25, 25, 2);
    	
    	assertTrue(typicalWorld.getName().equals("TestWorld"));
    	assertFalse(typicalWorld.getName().equals("WrongName"));
    	
    	assertTrue(typicalWorld.getWidth() == 30);
    	assertFalse(typicalWorld.getWidth() == 10);
    	
    	assertTrue(typicalWorld.getHeight() == 40);
    	assertFalse(typicalWorld.getHeight() == 10);
    	
    	// Test getTile() and ensure that tile types are set to default.
    	assertTrue(typicalWorld.getTile(2, 2).getTileType().equals(
    			World.getDefaultTileType()));
    	if (!World.getDefaultTileType().equals(ResourceType.WATER)) {
	    	assertFalse(typicalWorld.getTile(1, 5).getTileType().equals(
	    			ResourceType.WATER));
    	}
    	
    	assertTrue(typicalWorld.getEntitiesNumber() == 0);
    	typicalWorld.addAnimal(testAnimal1);
    	assertTrue(typicalWorld.getEntitiesNumber() == 1);
    	typicalWorld.addAnimal(testAnimal2);
    	assertTrue(typicalWorld.getEntitiesNumber() == 2);
    	
    	assertTrue(typicalWorld.getAnimal(0).equals(testAnimal1));
    	assertFalse(typicalWorld.getAnimal(0).equals(testAnimal2));
    	assertTrue(typicalWorld.getAnimal(1).equals(testAnimal2));
    }
    
    /** Test illegal constuctor parameter. */
    @Test (expected=NegativeArraySizeException.class)
    public void testNegativeDimensions() {
    	World testWorld = new World("TestWorld", -1, 1);
    }
    
    /** Test getTile(x,y) where x,y outside of world dimensions. */
    @Test (expected=IndexOutOfBoundsException.class)
    public void testGetTile() {    	
    	World testWorld = new World("TestWorld", 10, 10);
    	testWorld.getTile(new Point(1,15));
    }
    
    /** Test adding same animal twice. */
    @Test (expected=RuntimeException.class)
    public void testAddAnimal() {
    	World testWorld = new World("World", 10, 10);
    	Animal testAnimal = new Animal(2, 2, ResourceType.SHEEP, 25, 25, 25, 25, 2);

    	testWorld.addAnimal(testAnimal);
    	testWorld.addAnimal(testAnimal);
    }
    
    /** Test getAnimal(index) when index out of bounds. */
    @Test (expected=IndexOutOfBoundsException.class)
    public void testGetAnimal() {
    	World testWorld = new World("World", 10, 10);
    	Animal testAnimal = new Animal(2, 2, ResourceType.SHEEP, 25, 25, 25, 25, 2);
    	testWorld.addAnimal(testAnimal);
    	testWorld.getAnimal(1);
    }
}
