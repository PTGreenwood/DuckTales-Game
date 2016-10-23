package uq.deco2800.ducktales.rendering.worlddisplay;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.MainEntityManager;
import uq.deco2800.ducktales.features.landscape.tiles.TilesManager;

import static org.junit.Assert.*;


/**
 * Created on 23/10/2016.
 */
public class WorldDisplayRendererTest extends ApplicationTest {
    @Test
    public void testBasicCreation() {
        WorldDisplayRenderer renderer = new WorldDisplayRenderer();
        renderer.handle(System.nanoTime());

        // Attempt all the manager setup methods
        TilesManager tilesManager = new TilesManager(
                new World("new world", 10, 10),
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

        // Attempt all the manager setup methods
        TilesManager tilesManager = new TilesManager(
                new World("new world", 10, 10),
                new Pane()
        );
        renderer.setTilesManager(tilesManager);
        MainEntityManager entityManager = MainEntityManager.getInstance();
        renderer.setMainEntityManager(entityManager);

        // Attempt to use set moving directions
        renderer.setMovingDirectionH(WorldDisplayRenderer.HDirection.RIGHT);
        renderer.setMovingDirectionV(WorldDisplayRenderer.VDirection.DOWN);

        //TODO CHECK PANNING SPEED BASED ON DIRECTIONS
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
