package uq.deco2800.ducktales.entities;

public class Threat {
	String name;
	String type;
	private boolean hasStartTimer = false;
	private boolean hasEndTimer = false;

	private float startTimer = 0;
	private float endTimer = 0;
	private float currentTime;

	/**
	 * Enemy takes a string name and a type of enemy which is or Creature or
	 * Effect
	 * 
	 * @param name
	 *            - String name
	 * @param type
	 *            - String that is Creature or Effect
	 * @return
	 */
	public Threat(String name, String type) {

		if (name == null || name.isEmpty() || name.trim().isEmpty()) {
			// Throw exception
		} else {
			this.name = name;
		}

		if (!(type.equals("Enemy") || type.equals("Effect"))) {
			// Throw exception
		} else {

			this.type = type;
		}
	}

	/**
	 * Set time for a timer of start
	 * 
	 * @param time
	 *            input the system time when the effect needs to start
	 */
	public void setStartTimer(float time) {
		if (time > 0) {
			this.startTimer = time;
			this.hasStartTimer = true;
		} else {
			// throw new exception
		}
	}

	/**
	 * Set time for a timer of expiry
	 * 
	 * @param time
	 *            in seconds when effect ends from now
	 */
	public void setEndTimer(float time) {
		if (time > 0) {
			this.currentTime = System.currentTimeMillis();
			this.endTimer = time + currentTime;
			this.hasEndTimer = true;
		} else {
			// throw new exception
		}

	}

	/**
	 * 
	 * @return true if the effect should/end expire
	 */
	public boolean hasEffectEnded() {
		this.currentTime = System.currentTimeMillis();
		if (endTimer == currentTime && hasEndTimer) {
			// Change HasEndTimer to false (Not sure if if stat will break)
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return true when the effect should start
	 */
	public boolean shouldEffectStart() {
		this.currentTime = System.currentTimeMillis();
		if (startTimer == currentTime && hasStartTimer) {
			// Change HasStarTimer to false (Not sure if if stat will break)
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return StartTime if it exists or 0 if the timer has expired or otherwise
	 */
	public float returnStartTime() {
		if (hasStartTimer) {
			return startTimer;
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @return EndTime if it exists or 0 if the timer has expired or otherwise
	 */
	public float returnEndTime() {
		if (hasEndTimer) {
			return endTimer;
		} else {
			return 0;
		}
	}

}