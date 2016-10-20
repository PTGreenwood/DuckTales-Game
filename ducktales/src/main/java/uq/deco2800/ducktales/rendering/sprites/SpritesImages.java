package uq.deco2800.ducktales.rendering.sprites;

import uq.deco2800.ducktales.resources.ResourceType;

public class SpritesImages {
	
	public static ResourceType[] schoolDay() {
		ResourceType[] idleFrames = {
				ResourceType.SCHOOL_1,
				ResourceType.SCHOOL_2,
				ResourceType.SCHOOL_3,
				ResourceType.SCHOOL_4,
				ResourceType.SCHOOL_5,
		};
		return idleFrames;
	}
	
	public static ResourceType[] schoolNight() {
		ResourceType[] idleFrames = {
				ResourceType.SCHOOL_NIGHT_1,
                ResourceType.SCHOOL_NIGHT_2,
                ResourceType.SCHOOL_NIGHT_3,
                ResourceType.SCHOOL_NIGHT_4,
                ResourceType.SCHOOL_NIGHT_5,
                ResourceType.SCHOOL_NIGHT_6,
		};
		return idleFrames;
	}
}