package uq.deco2800.ducktales.features.entities.agententities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Point;

/**
 * Defines the Wolf animal, a predator.
 *
 * @author Damian Maher, Josh Benavides
 */
public class Wolf extends Animal {

    private List<Point> goalPoints;

    public Wolf(int x, int y) {
        super(x, y, ResourceType.WOLF, 1, 1, 1, 1, 0.05);
        Random random = new Random();
        int var = random.nextInt(100);
        int var2 = random.nextInt(50);
        setStartingHealth(var);
        setStartingHunger(var);
        setStartingThirst(var);
        setStartingStrength(var2);
        this.goalPoints = new ArrayList<>();
    }
}
