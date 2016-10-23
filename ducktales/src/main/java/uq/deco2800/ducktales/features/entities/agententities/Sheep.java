package uq.deco2800.ducktales.features.entities.agententities;

import java.util.Random;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Class which defines the animal 'Sheep' that produces wool and mutton
 *
 * @author Damian Maher
 */

public class Sheep extends Animal {

	/** variables which check whether the sheep can produce wool and mutton */
    private boolean canProduceWool = false; 
    private boolean canProduceMutton = false; 

    /** 
     * Constructor for the sheep animal, creates a new sheep at the specified
     * location
     * 
     * @param x, the x location of the sheep
     * @param y, the y location of the sheep
     */
    public Sheep(int x, int y) {
        super(x, y, ResourceType.SHEEP, 1, 1, 1, 1, 0.02);
        int var = 20 + (int)(Math.random() * ((100 - 20) + 1));
        int var2 = 0 + (int)(Math.random() * ((50 - 0) + 1));
        setStartingHealth(var);
        setStartingHunger(var2);
        setStartingThirst(var2);
        setStartingStrength(var2);
    }

    /**
     * Checks whether the sheep can produce wool. Sheep can only produce 
     * wool if their health, hunger, and thirst meet
     * satisfy a certain threshold.
     */
    public void produceWool() {
        if (this.getHealth() >= 85 && this.getHunger() >= 85 && this.
        	getThirst() >= 85) {
            this.canProduceWool = true;
        }
    }
    
    /**
     * Checks whether the sheep can produce mutton. Sheep can only produce 
     * mutton if their health, hunger, and thirst meet
     * satisfy a certain threshold.
     */
    public void produceMutton() {
        if (this.isDead()) {
            this.canProduceMutton = true;
        }
    }

    /**
     * Returns whether the sheep can produce wool.
     *
     * @return canProduceWool
     */
    public boolean canProduceWool() {
        return this.canProduceWool;
    }
    
    /**
     * Returns whether the sheep can produce mutton.
     *
     * @return canProduceWool
     */
    public boolean canProduceMutton() {
        return this.canProduceMutton;
    }
}
