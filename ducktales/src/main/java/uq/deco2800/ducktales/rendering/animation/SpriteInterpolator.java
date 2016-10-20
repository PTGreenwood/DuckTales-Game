package uq.deco2800.ducktales.rendering.animation;

import javafx.animation.Interpolator;
import javafx.scene.image.Image;

import java.util.List;

/**
 * This class represents a basic interpolator that each sprite will utilize to
 * control its own animation
 *
 * Created on 21/09/2016.
 * @author khoiphan21
 */
public class SpriteInterpolator extends Interpolator {

    /** The list of sprites that this interpolator will return at each point
     * of the Timeline
     */
    private List<Image> spritesList;

    /**
     * Create an interpolator for the list of sprite images given
     *
     * @param spritesList
     *          The list of images representing different frames of a sprite
     */
    public SpriteInterpolator(List<Image> spritesList) {
        this.spritesList = spritesList;
    }

    /**
     * This method will be repeatedly called by Timeline, during an animation
     * period, to determine which image is shown for a certain sprite.
     *
     * Current implementation: based on how long the list of images are,
     * each image will be given an equal amount of time through out the
     * animation
     *
     * @param startValue
     *          This is a value passed in via KeyValue for the start state
     * @param endValue
     *          This is a value passed in via KeyValue for the expected end
     *          state
     * @param fraction
     *          The progress of the animation - range between 0.0 and 1.0
     * @return
     */
    @Override
    public Object interpolate(Object startValue, Object endValue, double fraction) {
        // Determine the index of the frame to be returned
        int index = 0;
        // Based on the current 'progress' of the animation, calculate the
        // appropriate index
        int listSize = spritesList.size();
        index = (int) (listSize * fraction);

        // Make sure the index does not go out of bounds when fraction == 1.0
        if (index == listSize) {
            index -= 1;
        }

        // Return the right frame
        //System.out.println(spritesList.get(0).toString());
        //System.out.println(index);
        return spritesList.get(index);
    }

    /**
     * NOTE: This method is not really necessary, as it is only used in very
     * complicated animation instances
     * @param t
     *      A variable representing the time of the animation
     * @return
     */
    @Override
    protected double curve(double t) {
        return 0;
    }
}
