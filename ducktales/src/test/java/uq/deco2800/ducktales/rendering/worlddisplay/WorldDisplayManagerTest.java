package uq.deco2800.ducktales.rendering.worlddisplay;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testfx.framework.junit.ApplicationTest;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.landscape.tiles.Tile;
import uq.deco2800.ducktales.features.time.TimeManager;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



/**
 * Test for {@link WorldDisplayManager} class
 *
 * Created on 24/10/2016.
 * @author khoiphan21
 */
public class WorldDisplayManagerTest extends ApplicationTest{
    /** CONSTANTS USED FOR SETTING UP MOCK OBJECTS */
    private final int WORLD_WIDTH = 1;
    private final int WORLD_HEIGHT = 1;
    private final String WORLD_NAME = "New World";

    @Mock
    private World mockWorld;
    @Mock
    private GameManager mockGameManager;
    private Pane mockWorldDisplay;

    @Test
    public void testBasicCreation() {
        WorldDisplayManager manager = new WorldDisplayManager();
        manager.initialize(null, null);
    }

    /**
     * Set up the mock objects, to make sure there is no null
     * pointers in them whenever a new test is run
     */
    private void setupMockObjects(WorldDisplayManager manager) {
        // Setting up the mock world
        mockWorld = Mockito.mock(World.class);
        when(mockWorld.getWidth()).thenReturn(WORLD_WIDTH);
        when(mockWorld.getHeight()).thenReturn(WORLD_HEIGHT);
        when(mockWorld.getTile(0, 0)).thenReturn(new Tile(ResourceType.GRASS_1));

        // Setting up the mock game manager
        mockGameManager = Mockito.mock(GameManager.class);
        when(mockGameManager.getTimeManager()).thenReturn(
                new TimeManager()
        );
        mockWorldDisplay = new Pane();

        manager.setGameManager(mockGameManager);
        manager.setWorld(mockWorld);
        manager.setWorldDisplay(mockWorldDisplay);
    }

    @Test(expected = GameSetupException.class)
    public void testMissingWorld() {
        WorldDisplayManager manager = new WorldDisplayManager();
        manager.initialize(null, null);

        this.setupMockObjects(manager);

        manager.setWorld(null);

        manager.initializeWorld();
    }

    @Test(expected = GameSetupException.class)
    public void testMissingGameManager() {
        WorldDisplayManager manager = new WorldDisplayManager();
        manager.initialize(null, null);

        this.setupMockObjects(manager);

        manager.setGameManager(null);

        manager.initializeWorld();
    }

    @Test(expected = GameSetupException.class)
    public void testMissingWorldDisplay() {
        WorldDisplayManager manager = new WorldDisplayManager();
        manager.initialize(null, null);

        this.setupMockObjects(manager);

        manager.setWorldDisplay(null);

        manager.initializeWorld();
    }

    @Test(expected = GameSetupException.class)
    public void testMissingRenderer() {
        WorldDisplayManager manager = new WorldDisplayManager();
        manager.initialize(null, null);

        this.setupMockObjects(manager);

        manager.setRenderer(null);

        manager.initializeWorld();
    }

    @Test
    public void testSuccessfulInitializeWorld() {
        WorldDisplayManager manager = new WorldDisplayManager();
        manager.initialize(null, null);

        setupMockObjects(manager);

        manager.initializeWorld();

        // Check for tiles manager
        assertNotNull(manager.getTilesManager());
        assertNotNull(manager.getWorldDisplay());
    }

    @Test
    public void testMovingWorld() {
        WorldDisplayManager manager = new WorldDisplayManager();
        manager.initialize(null, null);

        setupMockObjects(manager);

        manager.initializeWorld();

        // Start moving world
        manager.moveWorld(WorldDisplayManager.Direction.UP);
        manager.moveWorld(WorldDisplayManager.Direction.DOWN);
        manager.moveWorld(WorldDisplayManager.Direction.LEFT);
        manager.moveWorld(WorldDisplayManager.Direction.RIGHT);

        // Stop moving world
        manager.stopMoveWorld(WorldDisplayManager.Direction.UP);
        manager.stopMoveWorld(WorldDisplayManager.Direction.DOWN);
        manager.stopMoveWorld(WorldDisplayManager.Direction.LEFT);
        manager.stopMoveWorld(WorldDisplayManager.Direction.RIGHT);

    }

    @Test
    public void testChangeLightLevel() {
        WorldDisplayManager manager = new WorldDisplayManager();
        manager.initialize(null, null);

        setupMockObjects(manager);

        manager.initializeWorld();

        manager.changeLightLevel(new Pane());
    }

    @Test(expected = GameSetupException.class)
    public void testMissingTimeManager() {
        WorldDisplayManager manager = new WorldDisplayManager();
        manager.initialize(null, null);

        setupMockObjects(manager);

        manager.initializeWorld();

        when(mockGameManager.getTimeManager()).thenReturn(null);

        manager.changeLightLevel(new Pane());
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
