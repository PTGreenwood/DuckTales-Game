package uq.deco2800.ducktales.features.entities.agententities;

import java.util.Random;

import uq.deco2800.ducktales.features.entities.MainEntityManager;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Defines the duck animal.
 *
 * @author Josh Benavides
 */
public class Duck extends Animal {

    private boolean canLayEggs = false; // Whether the duck can lay eggs.
    private boolean canDropFeathers = false; // Whether the duck can drop feathers.

    /*
    Whether the duck can drop resources. This is only temporary while other resources are yet to be developed. The
    resource will only be dropped when the animal is dead.
     */
    private boolean canDropResource = false;

    private Peon opponent; // The peon that the animal will battle.
    private MainEntityManager opponentList; // List of possible opponents.

    public Duck(int x, int y) {
        super(x, y, ResourceType.DUCK, 1, 1, 1, 1, 0.05);
        
        Random random = new Random();
        Random random2 = new Random();
        int var = random.nextInt(100);
        int var2 = random2.nextInt(20);
        setStartingHealth(var);
        setStartingHunger(var);
        setStartingThirst(var);
        setStartingStrength(var2);
    }


    /**
     * Enables the duck to lay eggs. Ducks can only lay eggs if their health, hunger, and thirst meet satisfy
     * a certain threshold.
     */
    public void layEggs() {
        if (this.getHealth() >= 85 && this.getHunger() >= 85 && this.getThirst() >= 85) {
            this.canLayEggs = true;
        }
    }

    /**
     * Enables the duck to drop feathers. Ducks can only drop feathers when they are dead.
     */
    public void dropFeathers() {
        if (this.isDead()) {
            this.canDropFeathers = true;
        }
    }

    /**
     * Enables the duck to drop resources. Ducks can only drop resources when they are dead.
     * Note that this is only a temporary method.
     */
    public void dropResource() {
        if (this.isDead()) {
            this.canDropResource = true;
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

    /**
     * Returns whether the duck can drop a resource. This is only temporary as other resources have not yet been
     * implemented.
     *
     * @return canDropResource
     */
    public boolean canDropResource() {
        return canDropResource;
    }
}
