package uq.deco2800.ducktales.rendering.sprites;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import uq.deco2800.ducktales.features.entities.Entity;
import uq.deco2800.ducktales.features.landscape.tiles.TileSprite;
import uq.deco2800.ducktales.features.landscape.tiles.TilesManager;
import uq.deco2800.ducktales.rendering.RenderingInformation;
import uq.deco2800.ducktales.rendering.animation.SpriteInterpolator;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a general sprites of the game
 *
 * Created on 21/09/2016.
 * @author khoiphan21
 */
public class Sprite extends ImageView{

    /** The timeline that controls the animation of this sprite */
    protected Timeline timeline;

    /** The list of images to be used for animation */
    protected List<Image> imageList;

    /** The interpolator to decide which images to show for animation */
    protected SpriteInterpolator interpolator;

    /**
     * Instantiate an empty sprite with an empty timeline
     */
    public Sprite() {
        super();

        // Setup the timeline
        this.timeline = new Timeline();
    }

    /**
     * Set the list of images that will be used for this sprite's basic
     * animation
     *
     * @param imageList
     *          The list of images to be shown as animation
     */
    public void setImageList(List<Image> imageList) {
        // Create a new empty list of images
        this.imageList = new ArrayList<Image>();

        // Deep clone the list of images
        for (int i = 0; i < imageList.size(); i++) {
            this.imageList.add(imageList.get(i));
        }

        // Setup the interpolator
        interpolator = new SpriteInterpolator(this.imageList);
    }

    /**
     * Set the duration for the animation, to control how smooth it will play
     *
     * For example, if the list of images has 60 frames, and duration is set to
     * 1 second, the animation will be played at 60 frames per second (60 FPS)
     *
     * The default cycle count is 1, i.e. the animation will not loop at all
     *
     * @param duration
     *          The duration of the whole animation, in seconds
     */
    public void setupAnimation(double duration) {
        // Initiate the duration of the animation
        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.seconds(duration);

        // Create the start and end Key Frames
        KeyValue startKeyValue = new KeyValue(this.imageProperty(), null, this.interpolator);
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyValue endKeyValue = new KeyValue(this.imageProperty(), null, this.interpolator);
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        // Re-initialise the timeline
        timeline = new Timeline(startKeyFrame, endKeyFrame);
        timeline.setCycleCount(1);
    }

    /**
     * Set the number of times the animation will be played
     *
     * @param count
     *          The number of times this animation will be played till stop
     */
    public void setAnimationCycleCount(int count) {
        this.timeline.setCycleCount(count);
    }

    /**
     * Start the current animation of this sprite
     */
    public void startAnimation() {
        this.timeline.play();
    }

    /**
     * Stop animating this sprite
     */
    public void stopAnimation() {
        this.timeline.stop();
    }

    /**
     * Temporarily pause the animation of this sprite
     */
    public void pauseAnimation() {
        this.timeline.pause();
    }

    public void resetInterpolator() {
        this.interpolator = new SpriteInterpolator(this.imageList);
    }

    /**
     * Set up a given agent entity sprite. Tasks currently carried out:
     *      1. Set the sprite's x- and y-locations (regarding world size)
     *      2. Change the size of the sprite based on the main scale factor
     *      3. Adjust the offset of the sprite to the bottom middle
     *      4. set the location of the sprite based on the given tile
     * @param sprite
     *          The sprite to set up
     * @param x
     *          The x-location of the given tile
     * @param y
     *          The y-location of the given tile
     * @param tilesManager
     *          The manager of all the tiles in the game
     */
    public static void setupEntitySprite(EntitySprite sprite,
                                         int x, int y,
                                         TilesManager tilesManager) {
        // IMPORTANT: Setup the x-and y-locations of the sprite
        sprite.setxLocation(x);
        sprite.setyLocation(y);

        // Set the fit width and height of the sprite, based on the given
        // rendering scale
        double mainScale = RenderingInformation.MAIN_SCALE_FACTOR;
        sprite.setFitHeight(sprite.getImage().getHeight() * mainScale);
        sprite.setFitWidth(sprite.getImage().getWidth() * mainScale);

        // Adjust the offset of the sprite, so that it is at the middle of the
        // bottom of the sprite
        sprite.setX(-sprite.getFitWidth() / 2);
        sprite.setY(-sprite.getFitHeight());

        // Get the sprite of the tile at the given location
        TileSprite tileSprite = tilesManager.getTileSprite(x, y);

        // set the location of the entity sprite based on the given tile
        sprite.setLayoutX(tileSprite.getLayoutX() + tileSprite.getFitWidth() / 2);
        sprite.setLayoutY(tileSprite.getLayoutY() + tileSprite.getFitHeight());
    }

    /**
     * Update the location of the sprite of the given entity, based on the stored location
     * of the entity's x- and y- coordinates
     * @param entity
     *          The model of the sprite
     * @param sprite
     *          The sprite whose location is to be updated
     * @param tileSprite
     *          The sprite of the tile where the location will be updated from
     */
    public static void updateSpriteLocation(Entity entity, EntitySprite sprite,
                                            TileSprite tileSprite) {
        final double EPSILON = 0.0001;

        // Now get the coordinates of the center of the tile
        double tileCenterX = tileSprite.getLayoutX() +
                (tileSprite.getLayoutBounds().getWidth() / 2);
        double tileCenterY = tileSprite.getLayoutY() +
                (tileSprite.getLayoutBounds().getHeight() / 2);

        // Calculate the maximum travel distance in the X and Y directions
        double maxDistanceX = tileCenterX - tileSprite.getLayoutX();
        double maxDistanceY = tileCenterY - tileSprite.getLayoutY();

        // Now check for the 4 cases representing the 4 different directions
        // of movement
        if (Math.abs(entity.getX() - sprite.getxLocation()) < EPSILON) {
            // moving in the Y direction
            double difference = Math.abs(entity.getY() - sprite.getyLocation());
            if (entity.getY() < sprite.getyLocation()) {
                // Moving north-west
                sprite.setLayoutX(tileCenterX - difference * maxDistanceX);
                sprite.setLayoutY(tileCenterY - difference * maxDistanceY);
            } else {
                // Moving south-east
                sprite.setLayoutX(tileCenterX + difference * maxDistanceX);
                sprite.setLayoutY(tileCenterY + difference * maxDistanceY);
            }
        } else if (Math.abs(entity.getY() - sprite.getyLocation()) < EPSILON) {
            // moving in the X direction
            double difference = Math.abs(entity.getX() - sprite.getxLocation());
            if (entity.getX() < sprite.getxLocation()) {
                // Moving north-east
                sprite.setLayoutX(tileCenterX + difference * maxDistanceX);
                sprite.setLayoutY(tileCenterY - difference * maxDistanceY);
            } else {
                // Moving south-west
                sprite.setLayoutX(tileCenterX - difference * maxDistanceX);
                sprite.setLayoutY(tileCenterY + difference * maxDistanceY);

            }
        }

        // Update the coordinates of the sprite if it has moved on to a new location
        double xDifference = Math.abs(entity.getX() - sprite.getxLocation());
        double yDifference = Math.abs(entity.getY() - sprite.getyLocation());
        if (xDifference == 0.0) {
            if (yDifference == 1.0) {
                sprite.setyLocation((int) entity.getY());
            }
        } else if (xDifference == 1.0) {
            if (yDifference == 0.0) {
                sprite.setxLocation((int) entity.getX());
            }
        }
    }


}
