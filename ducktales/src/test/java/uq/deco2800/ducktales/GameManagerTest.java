package uq.deco2800.ducktales;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import uq.deco2800.ducktales.features.achievements.AchievementManager;
import uq.deco2800.ducktales.features.entities.MainEntityManager;
import uq.deco2800.ducktales.features.entities.resourceentities.ResourceEntityManager;
import uq.deco2800.ducktales.features.helper.HelperManager;
import uq.deco2800.ducktales.features.hud.HUDManager;
import uq.deco2800.ducktales.features.hud.informationdisplay.peon.PeonInformationDisplayManager;
import uq.deco2800.ducktales.features.level.LevelManager;
import uq.deco2800.ducktales.features.market.MarketManager;
import uq.deco2800.ducktales.features.missions.MissionManager;
import uq.deco2800.ducktales.features.time.TimeManager;
import uq.deco2800.ducktales.features.tutorials.TutorialManager;
import uq.deco2800.ducktales.features.weather.WeatherManager;
import uq.deco2800.ducktales.rendering.worlddisplay.CursorManager;
import uq.deco2800.ducktales.rendering.worlddisplay.WorldDisplayManager;

import static org.junit.Assert.*;

/**
 * Tests for the main manager of the game - {@link GameManager}
 * Created on 16/10/2016.
 * @author Khoi
 */
public class GameManagerTest extends ApplicationTest {

    /*
     * Dummy objects used during tests
     */
    Pane rootPane = new Pane();

    /*
     * Basic game manager creation tests
     */
    @Test
    public void testBasicCreation() {
        World basicWorld = new World("New World", 10, 10);
        GameManager gameManager1 = new GameManager(this.rootPane);
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

    @Test
    public void testBasicHudManagerCreation() {
        AnchorPane rootPane = new AnchorPane();
        AnchorPane leftPane = new AnchorPane();
        AnchorPane bottomPane = new AnchorPane();
        HUDManager hudManager = new HUDManager(rootPane, leftPane, bottomPane);

        GameManager gameManager = new GameManager(rootPane);
        gameManager.setHudManager(hudManager);

        assertEquals(hudManager, gameManager.getHudManager());
    }

    @Test
    public void testBasicMarketManagerCreation() {
        MarketManager marketManager = new MarketManager();

        GameManager gameManager = new GameManager(this.rootPane);
        gameManager.setMarketManager(marketManager);

        assertEquals(marketManager, gameManager.getMarketManager());
    }

    @Test
    public void testBasicWorldDisplayManagerCreation() {
        WorldDisplayManager displayManager = new WorldDisplayManager();

        GameManager gameManager = new GameManager(this.rootPane);
        gameManager.setWorldDisplayManager(displayManager);

        assertEquals(displayManager, gameManager.getWorldDisplayManager());
    }

    @Test
    public void testBasicHelperManagerCreation() {
        HelperManager helperManager = new HelperManager();

        GameManager gameManager = new GameManager(this.rootPane);
        gameManager.setHelperManager(helperManager);

        assertEquals(helperManager, gameManager.getHelperManager());
    }

    @Test
    public void testBasicMissionManagerCreation() {
        MissionManager missionManager = new MissionManager();

        GameManager gameManager = new GameManager(this.rootPane);
        gameManager.setMissionManager(missionManager);

        assertEquals(missionManager, gameManager.getMissionManager());
    }

    @Test
    public void testBasicTutorialManagerCreation() {
        TutorialManager tutorialManager = new TutorialManager();

        GameManager gameManager = new GameManager(this.rootPane);
        gameManager.setTutorialManager(tutorialManager);

        assertEquals(tutorialManager, gameManager.getTutorialManager());
    }

    @Test
    public void testBasicLevelManagerCreation() {
        LevelManager levelManager = new LevelManager();

        GameManager gameManager = new GameManager(this.rootPane);
        gameManager.setLevelManager(levelManager);

        assertEquals(levelManager, gameManager.getLevelManager());
    }

    @Test
    public void testBasicAchievementManagerCreation() {
        AchievementManager achievementManager = new AchievementManager();

        GameManager gameManager = new GameManager(this.rootPane);
        gameManager.setAchievementManager(achievementManager);

        assertEquals(achievementManager, gameManager.getAchievementManager());
    }

    @Test
    public void testBasicCursorManagerCreation() {
        CursorManager cursorManager = new CursorManager(this.rootPane);

        GameManager gameManager = new GameManager(this.rootPane);
        gameManager.setCursorManager(cursorManager);

        assertEquals(cursorManager, gameManager.getCursorManager());
    }

    @Test
    public void testBasicMainEntityManagerCreation() {
        MainEntityManager entityManager = MainEntityManager.getInstance();

        GameManager gameManager = new GameManager(this.rootPane);
        gameManager.setMainEntityManager(entityManager);

        assertEquals(entityManager, gameManager.getMainEntityManager());
    }

    @Test
    public void testBasicResourceEntityManagerCreation() {
        ResourceEntityManager resourceEntityManager = new ResourceEntityManager();

        GameManager gameManager = new GameManager(this.rootPane);
        gameManager.setResourceEntityManager(resourceEntityManager);

        assertEquals(resourceEntityManager, gameManager.getResourceEntityManager());
    }

    @Test
    public void testBasicTimeManagerCreation() {
        TimeManager timeManager = new TimeManager();

        GameManager gameManager = new GameManager(this.rootPane);
        gameManager.setTimeManager(timeManager);

        assertEquals(timeManager, gameManager.getTimeManager());
    }

    @Test
    public void testBasicWeatherManagerCreation() {
        WeatherManager weatherManager = new WeatherManager();

        GameManager gameManager = new GameManager(this.rootPane);
        gameManager.setWeatherManager(weatherManager);

        assertEquals(weatherManager, gameManager.getWeatherManager());
    }

    @Test
    public void testPeonInfoDisplayManagerCreation() {
        PeonInformationDisplayManager manager = new PeonInformationDisplayManager();

        GameManager gameManager = new GameManager(this.rootPane);
        gameManager.setPeonInformationDisplayManager(manager);

        assertEquals(manager, gameManager.getPeonInformationDisplayManager());
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
