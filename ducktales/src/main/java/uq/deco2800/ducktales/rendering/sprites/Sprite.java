package uq.deco2800.ducktales.rendering.sprites;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

    /**
     * Instantiate an empty sprite with an empty timeline
     */
    public Sprite() {
        super();
        this.timeline = new Timeline();
    }

    /**
     * Set the list of
     * @param imageList
     */
    public void setImageList(List<Image> imageList) {
        // Create a new empty list of images
        this.imageList = new ArrayList<Image>();

        // Deep clone the list of images
        for (int i = 0; i < imageList.size(); i++) {
            this.imageList.add(imageList.get(i));
        }
    }

    /**
     * Start the animation of this sprite when it is idle
     */
    public void startIdleAnimation() {
        this.timeline.play();
    }

    /**
     * Stop animating this sprite temporarily
     */
    public void stopAnimation() {
        this.timeline.stop();
    }
}
