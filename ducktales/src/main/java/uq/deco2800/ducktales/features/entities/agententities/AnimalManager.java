package uq.deco2800.ducktales.features.entities.agententities;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.landscape.tiles.TileSprite;
import uq.deco2800.ducktales.rendering.sprites.AnimalSprite;
import uq.deco2800.ducktales.rendering.sprites.Sprite;
import uq.deco2800.ducktales.rendering.sprites.SpritesFactory;
import uq.deco2800.ducktales.resources.ResourceInfoRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.util.exceptions.AnimalNotRegisteredException;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will handle adding animals and their sprites, as well as updating
 * and managing them during gameplay
 *
 * Created on 12/10/2016.
 * @author khoiphan21
 */
public class AnimalManager extends SecondaryManager{

    /** The list of animal sprites */
    private List<AnimalSprite> animalSprites;
    
    /**
     * Construct an animal manager with an empty list of animal sprites
     * @param gameManager
     */
    public AnimalManager(GameManager gameManager) {
        this.gameManager = gameManager;
        animalSprites = new ArrayList<>();
    }

    /**
     * Add an animal to the given location in the game. This method also
     * instantiates a sprite for that animal, based on its type and render
     * that sprite onto the game
     *
     * @param type
     *          The type of animal to be added
     * @param x
     *          The x-coordinate of the animal in regards to the world size
     * @param y
     *          The y-coordinate of the animal in regards to the world size
     */
    public void addAnimal(ResourceType type, int x, int y) {
        // Construct a new animal from the given type
        Animal animal = ResourceInfoRegister.createAnimal(type, x, y);

        // check if the animal has been registered
        if (animal != null) {
            if (this.gameManager != null){
                animal.setGameManager(this.gameManager);
            } else {
                throw new GameSetupException("An animal class does not have" +
                        "a reference of Game Manager yet");
            }

            // Add that animal to the animals list
            world.addAnimal(animal);

            // Add the sprite of the animal to the sprites list, and set
            // the position of that sprite
            AnimalSprite sprite = SpritesFactory.createAnimalSprite(
                    animalSprites.size(), type, this.gameManager
            );
            if (sprite == null) {
                throw new GameSetupException("Sprite of type " + type +
                        " is not yet registered in SpritesFactory");
            }

            // Setup the sprite
            Sprite.setupEntitySprite(sprite, x, y,
                    gameManager.getWorldDisplayManager().getTilesManager());

            // Add the sprite to the array list
            animalSprites.add(sprite);

            // Add the sprite to the world display
            gameManager.getWorldDisplayManager().getWorldDisplay()
                    .getChildren().add(sprite);

        } else {
            throw new AnimalNotRegisteredException("The animal requested" +
                    " is not yet registered in ResourceInfoRegister");
        }
    }

    /**
     * Update the location of the sprites based on the location values stored in the model
     */
    public void updateSpriteLocations() {
        Animal animal;
        AnimalSprite animalSprite;
        TileSprite tileSprite;
        if (gameManager != null) {
            for (int i = 0; i < animalSprites.size(); i++) {
                animal = world.getAnimal(i);
                animalSprite = animalSprites.get(i);
                tileSprite = gameManager.getWorldDisplayManager()
                        .getTilesManager().getTileSprite(
                                animalSprite.getXLocation(), animalSprite.getYLocation()
                        );

                // Update the location of the sprites
                Sprite.updateSpriteLocation(animal, animalSprite, tileSprite);

            }
        }
    }

    /**
     * Move all the animal sprites by the given x- and y-amount
     *
     * @param xAmount
     *          The amount to move in x-direction
     * @param yAmount
     *          The amount to move in y-direction
     */
    public void moveAllAnimalsSprites(double xAmount, double yAmount) {
        for (AnimalSprite sprite : animalSprites) {
            if (sprite != null) {
                sprite.setLayoutX(sprite.getLayoutX() + xAmount);
                sprite.setLayoutY(sprite.getLayoutY() + yAmount);
            } else {
                throw new RuntimeException("A sprite is not yet " +
                        "instantiated");
            }
        }
    }
}
