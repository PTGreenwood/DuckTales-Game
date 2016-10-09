package uq.deco2800.ducktales.rendering.sprites;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
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

}
