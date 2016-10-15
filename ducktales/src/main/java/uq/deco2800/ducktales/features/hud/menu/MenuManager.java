package uq.deco2800.ducktales.features.hud.menu;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
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
	@FXML
	private Button nextGridButton;
	@FXML
	private Button previousGridButton;

	// building options list to be displayed in HUD
	private ArrayList<GridPane> buildingOptionList;
	// animal options list to be displayed in HUD
	private ArrayList<GridPane> animalOptionList;

	// amount of rows in the options grid
	private final int gridRows = 7;
	// amount of columns in the options grid
	private final int gridColumns = 2;

	/** The lists of menu sprites */
	private ArrayList<BuildingMenuSprite> buildingMenuSprites;
	private ArrayList<AnimalMenuSprite> animalMenuSprites;

	/** Helpers for rendering information */
	private WorldEntityInfo worldEntityInfo;

	// Current grid visible in the HUD
	private String currentGrid;
	private int currentGridIndex;

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
		nextGridButton.setVisible(false);
		previousGridButton.setVisible(false);
		// Instantiating and set up the menus
		setupMenus();
	}

	/**
	 * @author mattyleggy
	 * 
	 * @param grid
	 *            the grid to set to be current
	 * @param index
	 *            the index of the list which is visible
	 */
	private void setCurrentGrid(String grid, int index) {
		this.currentGrid = grid;
		this.currentGridIndex = index;
		
		if (this.currentGridIndex == 0)
			previousGridButton.setVisible(false);
		else 
			previousGridButton.setVisible(true);
		
		switch (this.currentGrid) {
		case "buildings":
			if (this.currentGridIndex == (buildingOptionList.size()-1))
				nextGridButton.setVisible(false);
			else
				nextGridButton.setVisible(true);
			break;
		case "animals":
			if (this.currentGridIndex == (animalOptionList.size()-1))
				nextGridButton.setVisible(false);
			else
				nextGridButton.setVisible(true);
			break;
		}
	}

	/**
	 * 
	 * @author mattyleggy
	 * 
	 * @return the grid which is currently visible in the HUD
	 */
	private String getCurrentGrid() {
		return this.currentGrid;
	}

	/**
	 * @author mattyleggy
	 * 
	 * @return the grid index which is currently visible in the HUD
	 */
	private int getCurrentGridIndex() {
		return this.currentGridIndex;
	}

	/**
	 * Show the buildings menu
	 */
	@FXML
	public void showBuildingsMenu() {
		if (buildingOptionList.size() > 0) {
			showBuildingMenuFromIndex(0);
		}
	}

	/**
	 * @param index
	 *            index value of the array to load
	 */
	private void showBuildingMenuFromIndex(int index) {
		this.clearOptionPane();
		GridPane gridPane = buildingOptionList.get(index);
		optionPane.getChildren().add(gridPane);
		setCurrentGrid("buildings", index);
	}

	/**
	 * Show the animals menu
	 */
	@FXML
	public void showAnimalsMenu() {
		if (animalOptionList.size() > 0) {
			showAnimalMenuFromIndex(0);
		}
	}

	/**
	 * @param index
	 *            index value of the array to load
	 */
	private void showAnimalMenuFromIndex(int index) {
		this.clearOptionPane();
		GridPane gridPane = animalOptionList.get(index);
		optionPane.getChildren().add(gridPane);
		setCurrentGrid("animals", index);
	}

	/**
	 * @author mattyleggy
	 * 
	 *         Show the next Grid in the HUD
	 */
	@FXML
	public void nextGrid() {
		int currentIndex = this.getCurrentGridIndex();
		int newIndex;
		switch (this.getCurrentGrid()) {
		case "buildings":
			if (currentIndex < (this.buildingOptionList.size() - 1)) {
				newIndex = currentIndex + 1;
				this.showBuildingMenuFromIndex(newIndex);
				setCurrentGrid("buildings", newIndex);
			}
			break;
		case "animals":
			if (currentIndex < (this.animalOptionList.size() - 1)) {
				newIndex = currentIndex + 1;
				this.showAnimalMenuFromIndex(newIndex);
				setCurrentGrid("animals", newIndex);
			}
			break;
		}
	}

	/**
	 * @author mattyleggy
	 * 
	 *         Show the previous Grid in the HUD
	 */
	@FXML
	public void previousGrid() {
		int currentIndex = this.getCurrentGridIndex();
		int newIndex;
		if (currentIndex > 0) {
			switch (this.getCurrentGrid()) {
			case "buildings":
				newIndex = currentIndex - 1;
				this.showBuildingMenuFromIndex(newIndex);
				setCurrentGrid("buildings", newIndex);

				break;
			case "animals":
				newIndex = currentIndex - 1;
				this.showAnimalMenuFromIndex(newIndex);
				setCurrentGrid("animals", newIndex);
				break;
			}
		}
	}

	/**
	 * Remove all components from the options pane.
	 * 
	 * @author mattyleggy
	 */
	private void clearOptionPane() {
		for (int i = 0; i < optionPane.getChildren().size(); i++) {
			optionPane.getChildren().remove(i);
		}
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
		int column = 0;
		int row = 0;
		int currentIteration;
		GridPane currentGrid = null;
		// adjust the size of the sprites
		for (int i = 0; i < animalMenuSprites.size(); i++) {
			currentIteration = i + 1;
			if (currentIteration == 1 || i % this.getMaxOptions() == 0) {
				row = 0;
				column = 0;
				currentGrid = createGrid();
				animalOptionList.add(currentGrid);
			}

			AnimalMenuSprite sprite = animalMenuSprites.get(i);
			GridPane.setHalignment(sprite, HPos.CENTER);
			GridPane.setValignment(sprite, VPos.CENTER);
			currentGrid.add(sprite, column, row);
			if (column == 1) {
				column = 0;
				row++;
			} else {
				column++;
			}
		}
		setGridConstraints(animalOptionList);
	}

	/**
	 * Create a GridPane to be used in the HUD and have buildings and animals
	 * added to it.
	 * 
	 * @author - mattyleggy
	 * 
	 * @return the newly created grid pane to be used in the HUD
	 */
	private GridPane createGrid() {
		GridPane gridPane = new GridPane();
		// gridPane.setGridLinesVisible(true);
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
			gridPane.setAlignment(Pos.CENTER);
			// set the column width
			ColumnConstraints columnConstraints = new ColumnConstraints();
			columnConstraints.setPrefWidth(100);
			for (int i = 0; i < this.gridColumns; i++) {
				gridPane.getColumnConstraints().add(columnConstraints);
			}

			// set the row height
			RowConstraints rowConstraints = new RowConstraints();
			rowConstraints.setPrefHeight(57);
			for (int i = 0; i < this.gridRows; i++) {
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
				GridPane.setHalignment(sprite, HPos.CENTER);
				GridPane.setValignment(sprite, VPos.CENTER);
				currentGrid.add(sprite, column, row);
				if (column == 1) {
					column = 0;
					row++;
				} else {
					column++;
				}

				this.setBuildingSpriteSizing(sprite, uiScale);
			}

			setGridConstraints(buildingOptionList);
		}
	}

	private void setBuildingSpriteSizing(BuildingMenuSprite sprite,
			double uiScale) {
		// Get the size of the building in tile-unit first
		int xLength = 0;
		int yLength = 0;
		try {
			xLength = worldEntityInfo.getBuildingLength(sprite.getSpriteType(),
					worldEntityInfo.XLENGTH);
			yLength = worldEntityInfo.getBuildingLength(sprite.getSpriteType(),
					worldEntityInfo.YLENGTH);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		if (xLength == 0 || yLength == 0) {
			// this building is not yet registered
			System.err.println("BuildingMenuSprite: " + sprite.getSpriteType()
					+ "is" + " not yet registered in WorldEntityInfo");
			return;
		}

		// Now set the size of the sprite based on the length in tile
		// unit, and
		// the variable UI_SCALE
		sprite.setFitHeight((sprite.getSpriteHeight() / xLength) * uiScale);
		sprite.setFitWidth((sprite.getSpriteWidth() / yLength) * uiScale);
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
