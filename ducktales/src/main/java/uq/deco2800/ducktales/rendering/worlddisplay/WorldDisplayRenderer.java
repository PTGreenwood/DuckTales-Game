package uq.deco2800.ducktales.rendering.worlddisplay;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.features.landscape.tiles.TilesManager;

/**
 * Created by Khoi on 8/09/2016.
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
    HDirection hDirection = HDirection.NONE; // control horizontal movement
    VDirection vDirection = VDirection.NONE; // control vertical movement

    /** The secondary managers of the game */
    private TilesManager tilesManager;

    @Override
    public void handle(long now) {
        // First check if the tiles manager has been instantiated
        if (tilesManager != null) {
            // Check if the world should be moved around
            if (hDirection != HDirection.NONE || vDirection != VDirection.NONE) {
                moveWorld();
            }
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
                    System.err.println("Failed to move world. TileSprite not " +
                            "yet initiated");
                }
            }
        }
    }

    /**
     * Get the amount the world need to move in the x-direction, based on the
     * currently stored values of vDirection and hDirection
     *
     * @return The amount to move the world in the x-direction by
     */
    private int getXMovementAmount() {
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
    private int getYMovementAmount() {
        if (vDirection == VDirection.UP) {
            return -panSpeed;
        } else if (vDirection == VDirection.DOWN) {
            return panSpeed;
        } else {
            return 0;
        }
    }
}

