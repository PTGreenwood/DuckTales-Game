package uq.deco2800.ducktales.entities.agententities;

import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Class which defines the animal 'Cow' that produces milk
 *
 * @author Damian Maher'
 */

public class Cow extends Animal {

    // Define the resource type of Cow
    private final static ResourceType type = ResourceType.COW;
    private final static int health = (int) ((Math.random() + 0.1) * 100);
    private final static int hunger = (int) ((Math.random() + 0.1) * 100);
    private final static int thirst = (int) ((Math.random() + 0.1) * 100);
    private final static int strength = (int) ((Math.random() + 0.1) * 20);
    private final static double speed = 0.05;

    // Whether the cow can produce milk
    private boolean canProduceMilk = false;
    // Whether the cow is dead.
    private boolean isDead = false;
    // The peon that the animal will battle.
    private Peon opponent;
    // List of possible opponents.
    private EntityManager opponentList;

    // Cow attributes will be set in the AnimalManagerClass
    public Cow(int x, int y) {
        super(x, y, 1, 1, type, health, hunger, thirst, strength, speed);
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
    public void attack() {

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
