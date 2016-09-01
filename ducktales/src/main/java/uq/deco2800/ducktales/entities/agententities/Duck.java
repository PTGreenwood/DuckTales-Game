package uq.deco2800.ducktales.entities.agententities;

import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.resources.ResourceType;

import static uq.deco2800.ducktales.resources.ResourceType.DUCK;

/**
 * Defines the duck animal.
 *
 * @author Josh Benavides
 */
public class Duck extends Animal {

    private boolean canLayEggs = false; // Whether the duck can lay eggs.
    private boolean canDropFeathers = false; // Whether the duck can drop feathers.
    private Peon opponent; // The peon that the animal will battle.
    private EntityManager opponentList; // List of possible opponents.

    public Duck(int x, int y) {
        super(x, y, DUCK, 1, 1, 1, 1, 0.01);
        int var = (int) (Math.random() * 100);
        int var2 = (int) (Math.random() * 20);
        setStartingHealth(var);
        setStartingHunger(var);
        setStartingThirst(var);
        setStartingStrength(var2);
    }

//    @Override
//    public void tick() {
//        if (currentLocation.equals(nextLocation)) {
//            newNextLocation();
//        } else {
//            // maybe make it stand still for a sec
//            moveTo(nextLocation);
//        }
//    }

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

    // Getter methods below.

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
