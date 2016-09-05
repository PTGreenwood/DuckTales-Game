package uq.deco2800.ducktales.entities.agententities;

import uq.deco2800.ducktales.entities.EntityManager;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Defines the turtle animal.
 *
 * @author Wangjia Dong
 */
public class Turtle extends Animal {

    public Turtle(int x, int y) {
        super(x, y, ResourceType.DUCK, 1, 1, 1, 1, 0.05);
        int var = (int) (Math.random() * 100);
        int var2 = (int) (Math.random() * 20);
        setStartingHealth(var);
        setStartingHunger(var);
        setStartingThirst(var);
        setStartingStrength(var2);
    }
}
