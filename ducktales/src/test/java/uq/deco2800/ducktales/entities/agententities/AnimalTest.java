package uq.deco2800.ducktales.entities.agententities;

import org.junit.Test;

import uq.deco2800.ducktales.features.entities.EntityManager;
import uq.deco2800.ducktales.features.entities.agententities.Cow;
import uq.deco2800.ducktales.features.entities.agententities.Duck;
import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.resources.*;

import static org.junit.Assert.*;


/**
 * Contains tests for the animal class.
 *
 * @author Josh Benavides, Damian Maher
 */
public class AnimalTest {

    /**
     * Tests creation of duck.
     */
    @Test
    public void animalTest() {

    	// Create base entities for testing purposes
        EntityManager entityManager = EntityManager.getInstance();
        Duck duck = new Duck(10, 10);
        Peon opponent = new Peon(10, 10);
        entityManager.addEntity(duck);
        entityManager.addEntity(opponent);

        // Test whether the creation of Animal has no null attributes
        assertNotNull("Duck cannot be null.", duck);
        assertNotNull("X coordinate cannot be null.", duck.getX());
        assertNotNull("Y coordinate cannot be null.", duck.getY());
        assertNotNull("ResourceType of animal cannot be null.", duck.getType());
        assertNotNull("Health cannot be null.", duck.getHealth());
        assertNotNull("Hunger cannot be null.", duck.getHunger());
        assertNotNull("Thirst cannot be null.", duck.getThirst());
        assertNotNull("Strength cannot be null.", duck.getStrength());
        assertNotNull("Speed cannot be null.", duck.getSpeed());

        // Test whether Animal class methods return expected values.
        assertTrue("Speed is incorrect.", duck.getSpeed() == 0.05);
        assertTrue("Type is incorrect.", duck.getType() == ResourceType.DUCK);
        assertTrue("Duck cannot be killed on creation.", duck.canBeKilled() == false);
        assertTrue("Duck cannot lay eggs on creation.", duck.canLayEggs() == false);
        assertTrue("Duck cannot drop feathers on creation.", duck.canDropFeathers() == false);
        assertTrue("Duck cannot be dead on creation.", duck.isDead() == false);



        // Test attribute setters from Animal class
        duck.setHealth(101);
        assertTrue("Duck health should be 100 if parameter is greater than 100. ", duck.getHealth() == 100);
        duck.setHealth(50);
        assertTrue("Duck health should equal the parameter.", duck.getHealth() == 50);
        duck.setHealth(-1);
        assertTrue("Duck health should be 0 if the parameter is less than 0.", duck.getHealth() == 0);
        duck.setHunger(101);
        assertTrue("Duck hunger should be 100 if parameter is greater than 100. ", duck.getHunger() == 100);
        duck.setHunger(50);
        assertTrue("Duck hunger should equal the parameter.", duck.getHunger() == 50);
        duck.setHunger(-1);
        assertTrue("Duck hunger should be 0 if the parameter is less than 0.", duck.getHunger() == 0);
        duck.setThirst(101);
        assertTrue("Duck thirst should be 100 if parameter is greater than 100. ", duck.getThirst() == 100);
        duck.setThirst(50);
        assertTrue("Duck thirst should equal the parameter.", duck.getThirst() == 50);
        duck.setThirst(-1);
        assertTrue("Duck thirst should be 0 if the parameter is less than 0.", duck.getThirst() == 0);
        duck.setStrength(10);
        assertTrue("Strength has an incorrect value.", duck.getStrength() == 10);

//        duck.setType(ResourceType.DuckUp);

        // Attack tests.
        duck.setHealth(100);
        duck.setStrength(20);
        opponent.setHealth(100);
        //opponent.setStrength(20);
        duck.attack(opponent);
//        assertTrue("Opponent health must decrease by the animal's strength.", opponent.getHealth() == 80);
        duck.setHealth(0);
        duck.setIsDead();
        assertTrue("Duck must be dead when its health is 0;", duck.isDead() == true);
    }

    @Test
    public void duckTest () {

        // Create base entities for testing purposes.
        EntityManager entityManager = EntityManager.getInstance();
        Duck duck = new Duck(10, 10);
        Peon opponent = new Peon(10, 10);
        entityManager.addEntity(duck);
        entityManager.addEntity(opponent);

        // Test if duck can drop resources appropriately.
        duck.setHealth(100); // Set attributes to pass attribute threshold for laying eggs.
        duck.setHunger(100);
        duck.setThirst(100);
        duck.layEggs();
        assertTrue("Duck can only lay eggs if the health, hunger, and thirst thresholds are met.", duck.canLayEggs()
                == true);
        duck.setHealth(0);
        duck.setIsDead();
        duck.dropFeathers();
        assertTrue("Duck must be dead to drop feathers.", duck.canDropFeathers() == true);

    }

    /**
     * Tests creation of cow.
     */
    @Test
    public void cowTest () {

    	// Create base entities for testing purposes.
    	EntityManager entityManager = EntityManager.getInstance();
        Cow cow = new Cow(10, 10);
        Peon opponent = new Peon(10, 10);
        entityManager.addEntity(cow);
        entityManager.addEntity(opponent);

        // Test if cows drop resources appropriately.
        cow.setHealth(100); // Set attributes to pass attribute threshold for producing milk.
        cow.setHunger(100);
        cow.setThirst(100);
        cow.produceMilk();
        assertTrue("Cow can only produce milk if the health, hunger, and thirst thresholds are met.", cow
                .canProduceMilk() == true);
    }
}
