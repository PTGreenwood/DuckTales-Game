package uq.deco2800.ducktales.entities.agententities;

import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Class which defines the animal 'Cow' that produces milk
 *
 * @author Damian Maher'
 */

public class Cow extends Animal {

    private boolean canProduceMilk = false; // Whether the cow can produce milk
    private boolean isDead = false; // Whether the cow is dead.
    private Peon opponent; // The peon that the animal will battle.
    private EntityManager opponentList; // List of possible opponents.

    // Cow attributes will be set in the AnimalManagerClass
    public Cow(int x, int y) {
        super(x, y, 1, 1, ResourceType.COW, 1, 1, 1, 1, 0.05);
        setStartingHealth((int) (Math.random() * 100));
        setStartingHunger((int) (Math.random() * 100));
        setStartingThirst((int) (Math.random() * 100));
        setStartingStrength((int) (Math.random() * 20));
    }

    /**
     * Checks whether the cow can produce milk. Cows can only produce milk if their health, hunger, and thirst meet
     * satisfy a certain threshold.
     */
    private void produceMilk() {
        if (this.getHealth() >= 85 && this.getHunger() >= 85 && this.getThirst() >= 85) {
            this.canProduceMilk = true;
        }
    }

    /**
     * Enables the cow to attack
     */
    public void attack(Peon opponent) {
    	opponent.setHealth(opponent.getHealth() - this.getStrength());
    }
    
    public void setIsDead() {
        if (this.getHealth() == 0) {
            this.isDead = true;
        }
    }

    // getter methods below

    /**
     * Returns whether the cow is dead.
     *
     * @return isDead;
     */
    public boolean isDead() {
        return this.isDead;
    }

    /**
     * Returns whether the cow can produce milk.
     *
     * @return canProduceMilk
     */
    public boolean canProduceMilk() {
        return this.canProduceMilk;
    }
}
