package uq.deco2800.ducktales.entities.agententities;

import org.junit.Test;

import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.entities.peons.PeonDebuffType;
import uq.deco2800.ducktales.features.entities.peons.PeonBuffType;
import uq.deco2800.ducktales.features.jobframework.JobType;
import uq.deco2800.ducktales.features.peonupgrades.ToolType;

import static org.junit.Assert.*;

/**
 * Contains tests for the Peon class.
 *
 * @author Jin Shin
 */

public class PeonTest {
  @Test
  public void peonTest() {
    //Create Peon for testing
    Peon peon = new Peon(10, 10, "John Doe");

    //Test to see if Peon has no null attributes
    assertNotNull("Peon cannot be null", peon);
    assertNotNull("Peon name cannot be null", peon.getPeonName());
    assertNotNull("X coordinate cannot be null.", peon.getX());
    assertNotNull("Y coordinate cannot be null.", peon.getY());
    assertNotNull("ResourceType of Peon cannot be null", peon.getType());
    assertNotNull("Health cannot be null", peon.getHealth());
    assertNotNull("Hunger cannot be null", peon.getHunger());
    assertNotNull("Thirst cannot be null", peon.getThirst());
    assertNotNull("Speed cannot be null", peon.getSpeed());
    assertNotNull("Strength cannot be null", peon.getStrength());
    assertNotNull("Resource cannot be null", peon.getResources());
    assertNotNull("Intelligence cannot be null", peon.getIntelligence());
    assertNotNull("Job cannot be null", peon.getJob());
    assertNotNull("Qualification cannot be null", peon.getQualificationToolEquipped());
    assertNotNull("Tree choppsed cannot be null", peon.getTreesChopped());
    assertNotNull("Mentor status cannot be null", peon.getMentorStatus());

    //Test to see if Peon returns expected values on instantiation
    assertTrue("Peon cannot be dead on instantiation", peon.isDead() == false);

    //Test attributes setters
    peon.setPeonName("Jin Shin");
    assertTrue("peon name should now be Jin Shin", peon.getPeonName() == "Jin Shin");
    peon.setHealth(1001);
    assertTrue("peon health should be 1000 if parameter is greater than 1000", peon.getHealth() == 1000);
    peon.setHealth(-1);
    assertTrue("peon health should be 0 if parameter is less than 0", peon.getHealth() == 0);
    peon.setHealth(50);
    assertTrue("peon health should be parameter", peon.getHealth() == 50);
    peon.setHunger(101);
    assertTrue("peon hunger should be 100 if parameter is greater than 100", peon.getHunger() == 100);
    peon.setHunger(-1);
    assertTrue("peon hunger should 0 if parameter is less than 0", peon.getHunger() == 0);
    peon.setHunger(50);
    assertTrue("peon hunger should be parameter", peon.getHunger() == 50);
    peon.setThirst(101);
    assertTrue("peon thirst should be 100 if parameter is greater than 100", peon.getThirst() == 100);
    peon.setThirst(-1);
    assertTrue("peon thirst should be 0 if parameter is less than 0", peon.getThirst() == 0);
    peon.setThirst(50);
    assertTrue("peon thirst should be parameter", peon.getThirst() == 50);
    peon.setSpeed(-1);
    assertTrue("peon speed should be 0 if parameter is less than 0", peon.getSpeed() == 0);
    peon.setSpeed(0.10);
    assertTrue("peon speed should be parameter", peon.getSpeed() == 0.10);
    peon.setResource(10);
    assertTrue("Peon resource value should be parameter", peon.getResources() == 10);
    peon.choppedATree();
    assertTrue("method should add 1 to the peon treesChopped", peon.getTreesChopped() == 1);
    peon.addDebuff(PeonDebuffType.HUNGRY);
    assertTrue("peon now should have a HUNGER debuff", peon.getDebuffs().get(0).toString() == "HUNGRY");
    peon.addDebuff(PeonDebuffType.THIRSTY);
    assertTrue("peon now should have two debuffs", peon.getDebuffs().size() == 2);
    peon.addDebuff(PeonDebuffType.HUNGRY);
    assertTrue("no duplicate is allowed in debuffs", peon.getDebuffs().size() == 2);
    peon.removeDebuff(PeonDebuffType.HUNGRY);
    assertTrue("peon now should not have HUNGER debuff so only one debuff", peon.getDebuffs().size() == 1);
    peon.addBuff(PeonBuffType.STUFFED);
    assertTrue("peon now should have a STUFFED buff", peon.getBuffs().get(0).toString() == "STUFFED");
    peon.addBuff(PeonBuffType.HYDRATED);
    assertTrue("peon now should have two buffs", peon.getBuffs().size() == 2);
    peon.addBuff(PeonBuffType.STUFFED);
    assertTrue("no duplicate is allowed in buffs", peon.getBuffs().size() == 2);
    peon.removeBuff(PeonBuffType.STUFFED);
    assertTrue("peon now should only have one buff left", peon.getBuffs().size() == 1);
    peon.setIsDead();
    assertTrue("peon now should be dead", peon.isDead() == true);
  }
}
