package uq.deco2800.ducktales.entities.agententities;

import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Defines the animal Duck that lays eggs.
 *
 * @author Josh Benavides
 */
public class Duck extends Animal {

    private final static ResourceType type = ResourceType.DUCK;
    // Whether the duck can lay eggs.
    private boolean canLayEggs = false;
    // Whether the duck can drop feathers.
    private boolean canDropFeathers = false;
    // Whether the duck is dead.
    private boolean isDead = false;
    // The peon that the animal will battle.
    private Peon opponent;
    // List of possible opponents.
    private EntityManager opponentList;
    // The strength level of the duck.
    private int strength;


    // AnimalDuck attributes will be set in the AnimalManagerClass
    public Duck(int x, int y, int strength) {
        super(x, y, (int) ((Math.random() + 0.1) * 100), (int) ((Math.random() + 0.1) * 100), (int) ((Math.random() +
                0.1) * 100), 0.05, 1, 1, type);
        this.strength = strength;
    }

    /**
     * Checks whether the duck can lay eggs. Ducks can only lay eggs if their health, hunger, and thirst meet satisfy
     * a certain threshold.
     */
    private void layEggs() {
        if (this.getHealth() >= 85 && this.getHunger() >= 85 && this.getThirst() >= 85) {
            this.canLayEggs = true;
        }
    }

    /**
     * Enables the duck to drop feathers.
     */
    private void DropFeathers() {
        if (this.isDead() == true) {
            this.canDropFeathers = true;
        }
    }

    /**
     * Enables the predator to attack
     */
    public void attack() {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
    }

    // Getter methods below.

    /**
     * Returns whether the duck is dead.
     *
     * @return isDead
     */
    public boolean isDead() {

        return this.isDead;
    }

    /**
     * Returns whether the duck can lay eggs.
     *
     * @return canLayEggs
     */
    public boolean canLayEggs() {

        return this.canLayEggs;
    }

    /**
     * Returns weather the duck can drop feathers.
     *
     * @return canDropFeathers
     */
    public boolean canDropFeathers() {
        return canDropFeathers;
    }

    public int getStrength() {
        return strength;
    }
}
