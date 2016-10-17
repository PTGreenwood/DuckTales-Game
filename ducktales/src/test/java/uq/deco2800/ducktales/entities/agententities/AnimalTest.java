package uq.deco2800.ducktales.entities.agententities;

import org.junit.Test;

import uq.deco2800.ducktales.features.entities.agententities.Cow;
import uq.deco2800.ducktales.features.entities.agententities.Duck;
import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.features.entities.agententities.Sheep;
import uq.deco2800.ducktales.resources.ResourceType;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Contains tests for the animal class.
 *
 * @author Josh Benavides, Damian Maher
 */
public class AnimalTest {

    /**
     * Tests Animal class methods and instantiation.
     */
    @Test
    public void animalTest() {

    	// Create base entities for testing purposes.
        Duck duck = new Duck(10, 10);
        Peon opponent = new Peon(10, 10);

        // Test whether the creation of Animal has no null attributes.
        assertNotNull("Duck cannot be null.", duck);
        assertNotNull("X coordinate cannot be null.", duck.getX());
        assertNotNull("Y coordinate cannot be null.", duck.getY());
        assertNotNull("ResourceType of animal cannot be null.", duck.getType());
        assertNotNull("Health cannot be null.", duck.getHealth());
        assertNotNull("Hunger cannot be null.", duck.getHunger());
        assertNotNull("Thirst cannot be null.", duck.getThirst());
        assertNotNull("Strength cannot be null.", duck.getStrength());
        assertNotNull("Speed cannot be null.", duck.getSpeed());


        // Test whether Animal class methods return expected values on instantiation.
        assertTrue("Speed is incorrect.", duck.getSpeed() == 0.05);
        assertTrue("Type is incorrect.", duck.getType() == ResourceType.DUCK);
        assertTrue("Duck cannot be killed on creation.", duck.canBeKilled() == false);
        assertTrue("Duck cannot lay eggs on creation.", duck.canLayEggs() == false);
        assertTrue("Duck cannot drop feathers on creation.", duck.canDropFeathers() == false);
        assertTrue("Duck cannot be dead on creation.", duck.isDead() == false);


        // Test attribute setters from Animal class
        duck.setHealth(101);
        assertTrue("Animal health should be 100 if parameter is greater than 100. ", duck.getHealth() == 100);
        duck.setHealth(50);
        assertTrue("Animal health should equal the parameter.", duck.getHealth() == 50);
        duck.setHealth(-1);
        assertTrue("Animal health should be 0 if the parameter is less than 0.", duck.getHealth() == 0);
        duck.setHunger(101);
        assertTrue("Animal hunger should be 100 if parameter is greater than 100. ", duck.getHunger() == 100);
        duck.setHunger(50);
        assertTrue("Animal hunger should equal the parameter.", duck.getHunger() == 50);
        duck.setHunger(-1);
        assertTrue("Animal hunger should be 0 if the parameter is less than 0.", duck.getHunger() == 0);
        duck.setThirst(101);
        assertTrue("Animal thirst should be 100 if parameter is greater than 100. ", duck.getThirst() == 100);
        duck.setThirst(50);
        assertTrue("Animal thirst should equal the parameter.", duck.getThirst() == 50);
        duck.setThirst(-1);
        assertTrue("Animal thirst should be 0 if the parameter is less than 0.", duck.getThirst() == 0);
        duck.setStrength(10);
        assertTrue("Strength has an incorrect value.", duck.getStrength() == 10);

        // Attack tests.
        duck.setHealth(100);
        duck.setStrength(20);
        opponent.setHealth(100);
//        opponent.setStrength(20);
        duck.attack(opponent);
//        assertTrue("Opponent health must decrease by the animal's strength.", opponent.getHealth() == 80);
        duck.setHealth(0);
        
        assertTrue("Animal must be dead when its health is 0;", duck.isDead() == true);
    }

    @Test
    public void duckTest () {

        // Create base entities for testing purposes.
        Duck duck = new Duck(10, 10);

        // Test if duck can drop resources appropriately.
        duck.setHealth(100); // Set attributes to pass attribute threshold for laying eggs.
        duck.setHunger(100);
        duck.setThirst(100);
        duck.layEggs();
        assertTrue("Duck can only lay eggs if the health, hunger, and thirst thresholds are met.", duck.canLayEggs()
                == true);
        duck.setHealth(0);
     
        duck.dropFeathers();
        assertTrue("Duck must be dead to drop feathers.", duck.canDropFeathers() == true);

    }

    /**
     * Tests creation of cow.
     */
    @Test
    public void cowTest () {

    	// Create base entities for testing purposes.
        Cow cow = new Cow(10, 10);

        // Test if cows drop resources appropriately.
        cow.setHealth(100); // Set attributes to pass attribute threshold for producing milk and beef.
        cow.setHunger(100);
        cow.setThirst(100);
        cow.produceMilk();
        assertTrue("Cow can only produce milk if the health, hunger, and thirst thresholds are met.", cow
                .canProduceMilk() == true);
        cow.setHealth(0);
        
        cow.produceBeef();
        assertTrue("Cow must be dead to drop beef.", cow.canProduceBeef() == true);
    }

    /**
     * Tests creation of sheep.
     */
    @Test
    public void sheepTest () {

    	// Create base entities for testing purposes.
        Sheep sheep = new Sheep(10, 10);
        Peon opponent = new Peon(10, 10);

        // Test if cows drop resources appropriately.
        sheep.setHealth(100); // Set attributes to pass attribute threshold for producing milk and beef.
        sheep.setHunger(100);
        sheep.setThirst(100);
        sheep.produceWool();
        assertTrue("Sheep can only produce wool if the health, hunger, and thirst thresholds are met.", sheep
                .canProduceWool() == true);
        sheep.setHealth(0);
        
        sheep.produceMutton();
        assertTrue("Sheep must be dead to drop mutton.", sheep
                .canProduceMutton() == true);
    }
}
