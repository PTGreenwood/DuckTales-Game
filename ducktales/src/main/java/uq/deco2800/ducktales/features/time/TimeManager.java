package uq.deco2800.ducktales.features.time;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import uq.deco2800.ducktales.GameLoop;
import uq.deco2800.ducktales.features.seasons.SeasonManager;
import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.util.Tickable;

/**
 * This manager controls the time display by retrieving time info from GameTime
 *
 * Created on 9/09/2016.
 */

public class TimeManager extends SecondaryManager implements Initializable, Tickable {

	/** The root pane for all the time display elements */
	@FXML
	private AnchorPane timeDisplay;
	@FXML
	private Text timeDisplayText;
	@FXML
	private Text dayDisplayText;
	@FXML
	private Text temperatureDisplayText;
	@FXML
	private Button timePause;
	@FXML
	private Button timePlay;
	@FXML
	private Button timeFastForward;
	@FXML
	private Button timeDoubleFastForward;

	/* The model for the game time */
	private GameTime gameTime;
	private int seasonNumber;
	private int previousHour;
	private int previousDay;
	/* Manager for the Seasons ;) */
	public SeasonManager seasonManager;

	/**
	 * This method is called when GameController initializes the time display
	 * using FXMLLoader, and so FXMLLoader will make an instance of this class
	 * and call initialized()
	 *
	 * @param location
	 *            The location of this class
	 * @param resources
	 *            The resources passed to FXMLLoader
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Start the game time
		gameTime = new GameTime();
		seasonManager = new SeasonManager();
		seasonNumber = 0;
		previousHour = gameTime.getHour();
		previousDay = gameTime.getCurrentDay();

	}

	@FXML
	public void pauseGame() {
		GameLoop.justPause();
		timeDisplay.getStylesheets().remove(0);
		timeDisplay.getStylesheets().add(getClass().getResource("/time/timeDisplayPauseEvent.css").toExternalForm());
	}

	@FXML
	public void playGame() {
		GameLoop.justPlay();
		GameLoop.setSpeedModifier(1);
		timeDisplay.getStylesheets().remove(0);
		timeDisplay.getStylesheets().add(getClass().getResource("/time/timeDisplayNoEvents.css").toExternalForm());
		System.out.println("Speed 1x"); // set time scale to default
	}

	@FXML
	public void fastForwardGame() {
		GameLoop.setSpeedModifier(1.5);
		timeDisplay.getStylesheets().remove(0);
		timeDisplay.getStylesheets().add(getClass().getResource("/time/timeDisplay1.5xEvent.css").toExternalForm());
		System.out.println("Speed 1.5x"); // set time scale to 1.5x
	}

	@FXML
	public void doubleFastForwardGame() {
		GameLoop.setSpeedModifier(2.5);
		timeDisplay.getStylesheets().remove(0);
		timeDisplay.getStylesheets().add(getClass().getResource("/time/timeDisplay2.5xEvents.css").toExternalForm());
		System.out.println("Speed 2.5x"); // set time scale to 2.5x
	}

	@Override
	public void tick() {
		gameTime.tick();
		// Display the new time\

		final int currentDay = gameTime.getCurrentDay();
		final int currentHour = gameTime.getHour();
		final String currentMinute = String.format("%02d", gameTime.getMinute());

		final int currentTemperature = this.getSeasonManager().getCurrentSeason().getCurrentTemperature();
		final String degreeSymbol = "\u00b0";

		// Variable to hold the current Season Number to get the appropriate
		// season name from the
		// season list held in seasonManager.getSeasonList();
		if (gameTime.getSeasonalDayTracker() > 20) {
			if (seasonNumber < 3) {
				seasonNumber++;

			} else {
				seasonNumber = 0;
			}

			this.seasonManager.updateSeason(seasonNumber);

			gameTime.resetTracker();

		}

		// Checking to update temperature on gameTick
		if (currentHour > this.previousHour || currentDay > this.previousDay) {
			this.previousHour = currentHour;
			this.previousDay = currentDay;
			int randomNumber = (int) Math.floor(Math.random() * 2);
			if ((currentHour < this.seasonManager.getCurrentSeason().getTimeNightFall())
					&& (currentHour > this.seasonManager.getCurrentSeason().getTimeDayBreak())) {
				
				this.seasonManager.updateTemperature(randomNumber, true);
			} else {

				this.seasonManager.updateTemperature(randomNumber, false);
			}
		}

		// this is needed, since this UI update is called from another thread
		// (GameLoop runs on another thread and not the main FXApplication
		// thread)
		// IN REGARDS TO TIME ALL CALL TO UI CHANGES MUST GO INSIDE THIS METHOD
		// CALL

		Platform.runLater(() -> {
			if (currentHour >= 12 && currentHour <= 23) {
				timeDisplayText.setText(currentHour + ":" + currentMinute + "pm");
			} else {
				timeDisplayText.setText(currentHour + ":" + currentMinute + "am");
			}
			dayDisplayText.setText("DAY " + currentDay);
			temperatureDisplayText.setText(currentTemperature + "" + degreeSymbol + "c");
		});

	}

	/**
	 * Is it night time or day time?
	 * 
	 * @return true if night time. False if day time
	 */
	public boolean isNight() {
		int currentHour = gameTime.getHour();
		int seasonalNightTime = this.getSeasonManager().getCurrentSeason().getTimeNightFall();
		int seasonalDayTime = this.getSeasonManager().getCurrentSeason().getTimeDayBreak();
		
		if ((currentHour >= seasonalNightTime || currentHour <= seasonalDayTime)) {
			return true;
		}

		return false;

	}

	public void setTime(int hour) {
		this.getGameTimeObject().setHour(hour);
	}

	/**
	 * Gets the current gameTime Object This was added in for a test. 
	 * 
	 * @return gameTime - The GameTime object being managed done
	 */
	public GameTime getGameTimeObject() {
		return this.gameTime;
	}

	/**
	 * Sets the seasonManager for the TimeManager class. Will no longer return
	 * null because of instantiations.
	 * 
	 * @param seasonManager
	 *            - The seasonManager that is being managed by Time. - Can and
	 *            should only be accessed through getSeasonManager() method.
	 */
	public void setSeasonManager(SeasonManager seasonManager) {
		this.seasonManager = seasonManager;
	}

	/**
	 * Gets the instantiated SeasonManager created inside TimeManager This will
	 * allow the modification of season data from outside.
	 * 
	 * @return SeasonManager seasonManager - The Currently instantiated
	 *         seasonManager
	 */
	public SeasonManager getSeasonManager() {
		return this.seasonManager;
	}

	/**
	 * Sets an object of GameTime. Used for JUnit testing purposes.
	 * FXML testing and the overridden initialise function causes GameTime
	 * to not be instantated on TimeManager creation.
	 */
	public void setGameTimeObject(GameTime gt) {
		this.gameTime = gt;
	}
}
