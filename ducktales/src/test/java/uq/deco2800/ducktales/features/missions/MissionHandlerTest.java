package uq.deco2800.ducktales.features.missions;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.stage.Stage;

public class MissionHandlerTest extends ApplicationTest {

	@Test
	public void missionImageTest() {
		
		MissionHandler missionHandler = new MissionHandler();
		
		String actualImageString = "/missions/boxUnchecked.png";
		
		for(int i = 0; i < 8; i++) {
			assertTrue(missionHandler.getmissionImageCompleted(i).impl_getUrl().contains(actualImageString));
		}
		
	}
	
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
	
	
	@Test
	public void singletonTest() {
		MissionHandler missionHandler = MissionHandler.getInstance();
		assertTrue(missionHandler.equals(MissionHandler.getInstance()));
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
	}

	
	
}
