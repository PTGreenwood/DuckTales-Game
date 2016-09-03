package uq.deco2800.ducktales.world.builder;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import uq.deco2800.ducktales.achievements.Achievements;
import uq.deco2800.ducktales.missions.Missions;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.rendering.tiles.WorldBuilderTile;
import uq.deco2800.ducktales.rendering.engine.WorldEntityRenderingInfo;
import uq.deco2800.ducktales.util.Array2D;
import uq.deco2800.ducktales.world.World;

import java.util.ArrayList;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * Created by Khoi on 19/08/2016.
 */
public class WorldBuilderRenderer extends AnimationTimer {

    /**
     * CONSTANTS
     */
    private final double TRANSPARENCY = 0.5;
    private final ResourceType[] TILE_TYPES = {
        GRASS_1, GRASS_2, GRASS_3, DIRT_1, DIRT_2, DIRT_3
    };
    private final ResourceType[] RESOURCE_TYPES = {
        HOSPITAL, BAKERY, BARN
    };
    // The constants to layout the UI elements
    private double BUILDING_SCENE_H_PORTION = 85.0/100.0;
    private double BUILDING_SCENE_V_PORTION = 85.0/100.0;
    private double TILE_MENU_H_PORTION = 100.0 - BUILDING_SCENE_H_PORTION;
    private double TILE_MENU_V_PORTION = BUILDING_SCENE_V_PORTION;
    private double RESOURCE_MENU_H_PORTION = 1.0;
    private double RESOURCE_MENU_V_PORTION = 100.0 - BUILDING_SCENE_V_PORTION;


    /** General rendering variables */
    private World world;
    private ResourceSpriteRegister resourceSpriteRegister;
    private int tileHeight;
    private int tileWidth;

    /** UI variables */
    private Pane root; // The root pane
    private BorderPane worldBuilderPane; // The parent pane to layout all the ui elements
    private Pane buildingScene;
    private VBox tileMenu;
    private HBox resourceMenu;

    /** The SCALE/zoom factor */
    private double SCALE = 0.2;

    /**
     * The class containing info to render different types of entities
     */
    WorldEntityRenderingInfo renderingInfo;

    /**
     * The manager for World builder
     */
    WorldBuilderManager manager = WorldBuilderManager.getInstance();
    
    /*
     * Call Achievements Class     
     */
    Achievements achievementScore = Achievements.getInstance();
    /*
     * Call Missions Class
     */
    Missions missions = Missions.getInstance();
    
    /**
     * starting X and Y positions to render the tiles
     */
    private int startingX;
    private int startingY;

    /**
     * The array containing all the tiles in the current world for this builder
     */
    private Array2D<WorldBuilderTile> tiles;

    /**
     * The list of entities that have been added onto the scene
     */
    private ArrayList<ImageView> addedEntities;

    /**
     * Variables to control the hovering image when managing a world entity
     */
    private ImageView hoveringImage; // The sprite for the image
    private boolean isTiledHovered = false;

    /**
     * CONSTRUCTOR METHOD
     *
     * @param root
     *          The root pane to render onto
     */
    public WorldBuilderRenderer(Pane root, BorderPane worldBuilderPane) {
        super();

        // Setup the UI elements
        this.root = root;
        this.worldBuilderPane = worldBuilderPane;
        setupWorldBuilderUI();

        this.world = WorldBuilderManager.getInstance().getWorld();
        this.resourceSpriteRegister = ResourceSpriteRegister.getInstance();
        this.tileHeight = ResourceSpriteRegister.TILE_HEIGHT;
        this.tileWidth = ResourceSpriteRegister.TILE_WIDTH;
        this.renderingInfo = WorldEntityRenderingInfo.getInstance();
        this.addedEntities = new ArrayList<>();

        // Setup the initial point where the rendering will start from
        this.startingX = (int) (this.world.getWidth() * tileWidth * SCALE * 0.5);
        this.startingY = (int) (this.world.getHeight() * tileHeight * SCALE * 0.3);

        createWorld(buildingScene);
        createTileMenu(tileMenu);
        createWorldEntityMenu(resourceMenu);
        setupHoveringImage(buildingScene);
    }

    /**
     * Set the current tile being selected to be shown on the map whenever
     * a tile is hovered upon, and also make sure the hovering image is not
     * shown anymore
     *
     * @param tileType
     */
    public void setCurrentTileSelected(ResourceType tileType) {
        hoveringImage.setImage(null);

        for (int i = 0; i < tiles.getWidth(); i++) {
            for (int j = 0; j < tiles.getHeight(); j++) {
                tiles.get(i, j).setHoverType(tileType);
            }
        }
        //Untick the second mission box
        missions.MissionImageCompleted(1);
    }

    public void setCurrentEntitySelected(ResourceType entityType) {
        // Set the image that will follow the mouse
        Image image = resourceSpriteRegister.getResourceImage(entityType);
        hoveringImage.setImage(image);

        // setup the size of the rendered image
        hoveringImage.setFitHeight(image.getHeight() * SCALE);
        hoveringImage.setFitWidth(image.getWidth() * SCALE);

        hoveringImage.setY(-hoveringImage.getFitHeight());
        hoveringImage.setX(-renderingInfo.getStartPoint(entityType));
    }

    /**
     * This method will be called whenever a world entity is being managed,
     * and a tile is hovered upon. It will adjust the hoveringImage to snap
     * to the position of that tile
     *
     * @param x
     *          The x-coordinate of the hovered upon tile
     * @param y
     *          The y-coordinate of the hovered upon tile
     */
    public void notifyTileHovered(int x, int y) {
        // making sure the hovering image does not move elsewhere due to
        // the setOnMouseMoved implementation
        isTiledHovered = true;
        WorldBuilderTile tile = tiles.get(x, y);

        hoveringImage.setLayoutX(tile.getLayoutX() + tile.getFitWidth()/2);
        hoveringImage.setLayoutY(tile.getLayoutY() + tile.getFitHeight()/2);
    }

    /**
     * This method will make sure that the hoveringImage will follow the cursor
     * if the cursor is not hovered on any tile.
     *
     * NOTE: there is currently a bug which causes occasional jittering when
     * cursor moves from one tile to another
     */
    public void notifyTileEndHovering() {
        isTiledHovered = false;
    }

    /**
     * This method will be called whenever a tile is clicked while an entity is
     * being managed. It will add the currently managed entity onto the scene
     * @param x
     * @param y
     */
    public void notifyTileClicked(int x, int y) {
        ImageView entity = new ImageView();
        entity.setImage(hoveringImage.getImage());
        entity.setFitHeight(hoveringImage.getFitHeight());
        entity.setFitWidth(hoveringImage.getFitWidth());
        entity.setLayoutX(hoveringImage.getLayoutX());
        entity.setLayoutY(hoveringImage.getLayoutY());
        entity.setX(hoveringImage.getX());
        entity.setY(hoveringImage.getY());

        addedEntities.add(entity);

        // add the entity onto the building scene
        buildingScene.getChildren().add(entity);

        System.out.println("Entities added: " + addedEntities.toString());
        
        //Achievement score will be incremented whenever any building is built
        achievementScore.achieveVeasy();
        //If any building is built then unchecked box will be changed to checked box
        missions.MissionImageCompleted(0);       
    }

    /**
     * Initialize and set up the image to be displayed at the cursor when
     * a world entity is clicked on
     */
    private void setupHoveringImage(Pane buildingScene) {
        this.hoveringImage = new ImageView();

        buildingScene.getChildren().add(hoveringImage);
        buildingScene.setOnMouseMoved(event -> {
            if (!isTiledHovered) {
                //System.out.println("X Y are: " + event.getX() + ", " + event.getY());

                hoveringImage.setLayoutX(event.getX());
                hoveringImage.setLayoutY(event.getY());
            }
        });
    }

    /**
     * Create the menu with all the resources to be added to the world
     * @param worldEntityMenu
     *          The HBox to add the resource images into
     */
    private void createWorldEntityMenu(HBox worldEntityMenu) {
        for (int i = 0; i < RESOURCE_TYPES.length; i++) {
            worldEntityMenu.getChildren().add(
                    new WorldEntitySprite(RESOURCE_TYPES[i]));
        }
    }

    /**
     * Create the menu with all the tiles to be added to the world
     * @param tileMenu
     *          The VBox to add all the tile images into
     */
    private void createTileMenu(VBox tileMenu) {
        for (int i = 0; i < TILE_TYPES.length; i++) {
            TileSprite sprite = new TileSprite(TILE_TYPES[i]);
            sprite.getStyleClass().add("menuTileTypes");
            tileMenu.getChildren().add(sprite);
        }
    }

    /**
     * Create and render the world into the world building scene
     * @param pane
     *          The pane to render all the tiles and resources into
     */
    private void createWorld(Pane pane) {
        this.tiles = new Array2D<>(world.getWidth(), world.getHeight());

        int scaledWidth = (int) (tileWidth * SCALE);
        int scaledHeight = (int) (tileHeight * SCALE);

        WorldBuilderTile tile;

        System.out.println("Starting width: " + this.startingX);


        // Create the array of ImageViews
        for (int i = 0; i < this.world.getWidth(); i++) {
            for (int j = 0; j < this.world.getHeight(); j++) {
                /*
                 * Construct a WorldBuilderTile, passing it its world-coordinates
                  * and a handle of this rendering engine,
                 */
                tiles.set(i, j, new WorldBuilderTile(this, i, j));

                int x = startingX + (j - i) * scaledWidth / 2;
                int y = startingY + (j + i) * scaledHeight / 2;

                tile = tiles.get(i, j);
                tile.setImage(resourceSpriteRegister.getResourceImage(GRASS_1));

                tile.setFitHeight(resourceSpriteRegister.TILE_HEIGHT* SCALE);
                tile.setFitWidth(resourceSpriteRegister.TILE_WIDTH* SCALE);

                tile.setLayoutX(x);
                tile.setLayoutY(y);

                pane.getChildren().add(tile);
            }
        }

    }


    /**
     * Set up the UI for WorldBuidler
     */
    private void setupWorldBuilderUI() {
        // Initialize all the UI elements
        buildingScene = new Pane();
        tileMenu = new VBox();
        resourceMenu = new HBox();

        // Add the UI elements into the main pane
        this.worldBuilderPane.setCenter(buildingScene);
        this.worldBuilderPane.setRight(tileMenu);
        this.worldBuilderPane.setBottom(resourceMenu);


        double renderingWidth = root.getPrefWidth();
        double renderingHeight = root.getPrefHeight();

        System.err.println("world builder pane rendered width and height: " +
                renderingWidth + ", " + renderingHeight);

        // Add some styling to the root pane
        this.worldBuilderPane.getStylesheets().add("/builderStyle.css");

        // The pane where the world is rendered onto
//        buildingScene.setPrefSize(
//                renderingWidth * BUILDING_SCENE_H_PORTION,
//                renderingHeight * BUILDING_SCENE_V_PORTION
//        );
        buildingScene.getStyleClass().add("buildingScene");

        // The pane containing the tiles
        tileMenu.setPrefSize(
                renderingWidth * TILE_MENU_H_PORTION,
                renderingHeight * TILE_MENU_V_PORTION
        );
        tileMenu.getStyleClass().add("tileMenu");
        tileMenu.setPadding(new Insets(25));
        tileMenu.setSpacing(20);

        // The pane containing the resources
        resourceMenu.setPrefWidth(renderingWidth * RESOURCE_MENU_H_PORTION);
        resourceMenu.setMaxHeight(renderingHeight * RESOURCE_MENU_V_PORTION);
        resourceMenu.getStyleClass().add("resourceMenu");

        // Add the child panes into the main pane
        this.worldBuilderPane.setCenter(buildingScene);
        this.worldBuilderPane.setRight(tileMenu);
        this.worldBuilderPane.setBottom(resourceMenu);
        
        
    }

    @Override
    public void handle(long arg0) {
        // stub method
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }
}
