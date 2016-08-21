package uq.deco2800.ducktales.weather;

public class Rain implements Weather {
	public Effect getEffect() {
		Effect effect = new Effect();
		return effect;
	}
	
	public boolean isLand() {
		return true;
	}
	
	public boolean isWater() {
		return true;
	}
	
	public boolean isAmphibious() {
		return isLand() && isWater();
	}
	
	public boolean requiresObjectUpdate() {
		return true;
	}
}
