package uq.deco2800.ducktales.missions;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import uq.deco2800.ducktales.achievements.Achievements;
import javafx.scene.control.ProgressIndicator;
import uq.deco2800.ducktales.achievements.progressIndicator;
import uq.deco2800.ducktales.level.Level;
import uq.deco2800.ducktales.world.builder.WorldBuilderRenderer;

public class MissionController {
	
	
	private BorderPane mission1;
	private BorderPane mission2;
	private BorderPane mission3;
	private BorderPane achievement;
	private BorderPane level;
	
	
	
	@FXML	
	private AnchorPane missionWindow, rightPane;	
	@FXML
	private TextArea mission2TextArea;
	
	Achievements achievementMain = Achievements.getInstance();
	Missions missionMain = Missions.getInstance();
	Level levelMain = Level.getInstance();
	progressIndicator piMain = progressIndicator.getInstance();
	
	@FXML
	public void startmission1(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(mission1,mission2,mission3,achievement,level);
		URL location = getClass().getResource("mission1.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		
		Label mission1Top = new Label("LaunchGame Missions");
		mission1Top.setFont(new Font("Arial",36));
		
		mission1 = loader.load();
		mission1.setTop(mission1Top);
		mission1.setAlignment(mission1Top, Pos.CENTER);
		mission1.setPrefHeight(rightPane.getHeight());
		mission1.setPrefWidth(rightPane.getWidth());		
		rightPane.getChildren().add(mission1);
		
	}
	
	@FXML
	public void startmission2(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(mission1,mission2,mission3,achievement,level);
		URL location = getClass().getResource("mission2.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		
		GridPane missions = new GridPane();
		
		Label missions1 = new Label("1.Build any one of the building onto the tiles :  ");
		missions1.setFont(new Font("Arial", 24));
		Label missions2 = new Label("2.Click any one of the tile :  ");
		missions2.setFont(new Font("Arial", 24));
		
		ImageView mission1Box = new ImageView();
		mission1Box = Missions.getInstance().getMissionImageCompleted(0);
		HBox mission1HBox = new HBox();
		mission1HBox.getChildren().addAll(missions1,mission1Box);
		ImageView mission2Box = new ImageView();
		mission2Box = Missions.getInstance().getMissionImageCompleted(1);
		HBox mission2HBox = new HBox();
		mission2HBox.getChildren().addAll(missions2,mission2Box);
		
		missions.setVgap(10);
		missions.add(mission1HBox, 0, 1);
		missions.add(mission2HBox, 0, 2);
		
		Label mission2Top = new Label("WorldBuilder Missions");
		mission2Top.setFont(new Font("Arial",36));
		
		ScrollPane scroll = new ScrollPane(missions);
		
		mission2 = loader.load();
		mission2.setAlignment(mission2Top, Pos.CENTER);
		mission2.setTop(mission2Top);
		mission2.setCenter(scroll);		
		mission2.setPrefHeight(rightPane.getHeight());
		mission2.setPrefWidth(rightPane.getWidth());		
		
		rightPane.getChildren().add(mission2);
	}
	
	@FXML
	public void startmission3(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(mission1,mission2,mission3,achievement,level);
		URL location = getClass().getResource("mission3.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		
		GridPane missions = new GridPane();		
		
		Label missions1 = new Label("1.Click Add peon :  ");
		missions1.setFont(new Font("Arial", 24));
		Label missions2 = new Label("2.Click marketplace :  ");
		missions2.setFont(new Font("Arial", 24));
		
		ImageView mission1Box = new ImageView();
		mission1Box = Missions.getInstance().getMissionImageCompleted(2);
		HBox mission1HBox = new HBox();
		mission1HBox.getChildren().addAll(missions1,mission1Box);
		ImageView mission2Box = new ImageView();
		mission2Box = Missions.getInstance().getMissionImageCompleted(3);
		HBox mission2HBox = new HBox();
		mission2HBox.getChildren().addAll(missions2,mission2Box);
		
		missions.setVgap(10);
		missions.add(mission1HBox, 0, 1);
		missions.add(mission2HBox, 0, 2);
		
		Label mission3Top = new Label("World Builder Missions");
		mission3Top.setFont(new Font("Arial", 36));
		
		ScrollPane scroll = new ScrollPane(missions);
		
		mission3 = loader.load();

		mission3.setTop(mission3Top);
		mission3.setCenter(scroll);
		mission3.setAlignment(mission3Top, Pos.CENTER);
		mission3.setPrefHeight(rightPane.getHeight());
		mission3.setPrefWidth(rightPane.getWidth());		
		
		rightPane.getChildren().add(mission3);		
	}
	
	
	@FXML
	public void startachievement(ActionEvent event) throws Exception {
		
		rightPane.getChildren().removeAll(mission1,mission2,mission3,achievement,level);
		URL location = getClass().getResource("achievement.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		
		GridPane achieveGrid = new GridPane();
		
		Label achieveLabel = new Label("Total Achievement : " + achievementMain.getAchieve());
		achieveLabel.setFont(new Font("Arial", 24));
		Label achieveTop = new Label("Achievement");
		achieveTop.setFont(new Font("Arial", 36));
		
		Label pi1Label = new Label("GameBeta Mission Progress");
		ProgressIndicator  pi1 = new ProgressIndicator();
		pi1 = piMain.getProgressIndicator();
		
		
		achieveGrid.setVgap(10);
		achieveGrid.setPadding(new Insets(10, 10, 10, 10));
		achieveGrid.add(pi1, 0, 1);
		achieveGrid.add(pi1Label, 0, 2);
		
		achievement = loader.load();
		achievement.setTop(achieveTop);
		achievement.setAlignment(achieveTop, Pos.CENTER);
		achievement.setCenter(achieveGrid);		
		achievement.setBottom(achieveLabel);
		achievement.setAlignment(achieveLabel, Pos.CENTER);
		achievement.setPrefHeight(rightPane.getHeight());
		achievement.setPrefWidth(rightPane.getWidth());		
		
		rightPane.getChildren().add(achievement);
	}
	
	@FXML
	public void startlevel(ActionEvent event) throws Exception {
		
		rightPane.getChildren().removeAll(mission1,mission2,mission3,achievement,level);
		URL location = getClass().getResource("level.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		
		GridPane levelGrid = new GridPane();
		
		Label levelTop = new Label("Leveling System");
		levelTop.setFont(new Font("Arial", 36));
		Label levelDisplay = new Label("Level : " + levelMain.getLevel());
		
		ProgressBar  pb1 = new ProgressBar();
		pb1 = levelMain.getProgressIndicator();
		
		levelGrid.setVgap(10);
		levelGrid.setPadding(new Insets(10, 10, 10, 10));
		levelGrid.add(levelDisplay, 0, 1);
		levelGrid.add(pb1, 0, 2);
		
		level = loader.load();
		level.setTop(levelTop);
		level.setAlignment(levelTop, Pos.CENTER);
		level.setCenter(levelGrid);
		level.setPrefHeight(rightPane.getHeight());
		level.setPrefWidth(rightPane.getWidth());
		
		rightPane.getChildren().add(level);	
	}
	
	
}
