package uq.deco2800.ducktales;


import org.junit.Test;
import uq.deco2800.ducktales.features.entities.resourceentities.Tree;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

import static org.junit.Assert.*;

/**
 * Test for the {@link World} class, which is the main model of the game
 *
 * Created on 22/10/2016.
 * @author khoiphan21
 */
public class WorldTest {
    private final String NAME = "World name";
    private final int WIDTH = 10;
    private final int HEIGHT = 10;

    @Test
    public void testBasicTreeAddition() {
        World world = new World(NAME, WIDTH, HEIGHT);

        Tree tree = new Tree(5, 5);

        world.addTree(tree);

        assertEquals(tree, world.getTree(tree.hashCode()));
    }

    @Test(expected = GameSetupException.class)
    public void testAddingMultipleTree() {
        World world = new World(NAME, WIDTH, HEIGHT);

        Tree tree = new Tree(5, 5);

        world.addTree(tree);
        world.addTree(tree);

    }
}
