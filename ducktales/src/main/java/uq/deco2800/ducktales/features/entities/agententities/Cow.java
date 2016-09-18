package uq.deco2800.ducktales.features.entities.agententities;

import uq.deco2800.ducktales.features.entities.EntityManager;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Class which defines the animal 'Cow' that produces milk
 *
 * @author Damian Maher
 */

public class Cow extends Animal {

    private boolean canProduceMilk = false; // Whether the cow can produce milk
    private boolean canProduceBeef = false; // Whether the cow can produce beef
    private Peon opponent; // The peon that the animal will battle.
    private EntityManager opponentList; // List of possible opponents.

    // Cow attributes will be set in the AnimalManagerClass
    public Cow(int x, int y) {
        super(x, y, ResourceType.COW, 1, 1, 1, 1, 0.05);
        int var = (int) (Math.random() * 100);
        setStartingHealth(var);
        setStartingHunger(var);
        setStartingThirst(var);
        setStartingStrength(var);
    }

    /**
     * Checks whether the cow can produce milk. Cows can only produce 
     * milk if their health, hunger, and thirst meet
     * satisfy a certain threshold.
     */
    public void produceMilk() {
        if (this.getHealth() >= 85 && this.getHunger() >= 85 && this.getThirst() >= 85) {
            this.canProduceMilk = true;
        } 
    }
    
    /**
     * Checks whether the cow can produce beef. Cows can only produce beef if 
     * their health, hunger, and thirst meet
     * satisfy a certain threshold.
     */
    public void produceBeef() {
        if (this.getHealth() >= 85 && this.getHunger() >= 85 && this.getThirst() >= 85) {
            this.canProduceBeef = true;
        } 
    }

    // Getter methods below

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
