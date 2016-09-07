package uq.deco2800.ducktales.ui;

import uq.deco2800.ducktales.OldGameManager;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Handles Mouse release events.
 * 
 * @author Leggy
 *
 */
public class MouseReleasedHandler implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent event) {
		int tileX = (int) (event.getX() / ResourceSpriteRegister.TILE_WIDTH);
		int tileY = (int) (event.getY() / ResourceSpriteRegister.TILE_HEIGHT);
		OldGameManager.getInstance().setReleased(tileX, tileY);
	}

}
