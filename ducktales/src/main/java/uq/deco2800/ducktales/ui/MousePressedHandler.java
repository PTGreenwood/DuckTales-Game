package uq.deco2800.ducktales.ui;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.ResourceRegister;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Handles Mouse press events.
 * 
 * @author Leggy
 *
 */
public class MousePressedHandler implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent event) {
		int tileX = (int) (event.getX() / ResourceRegister.TILE_WIDTH);
		int tileY = (int) (event.getY() / ResourceRegister.TILE_HEIGHT);
		GameManager.getInstance().setPressed(tileX, tileY);
	}

}
