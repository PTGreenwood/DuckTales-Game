package uq.deco2800.ducktales.weather;

/**
 * 
 * @author mattyleggy
 *
 */
public class Fire implements Weather {
	public Effect getEffect() {
		Effect effect = new Effect();
		return effect;
	}
	
	public boolean isLand() {
		return true;
	}
	
	public boolean isWater() {
		return false;
	}
	
	public boolean isAmphibious() {
		return isLand() && isWater();
	}
	
	public boolean requiresObjectUpdate() {
		return true;
	}
}
