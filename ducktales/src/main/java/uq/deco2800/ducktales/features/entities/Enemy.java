package uq.deco2800.ducktales.features.entities;

import uq.deco2800.ducktales.features.entities.agententities.Peon;

public class Enemy extends Threat {
	
	private Peon peon;
	
	/**Creates an Enemy that does some harm to the world
	 * 
	 * @param name
	 */	
	public Enemy(String name){
		super(name,"Enemy");
	}
	
	// method to detect peon/enemy  collisions

	public void checkCollision() {
		int currentHealth = peon.getHealth();
		int newHealth = currentHealth - 50;
		if ((this.getX() == peon.getX() && 
				(this.getY() == peon.getY()))) {
					peon.setHealth(newHealth);
				}
	}
	
}
