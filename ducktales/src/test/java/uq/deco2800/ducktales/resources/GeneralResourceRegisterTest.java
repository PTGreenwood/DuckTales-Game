package uq.deco2800.ducktales.resources;

import uq.deco2800.ducktales.TestClassWithApplication;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeneralResourceRegisterTest extends TestClassWithApplication{
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
}
