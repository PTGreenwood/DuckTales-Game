package uq.deco2800.ducktales.features.duckgods;

import javax.swing.ImageIcon;

import uq.deco2800.ducktales.features.entities.agententities.Peon;

/**
 * Individual class for the Earth God
 * 
 * @author Freddy
 * 
 */
public class EarthGod extends DuckGods {

	/** this feature is waited to be build
	private boolean noConflict = true;
	*/
	  
	public EarthGod(String name, String bonus, ImageIcon image) {
		super();
	}
	 
	public void giveaward() {
		if(isWorshiped == true){
      	/**Peon.speed= Peon.speed*2;
	 *need to change Speed visibility to public
	 *more award details
	 */
		}
	}
	
	public void givepenalty() {
		if(isSelected==true&&isWorshiped==false){
	  /**Peon.speed= Peon.speed*0.8;
	   *need to change Speed visibility to public
	   *more penalty detail
	   */
		}
	}  
        
}
