package uq.deco2800.ducktales.ui;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.tiles.TileRegister;
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
		int tileX = (int) (event.getX() / TileRegister.TILE_WIDTH);
		int tileY = (int) (event.getY() / TileRegister.TILE_HEIGHT);
		GameManager.getInstance().setReleased(tileX, tileY);
	}

}
