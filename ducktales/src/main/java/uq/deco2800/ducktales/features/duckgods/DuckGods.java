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
    
    /**
     * Main constructor of {@link DuckGods}.
     * @param name
     * @param bonus
     * @param image
     */
    public String getDuckName(){
    	return duckName;
    }
    /** to get what needed to sacrifice
     * 
     * @return
     */
    public String[] getSacrifice(){
    	String[] Sacrifice ={this.getrequiredSacrifice(),this.getrequiredAmount()};
    	return Sacrifice;
    } 
    private String getrequiredAmount() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getrequiredSacrifice(){
    	return requiredSacrifice;
    	
    }
    }
