package uq.deco2800.ducktales.rendering.sprites;

import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import uq.deco2800.ducktales.resources.ResourceType;
import static org.junit.Assert.*;
import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * Tests for the SpritesImages class
 *
 * @author Gabrielle Hodge, 43590526
 */
public class SpritesImagesTest extends ApplicationTest {

	/**
	 * Test for images for normal day 
	 */
	@Test
	public void basicDayTest() {
        ResourceType[] buildings = {
                HOSPITAL, BAKERY, BUTCHER, CEMETERY, CHURCH, COMMUNITY_BUILDING,
                FARM, FORGE, HOUSE, MINE, OBSERVATORY, PASTURE, QUARRY, SAWMILL,
                SCHOOL, GYMNASIUM, STORAGEBARN, BARN
        };
        
        for (ResourceType buildingType : buildings) {
        	if (buildingType == BARN || buildingType == FARM || 
        			buildingType == PASTURE || buildingType == QUARRY ||
        			buildingType == BARN || buildingType == STORAGEBARN) {
        		assertEquals(null, SpritesImages.dayAnimation(buildingType));
        	} else {
        		assertNotEquals(null, SpritesImages.dayAnimation(buildingType));
        	}
        }
	}
	
	/**
	 * Test for normal night animation images
	 */
	@Test
	public void basicNightTest() {
        ResourceType[] buildings = {
                HOSPITAL, BAKERY, BUTCHER, CEMETERY, CHURCH, COMMUNITY_BUILDING,
                FARM, FORGE, HOUSE, MINE, OBSERVATORY, PASTURE, QUARRY, SAWMILL,
                SCHOOL, GYMNASIUM, STORAGEBARN, BARN
        };
        
        for (ResourceType buildingType : buildings) {
        	if (buildingType == GYMNASIUM || buildingType == SCHOOL) {
        		assertNotEquals(null, SpritesImages.nightAnimation(buildingType));
        	} else {
        		assertEquals(null, SpritesImages.nightAnimation(buildingType));
        	}
        }
	}
	
	/**
	 * Test for winter day animation images
	 */
	@Test
	public void winterDayTest() {
        ResourceType[] buildings = {
                HOSPITAL, BAKERY, BUTCHER, CEMETERY, CHURCH, COMMUNITY_BUILDING,
                FARM, FORGE, HOUSE, MINE, OBSERVATORY, PASTURE, QUARRY, SAWMILL,
                SCHOOL, GYMNASIUM, STORAGEBARN, BARN
        };
        
        for (ResourceType buildingType : buildings) {
        	assertEquals(null, SpritesImages.winterDayAnimation(buildingType));
        }
	}
	
	/**
	 * Test for winter night images
	 */
	@Test
	public void winterNightTest() {
        ResourceType[] buildings = {
                HOSPITAL, BAKERY, BUTCHER, CEMETERY, CHURCH, COMMUNITY_BUILDING,
                FARM, FORGE, HOUSE, MINE, OBSERVATORY, PASTURE, QUARRY, SAWMILL,
                SCHOOL, GYMNASIUM, STORAGEBARN, BARN
        };
        
        for (ResourceType buildingType : buildings) {
        	assertEquals(null, SpritesImages.winterNightAnimation(buildingType));
        }
	}

	@Override
	public void start(Stage stage) throws Exception {
		
	}

}
