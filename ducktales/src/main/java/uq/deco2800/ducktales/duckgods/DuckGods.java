package uq.deco2800.ducktales.duckgods;

import javax.swing.ImageIcon;

import uq.deco2800.ducktales.util.*;

/**
 * Base class for all duck gods and their bonuses
 * 
 * @author Alison Collins
 * @author freddy
 *
 */

public abstract class DuckGods {
    
    // The name of the duck god selected.
    protected String duckName;
    // The bonus implemented by the duck god.
    //We probably dont need this as every god class has its own specific bonus, having it stored as a string is redundant.
    //probably better to hava toString method
    protected String bonus;
    // The image to be rendered of the duck god.
    protected ImageIcon image;
    
    
    
 
    public DuckGods(String name, String bonus, ImageIcon image) {
        this.duckName = name;
        this.bonus = bonus;
        this.image = image;
        //this.selectedDuckGod = ;
                
    }
    
    public void applyBonus(){}
    
    public String toString(){
        return "Abstract god with no power";
    }
    
}