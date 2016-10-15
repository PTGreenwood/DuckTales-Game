package uq.deco2800.ducktales.features.duckgods;

import javax.swing.ImageIcon;

import uq.deco2800.ducktales.features.entities.agententities.Peon;

/**
 * Individual class for the Fire God
 * 
 * @author Freddy
 * 
 */
public class ChaosGod extends DuckGods {
	

	/** this feature is waited to be build
	private boolean noConflict = true;
	*/
	  
	public ChaosGod(String name, String bonus, ImageIcon image) {
		super();
	}
	 
	public void giveaward() {
		
		/**provides rewards to the user which would result a possitive impact
		e.g. buffs
		*/
		
		if(isWorshiped == true){
      		 /**Peon.speed= Peon.speed*2;
		*need to change Speed visibility to public
		*more award details
		*/
		}
		
	}
	
	public void givepenalty() {
		
		/**provides penalties to the user which would result a negative impact
		e.g. debuffs
		*/
		
		if(isSelected==true&&isWorshiped==false){
	  /**Peon.speed= Peon.speed*0.8;
	   *need to change Speed visibility to public
	   *more penalty detail
	   */
		}
	}  
        
}
