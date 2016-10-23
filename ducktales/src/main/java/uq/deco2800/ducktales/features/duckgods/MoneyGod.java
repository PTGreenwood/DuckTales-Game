package uq.deco2800.ducktales.features.duckgods;

import javax.swing.ImageIcon;

/**
 * Individual class for the Money God
 * 
 * @author Freddy
 * 
 */
public class MoneyGod extends DuckGods {
	
	/** this feature is waited to be build
	private boolean noConflict = true;
	*/
	  
	public MoneyGod(String name, String bonus, ImageIcon image) {
		super(name, bonus, image);
	}

	public void giveaward() {
		if(isWorshiped){
       /**Peon.speed= Peon.speed*2;
		*need to change Speed visibility to public
		*more award details
		*/
		}
		
	}
	
	public void givepenalty() {
		if(isSelected && !isWorshiped){
	  /**Peon.speed= Peon.speed*0.8;
	   *need to change Speed visibility to public
	   *more penalty detail
	   */
	}}  
        
}