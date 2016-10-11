package uq.deco2800.ducktales.features.entities.agententities;

import java.util.Random;

import uq.deco2800.ducktales.features.entities.EntityManager;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Class which defines the animal 'Sheep' that produces milk
 *
 * @author Damian Maher
 */

public class Sheep extends Animal {

    private boolean canProduceWool = false; // Whether the sheep can produce wool
    private boolean canProduceMutton = false; // Whether the sheep can produce mutton
    private Peon opponent; // The peon that the animal will battle.
    private EntityManager opponentList; // List of possible opponents.

    // Sheep attributes will be set in the AnimalManagerClass
    public Sheep(int x, int y) {
        super(x, y, ResourceType.SHEEP, 1, 1, 1, 1, 0.01);
        Random random = new Random();
        int var = random.nextInt(100);
        setStartingHealth(var);
        setStartingHunger(var);
        setStartingThirst(var);
        setStartingStrength(var);
    }

    /**
     * Checks whether the sheep can produce wool. Sheep can only produce wool if 
     * their health, hunger, and thirst meet
     * satisfy a certain threshold.
     */
    public void produceWool() {
        if (this.getHealth() >= 85 && this.getHunger() >= 85 && this.getThirst() >= 85) {
            this.canProduceWool = true;
        }
    }
    
    /**
     * Checks whether the sheep can produce mutton. Sheep can only produce mutton if 
     * their health, hunger, and thirst meet
     * satisfy a certain threshold.
     */
    public void produceMutton() {
        if (this.isDead() == true) {
            this.canProduceMutton = true;
        }
    }

    // Getter methods below

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
