package uq.deco2800.ducktales.features.duckgods;

import javax.swing.ImageIcon;

/**
 * Base class for all duck gods and their bonuses
 * 
 * @author Alison Collins
 * @author freddy
 *
 */

public abstract class DuckGods {
    
	protected String requiredSacrifice; 
	protected int requiredAmount;
    		// The name of the duck god selected.
    	protected String duckName;
   		// The bonus implemented by the duck god.
	protected GodType godType;
    	protected String bonus;
   		// The image to be rendered of the duck god.
  	protected ImageIcon image;

   /** flags to control the state of the god */
    	protected boolean isBuilt = false;
    	protected boolean isWorshiped = false;
    	protected boolean isSelected = false;

    
    /**
     * Main constructor of {@link DuckGods}.
     * @param name
     * @param bonus
     * @param image
     */
    public String getDuckName() {
    	return duckName;
    }
    private String getrequiredAmount() {
	    return "";
    }
	public String getrequiredSacrifice() {
    	return requiredSacrifice;
    }

    public void build() {
        /**wait for chaoschurch to be built
         * if(isset(chaoschurch)){
         */
        isBuilt= true;
    }
 
    public void selected() {
        /**needs to check mouseListener to see if it's clicked
         if(clicked)
         */
        isSelected = true;
    }

    public void worship() {
        if(isBuilt && !isSelected) {
            isWorshiped = true;
        }
    }
}
