package uq.deco2800.ducktales.entities.agententities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Point;

/**
 * Handles all animal interactions in the world.
 *
 * @author Josh Benavides
 */
public class AnimalManager {

    // Stores all live animals in the world.
    HashMap<String, List<? extends Animal>> animals = new HashMap<>();
    // Stores all the live Ducks in the world.
    private List<Duck> ducks;
    // Stores all the live Cows in the world.
    private List<Cow> cows;
    // Stores all the live Sheep in the world.
//    private List<Sheep> sheep;
    // The spawn point of the animal.
    private Point spawnPoint;

    /**
     * Creates an instance of the AnimalManager class.
     */
    public AnimalManager() {
        this.ducks = new ArrayList<>();
        this.cows = new ArrayList<>();
//        this.sheep = new ArrayList<>();
        animals.put("duck", ducks);
        animals.put("cows", cows);
//        animals.put("sheep", sheep);

//        this.spawnPoint;
    }

    /**
     * Adds the animal to the AnimalManager.
     */
    public void addAnimal(Animal animal) {
//        if (animal instanceof Duck) {
//            animals.get("duck").add(animal);
//        }
    }

    /**
     * Adds Cows to the AnimalManager.
     */
    public void createCow(Cow cow) {
        cows.add(cow);
    }

    /**
     * Adds Sheep to the AnimalManager.
     */
//    public void createSheep(Sheep sheep) {
//        sheep.add(sheep);
//    }

    /**
     * Spawns the Animals. Animals can only be spawned in
     *
     * @param animal The type of animal to be spawned.
     */
    public void spawnAnimal(Animal animal) {
    }

}
