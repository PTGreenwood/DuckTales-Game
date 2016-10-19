package uq.deco2800.ducktales.resources;

import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeneralResourceRegisterTest extends ApplicationTest {
	// Retrieve the resource register
	GeneralResourceRegister register = GeneralResourceRegister.getInstance();

	@Test
	public void loadNameTest(){
		GeneralResourceRegister.getInstance();
		// at this point if no exceptions are thrown, name-loading is correct
	}

	@Test
	public void getRandomNameTest() {
		assertNotNull(register.getRandomName());

	}

	@Override
	public void start(Stage stage) throws Exception {

	}
}
