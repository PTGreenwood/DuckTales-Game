package uq.deco2800.ducktales.features.missions;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.stage.Stage;

public class MissionHandlerTest extends ApplicationTest {

	
	/**
	 *  CHeck image has right URL
	 */
	@Test
	public void missionImageTest() {
		
		MissionHandler missionHandler = new MissionHandler();
		
		String actualImageURL = "/missions/boxUnchecked.png";
		
		for(int i = 0; i < 8; i++) {
			assertTrue(missionHandler.getmissionImageCompleted(i).impl_getUrl().contains(actualImageURL));
		}
		
	}
	
	/**
	 * Check getCountCompletedMission returns right value
	 */
	@Test
	public void getCountCompletedMissionsTest() {
		MissionHandler missionHandler = new MissionHandler();
		
		int countNumberOfZeros = 0;
		for(int i = 0; i < 8; i++) {
			if (missionHandler.getCountCompletedMissions()[i] == 1) {
				countNumberOfZeros += 1;
			}
		}
		missionHandler.countNumberOfCompletedMissions();
		assertTrue(missionHandler.getNumberOfCompletedMissions() == countNumberOfZeros);
	}
	
	/**
	 * Check missionImageCompeted method returns right Image
	 */
	@Test
	public void missionImageCompletedTest() {
		MissionHandler missionHandler = new MissionHandler();
		missionHandler.missionImageCompleted(0);
		String expectedImageURL = missionHandler.getmissionImageCompleted(0).impl_getUrl();
		
		String actualImageURL = "/missions/boxChecked.png";
		
		assertTrue(expectedImageURL.contains(actualImageURL));
	}
	
	/**
	 * Check instance in the class works properly
	 */
	@Test
	public void singletonTest() {
		MissionHandler missionHandler = MissionHandler.getInstance();
		assertTrue(missionHandler.equals(MissionHandler.getInstance()));
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
	}

	
	
}
