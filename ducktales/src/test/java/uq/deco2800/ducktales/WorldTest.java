package uq.deco2800.ducktales;


import org.junit.Test;

import uq.deco2800.ducktales.features.entities.agententities.Animal;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.entities.resourceentities.DroppableResourceEntity;
import uq.deco2800.ducktales.features.entities.resourceentities.Tree;
import uq.deco2800.ducktales.features.entities.worldentities.*;
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

    /** Test boundary cases of constructor. */
    @Test
    public void boundaryTest() {
    	World boundaryWorld1 = new World("1", 0, 0);
    	World boundaryWorld2 = new World("", 1, 1);
    }
    
    /**
     * Typical use case.
     * Test typical use of constructor and public methods.
     */
    @Test
    public void typicalTest() {
    	World typicalWorld = new World("TestWorld", 30, 40);
    	
    	assertTrue(typicalWorld.getName().equals("TestWorld"));
    	assertFalse(typicalWorld.getName().equals("WrongName"));
    	
    	assertTrue(typicalWorld.getWidth() == 30);
    	assertFalse(typicalWorld.getWidth() == 10);
    	
    	assertTrue(typicalWorld.getHeight() == 40);
    	assertFalse(typicalWorld.getHeight() == 10);
    	
    	// Test getTile() and ensure that tile types are set to default.
    	assertTrue(typicalWorld.getTile(2, 2).getTileType().equals(
    			World.getDefaultTileType()));
    	assertTrue(typicalWorld.getTile(new Point(10, 15)).getTileType().equals(
    			World.getDefaultTileType()));
    	if (!World.getDefaultTileType().equals(ResourceType.WATER)) {
	    	assertFalse(typicalWorld.getTile(1, 5).getTileType().equals(
	    			ResourceType.WATER));
    	}
    	
    	Animal testAnimal1 = new Animal(2, 2, ResourceType.SHEEP, 25, 25, 25, 25, 2);
    	Animal testAnimal2 = new Animal(4, 4, ResourceType.SHEEP, 25, 25, 25, 25, 2);
    	assertTrue(typicalWorld.getEntitiesNumber() == 0);
    	typicalWorld.addAnimal(testAnimal1);
    	assertTrue(typicalWorld.getEntitiesNumber() == 1);
    	typicalWorld.addAnimal(testAnimal2);
    	assertTrue(typicalWorld.getEntitiesNumber() == 2);
    	
    	assertTrue(typicalWorld.getAnimal(0).equals(testAnimal1));
    	assertFalse(typicalWorld.getAnimal(0).equals(testAnimal2));
    	assertTrue(typicalWorld.getAnimal(1).equals(testAnimal2));
    	
    	Peon testPeon1 = new Peon(1, 1, "TestPeon1");
    	Peon testPeon2 = new Peon(2, 2, "TestPeon1");
    	typicalWorld.addPeon("TestPeon1", testPeon1);
    	assertTrue(typicalWorld.getEntitiesNumber() == 3);
    	typicalWorld.addPeon("TestPeon2", testPeon2);
    	assertTrue(typicalWorld.getEntitiesNumber() == 4);
    	
    	assertTrue(typicalWorld.getPeon("TestPeon1").equals(testPeon1));
    	assertFalse(typicalWorld.getPeon("TestPeon1").equals(testPeon2));
    	assertTrue(typicalWorld.getPeon("TestPeon2").equals(testPeon2));
   	
    	assertTrue(typicalWorld.checkPeonNameDuplication("TestPeon1"));
    	assertFalse(typicalWorld.checkPeonNameDuplication("UnusedName"));

    	assertTrue(typicalWorld.getNumberOfPeons() == 2);
    	
    	Tree testTree1 = new Tree(5, 5);
    	Tree testTree2 = new Tree(6, 6);
        typicalWorld.addTree(testTree1);
    	assertTrue(typicalWorld.getEntitiesNumber() == 5);
        typicalWorld.addTree(testTree2);
    	assertTrue(typicalWorld.getEntitiesNumber() == 6);

        assertTrue(typicalWorld.getTree(testTree1.hashCode()).equals(testTree1));
        assertTrue(typicalWorld.getTree(testTree2.hashCode()).equals(testTree2));

        DroppableResourceEntity testDroppable = new DroppableResourceEntity(
        		2, 2, ResourceType.BOX);
        typicalWorld.addDroppedResource(testDroppable);
    	assertTrue(typicalWorld.getEntitiesNumber() == 7);
    	
    	assertTrue(typicalWorld.getDroppedResource(testDroppable.hashCode()).equals(testDroppable));

    	Building testBuilding = new Butcher(2, 2);
    	typicalWorld.addBuilding(testBuilding, 2,  2,  2,  2);
    	assertTrue(typicalWorld.getEntitiesNumber() == 8);
    	
    	assertTrue(typicalWorld.checkTileAvailability(15, 15, 2, 2));
    	assertFalse(typicalWorld.checkTileAvailability(2, 2, 2, 2));
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
    @Test (expected=GameSetupException.class)
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
    
    /** Test adding same peon twice. */
    @Test (expected=GameSetupException.class)
    public void testAddPeon() {
    	World testWorld = new World("TestWorld", 10, 10);
    	Peon testPeon = new Peon(1, 1, "TestPeon");
    	
    	testWorld.addPeon("TestPeon", testPeon);
    	testWorld.addPeon("TestPeon", testPeon);
    }
    
    /** Test getPeon(name) for invalid name. */
    @Test (expected=GameSetupException.class)
    public void testGetPeon() {
    	World testWorld = new World("TestWorld", 10, 10);
    	Peon testPeon = new Peon(1, 1, "TestPeon");
    	
    	testWorld.addPeon("TestPeon", testPeon);
    	testWorld.getPeon("WrongName");
    }
    
    /** Test adding same tree twice. */
    @Test (expected = GameSetupException.class)
    public void testAddTree() {
        World testWorld = new World("TestWorld", 10, 10);
        Tree tree = new Tree(5, 5);

        testWorld.addTree(tree);
        testWorld.addTree(tree);
    }
    
    /** Test getTree(hashcode) with non-matching hashcode. */
    @Test (expected=GameSetupException.class)
    public void testGetTree() {
    	World testWorld = new World("TestWorld", 10, 10);
    	Tree testTree = new Tree(2, 2);
    	
    	testWorld.addTree(testTree);
    	if (testTree.hashCode() != 1) {
    		testWorld.getTree(1);
    	} else {
    		testWorld.getTree(2);
    	}
    }

    /** Test adding same droppable entity twice. */
    @Test (expected = GameSetupException.class)
    public void testAddDroppedResource() {
        World testWorld = new World("TestWorld", 10, 10);
        DroppableResourceEntity testDroppable = new DroppableResourceEntity(
        		2, 2, ResourceType.BOX);
        
        testWorld.addDroppedResource(testDroppable);
        testWorld.addDroppedResource(testDroppable);
    }
    
    /** Test getDroppedResource(hashcode) with non-matching hashcode. */
    @Test (expected=GameSetupException.class)
    public void testGetDroppedResource() {
    	World testWorld = new World("TestWorld", 10, 10);
        DroppableResourceEntity testDroppable = new DroppableResourceEntity(
        		2, 2, ResourceType.BOX);
    	
    	testWorld.addDroppedResource(testDroppable);
    	if (testDroppable.hashCode() != 1) {
    		testWorld.getDroppedResource(1);
    	} else {
    		testWorld.getDroppedResource(2);
    	}
    }
    
    /** Test adding same building twice. */
    @Test (expected = GameSetupException.class)
    public void testAddBuilding() {
        World testWorld = new World("TestWorld", 10, 10);
    	Building testBuilding = new Butcher(2, 2);
    	
    	testWorld.addBuilding(testBuilding, 2,  2,  2,  2);
    	testWorld.addBuilding(testBuilding, 2,  2,  2,  2);        
    }
}
