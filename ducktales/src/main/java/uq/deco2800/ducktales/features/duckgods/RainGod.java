package uq.deco2800.ducktales.features.duckgods;

import javax.swing.ImageIcon;

/**
 * Individual class for the Rain god.
 * 
 * @author Freddy
 * 
 */
public class RainGod extends DuckGods {
	
	private boolean isWorshiped =false;
	private boolean isSelected = false;
	private boolean noConflict = true;
	  
	public RainGod(String name, String bonus, ImageIcon image) {
    	super();
    }
	 
    public boolean isbuilt() {
    	return true;
    }
    
    public boolean isWorshiped () {
		//if(isbuilt=true)
		{
    		return true;
    	}
	}
    		
	public void giveaward() {
		//Peon.speed= Peon.speed*2;
		//while 
	}
	
    public void givepenalty() {
    	//Peon.speed=Peon.speed*0.8;
    	
	}  
        
}