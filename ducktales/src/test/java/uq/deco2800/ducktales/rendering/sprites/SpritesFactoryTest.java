package uq.deco2800.ducktales.rendering.sprites;

import org.junit.Test;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
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

    @Test(expected = GameSetupException.class)
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

    @Test
    public void testGeneralBuildingCreation() {
        int buildingIndex = 0;

        ResourceSpriteRegister.getInstance();

        ResourceType[] buildings = {
                HOSPITAL, BAKERY, BARN, BUTCHER, CEMETERY, CHURCH, COMMUNITY_BUILDING,
                FARM, FORGE, HOUSE, MINE, OBSERVATORY, PASTURE, QUARRY, SAWMILL,
                SCHOOL, GYMNASIUM
        };

        for (ResourceType buildingType : buildings) {

            BuildingSprite building = SpritesFactory.createBuildingSprite(
                    buildingIndex, buildingType);

            assertEquals(building.getIndex(), buildingIndex);
            assertEquals(building.getEntityType(), buildingType);
        }
    }

    /*
     * ANIMAL CREATION TESTS
     */
    @Test(expected = GameSetupException.class)
    public void testInvalidAnimalType() {
        SpritesFactory.createAnimalSprite(0, ResourceType.NONE, );
    }

    @Test
    public void testGeneralAnimalCreation() {
        ResourceType[] animals = {
                SHEEP, DUCK, COW
        };

        for (int i = 0; i < animals.length; i++) {
            int spriteIndex = 0;
            ResourceType spriteType = animals[i];

            AnimalSprite animal = SpritesFactory.createAnimalSprite(
                    spriteIndex, spriteType, );

            assertEquals(animal.getIndex(), spriteIndex);
            assertEquals(animal.getEntityType(), spriteType);
        }
    }



}
