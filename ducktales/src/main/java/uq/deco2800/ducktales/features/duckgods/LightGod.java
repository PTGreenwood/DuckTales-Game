package uq.deco2800.ducktales.features.duckgods;

import javax.swing.ImageIcon;

/**
 * Individual class for the Light God
 * 
 * @author Freddy
 * 
 */
public class LightGod extends DuckGods {
	
	private boolean isWorshiped =false;
	private boolean isSelected = false;
	private boolean noConflict = true;
	  
	public LightGod(String name, String bonus, ImageIcon image) {
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
		//while 
	}
    public void givepenalty() {
    	
	}  
        
}