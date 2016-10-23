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

    /** 
     * Constructor for the cow animal, creates a new wolf at the specified
     * location
     * 
     * @param x, the x location of the wolf
     * @param y, the y location of the wolf
     */
    public Wolf(int x, int y) {
        super(x, y, ResourceType.WOLF, 1, 1, 1, 1, 0.05);
        int var = 20 + (int)(Math.random() * ((100 - 20) + 1));
        int var2 = 0 + (int)(Math.random() * ((50 - 0) + 1));
        setStartingHealth(var);
        setStartingHunger(var2);
        setStartingThirst(var2);
        setStartingStrength(var2);
        this.goalPoints = new ArrayList<>();
    }
}
