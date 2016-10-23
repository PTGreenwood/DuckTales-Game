package uq.deco2800.ducktales.features.duckgods;

import javax.swing.ImageIcon;

/**
 * Individual class for the Fire God
 * 
 * @author Freddy
 * 
 */
public class FireGod extends DuckGods {
	
	/** this feature is waited to be build
	private boolean noConflict = true;
	*/
	  
	public FireGod(String name, String bonus, ImageIcon image) {
		super(name, bonus, image);
	}

	public String getBouns(){
		return bonus;
	} 

	public void giveaward() {
		if(isWorshiped){
       /**Peon.speed= Peon.speed*2;
		*need to change Speed visibility to public
		*/
		}
	}
	
	public void givepenalty() {
		if(isSelected &&! isWorshiped){
	  /**Peon.speed= Peon.speed*0.8;
	   *need to change Speed visibility to public
	   *more penalty detail
	   */
		}
	}  
        
}
