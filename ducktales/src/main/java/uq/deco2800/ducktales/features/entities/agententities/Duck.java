package uq.deco2800.ducktales.features.entities.agententities;


import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Defines the duck animal.
 *
 * @author Josh Benavides
 */
public class Duck extends Animal {

	/** variables which check whether the duck can produce eggs and feathers */
    private boolean canLayEggs = false; 
    private boolean canDropFeathers = false;

    /** 
     * Constructor for the duck animal, creates a new duck at the specified
     * location
     * 
     * @param x, the x location of the duck
     * @param y, the y location of the duck
     */
    public Duck(int x, int y) {
        super(x, y, ResourceType.DUCK, 1, 1, 1, 1, 0.05);
        int var = 20 + (int)(Math.random() * ((100 - 20) + 1));
        int var2 = 0 + (int)(Math.random() * ((50 - 0) + 1));
        setStartingHealth(var);
        setStartingHunger(var2);
        setStartingThirst(var2);
        setStartingStrength(var2);
    }


    /**
     * Enables the duck to lay eggs. Ducks can only lay eggs if 
     * their health, hunger, and thirst meet satisfy
     * a certain threshold.
     */
    public void layEggs() {
        if (this.getHealth() >= 85 && this.getHunger() >= 85 && 
        	this.getThirst() >= 85) {
            this.canLayEggs = true;
        }
    }

    /**
     * Enables the duck to drop feathers. Ducks can only drop feathers 
     * when they are dead.
     */
    public void dropFeathers() {
        if (this.isDead()) {
            this.canDropFeathers = true;
        }
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
