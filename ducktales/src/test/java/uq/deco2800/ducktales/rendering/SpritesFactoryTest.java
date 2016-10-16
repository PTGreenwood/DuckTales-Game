package uq.deco2800.ducktales.rendering;

import org.junit.Test;
import uq.deco2800.ducktales.rendering.sprites.AnimalSprite;
import uq.deco2800.ducktales.rendering.sprites.PeonSprite;
import uq.deco2800.ducktales.rendering.sprites.SpritesFactory;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

import static org.junit.Assert.*;
import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * Tests for the SpritesFactory class
 *
 * Created on 16/10/2016.
 * @author Khoi
 */
public class SpritesFactoryTest {

    /*
     * PEONS CREATION TESTS
     */
    @Test
    public void testBasicPeonCreation() {
        PeonSprite sprite1 = SpritesFactory.createPeonSprite("Test Peon");

        // Check that the peon sprite's name is correct
        assertEquals(sprite1.getPeonName(), "Test Peon");
    }

    @Test(expected = RuntimeException.class)
    public void testEmptyPeonName() {
        SpritesFactory.createPeonSprite("");
    }

    /*
     * BUILDING CREATION TESTS
     */
    @Test(expected = GameSetupException.class)
    public void testInvalidBuildingType() {
        SpritesFactory.createBuildingSprite(0, ResourceType.NONE);
    }

    /*
     * ANIMAL CREATION TESTS
     */
    @Test(expected = GameSetupException.class)
    public void testInvalidAnimalType() {
        SpritesFactory.createAnimalSprite(0, ResourceType.NONE);
    }
    // Creating a sheep
    @Test
    public void testBasicAnimalCreation() {
        ResourceType[] animals = {
                SHEEP, DUCK, COW
        };

        for (int i = 0; i < animals.length; i++) {
            int spriteIndex = 0;
            ResourceType spriteType = animals[i];

            AnimalSprite animal = SpritesFactory.createAnimalSprite(
                    spriteIndex, spriteType);

            assertEquals(animal.getIndex(), spriteIndex);
            assertEquals(animal.getEntityType(), spriteType);
        }
    }

}
