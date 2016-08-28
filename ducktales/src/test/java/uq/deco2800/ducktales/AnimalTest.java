package uq.deco2800.ducktales;

import org.junit.Test;

import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.entities.agententities.*;
import uq.deco2800.ducktales.resources.*;

import static org.junit.Assert.*;


/**
 * Contains tests for the animal class.
 *
 * @author Josh Benavides
 */
public class AnimalTest {

    /**
     * Tests creation of duck.
     */
    @Test
    public void DuckTest() {

        EntityManager entityManager = EntityManager.getInstance();
        Duck duck = new Duck(10, 10);
        entityManager.addEntity(duck);

        assertNotNull("Duck cannot be null.", duck);
        assertNotNull("Health cannot be null.", duck.getHealth());
        assertNotNull("Hunger cannot be null.", duck.getHunger());
        assertNotNull("Thirst cannot be null.", duck.getThirst());
        assertNotNull("Strength cannot be null.", duck.getStrength());
        assertTrue("Speed is incorrect.", duck.getSpeed() == 0.05);
        assertTrue("type is incorrect.", duck.getType() == ResourceType.DUCK);
        assertTrue("Duck cannot be killed on creation.", duck.canBeKilled() == false);
        assertTrue("Duck cannot lay eggs on creation.", duck.canLayEggs() == false);
        assertTrue("Duck cannot drop feathers on creation.", duck.canDropFeathers() == false);
        assertTrue("Duck cannot be dead on creation.", duck.isDead() == false);

        // Test attribute setting.
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
    }

}
