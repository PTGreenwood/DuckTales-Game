package uq.deco2800.ducktales.features.duckgods;

import javax.swing.ImageIcon;

import uq.deco2800.ducktales.features.entities.agententities.Peon;

/**
 * Individual class for the Fire God
 * 
 * @author Freddy
 * 
 */
public class FireGod extends DuckGods {
	
	protected boolean isBuilt     = false;  
	protected boolean isWorshiped = false;
	protected boolean isSelected  = false;
	
	/** this feature is waited to be build
	private boolean noConflict = true;
	*/
	  
	public FireGod(String name, String bonus, ImageIcon image) {
		super();
	}
	
	
	public String getBouns(){
		return bonus;
	} 
	
	
	
	public void build() {
		/**wait for firechurch to be built
		 * if(isset(firechurch)){
		 */
			isBuilt= true;
		}
		//}
	public void selected(){
	    /**needs to check mouseListener to see if it's clicked
	     if(clicked)
	     */
		isSelected = true;
	}
	
	public void worship()  {
		if(isBuilt==true && isSelected==true)
		{
		isWorshiped = true;
		}
	}
    		
	public void giveaward() {
		if(isWorshiped= true){
       /**Peon.speed= Peon.speed*2;
		*need to change Speed visibility to public
		*/
		}
		
	}
	
	public void givepenalty() {
		if(isSelected=true&&isWorshiped==false){
	  /**Peon.speed= Peon.speed*0.8;
	   *need to change Speed visibility to public
	   *more penalty detail
	   */
	}}  
        
}