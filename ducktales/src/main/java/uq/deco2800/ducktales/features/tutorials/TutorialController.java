package uq.deco2800.ducktales.features.tutorials;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

/**
 * Manage all fxml action of main tutorial window
 * 
 * @author Naehyung Kim
 *
 */
public class TutorialController {	
	
	/** Main window */
	@FXML
	private AnchorPane tutorialWindow;
	
	/** Right Pane of the window */
	@FXML
	private AnchorPane rightPane;
	@FXML
	private AnchorPane anchorTutorial1;	
	
	private AnchorPane tutorial1Main;
	private AnchorPane tutorial2Main;
	private AnchorPane tutorial3Main;
	
	private BorderPane tutorial1;
	private BorderPane tutorial2;
	private BorderPane tutorial3;
	
	/** Buttons on left Pane */
	@FXML
	private Button basicInter;
	@FXML
	private Button buildings;
	@FXML
	private Button marketPlace;	
	
	private void createTutorial(BorderPane borderPane, AnchorPane tutorialMain, String mainTutorilAddress, String subTutorialAddress) throws Exception {
		
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3);
		URL location = getClass().getResource(mainTutorilAddress);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		borderPane = loader.load();
		
		URL locationMain = getClass().getResource(subTutorialAddress);
		FXMLLoader loaderMain = new FXMLLoader();
		loaderMain.setLocation(locationMain);		
		tutorialMain = loaderMain.load();	
		
		borderPane.setPrefHeight(rightPane.getHeight());
		borderPane.setPrefWidth(rightPane.getWidth());
		borderPane.setCenter(tutorialMain);
		
		rightPane.getChildren().add(borderPane);	
	}
	
	/**
	 * Start tutorial1
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void startTutorial1(ActionEvent event) throws Exception {
		
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3);
		URL location = getClass().getResource("/tutorials/tutorial1.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial1 = loader.load();
		
		URL locationBasicInterfaceMain = getClass().getResource("/tutorials/tutorial1Pane0.fxml");
		FXMLLoader loaderBasicInterfaceMain = new FXMLLoader();
		loaderBasicInterfaceMain.setLocation(locationBasicInterfaceMain);		
		tutorial1Main = loaderBasicInterfaceMain.load();	
		
		tutorial1.setPrefHeight(rightPane.getHeight());
		tutorial1.setPrefWidth(rightPane.getWidth());
		tutorial1.setCenter(tutorial1Main);
		
		rightPane.getChildren().add(tutorial1);
	}
	
	/**
	 * Start tutorial2
	 * 	
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void startTutorial2(ActionEvent event) throws Exception {
		
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3);
		URL location = getClass().getResource("/tutorials/tutorial2.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial2 = loader.load();
		
		URL locationBuildingMain = getClass().getResource("/tutorials/tutorial2Pane0.fxml");
		FXMLLoader loaderBuildingMain = new FXMLLoader();
		loaderBuildingMain.setLocation(locationBuildingMain);		
		tutorial2Main = loaderBuildingMain.load();			
		
		tutorial2.setPrefHeight(rightPane.getHeight());
		tutorial2.setPrefWidth(rightPane.getWidth());
		tutorial2.setCenter(tutorial2Main);
		
		rightPane.getChildren().add(tutorial2);
	}
	
	/**
	 * Start tutorial3
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void startTutorial3(ActionEvent event) throws Exception {
		
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3);
		URL location = getClass().getResource("/tutorials/tutorial3.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial3 = loader.load();
		
		URL locationTradingMain = getClass().getResource("/tutorials/tutorial3Pane0.fxml");
		FXMLLoader loaderTradingMain = new FXMLLoader();
		loaderTradingMain.setLocation(locationTradingMain);		
		tutorial3Main = loaderTradingMain.load();			
		
		tutorial3.setPrefHeight(rightPane.getHeight());
		tutorial3.setPrefWidth(rightPane.getWidth());
		tutorial3.setCenter(tutorial3Main);
		
		rightPane.getChildren().add(tutorial3);
	}			
}
