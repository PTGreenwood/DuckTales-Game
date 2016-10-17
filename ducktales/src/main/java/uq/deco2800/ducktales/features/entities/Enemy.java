package uq.deco2800.ducktales.features.entities;

import uq.deco2800.ducktales.features.entities.threats.Threat;

public class Enemy extends Threat {
	
	/**Creates an Enemy that does some harm to the world
	 * 
	 * @param name
	 */	
	public Enemy(String name){
		super(name,"Enemy");
	}
}
