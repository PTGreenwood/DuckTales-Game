package uq.deco2800.ducktales.features.duckgods;

import javax.swing.ImageIcon;

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
		
		if(isWorshiped){
      		 /**Peon.speed= Peon.speed*2;
		*need to change Speed visibility to public
		*more award details
		*/
		}
		
	}
	
	public void givepenalty() {
		
		/**
		 * provides penalties to the user which would result a negative impact
		 * e.g. debuffs
		 */
		
		if (isSelected && !isWorshiped) {

		}
	}  
        
}
