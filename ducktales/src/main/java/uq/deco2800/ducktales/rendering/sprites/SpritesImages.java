package uq.deco2800.ducktales.rendering.sprites;

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
 * @author Gabrielle Hodge, 43590526
 *
 */
public class SpritesImages {
	
	/**
	 * Images for animation of the school during the day.
	 * 
	 * @return list containing images of the school animation during 
	 * the day
	 */
	public static List<Image> schoolDay() {
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
	 * Images for animation of the school during the night.
	 * 
	 * @return list containing images of the school animation during 
	 * the night
	 */
	public static List<Image> schoolNight() {
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
}
