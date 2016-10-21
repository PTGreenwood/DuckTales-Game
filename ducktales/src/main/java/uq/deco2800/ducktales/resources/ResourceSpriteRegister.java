package uq.deco2800.ducktales.resources;

import java.util.concurrent.ConcurrentHashMap;

import javafx.scene.image.Image;

import static uq.deco2800.ducktales.resources.ResourceType.*;

import static uq.deco2800.ducktales.resources.ResourceType.BAKERY;
import static uq.deco2800.ducktales.resources.ResourceType.BLANK;
import static uq.deco2800.ducktales.resources.ResourceType.BOX;
import static uq.deco2800.ducktales.resources.ResourceType.BUTCHER;
import static uq.deco2800.ducktales.resources.ResourceType.CHURCH;
import static uq.deco2800.ducktales.resources.ResourceType.COMMUNITY_BUILDING;
import static uq.deco2800.ducktales.resources.ResourceType.CONSTRUCTION;
import static uq.deco2800.ducktales.resources.ResourceType.COW;
import static uq.deco2800.ducktales.resources.ResourceType.COW_FRONT_RIGHT;
import static uq.deco2800.ducktales.resources.ResourceType.CYAN;
import static uq.deco2800.ducktales.resources.ResourceType.CYAN_CROSSED;
import static uq.deco2800.ducktales.resources.ResourceType.DUCK;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKDown0;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKDown1;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKLeft0;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKLeft1;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKRight0;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKRight1;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKUp0;
import static uq.deco2800.ducktales.resources.ResourceType.DUCKUp1;
import static uq.deco2800.ducktales.resources.ResourceType.DUCK_1_1;
import static uq.deco2800.ducktales.resources.ResourceType.FORGE;
import static uq.deco2800.ducktales.resources.ResourceType.GRASS_1;
import static uq.deco2800.ducktales.resources.ResourceType.GRASS_2;
import static uq.deco2800.ducktales.resources.ResourceType.GRASS_3;
import static uq.deco2800.ducktales.resources.ResourceType.GRASS_4;
import static uq.deco2800.ducktales.resources.ResourceType.HOSPITAL;
import static uq.deco2800.ducktales.resources.ResourceType.HOUSE;
import static uq.deco2800.ducktales.resources.ResourceType.LONG_BOX;
import static uq.deco2800.ducktales.resources.ResourceType.MINE;
import static uq.deco2800.ducktales.resources.ResourceType.OBSERVATORY;
import static uq.deco2800.ducktales.resources.ResourceType.PASTURE;
import static uq.deco2800.ducktales.resources.ResourceType.PEON;
import static uq.deco2800.ducktales.resources.ResourceType.ROCK_1;
import static uq.deco2800.ducktales.resources.ResourceType.ROCK_2;
import static uq.deco2800.ducktales.resources.ResourceType.SAWMILL;
import static uq.deco2800.ducktales.resources.ResourceType.SHEEP;
import static uq.deco2800.ducktales.resources.ResourceType.SHEEPRight0;
import static uq.deco2800.ducktales.resources.ResourceType.SHEEPRight1;
import static uq.deco2800.ducktales.resources.ResourceType.TREE_1;
import static uq.deco2800.ducktales.resources.ResourceType.TREE_2;
import static uq.deco2800.ducktales.resources.ResourceType.TREE_3;
import static uq.deco2800.ducktales.resources.ResourceType.VOID;
import static uq.deco2800.ducktales.resources.ResourceType.WATER;
import static uq.deco2800.ducktales.resources.ResourceType.WOOD_BOX;
import static uq.deco2800.ducktales.resources.ResourceType.YELLOW;


/**
 * Every resource of the same type will have some common attributes such as name,
 * image, type ID etc. Thus this class is used to manage those common resource attributes
 * and also makes it easier for Renderers to retrieve the images of the different
 * resource types. This will also save up memory as each sprite type is only stored once
 *
 * For example, The Tile class holds information about an instance of a tile --
 * however there is information that is common to every Tile of a certain type.
 * This class can manage information of a tile type and removes the requirement
 * of having to know or store the tile type itself. It allows for easy retrieval
 * of tile type information either through the name (as a string) or through the
 * tile type which can be retrieved from the instance method Tile.getResourceType().
 *
 * This class is a singleton -- to get an instance of this class, you must call
 * ResourceSpriteRegister.getInstance(); you cannot instantiate it.
 *
 * @author Anonymousthing, khoiphan21
 */
public class ResourceSpriteRegister {

	private static final ResourceSpriteRegister INSTANCE = new ResourceSpriteRegister();

	/**
	 * Returns the instance of {@link ResourceSpriteRegister}.
	 *
	 * @return Returns an instance of ResourceSpriteRegister.
	 */
	public static ResourceSpriteRegister getInstance() {
		return INSTANCE;
	}

	/**
	 * The base height for a 1*1 tile.
	 */
	public static final int TILE_HEIGHT = 100;

	/**
	 * The base width for a 1*1 tile.
	 */
	public static final int TILE_WIDTH = 174;

	// As we're a static instance we use a ConcurrentHashMap to prevent
	// potential threading issues
	private ConcurrentHashMap<ResourceType, Image> resourceTypeRegister;

	private ResourceSpriteRegister() {
		resourceTypeRegister = new ConcurrentHashMap<>();

		addTileResources();

		addLandscapeResources();

		addMiscellaneousResources();

		addAgentEntitiesResources();

		addBuildingResources();

	}


	/**
	 * Adds a resource to the register.
	 *
	 * @param type
	 *            The type of the resource
	 * @param imageName
	 *            The file name of the corresponding image
	 */
	private void addResource ( ResourceType type, String imageName) {
		if (resourceTypeRegister.containsKey(type)) {
			throw new RuntimeException(
					"Attempted to add an already registered ResourceTypeInfo \""
							+ type + "\" to a ResourceSpriteRegister");
		}
		resourceTypeRegister.put(type,
				new Image(getClass().getResource(imageName).toString()));
	}

	/**
	 * Retrieves the Image of the specified resource
	 *
	 * @param resourceType
	 *            The type of the resource
	 * @return The sprite Image of the resource
	 */
	public Image getResourceImage(ResourceType resourceType) {
		if (!resourceTypeRegister.containsKey(resourceType))
			throw new RuntimeException(
					"Attempted to access non-registered ResourceTypeInfo of tile type \""
							+ resourceType + "\" from a ResourceSpriteRegister");
		return resourceTypeRegister.get(resourceType);
	}


	/**
	 * Add the resources for the tiles
	 */
	private void addTileResources() {
		// GROUND TILES
		addResource(GRASS_1, "/tiles/grass_1.png");
		addResource(GRASS_2, "/tiles/grass_2.png");
		addResource(GRASS_3, "/tiles/grass_3.png");
		addResource(GRASS_4, "/tiles/grass_4.png");
	}

	/**
	 * Add the resources for the buildings into the register
	 */
	private void addBuildingResources() {
		//To be uncommented as the relevant graphics are created

		addResource(QUARRY, "/buildings/quarry.png");
		addResource(PASTURE, "/buildings/pasture.png");
		addResource(HOSPITAL, "/buildings/hospital.png");
		addResource(SCHOOL, "/buildings/school.png");
		addResource(GYMNASIUM, "/buildings/gymnasium.png");
		addResource(BUTCHER, "/buildings/butcher.png");
		addResource(STORAGEBARN, "/buildings/storagebarn.png");

		addResource(BAKERY, "/buildings/bakery.png");
		addResource(COMMUNITY_BUILDING, "/buildings/community_building.png");
		addResource(CONSTRUCTION, "/buildings/construction2.png");
		addResource(CONSTRUCTION_2, "/buildings/construction1_small.png");
		addResource(CHURCH, "/buildings/church.png");
		addResource(HOUSE, "/buildings/house.png");
		addResource(SAWMILL, "/buildings/sawmill.png");
		addResource(FORGE, "/buildings/forge.png");
		addResource(OBSERVATORY, "/buildings/observatory.png");
		addResource(MINE, "/buildings/mine.png");
		addResource(CEMETERY, "/buildings/cemetery_small.png");
		addResource(FARM, "/buildings/farmhouse.png");

		addBuildingAnimationResources();
	}

	/**
	 * Add the resources for animating buildings
	 */
	private void addBuildingAnimationResources() {
		// Normal buildings' animations
		// Bakery
		addResource(BAKERY_1, "/buildings/bakery/bakery_1.png");
		addResource(BAKERY_2, "/buildings/bakery/bakery_2.png");
		addResource(BAKERY_3, "/buildings/bakery/bakery_3.png");
		addResource(BAKERY_4, "/buildings/bakery/bakery_4.png");
		addResource(BAKERY_5, "/buildings/bakery/bakery_5.png");
		
		
		// Butcher
		addResource(BUTCHER_1, "/buildings/butcher/butcher_1.png");
		addResource(BUTCHER_2, "/buildings/butcher/butcher_2.png");
		addResource(BUTCHER_3, "/buildings/butcher/butcher_3.png");
		addResource(BUTCHER_4, "/buildings/butcher/butcher_4.png");
		addResource(BUTCHER_5, "/buildings/butcher/butcher_5.png");
		// Cemetery
		addResource(CEMETERY_1, "/buildings/cemetery/cemetery_small_1.png");
		addResource(CEMETERY_2, "/buildings/cemetery/cemetery_small_2.png");
		addResource(CEMETERY_3, "/buildings/cemetery/cemetery_small_3.png");
		addResource(CEMETERY_4, "/buildings/cemetery/cemetery_small_4.png");
		addResource(CEMETERY_5, "/buildings/cemetery/cemetery_small_5.png");
		addResource(CEMETERY_6, "/buildings/cemetery/cemetery_small_6.png");
		addResource(CEMETERY_7, "/buildings/cemetery/cemetery_small_7.png");
		addResource(CEMETERY_8, "/buildings/cemetery/cemetery_small_8.png");
		addResource(CEMETERY_9, "/buildings/cemetery/cemetery_small_9.png");
		addResource(CEMETERY_10, "/buildings/cemetery/cemetery_small_10.png");
		addResource(CEMETERY_11, "/buildings/cemetery/cemetery_small_11.png");
		addResource(CEMETERY_12, "/buildings/cemetery/cemetery_small_12.png");
		addResource(CEMETERY_13, "/buildings/cemetery/cemetery_small_13.png");
		addResource(CEMETERY_14, "/buildings/cemetery/cemetery_small_14.png");
		addResource(CEMETERY_15, "/buildings/cemetery/cemetery_small_15.png");
		addResource(CEMETERY_16, "/buildings/cemetery/cemetery_small_16.png");
		// Church
		addResource(CHURCH_1, "/buildings/church/church_1.png");
		addResource(CHURCH_2, "/buildings/church/church_2.png");
		addResource(CHURCH_3, "/buildings/church/church_3.png");
		addResource(CHURCH_4, "/buildings/church/church_4.png");
		addResource(CHURCH_5, "/buildings/church/church_5.png");
		// Community Building
		addResource(COMMUNITY_BUILDING_1, "/buildings/community_building/community_building_1.png");
		addResource(COMMUNITY_BUILDING_2, "/buildings/community_building/community_building_2.png");
		addResource(COMMUNITY_BUILDING_3, "/buildings/community_building/community_building_3.png");
		addResource(COMMUNITY_BUILDING_4, "/buildings/community_building/community_building_4.png");
		addResource(COMMUNITY_BUILDING_5, "/buildings/community_building/community_building_5.png");
		// Observatory
		addResource(OBSERVATORY_1, "/buildings/observatory/observatory_1.png");
		addResource(OBSERVATORY_2, "/buildings/observatory/observatory_2.png");
		addResource(OBSERVATORY_3, "/buildings/observatory/observatory_3.png");
		addResource(OBSERVATORY_4, "/buildings/observatory/observatory_4.png");
		addResource(OBSERVATORY_5, "/buildings/observatory/observatory_5.png");
		// Sawmill
		addResource(SAWMILL_1, "/buildings/sawmill/sawmill_1.png");
		addResource(SAWMILL_2, "/buildings/sawmill/sawmill_2.png");
		addResource(SAWMILL_3, "/buildings/sawmill/sawmill_3.png");
		addResource(SAWMILL_4, "/buildings/sawmill/sawmill_4.png");
		addResource(SAWMILL_5, "/buildings/sawmill/sawmill_5.png");
		addResource(SAWMILL_6, "/buildings/sawmill/sawmill_6.png");
		// Forge
		addResource(FORGE_1, "/buildings/forge/forge_1.png");
		addResource(FORGE_2, "/buildings/forge/forge_2.png");
		addResource(FORGE_3, "/buildings/forge/forge_3.png");
		addResource(FORGE_4, "/buildings/forge/forge_4.png");
		addResource(FORGE_5, "/buildings/forge/forge_5.png");
		// Gymnasium
		addResource(GYMNASIUM_1, "/buildings/gymnasium/gymnasium_1.png");
		addResource(GYMNASIUM_2, "/buildings/gymnasium/gymnasium_2.png");
		addResource(GYMNASIUM_3, "/buildings/gymnasium/gymnasium_3.png");
		addResource(GYMNASIUM_4, "/buildings/gymnasium/gymnasium_4.png");
		addResource(GYMNASIUM_5, "/buildings/gymnasium/gymnasium_5.png");
		// Hospital
		addResource(HOSPITAL_1, "/buildings/hospital/hospital_1.png");
		addResource(HOSPITAL_2, "/buildings/hospital/hospital_2.png");
		addResource(HOSPITAL_3, "/buildings/hospital/hospital_3.png");
		addResource(HOSPITAL_4, "/buildings/hospital/hospital_4.png");
		addResource(HOSPITAL_5, "/buildings/hospital/hospital_5.png");
		// House
		addResource(HOUSE_1, "/buildings/house/house_1.png");
		addResource(HOUSE_2, "/buildings/house/house_2.png");
		addResource(HOUSE_3, "/buildings/house/house_3.png");
		addResource(HOUSE_4, "/buildings/house/house_4.png");
		addResource(HOUSE_5, "/buildings/house/house_5.png");
		// Mine
		addResource(MINE_1, "/buildings/mine/mine_1.png");
		addResource(MINE_2, "/buildings/mine/mine_2.png");
		addResource(MINE_3, "/buildings/mine/mine_3.png");
		addResource(MINE_4, "/buildings/mine/mine_4.png");
		// School - Night
		addResource(SCHOOL_NIGHT_1, "/buildings/school_night/school_night_1.png");
		addResource(SCHOOL_NIGHT_2, "/buildings/school_night/school_night_2.png");
		addResource(SCHOOL_NIGHT_3, "/buildings/school_night/school_night_3.png");
		addResource(SCHOOL_NIGHT_4, "/buildings/school_night/school_night_4.png");
		addResource(SCHOOL_NIGHT_5, "/buildings/school_night/school_night_5.png");
		addResource(SCHOOL_NIGHT_6, "/buildings/school_night/school_night_6.png");
		// School
		addResource(SCHOOL_1, "/buildings/school/school_1.png");
		addResource(SCHOOL_2, "/buildings/school/school_2.png");
		addResource(SCHOOL_3, "/buildings/school/school_3.png");
		addResource(SCHOOL_4, "/buildings/school/school_4.png");
		addResource(SCHOOL_5, "/buildings/school/school_5.png");
		
		

		// Advanced buildings' animations
		// Butcher
		addResource(ADV_BUTCHER_1, "/buildings/adv_butcher/adv_butcher_01.png");
		addResource(ADV_BUTCHER_2, "/buildings/adv_butcher/adv_butcher_02.png");
		addResource(ADV_BUTCHER_3, "/buildings/adv_butcher/adv_butcher_03.png");
		addResource(ADV_BUTCHER_4, "/buildings/adv_butcher/adv_butcher_04.png");
		addResource(ADV_BUTCHER_5, "/buildings/adv_butcher/adv_butcher_05.png");
		// Hospital
		addResource(ADV_HOSPITAL_1, "/buildings/adv_hospital/adv_hospital_1.png");
		addResource(ADV_HOSPITAL_2, "/buildings/adv_hospital/adv_hospital_2.png");
		addResource(ADV_HOSPITAL_3, "/buildings/adv_hospital/adv_hospital_3.png");
		addResource(ADV_HOSPITAL_4, "/buildings/adv_hospital/adv_hospital_4.png");
		addResource(ADV_HOSPITAL_5, "/buildings/adv_hospital/adv_hospital_5.png");
		// Bakery
		addResource(BAKERY_1_ADV, "/buildings/adv_bakery/adv_bakery_1.png");
		addResource(BAKERY_2_ADV, "/buildings/adv_bakery/adv_bakery_2.png");
		addResource(BAKERY_3_ADV, "/buildings/adv_bakery/adv_bakery_3.png");
		addResource(BAKERY_4_ADV, "/buildings/adv_bakery/adv_bakery_4.png");
		addResource(BAKERY_5_ADV, "/buildings/adv_bakery/adv_bakery_5.png");
		
		addResource(BAKERY_1_ADV_NIGHT, "/buildings/adv_bakery_night/adv_bakery_night_2.png");
		addResource(BAKERY_2_ADV_NIGHT, "/buildings/adv_bakery_night/adv_bakery_night_2.png");
		addResource(BAKERY_3_ADV_NIGHT, "/buildings/adv_bakery_night/adv_bakery_night_3.png");
		addResource(BAKERY_4_ADV_NIGHT, "/buildings/adv_bakery_night/adv_bakery_night_4.png");
		addResource(BAKERY_5_ADV_NIGHT, "/buildings/adv_bakery_night/adv_bakery_night_5.png");
		addResource(BAKERY_6_ADV_NIGHT, "/buildings/adv_bakery_night/adv_bakery_night_6.png");
		// Sawmill
		addResource(SAWMILL_ADV_1, "/buildings/adv_sawmill/adv_sawmill_1.png");
		addResource(SAWMILL_ADV_2, "/buildings/adv_sawmill/adv_sawmill_2.png");
		addResource(SAWMILL_ADV_3, "/buildings/adv_sawmill/adv_sawmill_3.png");
		addResource(SAWMILL_ADV_4, "/buildings/adv_sawmill/adv_sawmill_4.png");
		addResource(SAWMILL_ADV_5, "/buildings/adv_sawmill/adv_sawmill_5.png");

	}

	private void addAgentEntitiesResources() {
		/*
		 * PEONS
		 */
		addResource(PEON, "/peon/basic_peon.png");


		/*
		 * ANIMALS
		 */
		addResource(DUCK, "/animal/duck/DUCKDown0.png");
		addResource(DUCK_1_1, "/animal/duck_1_1.png");

		addResource(DUCKDown0, "/animal/duck/DUCKDown0.png");
		addResource(DUCKDown1, "/animal/duck/DUCKDown1.png");
		addResource(DUCKUp0, "/animal/duck/DUCKUp0.png");
		addResource(DUCKUp1, "/animal/duck/DUCKUp1.png");
		addResource(DUCKLeft0, "/animal/duck/DUCKLeft0.png");
		addResource(DUCKLeft1, "/animal/duck/DUCKLeft1.png");
		addResource(DUCKRight0, "/animal/duck/DUCKRight0.png");
		addResource(DUCKRight1, "/animal/duck/DUCKRight1.png");

		addResource(SHEEPDown0, "/animal/sheep/SHEEPDown0.png");
		addResource(SHEEPDown1, "/animal/sheep/SHEEPDown1.png");
		addResource(SHEEPUp0, "/animal/sheep/SHEEPUp0.png");
		addResource(SHEEPUp1, "/animal/sheep/SHEEPUp1.png");
		addResource(SHEEPLeft0, "/animal/sheep/SHEEPLeft0.png");
		addResource(SHEEPLeft1, "/animal/sheep/SHEEPLeft1.png");
		addResource(SHEEPRight0, "/animal/sheep/SHEEPRight0.png");
		addResource(SHEEPRight1, "/animal/sheep/SHEEPRight1.png");

		addResource(SHEEP, "/animal/sheep_with_wool.png");

		addResource(COW, "/animal/cow/COW.png");
		// addResource(COWUpRight, "/COWUpRight.png");
		// addResource(COWUpLeft, "/COWUpLeft.png");
		// addResource(COWDownRight, "/COWDownRight.png");
		// addResource(COWDownLeft, "/COWDownLeft.png");
	}	
	
	/**
	 * Add the resources for droppable resource entitis, 
	 * such as feathers, beef, milk etc
	 */
	private void addResourceEntityResources() {
		addResource(CLOUD, "/animal/cloud.gif");
	}
	
	/**
	 * Add the resources for landscape items such as rocks and trees
	 */
	private void addLandscapeResources() {
		/*---Object resources---*/
		addResource(BOX, "/box2.png");
		addResource(LONG_BOX, "/longbox.png");
		addResource(WOOD_BOX, "/wood_stock.png");
		addResource(TREE_1, "/tree_1.png");
		addResource(TREE_2, "/tree_2.png");
		addResource(TREE_3, "/tree_3.png");
		addResource(ROCK_1, "/rock_1.png");
		addResource(ROCK_2, "/rock_2.png");
	}

	/**
	 * Miscellaneous resources - probably used for testing or debugging
	 */
	private void addMiscellaneousResources() {
		addResource(VOID, "/black.png");
		addResource(CYAN, "/cyan.png");
		addResource(CYAN_CROSSED, "/cyan_crossed.png");
		addResource(YELLOW, "/yellow.png");

		addResource(WATER, "/water.png");
		addResource(BLANK, "/blank.png");
	}

}
