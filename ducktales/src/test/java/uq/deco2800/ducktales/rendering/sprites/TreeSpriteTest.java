package uq.deco2800.ducktales.rendering.sprites;

import org.junit.Test;
import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

/**
 * Test for the tree sprite
 *
 * Created on 22/10/2016.
 * @author khoiphan21
 */
public class TreeSpriteTest extends ApplicationTest{
    @Test
    public void testBasicSpriteCreation() {
        int hashCode = 100;
        TreeSprite sprite = new TreeSprite(hashCode);

        assertEquals(sprite.getHashCode(), new Integer(hashCode));
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
