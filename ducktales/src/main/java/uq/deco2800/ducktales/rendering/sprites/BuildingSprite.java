package uq.deco2800.ducktales.rendering.sprites;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.util.Duration;
import uq.deco2800.ducktales.features.time.TimeManager;
import uq.deco2800.ducktales.rendering.animation.SpriteInterpolator;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Tickable;

import java.util.ArrayList;
import java.util.List;

/**
 * A building to be rendered into the game world, where other entities can interact
 * with. This building class will hold its own rendering information, since it is
 * a sub-class of ImageView
 *
 * Created on 2/10/2016.
 *
 * @author khoiphan21
 */
public class BuildingSprite extends EntitySprite {
    /** The sprites list for different types of animations */
    private BuildingAnimation constructionAnimation; // animation during construction
    private List<Image> idleAnimationDayFrames; // when construction is done
    private List<Image> idleAnimationNightFrames; // when construction is done
    private BuildingAnimation idleAnimation; // playing animations
    private double duration; // idle animation duration
    private ResourceType buildingType;

    private TimeManager gameTime = new TimeManager();
    
    /** Flags */
    // Whether to automatically reverse the idle animation
    private boolean autoReverse = true;

    /**
     * Create a sprite for a building
     *
     * @param index
     *          The unique ID of this sprite
     * @param buildingType
     *          The type of this building sprite
     */
    public BuildingSprite(int index, ResourceType buildingType) {
        super(index, buildingType);
        //this.buildingType = buildingType;
    }

    /**
     * Set up the animation to be played for this building when it's under
     * construction
     *
     * @param frames
     *          The frames of the animation
     * @param duration
     *          The duration of the animation
     */
    public void setupConstructionAnimation(List<Image> frames, double duration) {
        this.constructionAnimation = new BuildingAnimation(frames, duration);
    }

    /**
     * Set up the idle animation that will be looped forever for this building
     *
     * @param frames
     *          The frames of the animation
     * @param duration
     *          The duration of the animation
     */
    public void setupIdleAnimation(List<Image> frames,  
    		double duration, boolean autoReverse) {
        this.idleAnimation = new BuildingAnimation(frames, duration);
        //this.idleAnimationDayFrames = framesSwap;
        this.idleAnimationNightFrames = frames;
        this.duration = duration;
        this.autoReverse = autoReverse;
    }

    /**
     * Play the animation for the construction of the building
     */
    public void playConstructionAnimation() {
        double duration = this.constructionAnimation.duration;

        // Re-configure the image list and then the interpolator
        this.setImageList(constructionAnimation.frames);

        // Create a new timeline with the new list of frames and interpolator
        createNewTimeline(duration, 1);

        // Set the timeline to switch to the idle animation when it's done
        timeline.setOnFinished(event -> this.playIdleAnimation());

        timeline.play();
    }

    /**
     * Play the animation for the idle state of the building
     */
    public void playIdleAnimation() {
        double duration = this.idleAnimation.duration;

        // Re-configure the image list and then the interpolator
        this.setImageList(idleAnimation.frames);

        // Create a new timeline with the new list of frames and interpolator
        createNewTimeline(duration, Timeline.INDEFINITE);
        this.timeline.setAutoReverse(this.autoReverse);

        timeline.play();
    }

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
     * The class to hold the information for different type of animations for
     * buildings
     */
    class BuildingAnimation {
        /** Information needed for an animation */
        private List<Image> frames;
        private double duration;

        /**
         * Create an object containing animation information
         *
         * @param frames
         *          The list of frames for this animation
         * @param duration
         *          The duration of this animation (in seconds)
         */
        public BuildingAnimation(List<Image> frames, double duration) {
            // Initiate the private variables
            this.duration = duration;
            this.frames = new ArrayList<Image>();

            deepCopy(frames, this.frames);
        }
    }
    
    public void swap(int newAnimation) {
    	if (newAnimation == 0) {
    		System.err.println("dfksdhfskjdfhksjd");
    	} else {
    		setupIdleAnimation(SpritesImages.schoolDay(), 9, true);
    		interpolator = new SpriteInterpolator(SpritesImages.schoolDay());
    	}
    }

	
	public void nightAnimation() {
		
		System.out.println("sdfsafdasfdsdfsadffasdf");
		this.stopAnimation();
		
		setupIdleAnimation(SpritesImages.schoolNight(), 3, true);
		interpolator = new SpriteInterpolator(SpritesImages.schoolNight());
		playIdleAnimation();
		
	}
}
