package uq.deco2800.ducktales.duckgods;

import uq.deco2800.ducktales.util.*;

/**
 * Base class for all duck gods and their bonuses
 * 
 * @author Alison Collins
 *
 */

public class DuckGods {
    
    // The name of the duck god selected.
    protected String duckName;
    // The bonus implemented by the duck god.
    protected int bonus;
    // The image to be rendered of the duck god.
    protected String image;
    // The selected duck god
    protected String selectedDuckGod;
    

    public void DuckGod(String name, int bonus, String image) {
        this.duckName = name;
        this.bonus = bonus;
        this.image = image;
        //this.selectedDuckGod = ;
                
    }
}