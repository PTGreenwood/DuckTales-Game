package uq.deco2800.ducktales.resources;

import static uq.deco2800.ducktales.resources.ResourceType.*;

import java.util.concurrent.ConcurrentHashMap;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;


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
			throw new GameSetupException(
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
			throw new GameSetupException(
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
		addResource(STONEMASON, "/buildings/stonemason.png");

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
		
		addResource(GYMNASIUM_NIGHT_1, "/buildings/gymnasium_night/gymnasium_night_1.png");
		addResource(GYMNASIUM_NIGHT_2, "/buildings/gymnasium_night/gymnasium_night_2.png");
		addResource(GYMNASIUM_NIGHT_3, "/buildings/gymnasium_night/gymnasium_night_3.png");
		addResource(GYMNASIUM_NIGHT_4, "/buildings/gymnasium_night/gymnasium_night_4.png");
		addResource(GYMNASIUM_NIGHT_5, "/buildings/gymnasium_night/gymnasium_night_5.png");
		addResource(GYMNASIUM_NIGHT_6, "/buildings/gymnasium_night/gymnasium_night_6.png");
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
		
		// Winter animations
		// Bakery
		addResource(BAKERY_WINTER_1, "/buildings/bakery_winter/bakery_winter_1.png");
		addResource(BAKERY_WINTER_2, "/buildings/bakery_winter/bakery_winter_2.png");
		addResource(BAKERY_WINTER_3, "/buildings/bakery_winter/bakery_winter_3.png");
		addResource(BAKERY_WINTER_4, "/buildings/bakery_winter/bakery_winter_4.png");
		// Butcher
		addResource(BUTCHER_WINTER, "/buildings/butcher_winter.png");
		// Cemetery
		addResource(CEMETERY_WINTER, "/buildings/cemetery_small_winter.png");
		// Church
		addResource(CHURCH_WINTER, "/buildings/church_winter.png");
		// Community Building
		addResource(COMMUNITY_BUILDING_WINTER_1, "/buildings/community_building_winter/community_building_winter_1.png");
		addResource(COMMUNITY_BUILDING_WINTER_2, "/buildings/community_building_winter/community_building_winter_2.png");
		addResource(COMMUNITY_BUILDING_WINTER_3, "/buildings/community_building_winter/community_building_winter_3.png");
		addResource(COMMUNITY_BUILDING_WINTER_4, "/buildings/community_building_winter/community_building_winter_4.png");
		// Forge
		addResource(FORGE_WINTER, "/buildings/forge_winter.png");
		// Gymnasium
		addResource(GYMNASIUM_WINTER_1, "/buildings/gymnasium_winter/gymnasium_winter_1.png");
		addResource(GYMNASIUM_WINTER_2, "/buildings/gymnasium_winter/gymnasium_winter_2.png");
		addResource(GYMNASIUM_WINTER_3, "/buildings/gymnasium_winter/gymnasium_winter_3.png");
		addResource(GYMNASIUM_WINTER_4, "/buildings/gymnasium_winter/gymnasium_winter_4.png");
		// Hospital
		addResource(HOSPITAL_WINTER, "/buildings/hospital_winter.png");
		// House
		addResource(HOUSE_WINTER, "/buildings/house_winter.png");
		// Mine
		addResource(MINE_WINTER, "/buildings/mine_winter.png");
		// Observatory
		addResource(OBSERVATORY_WINTER, "/buildings/observatory_winter.png");
		// Sawmill
		addResource(SAWMILL_WINTER, "/buildings/sawmill_winter.png");
		// School
		addResource(SCHOOL_WINTER, "/buildings/school_winter.png");
		// Stonemason
		addResource(STONEMASON_WINTER, "/buildings/stonemason_winter.png");
		// Storage Barn
		addResource(STORAGEBARN_WINTER, "/buildings/storagebarn_winter.png");

		
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
		
		//LumberJack
		addResource(LUMBERJACK, "/peon/jobs/lumberjacks_1.png");
		addResource(LUMBERJACK_LV2, "/toolsUpgrade/lumberjack/lumberjack_lv2.png");
		addResource(LUMBERJACK_LV3, "/toolsUpgrade/lumberjack/lumberjack_lv3.png");
		
		//Miner
		addResource(MINER, "/peon/jobs/miner_1.png");
		addResource(MINER_LV2, "/toolsUpgrade/miner/miner_lv2.png");
		addResource(MINER_LV3, "/toolsUpgrade/miner/miner_lv3.png");
		//Blacksmith
		addResource(BLACKSMITH, "/peon/jobs/blacksmiths_1.png");	
		addResource(BLACKSMITH_LV2, "/toolsUpgrade/blacksmith/blacksmiths_lv2.png");
		addResource(BLACKSMITH_LV3, "/toolsUpgrade/blacksmith/blacksmiths_lv3.png");
		//Builder
		addResource(BUILDER, "/peon/jobs/builder_1.png");		
		addResource(BUILDER_LV2, "/toolsUpgrade/builder/builder_lv2.png");
		addResource(BUILDER_LV3, "/toolsUpgrade/builder/builder_lv3_left.png");
		//Doctor
		addResource(DOCTOR, "/peon/jobs/doctor_1.png");	
		addResource(DOCTOR_LV2, "/toolsUpgrade/doctor/doctor_lv2.png");
		addResource(DOCTOR_LV3, "/toolsUpgrade/doctor/doctor_lv3_left.png");
		//Farmer
		addResource(FARMER, "/peon/jobs/farmer_1.png");		
		addResource(FARMER_LV2, "/toolsUpgrade/farmer/farmer_lv2.png");
		addResource(FARMER_LV3, "/toolsUpgrade/farmer/farmer_lv3_left.png");
		//GymCoach
		addResource(GYMCOACH, "/peon/jobs/GymCoach_1.png");
		addResource(GYMCOACH_LV2, "/toolsUpgrade/gymcoach/gymcoach_lv2.png");
		addResource(GYMCOACH_LV3, "/toolsUpgrade/gymcoach/gymcoach_lv3_left.png");
		//Priest
		addResource(PRIEST, "/peon/jobs/priest_Church.png");		
		//Stonemason
		addResource(STONE_MASON, "/peon/jobs/stonemason.png");
		addResource(STONE_MASON_LV2, "/toolsUpgrade/stonemason/stonemason_lv2.png");	
		addResource(STONE_MASON_LV3, "/toolsUpgrade/stonemason/stonemason_lv3.png");	
		//Teacher
		addResource(TEACHER, "/peon/jobs/teacher_1.png");
		addResource(TEACHER_LV2, "/toolsUpgrade/teacher/teacher_lv2.png");	
		addResource(TEACHER_LV3, "/toolsUpgrade/teacher/teacher_lv3.png");	
		
		
		/*
		 * ANIMALS
		 */
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

		// addResource(COWUpRight, "/COWUpRight.png");
		// addResource(COWUpLeft, "/COWUpLeft.png");
		// addResource(COWDownRight, "/COWDownRight.png");
		// addResource(COWDownLeft, "/COWDownLeft.png");

		/*
		 * For the Menu
		 */
		addResource(SHEEP, "/animal/menu/sheep_stand.png");
		addResource(WOLF, "/animal/menu/wolf_front.png");
		addResource(COW, "/animal/menu/cow_front.png");
		addResource(DUCK, "/animal/menu/duck_stand.png");
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
		addResource(TREE_1_SUMMER, "/gameresources/trees/seasons/tree_1_summer.png");
		addResource(TREE_2_SUMMER, "/gameresources/trees/seasons/tree_2_summer.png");
		addResource(TREE_3_SUMMER, "/gameresources/trees/seasons/tree_3_summer.png");
		addResource(TREE_1_AUTUMN, "/gameresources/trees/seasons/tree_1_autumn.png");
		addResource(TREE_2_AUTUMN, "/gameresources/trees/seasons/tree_2_autumn.png");
		addResource(TREE_3_AUTUMN, "/gameresources/trees/seasons/tree_3_autumn.png");
		addResource(TREE_1_WINTER, "/gameresources/trees/seasons/tree_1_winter.png");
		addResource(TREE_2_WINTER, "/gameresources/trees/seasons/tree_2_winter.png");
		addResource(TREE_3_WINTER, "/gameresources/trees/seasons/tree_3_winter.png");
		addResource(TREE_1_SPRING, "/gameresources/trees/seasons/tree_1_spring.png");
		addResource(TREE_2_SPRING, "/gameresources/trees/seasons/tree_2_spring.png");
		addResource(TREE_3_SPRING, "/gameresources/trees/seasons/tree_3_spring.png");		
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
