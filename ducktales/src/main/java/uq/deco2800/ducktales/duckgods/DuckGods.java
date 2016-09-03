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

public class DuckGods {
    
    // The name of the duck god selected.
    protected String duckName;
    // The bonus implemented by the duck god.
    protected String bonus;
    // The image to be rendered of the duck god.
    protected ImageIcon image;
    
    
    

    public void duckGod(String name, String bonus, ImageIcon image) {
        this.duckName = name;
        this.bonus = bonus;
        this.image = image;
        //this.selectedDuckGod = ;
                
    }
}