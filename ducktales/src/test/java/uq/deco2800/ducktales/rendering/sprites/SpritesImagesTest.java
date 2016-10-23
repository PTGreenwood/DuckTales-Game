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
        		assertEquals(true, SpritesImages.dayAnimation(buildingType).isEmpty());
        	} else {
        		assertEquals(false, SpritesImages.dayAnimation(buildingType).isEmpty());
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
        		assertEquals(false, SpritesImages.nightAnimation(buildingType).isEmpty());
        	} else {
        		assertEquals(true, SpritesImages.nightAnimation(buildingType).isEmpty());
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
        	if (buildingType == GYMNASIUM || buildingType == BAKERY || 
        			buildingType == BUTCHER || buildingType == COMMUNITY_BUILDING
        			|| buildingType == HOSPITAL) {
        		assertEquals(false, SpritesImages.winterDayAnimation(buildingType).isEmpty());
        	} else {
        		assertEquals(true, SpritesImages.winterDayAnimation(buildingType).isEmpty());
        	}
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
        	assertEquals(true, SpritesImages.winterNightAnimation(buildingType).isEmpty());
        }
	}

	@Override
	public void start(Stage stage) throws Exception {
		
	}

}
