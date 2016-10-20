package uq.deco2800.ducktales.rendering.sprites;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;

public class SpritesImages {
	
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
