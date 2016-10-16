package uq.deco2800.ducktales.rendering.sprites;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This class represents a sprite of an animal to be rendered onto the world
 *
 * Created on 21/09/2016.
 * @author khoiphan21
 */
public class AnimalSprite extends EntitySprite {

    // Lists of sprites for different types of animations.
    private AnimalAnimation roamingAnimation; // Regular animation when roaming
    private AnimalAnimation deathAnimation; // Death animation
    private boolean resetFactor = true; // Whether to reset the animation back

    /**
     * Creates a sprite for an Animal.
     * @param index
     *         The unique ID of this sprite.
     * @param animalType
     *         The ResourceType of this AnimalSprite.
     */
    public AnimalSprite(int index, ResourceType animalType) {
        super(index, animalType);

        setupAnimation();
    }

    /**
     * Sets up the animation to be played for this AnimalSprite when it is alive and roaming the world.
     * @param frames
     *         The frames of the animation.
     * @param duration
     *         The duration of the animation.
     * @param resetFactor
     *         Whether to set the animation stage back.
     */
    public void setUpRoamingAnimation(List<Image> frames, double duration, boolean resetFactor) {
        this.roamingAnimation = new AnimalAnimation(frames, duration);
        this.resetFactor = resetFactor;
    }

    /**
     * Sets up the animation to be played for this AnimalSprite when it is dead.
     * @param frames
     *         The frames of the animation.
     * @param duration
     *         The duration of the animation.
     */
    public void setUpDeathAnimation(List<Image> frames, double duration) {
        this.deathAnimation = new AnimalAnimation(frames, duration);
    }

    /**
     * Plays the "roaming" animation for the animal.
     */
    public void playRoamingAnimation() {
        double duration = this.roamingAnimation.duration;

        // Re-configure the image list.
        this.setImageList(roamingAnimation.frames);

        // Create a new timeline and with new frames list and interpolator.
        createNewTimeline(duration, Timeline.INDEFINITE);
        this.timeline.setAutoReverse(this.resetFactor);

        timeline.play();
    }

//    /**
//     * Play the animation for the death of an animal.
//     */
//    public void playDeathAnimation() {
//    }

    /**
     * Create a new timeline with the given duration and cycle count
     *
     * This is used during switching of animations
     *
     * @param duration
     *          The duration of the animation
     * @param cycleCount
     *          How many times the animation will be looped
     */
    private void createNewTimeline(double duration, int cycleCount) {
        // Initiate the duration of the animation
        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.seconds(duration);

        // Create the start and end Key Frames
        KeyValue startKeyValue = new KeyValue(this.imageProperty(), null, this.interpolator);
        KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);

        KeyValue endKeyValue = new KeyValue(this.imageProperty(), null, this.interpolator);
        KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

        // Re-initialise the timeline
        this.timeline = new Timeline(startKeyFrame, endKeyFrame);
        timeline.setCycleCount(cycleCount);
    }

    /**
     * Set up the key frames as well as duration for the animation of this animal
     */
    private void setupAnimation() {

    }

    /**
     * Deep-copy a list of images into the given list reference
     *
     * @param source
     *          The source of images
     * @param target
     *          The list to copy all images into
     */
    private void deepCopy(List<Image> source, List<Image> target) {
        for (int i = 0; i < source.size(); i++) {
            target.add(source.get(i));
        }
    }

    /**
     * The class to hold the different information for different types of animations for buildings.
     */

    class AnimalAnimation {
        // Variables required for animation.
        private List<Image> frames;
        private double duration;

        public AnimalAnimation(List<Image> frames, double duration) {
            this.frames = new ArrayList<Image>();
            this.duration = duration;
            deepCopy(frames, this.frames);
        }
    }



}
