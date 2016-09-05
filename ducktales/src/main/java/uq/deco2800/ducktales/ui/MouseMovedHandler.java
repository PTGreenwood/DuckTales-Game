package uq.deco2800.ducktales.ui;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Handles Mouse moved events.
 */
public class MouseMovedHandler implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent event) {
		int tileX = (int) (event.getX() / ResourceSpriteRegister.TILE_WIDTH);
		int tileY = (int) (event.getY() / ResourceSpriteRegister.TILE_HEIGHT);
		GameManager.getInstance().setMoved(tileX, tileY);
	}

}
