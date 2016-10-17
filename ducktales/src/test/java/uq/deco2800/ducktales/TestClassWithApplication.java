package uq.deco2800.ducktales;

import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.BeforeClass;

/**
 * This class should be extended by all test classes that needs the javaFx toolkit
 * or internal graphics to be initialized first
 *
 * Created on 17/10/2016.
 * @author khoiphan21
 */
public abstract class TestClassWithApplication {
    // This is a class representing an empty javafx application
    public static class AsNonApp extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {

        }
    }
    @BeforeClass
    public static void setUpClass() throws InterruptedException {
        // Initialise Java FX

        // About to launch an empty FX application
        Thread t = new Thread("JavaFX Init Thread") {
            public void run() {
                Application.launch(AsNonApp.class, new String[0]);
            }
        };
        t.setDaemon(true);
        t.start();

        // Started the FX thread. now make it sleep a bit to make sure all other
        // engine threads are ready
        Thread.sleep(500);
    }
}
