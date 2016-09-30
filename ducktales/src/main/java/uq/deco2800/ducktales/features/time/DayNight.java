package uq.deco2800.ducktales.features.time;

//Day/Night time for the game

public abstract class DayNight {

		//name of the sprite
		private String name;
		
		//location of the sprite
		private static final String LOCATION = "time/";
		
		//sprite file name
		private String fileName;
		
		/**
		 * @param name
		 * 			name of the sprite
		 * @param location
		 * 			folder location of the sprite
		 * @param fileName
		 * 			the filename of the sprite.
		 */
		public DayNight(String fileName) {				
			this.fileName = fileName;
		}
		
		/**
		 * @return DayNight effect name
		 */
		public String getName() {
			return this.name;
		}

		
		/**
		 * Get the location that the sprite is located
		 * 
		 * @return sprite location
		 */
		public String getLocation() {
			return LOCATION;
		}
		
		/**
		 * Get the the sprite of effect.
		 * 
		 * @return the effect sprite
		 */
		public String getSprite() {
			return LOCATION + this.fileName;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
}
