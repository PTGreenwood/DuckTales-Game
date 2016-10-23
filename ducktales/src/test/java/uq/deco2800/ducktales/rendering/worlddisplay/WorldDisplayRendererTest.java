package uq.deco2800.ducktales.rendering.worlddisplay;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.MainEntityManager;
import uq.deco2800.ducktales.features.landscape.tiles.TileSprite;
import uq.deco2800.ducktales.features.landscape.tiles.TilesManager;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 * Created on 23/10/2016.
 */
public class WorldDisplayRendererTest extends ApplicationTest {
    /** default world variables used for testing */
    private final String WORLD_NAME = "New World";
    private final int WORLD_WIDTH = 10;
    private final int WORLD_HEIGHT = 10;

    @Test
    public void testBasicCreation() {
        WorldDisplayRenderer renderer = new WorldDisplayRenderer();
        renderer.handle(System.nanoTime());

        // Attempt all the manager setup methods
        TilesManager tilesManager = new TilesManager(
                new World(WORLD_NAME, WORLD_WIDTH, WORLD_HEIGHT),
                new Pane()
        );
        renderer.setTilesManager(tilesManager);
        MainEntityManager entityManager = MainEntityManager.getInstance();
        renderer.setMainEntityManager(entityManager);

        // Attempt to use set moving directions
        renderer.setMovingDirectionH(WorldDisplayRenderer.HDirection.RIGHT);
        renderer.setMovingDirectionV(WorldDisplayRenderer.VDirection.DOWN);
    }

    @Test
    public void testPanning() {
        WorldDisplayRenderer renderer = new WorldDisplayRenderer();
        renderer.handle(System.nanoTime());

        // Attempt all the manager setup methods, with mock tiles manager
        TilesManager tilesManager = mock(TilesManager.class);
        when(tilesManager.getWorldWidth()).thenReturn(1);
        when(tilesManager.getWorldHeight()).thenReturn(1);
        when(tilesManager.getTileSprite(0, 0))
                .thenReturn(new TileSprite(ResourceType.GRASS_1, 0, 0));
        renderer.setTilesManager(tilesManager);

        MainEntityManager entityManager = MainEntityManager.getInstance();
        renderer.setMainEntityManager(entityManager);

        // check panning speed based on directions
        renderer.setMovingDirectionH(WorldDisplayRenderer.HDirection.RIGHT);
        assertEquals(renderer.getXMovementAmount(), renderer.getPanSpeed());

        renderer.setMovingDirectionH(WorldDisplayRenderer.HDirection.LEFT);
        assertEquals(renderer.getXMovementAmount(), -renderer.getPanSpeed());

        renderer.setMovingDirectionV(WorldDisplayRenderer.VDirection.DOWN);
        assertEquals(renderer.getYMovementAmount(), renderer.getPanSpeed());

        renderer.setMovingDirectionV(WorldDisplayRenderer.VDirection.UP);
        assertEquals(renderer.getYMovementAmount(), -renderer.getPanSpeed());

        renderer.setMovingDirectionV(WorldDisplayRenderer.VDirection.NONE);
        renderer.setMovingDirectionH(WorldDisplayRenderer.HDirection.NONE);
        assertEquals(renderer.getXMovementAmount(), 0);
        assertEquals(renderer.getYMovementAmount(), 0);
    }

    @Test
    public void testMovingWorld() {
        WorldDisplayRenderer renderer = new WorldDisplayRenderer();

        // Attempt all the manager setup methods, with mock tiles manager
        TilesManager tilesManager = mock(TilesManager.class);
        when(tilesManager.getWorldWidth()).thenReturn(1);
        when(tilesManager.getWorldHeight()).thenReturn(1);
        when(tilesManager.getTileSprite(0, 0))
                .thenReturn(new TileSprite(ResourceType.GRASS_1, 0, 0));
        renderer.setTilesManager(tilesManager);

        MainEntityManager entityManager = MainEntityManager.getInstance();
        renderer.setMainEntityManager(entityManager);

        // Moving left
        renderer.setMovingDirectionH(WorldDisplayRenderer.HDirection.LEFT);
        renderer.handle(System.nanoTime());

        // Moving right
        renderer.setMovingDirectionH(WorldDisplayRenderer.HDirection.RIGHT);
        renderer.handle(System.nanoTime());

        // Moving up
        renderer.setMovingDirectionV(WorldDisplayRenderer.VDirection.UP);
        renderer.handle(System.nanoTime());

        // Moving down
        renderer.setMovingDirectionV(WorldDisplayRenderer.VDirection.DOWN);
        renderer.handle(System.nanoTime());

        // if no error then it means the setup is correct
    }

    @Test(expected = GameSetupException.class)
    public void testTileNotInitiated() {
        WorldDisplayRenderer renderer = new WorldDisplayRenderer();

        // Attempt all the manager setup methods, with mock tiles manager
        TilesManager tilesManager = mock(TilesManager.class);
        when(tilesManager.getWorldWidth()).thenReturn(1);
        when(tilesManager.getWorldHeight()).thenReturn(1);
        when(tilesManager.getTileSprite(0, 0))
                .thenReturn(null);
        renderer.setTilesManager(tilesManager);

        MainEntityManager entityManager = MainEntityManager.getInstance();
        renderer.setMainEntityManager(entityManager);

        // Moving left
        renderer.setMovingDirectionH(WorldDisplayRenderer.HDirection.LEFT);
        renderer.handle(System.nanoTime());
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
