package uq.deco2800.ducktales.entities;

/**
 * Class which defines the threat 'PoisonCloud' that
 * can poison the land
 *
 * @author Krista Harrison
 */

public class PoisonCloud {
	
	private boolean cloudActive = false;
	private int poison = 100;
	
	
	public PoisonCloud(int x, int y) {
		
	}
	
	private void canAttack() {
		if (this.poison > 0)
			this.cloudActive =true;
	}
	
	public void attack() {
		// this method will detail the effects on the environment
	}
	
	//method to return poison levels
	public int poisonLevel() {
		return poison;
	}
	

}
