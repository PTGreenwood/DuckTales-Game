package uq.deco2800.ducktales;

import javafx.scene.layout.Pane;
import org.junit.Test;

import static org.junit.Assert.*;
import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * Tests for the main manager of the game - {@link GameManager}
 * Created on 16/10/2016.
 * @author Khoi
 */
public class GameManagerTest {
    /*
     * Basic game manager creation tests
     */
    @Test
    public void basicCreation() {
        Pane rootPane = new Pane();
        World basicWorld = new World("New World", 10, 10);
        GameManager gameManager1 = new GameManager(rootPane);
        // Check the root pane
        assertEquals(rootPane, gameManager1.getRoot());
        // Check properties of the world
        assertEquals(GameManager.DEFAULT_WORLD_WIDTH, gameManager1.getWorld().getWidth());
        assertEquals(GameManager.DEFAULT_WORLD_HEIGHT, gameManager1.getWorld().getHeight());
        assertEquals(GameManager.DEFAULT_WORLD_NAME, gameManager1.getWorld().getName());

        GameManager gameManager2 = new GameManager(rootPane, basicWorld);
        assertEquals(rootPane, gameManager2.getRoot());
        assertEquals(basicWorld, gameManager2.getWorld());
    }

}
