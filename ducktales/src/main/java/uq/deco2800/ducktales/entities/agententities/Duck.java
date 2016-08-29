package uq.deco2800.ducktales.entities.agententities;

import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Defines the duck animal.
 *
 * @author Josh Benavides
 */
public class Duck extends Animal {

    private final static ResourceType type = ResourceType.DUCK;
    private final static int health = (int) ((Math.random() + 0.1) * 100);
    private final static int hunger = (int) ((Math.random() + 0.1) * 100);
    private final static int thirst = (int) ((Math.random() + 0.1) * 100);
    private final static int strength = (int) ((Math.random() + 0.1) * 20);
    private final static double speed = 0.05;

    private boolean canLayEggs = false; // Whether the duck can lay eggs.
    private boolean canDropFeathers = false; // Whether the duck can drop feathers.
    private boolean isDead = false; // Whether the duck is dead.
    private Peon opponent; // The peon that the animal will battle.
    private EntityManager opponentList; // List of possible opponents.

    public Duck(int x, int y) {
        super(x, y, 1, 1, type, health, hunger, thirst, strength, speed);
    }

    /**
     * Checks whether the duck can lay eggs. Ducks can only lay eggs if their health, hunger, and thirst meet satisfy
     * a certain threshold.
     */
    public void layEggs() {
        if (this.getHealth() >= 85 && this.getHunger() >= 85 && this.getThirst() >= 85) {
            this.canLayEggs = true;
        }
    }

    /**
     * Enables the duck to drop feathers.
     */
    public void DropFeathers() {
        if (this.isDead() == true) {
            this.canDropFeathers = true;
        }
    }

    /**
     * Tells the animal to attack.
     */
    public void attack(Peon opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
    }

    public void setIsDead() {
        if (this.getHealth() == 0) {
            this.isDead = true;
        }
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
}
