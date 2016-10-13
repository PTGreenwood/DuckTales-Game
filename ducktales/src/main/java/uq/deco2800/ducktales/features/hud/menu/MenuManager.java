package uq.deco2800.ducktales.features.hud.menu;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import uq.deco2800.ducktales.features.hud.menu.animal.AnimalMenuSprite;
import uq.deco2800.ducktales.features.hud.menu.building.BuildingMenuSprite;
import uq.deco2800.ducktales.rendering.info.WorldEntityInfo;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.SecondaryManager;

import static uq.deco2800.ducktales.resources.ResourceType.BAKERY;
import static uq.deco2800.ducktales.resources.ResourceType.BUTCHER;
import static uq.deco2800.ducktales.resources.ResourceType.CEMETERY;
import static uq.deco2800.ducktales.resources.ResourceType.CHURCH;
import static uq.deco2800.ducktales.resources.ResourceType.COMMUNITY_BUILDING;
import static uq.deco2800.ducktales.resources.ResourceType.DUCK;
import static uq.deco2800.ducktales.resources.ResourceType.FARM;
import static uq.deco2800.ducktales.resources.ResourceType.FORGE;
import static uq.deco2800.ducktales.resources.ResourceType.HOSPITAL;
import static uq.deco2800.ducktales.resources.ResourceType.HOUSE;
import static uq.deco2800.ducktales.resources.ResourceType.MINE;
import static uq.deco2800.ducktales.resources.ResourceType.OBSERVATORY;
import static uq.deco2800.ducktales.resources.ResourceType.PASTURE;
import static uq.deco2800.ducktales.resources.ResourceType.QUARRY;
import static uq.deco2800.ducktales.resources.ResourceType.SAWMILL;
import static uq.deco2800.ducktales.resources.ResourceType.SCHOOL;
import static uq.deco2800.ducktales.resources.ResourceType.GYMNASIUM;
import static uq.deco2800.ducktales.resources.ResourceType.SHEEP;
import static uq.deco2800.ducktales.resources.ResourceType.COW;

/**
 * This manager manages the menu section of the HUD
 *
 * Created on 7/09/2016.
 */
public class MenuManager implements Initializable, SecondaryManager {
	/**
	 * CONSTANTS
	 */
	// TODO: TO ADD NEW BUILDINGS, REGISTER THEIR NAMES HERE
	private static final ResourceType[] BUILDINGS = { BAKERY, BUTCHER, CEMETERY,
			CHURCH, COMMUNITY_BUILDING, FARM, FORGE, HOSPITAL, HOUSE, SCHOOL,
			GYMNASIUM, MINE, OBSERVATORY, PASTURE, QUARRY, SAWMILL, };
	// TODO: TO ADD NEW ANIMALS, REGISTER THEIR NAMES HERE
	public static final ResourceType[] ANIMALS = { SHEEP, DUCK, COW };

	// enum to check which is selected, a BUILDING or an ANIMAL
	public enum MenuType {
		BUILDING, ANIMAL
	}

	/** GUI containers */
	@FXML
	private AnchorPane menuPane; // The parent Node for all menus
	@FXML
	private Pane optionPane;

	//building options list to be displayed in HUD
	private ArrayList<GridPane> buildingOptionList;
	//animal options list to be displayed in HUD
	private ArrayList<GridPane> animalOptionList;

	//amount of rows in the options grid
	private final int gridRows = 7;
	//amount of columns in the options grid
	private final int gridColumns = 2;

	/** The lists of menu sprites */
	private ArrayList<BuildingMenuSprite> buildingMenuSprites;
	private ArrayList<AnimalMenuSprite> animalMenuSprites;

	/** Helpers for rendering information */
	private WorldEntityInfo worldEntityInfo;

	/**
	 * This method is called when FXML Loader instantiates this class
	 *
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.worldEntityInfo = WorldEntityInfo.getInstance();
		buildingOptionList = new ArrayList<>();
		animalOptionList = new ArrayList<>();
		// Instantiating and set up the menus
		setupMenus();

	}

	/**
	 * Show the buildings menu
	 */
	@FXML
	public void showBuildingsMenu() {		
		this.clearOptionPane();
		GridPane gridPane = buildingOptionList.get(0);		
		optionPane.getChildren().add(gridPane);		
	}
	
	/**
	 * Remove all components from the options pane.
	 * 
	 * @author mattyleggy
	 */
	private void clearOptionPane() {
		System.out.println(optionPane.getChildren().size());
		
		for (int i=0; i < optionPane.getChildren().size(); i++) {
			optionPane.getChildren().remove(i);
		}
	}

	/**
	 * Show the animals menu
	 */
	@FXML
	public void showAnimalsMenu() {
		
	}

	/**
	 * Set up all the menus to be displayed on the HUD
	 */
	private void setupMenus() {
		this.animalMenuSprites = new ArrayList<>();
		this.buildingMenuSprites = new ArrayList<>();

		// Add the building sprites
		for (int i = 0; i < BUILDINGS.length; i++) {
			BuildingMenuSprite sprite = new BuildingMenuSprite(BUILDINGS[i]);

			if (!worldEntityInfo.containEntity(sprite.getSpriteType())) {
				// this building is not yet registered in the manager. not
				// rendered
				System.err.println(
						"BuildingMenuSprite " + sprite.getSpriteType() + " is "
								+ "not yet registered in WorldEntityInfo");
				continue;
			}

			buildingMenuSprites.add(sprite);
		}

		// Add the animal sprites
		for (int i = 0; i < ANIMALS.length; i++) {
			AnimalMenuSprite sprite = new AnimalMenuSprite(ANIMALS[i]);

			animalMenuSprites.add(sprite);
		}

		// Set up the menus
		setupBuildingsMenu();
		setupAnimalsMenu();
	}

	/**
	 * Set up the animals menu
	 */
	private void setupAnimalsMenu() {
		if (animalOptionList.size() == 0) {
			/*
			 * Then adjust the size of the sprites accordingly
			 */
			// TODO IMPLEMENT THIS
			int column = 0;
			int row = 0;
			for (int i = 0; i < animalMenuSprites.size(); i++) {
				AnimalMenuSprite sprite = animalMenuSprites.get(i);
				//animalsMenu.add(sprite, column, row);
				if (column == 1) {
					column = 0;
					row++;
				} else {
					column++;
				}
				// STUB METHOD - set max height for the sprites
				// sprite.setFitHeight(animalsMenu.getHeight());
			}
		}
	}

	private GridPane createGrid() {
		GridPane gridPane = new GridPane();
		gridPane.setGridLinesVisible(true);
		gridPane.setPrefHeight(402.0);
		gridPane.setPrefWidth(152.0);
		return gridPane;
	}

	/**
	 * 
	 * Set the row and column constraints of the grid which will be placed in
	 * the right hand side HUD.
	 * 
	 * @author mattyleggy
	 * 
	 * @param gridPane
	 *            the GridPane to assign the constraints to
	 */
	private void setGridConstraints(ArrayList<GridPane> gridPaneList) {
		for (GridPane gridPane : gridPaneList) {
			// set the column width
			ColumnConstraints columnConstraints = new ColumnConstraints();
			columnConstraints.setPrefWidth(100);			
			for (int i=0; i < this.gridColumns; i++) {
				gridPane.getColumnConstraints().add(columnConstraints);
			}
			
			// set the row height
			RowConstraints rowConstraints = new RowConstraints();
			rowConstraints.setPrefHeight(57);
			for (int i=0; i < this.gridRows; i++) {
				gridPane.getRowConstraints().add(rowConstraints);
			}
		}
	}

	/**
	 * Set up the buildings menu for players to select buildings to add to the
	 * world
	 */
	private void setupBuildingsMenu() {
		// Check if the buildings menu has been instantiated before
		if (buildingOptionList.size() == 0) {
			/*
			 * Firstly add all building sprites to the menu first
			 */
			// buildingsMenu.getChildren().addAll(buildingMenuSprites);

			/*
			 * Then adjust the size of the sprites accordingly
			 */
			// Get the officially defined scale from the rendering manager
			// double uiScale = RenderingInformation.UI_SCALE;
			double uiScale = 0.5;
			int column = 0;
			int row = 0;			
			int currentIteration;
			GridPane currentGrid = null;
			// adjust the size of the sprites
			for (int i = 0; i < buildingMenuSprites.size(); i++) {
				currentIteration = i + 1;
				if (currentIteration == 1 || i % this.getMaxOptions() == 0) {
					row = 0;
					column = 0;
					currentGrid = createGrid();
					buildingOptionList.add(currentGrid);
				}
				
				BuildingMenuSprite sprite = buildingMenuSprites.get(i);
				
				// Get the size of the building in tile-unit first
				int xLength = 0;
				int yLength = 0;
				try {
					xLength = worldEntityInfo.getBuildingLength(
							sprite.getSpriteType(), worldEntityInfo.XLENGTH);
					yLength = worldEntityInfo.getBuildingLength(
							sprite.getSpriteType(), worldEntityInfo.YLENGTH);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}

				if (xLength == 0 || yLength == 0) {
					// this building is not yet registered
					System.err.println("BuildingMenuSprite: "
							+ sprite.getSpriteType() + "is"
							+ " not yet registered in WorldEntityInfo");
					return;
				}

				// Now set the size of the sprite based on the length in tile
				// unit, and
				// the variable UI_SCALE
				sprite.setFitHeight(
						(sprite.getSpriteHeight() / xLength) * uiScale);
				sprite.setFitWidth(
						(sprite.getSpriteWidth() / yLength) * uiScale);
				
				currentGrid.add(sprite, column, row);
				if (column == 1) {
					column = 0;
					row++;
				} else {
					column++;
				}
			}
			setGridConstraints(buildingOptionList);
		}
	}

	/**
	 * 
	 * Find the maximum amount of options which are available in the GridPanes
	 * by checking the row and column counts.
	 * 
	 * @author mattyleggy
	 * 
	 * @return the maximum amount of options available in the GridPanes
	 */
	private int getMaxOptions() {
		return this.gridRows * this.gridColumns;
	}

	@Override
	public void reload() {

	}
}
