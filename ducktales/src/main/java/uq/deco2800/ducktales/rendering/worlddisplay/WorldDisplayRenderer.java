package uq.deco2800.ducktales.rendering.worlddisplay;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.features.entities.MainEntityManager;
import uq.deco2800.ducktales.features.landscape.tiles.TilesManager;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

/**
 * The rendering engine for the world display. Currently handle:
 *      1. Moving the visible world around
 *
 * Created on 8/09/2016.
 * @author khoiphan21
 */
public class WorldDisplayRenderer extends AnimationTimer {
    /** Variable to control how fast the world moves */
    private int panSpeed = 20;


    /** Variables to control movement of the world objects */
    public enum VDirection {
        UP, DOWN, NONE
    }
    public enum HDirection {
        LEFT, RIGHT, NONE
    }
    private HDirection hDirection = HDirection.NONE; // control horizontal movement
    private VDirection vDirection = VDirection.NONE; // control vertical movement

    /** The secondary managers of the game */
    private TilesManager tilesManager;
    private MainEntityManager mainEntityManager;

    @Override
    public void handle(long now) {
        // First check if the tiles manager has been instantiated
        if (tilesManager != null && mainEntityManager != null &&
                (hDirection != HDirection.NONE || vDirection != VDirection.NONE)) {
            moveWorld();
        }
    }

    /**
     * Pass the handle of the tiles manager
     *
     * @param tilesManager
     *          The tiles manager of the world
     */
    public void setTilesManager(TilesManager tilesManager) {
        this.tilesManager = tilesManager;
    }

    /**
     * Pass the handle of the entity manager to this renderer
     *
     * @param mainEntityManager
     *          The entity manager of the game
     */
    public void setMainEntityManager(MainEntityManager mainEntityManager) {
        this.mainEntityManager = mainEntityManager;
    }

    /**
     * Return the speed at which the world should be moved
     *
     * @return The panning speed of the world pane
     */
    public int getPanSpeed() {
        return panSpeed;
    }

    /**
     * Set the horizontal movement direction
     *
     * @param direction
     */
    public void setMovingDirectionH(HDirection direction) {
        this.hDirection = direction;
    }

    public void setMovingDirectionV(VDirection direction) {
        this.vDirection = direction;
    }

    /**
     * Move the world in the stored directions by the given amount
     */
    private void moveWorld() {
        // Move all the tiles first
        int xAmount = getXMovementAmount();
        int yAmount = getYMovementAmount();

        // temporary variables
        ImageView sprite;

        // move all the tiles
        for (int x = 0; x < tilesManager.getWorldWidth(); x++ ) {
            for (int y = 0; y < tilesManager.getWorldHeight(); y++) {
                sprite = tilesManager.getTileSprite(x, y);
                if (sprite != null) {
                    // Move the sprite in the given direction
                    sprite.setLayoutX(sprite.getLayoutX() + xAmount);
                    sprite.setLayoutY(sprite.getLayoutY() + yAmount);
                } else {
                    throw new GameSetupException("Failed to move world. TileSprite not " +
                            "yet initiated");
                }
            }
        }

        // move all the entities
        mainEntityManager.moveAllEntities(xAmount, yAmount);

    }

    /**
     * Get the amount the world need to move in the x-direction, based on the
     * currently stored values of vDirection and hDirection
     *
     * @return The amount to move the world in the x-direction by
     */
    public int getXMovementAmount() {
        if (hDirection == HDirection.LEFT) {
            return -panSpeed;
        } else if (hDirection == HDirection.RIGHT) {
            return panSpeed;
        } else {
            return 0;
        }
    }

    /**
     * Get the amount the world need to move in the y-direction, based on the
     * currently stored values of vDirection and hDirection
     *
     * @return The amount to move the world in the y-direction by
     */
    public int getYMovementAmount() {
        if (vDirection == VDirection.UP) {
            return -panSpeed;
        } else if (vDirection == VDirection.DOWN) {
            return panSpeed;
        } else {
            return 0;
        }
    }
}

