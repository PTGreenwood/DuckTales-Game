package uq.deco2800.ducktales.util.events.handlers.custom;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.landscape.tiles.TileSprite;
import uq.deco2800.ducktales.features.landscape.tiles.TilesManager;
import uq.deco2800.ducktales.rendering.worlddisplay.CursorManager;
import uq.deco2800.ducktales.util.events.tile.TileEnteredEvent;

/**
 * This handler handles the TileEnteredEvent. Current logic:
 *      1. Move the cursor image to the tile, if a resource is being managed
 *
 *      TODO
 *      2. Shows the image as shaded if the entity cannot be added to the
 *          tile hovered on
 *      3. Change the tile display underneath to show how many tiles will
 *          be taken up by that building
 *
 * Created on 8/09/2016.
 * @author khoiphan21
 */
public class TileEnteredHandler implements EventHandler<TileEnteredEvent> {

    /** The main manager of the game */
    private GameManager gameManager;

    /** The secondary managers */
    private TilesManager tilesManager;
    private CursorManager cursorManager;

    public TileEnteredHandler(GameManager gameManager) {
        // Set up the manager handles
        this.gameManager = gameManager;
        this.tilesManager = gameManager.getWorldDisplayManager().getTilesManager();
        this.cursorManager = gameManager.getCursorManager();



    }
    @Override
    public void handle(TileEnteredEvent event) {
        cursorManager.setCursorImageFreeMoving(false);
        moveCursorImageToTile(event.getxPos(), event.getyPos());
    }

    /**
     * Move the cursor image to the given tile, at an appropriate point to
     * show the player where the entity would be added if mouse is clicked
     *
     * @param xPos
     *          The x-coordinate of the tile in the 2D array
     * @param yPos
     *          The y-coordinate of the tile in the 2D array
     */
    private void moveCursorImageToTile(int xPos, int yPos) {
        // Get the view's info
        ImageView cursorImage = cursorManager.getCursorImageSprite();
        TileSprite tileSprite = tilesManager.getTileSprite(xPos, yPos);

        // relocate the origin of the cursor image
        cursorImage.setX(-cursorImage.getFitWidth() / 2);
        cursorImage.setY(-cursorImage.getFitHeight());

        // Re-set the location of the cursor image
        cursorManager.relocateCursorImage(
                tileSprite.getLayoutX() + tileSprite.getFitWidth() / 2,
                tileSprite.getLayoutY() + tileSprite.getFitHeight()
        );
    }
}
