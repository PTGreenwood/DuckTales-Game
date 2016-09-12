package uq.deco2800.ducktales.features.entities.agententities;

import uq.deco2800.ducktales.features.entities.EntityManager;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Defines the turtle animal.
 *
 * @author Wangjia Dong, Damian Maher
 */
public class Turtle extends Animal {
	
    //private boolean canProduceMilk = false; // Whether the cow can produce milk
    //private boolean canProduceBeef = false; // Whether the cow can produce beef
    //private Peon opponent; // The peon that the animal will battle.
    //private EntityManager opponentList; // List of possible opponents.

    public Turtle(int x, int y) {
        super(x, y, ResourceType.TURTLE, 1, 1, 1, 1, 0.05);
        int var = (int) (Math.random() * 100);
        int var2 = (int) (Math.random() * 20);
        setStartingHealth(var);
        setStartingHunger(var);
        setStartingThirst(var);
        setStartingStrength(var2);
    }
}
