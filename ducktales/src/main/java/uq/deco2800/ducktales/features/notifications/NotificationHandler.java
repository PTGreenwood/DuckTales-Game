package uq.deco2800.ducktales.features.notifications;

import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.util.events.handlers.GameEventHandler;

/**
 * 
 * Handles the Notifications from buildings
 * 
 * @author Dean
 *
 */
public class NotificationHandler extends GameEventHandler {
	
	
	
	public NotificationHandler(GameManager gameManager) {
		super(gameManager);
	}

	public void handleNotification() {
		System.out.println("The building has been constructed");
		gameManager.getNotificationManager().showNotifications();
	}
}