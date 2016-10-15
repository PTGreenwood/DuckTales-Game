package uq.deco2800.ducktales.features.notifications;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * Manages the Notifications from buildings
 * 
 * @author Dean
 *
 */
public class NotificationManager {
	
	@FXML
	private AnchorPane mainWindow;	
	@FXML
	private Label notificationLabel;
	
	@FXML
	public void buildingFinishedNotification() {
		System.out.println("The building has been constructed");
		//showNotifications();
	}
	
	
	
	public void showNotifications() {
		this.mainWindow.setVisible(true);
	}
	public void hideNotifications() {
		this.mainWindow.setVisible(false);
	}
	
	
}