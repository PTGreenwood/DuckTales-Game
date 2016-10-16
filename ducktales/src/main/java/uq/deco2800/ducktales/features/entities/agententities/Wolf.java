package uq.deco2800.ducktales.features.entities.agententities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uq.deco2800.ducktales.features.entities.MainEntityManager;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Point;

/**
 * Defines the Wolf animal, a predator.
 *
 * @author Damian Maher, Josh Benavides
 */
public class Wolf extends Animal {

    private Peon opponent; // The peon that the Wolf will attack.
    private Animal opponent2; // The domestic animals that the Wolf will attack
    private MainEntityManager opponentList; // List of possible agentEntity opponents.
    private String direction; // The direction that the animal is travelling.
    private List<Point> goalPoints;
    private MainEntityManager mainEntityManager = MainEntityManager.getInstance();
    // The variables below are used to alternate images for animation.
    private int animationStage; // Determines which of the two images per direction is rendered.
    private int currentAnimationTick;
    private int animationSpeed;

    private List<AgentEntity> opponents;

    public Wolf(int x, int y) {
        super(x, y, ResourceType.WOLF, 1, 1, 1, 1, 0.05);
        Random random = new Random();
        Random random2 = new Random();
        int var = random.nextInt(100);
        int var2 = random2.nextInt(50);
        setStartingHealth(var);
        setStartingHunger(var);
        setStartingThirst(var);
        setStartingStrength(var2);
        this.goalPoints = new ArrayList<Point>();
        this.animationStage = 0;
        this.currentAnimationTick = 0;
        this.animationSpeed = 1;
    }


//    public AgentEntity findTarget(){
//
//    }

    @Override
    public void tick() {
        if (goalPoints.isEmpty()) {
            goalPoints = super.newGoalPoints();
        } else if (point.distance(goalPoints.get(0)) < speed) {
            point = goalPoints.remove(0);
            if (goalPoints.isEmpty()) {
                this.goalPoints = super.newGoalPoints();
            }
        } else {
            String newDir = null;
            if (goalPoints.get(0).getX() > point.getX()) {
                newDir = "Left";
            }
            if (goalPoints.get(0).getX() < point.getX()) {
                newDir = "Right";
            }
            if (goalPoints.get(0).getY() > point.getY()) {
                newDir = "Down";
            }
            if (goalPoints.get(0).getY() < point.getY()) {
                newDir = "Up";
            }
            setDirection(newDir);
            updateType(ResourceType.valueOf(getSprite()));
            point.moveToward(goalPoints.get(0), getSpeed());
        }
        calculateRenderingOrderValues();
    }
}
