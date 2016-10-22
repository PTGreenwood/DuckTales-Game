package uq.deco2800.ducktales.rendering.sprites;

import static uq.deco2800.ducktales.resources.ResourceType.*;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;


/**
 * Class to contain the images for animations for the buildings. Only 
 * for buildings with animations that are to swap (night and day, or 
 * non-winter and winter).
 * 
 * Note: null is returned by all methods if the resource is not a valid 
 * building, or if there are no animation images for that type
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */
public class SpritesImages {
	
	/**
	 * Select the winter animation for the building. calls the relevant method 
	 * to return the list of images for the buildings winter animation.
	 * 
	 * @param building to get animation images for
	 * @return list of animation images
	 */
	public static List<Image> dayAnimation(ResourceType building) {
		switch (building) {
			case BAKERY:
				return dayBakery();
			case BARN:
				return dayBarn();
			case BUTCHER:
				return dayButcher();
			case CEMETERY:
				return dayCemetery();
			case CHURCH:
				return dayChurch();
			case COMMUNITY_BUILDING:
				return dayCommunityBuilding();
			case FARM:
				return dayFarm();
			case FORGE:
				return dayForge();
			case GYMNASIUM:
				return dayGymnasium();
			case HOSPITAL:
				return dayHospital();
			case HOUSE:
				return dayHouse();
			case MINE:
				return dayMine();
			case OBSERVATORY:
				return dayObservatory();
			case PASTURE:
				return dayPasture();
			case QUARRY:
				return dayQuarry();
			case SAWMILL:
				return daySawmill();
			case SCHOOL:
				return daySchool();
			case STORAGEBARN:
				return dayStorageBarn();
		}
		return null;
	}
	

	/**
	 * Images for animation of the bakery during the day.
	 * 
	 * @return list containing images of the bakery animation during 
	 * the day
	 */
	protected static List<Image> dayBakery() {
		ResourceType[] idleFrames = {
				ResourceType.BAKERY_1,
                ResourceType.BAKERY_2,
                ResourceType.BAKERY_3,
                ResourceType.BAKERY_4,
                ResourceType.BAKERY_5
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the barn during the day.
	 * 
	 * @return list containing images of the barn animation during 
	 * the day
	 */
	protected static List<Image> dayBarn() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the butcher during the day.
	 * 
	 * @return list containing images of the butcher animation during 
	 * the day
	 */
	protected static List<Image> dayButcher() {
		ResourceType[] idleFrames = {
				ResourceType.BUTCHER_1,
                ResourceType.BUTCHER_2,
                ResourceType.BUTCHER_3,
                ResourceType.BUTCHER_4,
                ResourceType.BUTCHER_5,
                ResourceType.BUTCHER_5,
                ResourceType.BUTCHER_5,
                ResourceType.BUTCHER_5,
                ResourceType.BUTCHER_5
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the cemetery during the day.
	 * 
	 * @return list containing images of the cememtery animation during 
	 * the day
	 */
	protected static List<Image> dayCemetery() {
		ResourceType[] idleFrames = {
				 ResourceType.CEMETERY_1,
	                ResourceType.CEMETERY_2,
	                ResourceType.CEMETERY_3,
	                ResourceType.CEMETERY_4,
	                ResourceType.CEMETERY_5,
	                ResourceType.CEMETERY_6,
	                ResourceType.CEMETERY_7,
	                ResourceType.CEMETERY_8,
	                ResourceType.CEMETERY_9,
	                ResourceType.CEMETERY_10,
	                ResourceType.CEMETERY_11,
	                ResourceType.CEMETERY_12,
	                ResourceType.CEMETERY_13,
	                ResourceType.CEMETERY_14,
	                ResourceType.CEMETERY_15,
	                ResourceType.CEMETERY_16,
	                ResourceType.CEMETERY_16,
	                ResourceType.CEMETERY_16,
	                ResourceType.CEMETERY_16
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the church during the day.
	 * 
	 * @return list containing images of the church animation during 
	 * the day
	 */
	protected static List<Image> dayChurch() {
		ResourceType[] idleFrames = {
				ResourceType.CHURCH_1,
                ResourceType.CHURCH_2,
                ResourceType.CHURCH_3,
                ResourceType.CHURCH_4,
                ResourceType.CHURCH_5
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the community building during the day.
	 * 
	 * @return list containing images of the community building animation 
	 * during the day
	 */
	protected static List<Image> dayCommunityBuilding() {
		ResourceType[] idleFrames = {
				COMMUNITY_BUILDING_1,
				COMMUNITY_BUILDING_2,
		        COMMUNITY_BUILDING_3,
		        COMMUNITY_BUILDING_4,
		        COMMUNITY_BUILDING_5,
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the farm during the day.
	 * 
	 * @return list containing images of the farm animation during 
	 * the day
	 */
	protected static List<Image> dayFarm() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the forge during the day.
	 * 
	 * @return list containing images of the forge animation during 
	 * the day
	 */
	protected static List<Image> dayForge() {
		ResourceType[] idleFrames = {
				ResourceType.FORGE_1,
	             ResourceType.FORGE_2,
	             ResourceType.FORGE_3,
	             ResourceType.FORGE_4,
	             ResourceType.FORGE_5,
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the gymnasium during the day.
	 * 
	 * @return list containing images of the gymnasium animation during 
	 * the day
	 */
	protected static List<Image> dayGymnasium() {
		ResourceType[] idleFrames = {
				GYMNASIUM_1,
	            GYMNASIUM_2,
	            GYMNASIUM_3,
	            GYMNASIUM_4,
	            GYMNASIUM_5,
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the hospital during the day.
	 * 
	 * @return list containing images of the hospital animation during 
	 * the day
	 */
	protected static List<Image> dayHospital() {
		ResourceType[] idleFrames = {
				HOSPITAL_1,
	            HOSPITAL_2,
	            HOSPITAL_3,
	            HOSPITAL_4,
	            HOSPITAL_5
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the house during the day.
	 * 
	 * @return list containing images of the house animation during 
	 * the day
	 */
	protected static List<Image> dayHouse() {
		ResourceType[] idleFrames = {
				HOUSE_1,
	            HOUSE_2,
	            HOUSE_3,
	            HOUSE_4,
	            HOUSE_5,
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the mine during the day.
	 * 
	 * @return list containing images of the mine animation during 
	 * the day
	 */
	protected static List<Image> dayMine() {
		ResourceType[] idleFrames = {
				MINE_1,
	            MINE_2,
	            MINE_3,
	            MINE_4
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the observatory during the day.
	 * 
	 * @return list containing images of the observatory animation during 
	 * the day
	 */
	protected static List<Image> dayObservatory() {
		ResourceType[] idleFrames = {
				ResourceType.OBSERVATORY_1,
                ResourceType.OBSERVATORY_2,
                ResourceType.OBSERVATORY_3,
                ResourceType.OBSERVATORY_4,
                ResourceType.OBSERVATORY_5
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the pasture during the day.
	 * 
	 * @return list containing images of the pasture animation during 
	 * the day
	 */
	protected static List<Image> dayPasture() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the quarry during the day.
	 * 
	 * @return list containing images of the quarry animation during 
	 * the day
	 */
	protected static List<Image> dayQuarry() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the sawmill during the day.
	 * 
	 * @return list containing images of the sawmill animation during 
	 * the day
	 */
	protected static List<Image> daySawmill() {
		ResourceType[] idleFrames = {
				ResourceType.SAWMILL_1,
                ResourceType.SAWMILL_2,
                ResourceType.SAWMILL_3,
                ResourceType.SAWMILL_4,
                ResourceType.SAWMILL_5,
                ResourceType.SAWMILL_6,
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the school during the day.
	 * 
	 * @return list containing images of the school animation during 
	 * the day
	 */
	protected static List<Image> daySchool() {
		ResourceType[] idleFrames = {
				ResourceType.SCHOOL_1,
				ResourceType.SCHOOL_2,
				ResourceType.SCHOOL_3,
				ResourceType.SCHOOL_4,
				ResourceType.SCHOOL_5,
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the storage barn during the day.
	 * 
	 * @return list containing images of the storage barn animation during 
	 * the day
	 */
	protected static List<Image> dayStorageBarn() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}

	/**
	 * Select the winter animation for the building. calls the relevant method 
	 * to return the list of images for the buildings winter animation.
	 * 
	 * @param building to get animation images for
	 * @return list of animation images
	 */
	public static List<Image> nightAnimation(ResourceType building) {
		switch (building) {
			case BAKERY:
				return nightBakery();
			case BARN:
				return nightBarn();
			case BUTCHER:
				return nightButcher();
			case CEMETERY:
				return nightCemetery();
			case CHURCH:
				return nightChurch();
			case COMMUNITY_BUILDING:
				return nightCommunityBuilding();
			case FARM:
				return nightFarm();
			case FORGE:
				return nightForge();
			case GYMNASIUM:
				return nightGymnasium();
			case HOSPITAL:
				return nightHospital();
			case HOUSE:
				return nightHouse();
			case MINE:
				return nightMine();
			case OBSERVATORY:
				return nightObservatory();
			case PASTURE:
				return nightPasture();
			case QUARRY:
				return nightQuarry();
			case SAWMILL:
				return nightSawmill();
			case SCHOOL:
				return nightSchool();
			case STORAGEBARN:
				return nightStorageBarn();
		}
		return null;
	}
	
	/**
	 * Images for animation of the bakery during the night.
	 * 
	 * @return list containing images of the bakery animation during 
	 * the night
	 */
	protected static List<Image> nightBakery() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the barn during the night.
	 * 
	 * @return list containing images of the barn animation during 
	 * the night
	 */
	protected static List<Image> nightBarn() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the butcher during the night.
	 * 
	 * @return list containing images of the butcher animation during 
	 * the night
	 */
	protected static List<Image> nightButcher() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the cemetery during the night.
	 * 
	 * @return list containing images of the cememtery animation during 
	 * the night
	 */
	protected static List<Image> nightCemetery() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null ; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the church during the night.
	 * 
	 * @return list containing images of the church animation during 
	 * the night
	 */
	protected static List<Image> nightChurch() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the community building during the night.
	 * 
	 * @return list containing images of the community building animation 
	 * during the night
	 */
	protected static List<Image> nightCommunityBuilding() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the farm during the night.
	 * 
	 * @return list containing images of the farm animation during 
	 * the night
	 */
	protected static List<Image> nightFarm() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the forge during the night.
	 * 
	 * @return list containing images of the forge animation during 
	 * the night
	 */
	protected static List<Image> nightForge() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the gymnasium during the night.
	 * 
	 * @return list containing images of the gymnasium animation during 
	 * the night
	 */
	protected static List<Image> nightGymnasium() {
		ResourceType[] idleFrames = {
				GYMNASIUM_NIGHT_1,
		        GYMNASIUM_NIGHT_2,
		        GYMNASIUM_NIGHT_3,
		        GYMNASIUM_NIGHT_4,
		        GYMNASIUM_NIGHT_5,
		        GYMNASIUM_NIGHT_6,        
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the hospital during the night.
	 * 
	 * @return list containing images of the hospital animation during 
	 * the night
	 */
	protected static List<Image> nightHospital() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the house during the night.
	 * 
	 * @return list containing images of the house animation during 
	 * the night
	 */
	protected static List<Image> nightHouse() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the mine during the night.
	 * 
	 * @return list containing images of the mine animation during 
	 * the night
	 */
	protected static List<Image> nightMine() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null;// idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the observatory during the night.
	 * 
	 * @return list containing images of the observatory animation during 
	 * the night
	 */
	protected static List<Image> nightObservatory() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null;//idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the pasture during the night.
	 * 
	 * @return list containing images of the pasture animation during 
	 * the night
	 */
	protected static List<Image> nightPasture() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the quarry during the night.
	 * 
	 * @return list containing images of the quarry animation during 
	 * the night
	 */
	protected static List<Image> nightQuarry() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the sawmill during the night.
	 * 
	 * @return list containing images of the sawmill animation during 
	 * the night
	 */
	protected static List<Image> nightSawmill() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the school during the night.
	 * 
	 * @return list containing images of the school animation during 
	 * the night
	 */
	protected static List<Image> nightSchool() {
		ResourceType[] idleFrames = {
				ResourceType.SCHOOL_NIGHT_1,
                ResourceType.SCHOOL_NIGHT_2,
                ResourceType.SCHOOL_NIGHT_3,
                ResourceType.SCHOOL_NIGHT_4,
                ResourceType.SCHOOL_NIGHT_5,
                ResourceType.SCHOOL_NIGHT_6,
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the storage barn during the night.
	 * 
	 * @return list containing images of the storage barn animation during 
	 * the night
	 */
	protected static List<Image> nightStorageBarn() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	
	/**
	 * Select the winter animation for the building. calls the relevant method 
	 * to return the list of images for the buildings winter animation.
	 * 
	 * @param building to get animation images for
	 * @return list of animation images
	 */
	public static List<Image> winterAnimation(ResourceType building) {
		switch (building) {
			case BAKERY:
				return winterBakery();
			case BARN:
				return winterBarn();
			case BUTCHER:
				return winterButcher();
			case CEMETERY:
				return winterCemetery();
			case CHURCH:
				return winterChurch();
			case COMMUNITY_BUILDING:
				return winterCommunityBuilding();
			case FARM:
				return winterFarm();
			case FORGE:
				return winterForge();
			case GYMNASIUM:
				return winterGymnasium();
			case HOSPITAL:
				return winterHospital();
			case HOUSE:
				return winterHouse();
			case MINE:
				return winterMine();
			case OBSERVATORY:
				return winterObservatory();
			case PASTURE:
				return winterPasture();
			case QUARRY:
				return winterQuarry();
			case SAWMILL:
				return winterSawmill();
			case SCHOOL:
				return winterSchool();
			case STORAGEBARN:
				return winterStorageBarn();
		}
		return null;
	}
	
	/**
	 * Images for animation of the bakery during the winter.
	 * 
	 * @return list containing images of the bakery animation during 
	 * the winter
	 */
	protected static List<Image> winterBakery() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the barn during the winter.
	 * 
	 * @return list containing images of the barn animation during 
	 * the winter
	 */
	protected static List<Image> winterBarn() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the butcher during the winter.
	 * 
	 * @return list containing images of the butcher animation during 
	 * the winter
	 */
	protected static List<Image> winterButcher() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the cemetery during the winter.
	 * 
	 * @return list containing images of the cememtery animation during 
	 * the winter
	 */
	protected static List<Image> winterCemetery() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the church during the winter.
	 * 
	 * @return list containing images of the church animation during 
	 * the winter
	 */
	protected static List<Image> winterChurch() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the community building during the winter.
	 * 
	 * @return list containing images of the community building animation 
	 * during the winter
	 */
	protected static List<Image> winterCommunityBuilding() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the farm during the winter.
	 * 
	 * @return list containing images of the farm animation during 
	 * the winter
	 */
	protected static List<Image> winterFarm() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the forge during the winter.
	 * 
	 * @return list containing images of the forge animation during 
	 * the winter
	 */
	protected static List<Image> winterForge() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the gymnasium during the winter.
	 * 
	 * @return list containing images of the gymnasium animation during 
	 * the winter
	 */
	protected static List<Image> winterGymnasium() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the hospital during the winter.
	 * 
	 * @return list containing images of the hospital animation during 
	 * the winter
	 */
	protected static List<Image> winterHospital() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the house during the winter.
	 * 
	 * @return list containing images of the house animation during 
	 * the winter
	 */
	protected static List<Image> winterHouse() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the mine during the winter.
	 * 
	 * @return list containing images of the mine animation during 
	 * the winter
	 */
	protected static List<Image> winterMine() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null; //idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the observatory during the winter.
	 * 
	 * @return list containing images of the observatory animation during 
	 * the winter
	 */
	protected static List<Image> winterObservatory() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null;//idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the pasture during the winter.
	 * 
	 * @return list containing images of the pasture animation during 
	 * the winter
	 */
	protected static List<Image> winterPasture() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null;//idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the quarry during the winter.
	 * 
	 * @return list containing images of the quarry animation during 
	 * the winter
	 */
	protected static List<Image> winterQuarry() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null;//idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the sawmill during the winter.
	 * 
	 * @return list containing images of the sawmill animation during 
	 * the winter
	 */
	protected static List<Image> winterSawmill() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null;//idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the school during the winter.
	 * 
	 * @return list containing images of the school animation during 
	 * the winter
	 */
	protected static List<Image> winterSchool() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null;//idleAnimationFrames;
	}
	

	/**
	 * Images for animation of the storage barn during the winter.
	 * 
	 * @return list containing images of the storage barn animation during 
	 * the winter
	 */
	protected static List<Image> winterStorageBarn() {
		ResourceType[] idleFrames = {
				
		};
		List<Image> idleAnimationFrames = new ArrayList<>();
	    ResourceSpriteRegister register = ResourceSpriteRegister.getInstance();
	    for (ResourceType frameType : idleFrames) {
            idleAnimationFrames.add(register.getResourceImage(frameType));
        }
		return null ; //idleAnimationFrames;
	}
	
}
