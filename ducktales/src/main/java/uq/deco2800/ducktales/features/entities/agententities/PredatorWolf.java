package uq.deco2800.ducktales.features.entities.agententities;

import uq.deco2800.ducktales.features.entities.EntityManager;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Defines the Wolf animal, a predator.
 *
 * @author Damian Maher
 */
public class PredatorWolf extends Animal {

    private Peon opponent; // The peon that the PredatorWolf will attack.
    private Animal opponent2; // The domestic animals that the PredatorWolf will attack
    private EntityManager opponentList; // List of possible opponents.

    public PredatorWolf(int x, int y) {
        super(x, y, ResourceType.WOLF, 1, 1, 1, 1, 0.05);
        int var = (int) (Math.random() * 100);
        int var2 = (int) (Math.random() * 20);
        setStartingHealth(var);
        setStartingHunger(var);
        setStartingThirst(var);
        setStartingStrength(var2);
    }
    
}
