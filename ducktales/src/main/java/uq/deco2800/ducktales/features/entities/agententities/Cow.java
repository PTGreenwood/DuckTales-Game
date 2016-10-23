package uq.deco2800.ducktales.features.entities.agententities;

import java.util.Random;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Class which defines the animal 'Cow' that produces milk and beef
 *
 * @author Damian Maher
 */

public class Cow extends Animal {

	/** variables which check whether the cow can produce milk and beef*/
    private boolean canProduceMilk = false; 
    private boolean canProduceBeef = false; 

    /** 
     * Constructor for the cow animal, creates a new cow at the specified
     * location
     * 
     * @param x, the x location of the cow
     * @param y, the y location of the cow
     */
    public Cow(int x, int y) {
        super(x, y, ResourceType.COW, 1, 1, 1, 1, 0.05);
        int var = 20 + (int)(Math.random() * ((100 - 20) + 1));
        int var2 = 0 + (int)(Math.random() * ((50 - 0) + 1));
        setStartingHealth(var);
        setStartingHunger(var2);
        setStartingThirst(var2);
        setStartingStrength(var2);
    }

    /**
     * Checks whether the cow can produce milk. Cows can only produce 
     * milk if their health, hunger, and thirst meet
     * satisfy a certain threshold.
     */
    public void produceMilk() {
        if (this.getHealth() >= 85 && this.getHunger() >= 85 && this.
        	getThirst() >= 85) {
            this.canProduceMilk = true;
        } 
    }
    
    /**
     * Checks whether the cow can produce beef. Cows can only produce beef if 
     * they are dead
     */
    public void produceBeef() {
        if (this.isDead()) {
            this.canProduceBeef = true;
        }
    }

    /**
     * Returns whether the cow can produce milk.
     *
     * @return canProduceMilk
     */
    public boolean canProduceMilk() {
        return this.canProduceMilk;
    }
    
    /**
     * Returns whether the cow can produce beef.
     *
     * @return canProduceBeef
     */
    public boolean canProduceBeef() {
        return this.canProduceBeef;
    }
}
