package uq.deco2800.ducktales.features.notifications;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.helper.HelperManager;

/**
 * 
 * Manages the Notifications from buildings
 * 
 * @author Dean
 *
 */
public class NotificationManager {
	
	private static final NotificationManager INSTANCE = new NotificationManager();	
	
	@FXML
	private AnchorPane mainWindow;	
	@FXML
	private Label notificationLabel;
	
	public static NotificationManager getInstance() {
		return INSTANCE;
	}
	
	@FXML
	public void builtNotification() {
		System.out.println("The building has been constructed");
		//notificationLabel.setText("The building has been constructed");
	}
	
	public void showNotifications() {
		this.mainWindow.setVisible(true);
	}
	public void hideNotifications() {
		this.mainWindow.setVisible(false);
	}
	
	
}