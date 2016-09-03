package uq.deco2800.ducktales;

import org.junit.Test;

import uq.deco2800.ducktales.entities.Entity;
import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.entities.agententities.*;
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
    public void duckTest() {

    	// Create base entities for testing purposes
        EntityManager entityManager = EntityManager.getInstance();
        Duck duck = new Duck(10, 10);
        Peon opponent = new Peon(10, 10);
        entityManager.addEntity(duck);
        entityManager.addEntity(opponent);

        // Test whether the creation of each cow has no null attributes
        assertNotNull("Duck cannot be null.", duck);
        assertNotNull("Health cannot be null.", duck.getHealth());
        assertNotNull("Hunger cannot be null.", duck.getHunger());
        assertNotNull("Thirst cannot be null.", duck.getThirst());
        assertNotNull("Strength cannot be null.", duck.getStrength());

        // Test whether Cow class methods return expected values
        // assertTrue("Speed is incorrect.", duck.getSpeed() == 0.01);
        assertTrue("type is incorrect.", duck.getType() == ResourceType.DUCK);
        assertTrue("Duck cannot be killed on creation.", duck.canBeKilled() == false);
        assertTrue("Duck cannot lay eggs on creation.", duck.canLayEggs() == false);
        assertTrue("Duck cannot drop feathers on creation.", duck.canDropFeathers() == false);
        assertTrue("Duck cannot be dead on creation.", duck.isDead() == false);

        // Attribute setting tests for the Duck class
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

        // Attack tests.
        duck.setHealth(100);
        duck.setStrength(20);
        opponent.setHealth(100);
        //opponent.setStrength(20);
        duck.attack(opponent);
        assertTrue("Opponent health must decrease by the animal's strength.", opponent.getHealth() == 80);
        //duck.isAttacked();
        //assertTrue("Duck health must decrease by the Peon's strength.", duck.getHealth() == 80);
        duck.setHealth(0);
        duck.setIsDead();
        assertTrue("Duck must be dead when its health is 0;", duck.isDead() == true);
    }

    /**
     * Tests creation of cow.
     */
    @Test
    public void cowTest () {

    	// Create base entities for testing purposes
    	EntityManager entityManager = EntityManager.getInstance();
        Cow cow = new Cow(10, 10);
        Peon opponent = new Peon(10, 10);
        entityManager.addEntity(cow);
        entityManager.addEntity(opponent);

        // Test whether the creation of each cow has no null attributes
        assertNotNull("Cow cannot be null.", cow);
        assertNotNull("Health cannot be null.", cow.getHealth());
        assertNotNull("Hunger cannot be null.", cow.getHunger());
        assertNotNull("Thirst cannot be null.", cow.getThirst());
        assertNotNull("Strength cannot be null.", cow.getStrength());

        // Test whether Cow class methods return expected values
        assertTrue("Speed is incorrect.", cow.getSpeed() == 0.05);
        assertTrue("type is incorrect.", cow.getType() == ResourceType.COW);
        assertTrue("Cow cannot be killed on creation.", cow.canBeKilled() == false);
        assertTrue("Cow cannot produce milk on creation.", cow.canProduceMilk() == false);
        assertTrue("Cow cannot be dead on creation.", cow.isDead() == false);

        // Attribute setting tests for the Cow class
        cow.setHealth(101);
        assertTrue("Cow health should be 100 if parameter is greater than 100. ", cow.getHealth() == 100);
        cow.setHealth(50);
        assertTrue("Cow health should equal the parameter.", cow.getHealth() == 50);
        cow.setHealth(-1);
        assertTrue("Cow health should be 0 if the parameter is less than 0.", cow.getHealth() == 0);
        cow.setHunger(101);
        assertTrue("Cow hunger should be 100 if parameter is greater than 100. ", cow.getHunger() == 100);
        cow.setHunger(50);
        assertTrue("Cow hunger should equal the parameter.", cow.getHunger() == 50);
        cow.setHunger(-1);
        assertTrue("Cow hunger should be 0 if the parameter is less than 0.", cow.getHunger() == 0);
        cow.setThirst(101);
        assertTrue("Cow thirst should be 100 if parameter is greater than 100. ", cow.getThirst() == 100);
        cow.setThirst(50);
        assertTrue("Cow thirst should equal the parameter.", cow.getThirst() == 50);
        cow.setThirst(-1);
        assertTrue("Cow thirst should be 0 if the parameter is less than 0.", cow.getThirst() == 0);
        cow.setStrength(10);
        assertTrue("Strength has an incorrect value.", cow.getStrength() == 10);

        // Attack tests.
        cow.setHealth(100);
        cow.setStrength(20);
        opponent.setHealth(100);
        //opponent.setStrength(20);
        cow.attack(opponent);
        assertTrue("Opponent health must decrease by the animal's strength.", opponent.getHealth() == 80);
        //duck.isAttacked();
        //assertTrue("Duck health must decrease by the Peon's strength.", duck.getHealth() == 80);
        cow.setHealth(0);
        cow.setIsDead();
        assertTrue("Cow must be dead when its health is 0;", cow.isDead() == true);
    }
}
