package uq.deco2800.ducktales.entities.features.duckgods;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static org.junit.Assert.assertNotEquals;

import uq.deco2800.ducktales.features.duckgods.ChaosGod;
import uq.deco2800.ducktales.features.duckgods.DuckGods;
import uq.deco2800.ducktales.features.duckgods.EarthGod;
import uq.deco2800.ducktales.features.duckgods.FireGod;
import uq.deco2800.ducktales.features.duckgods.LightGod;
import uq.deco2800.ducktales.features.duckgods.MoneyGod;
import uq.deco2800.ducktales.features.duckgods.RainGod;
import uq.deco2800.ducktales.features.duckgods.ThugLifeGod;
import uq.deco2800.ducktales.features.duckgods.WindGod;

public class DuckGodTest {
	
	private DuckGods testGod = new DuckGods("God Name", null, null);
	private DuckGods chaosGod = new ChaosGod("Chaos Name", null, null);
	private DuckGods earthGod = new EarthGod("Earth Name", null, null);
	private DuckGods fireGod = new FireGod("Fire Name", null, null);
	private DuckGods lightGod = new LightGod("Light Name", null, null);
	private DuckGods moneyGod = new MoneyGod("Money Name", null, null);
	private DuckGods rainGod = new RainGod("Rain Name", null, null);
	private DuckGods thugLifeGod = new ThugLifeGod("Thug Life Name", null, null);
	private DuckGods windGod = new WindGod("Wind Name", null, null);
	

	@Test
	// * Tests the getter for a ducks name */
	public void getDuckNameTest() {
		testGod.getDuckName();
		assertEquals("God Name", testGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getDuckNameTestFail() {
		testGod.getDuckName();
		assertNotEquals("Name", testGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getChaosDuckNameTest() {
		chaosGod.getDuckName();
		assertEquals("Chaos Name", chaosGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getChaosDuckNameTestFail() {
		chaosGod.getDuckName();
		assertNotEquals("Name", chaosGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getEarthDuckNameTest() {
		earthGod.getDuckName();
		assertEquals("Earth Name", earthGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getEarthDuckNameTestFail() {
		earthGod.getDuckName();
		assertNotEquals("Name", earthGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getFireDuckNameTest() {
		fireGod.getDuckName();
		assertEquals("Fire Name", fireGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getFireDuckNameTestFail() {
		fireGod.getDuckName();
		assertNotEquals("Name", fireGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getLightDuckNameTest() {
		lightGod.getDuckName();
		assertEquals("Light Name", lightGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getLightDuckNameTestFail() {
		lightGod.getDuckName();
		assertNotEquals("Name", lightGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getMoneyDuckNameTest() {
		moneyGod.getDuckName();
		assertEquals("Money Name", moneyGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getMoneyDuckNameTestFail() {
		moneyGod.getDuckName();
		assertNotEquals("Name", moneyGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getRainDuckNameTest() {
		rainGod.getDuckName();
		assertEquals("Rain Name", rainGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getRainDuckNameTestFail() {
		rainGod.getDuckName();
		assertNotEquals("Name", rainGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getThugLifeDuckNameTest() {
		thugLifeGod.getDuckName();
		assertEquals("Thug Life Name", thugLifeGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getThugLifeDuckNameTestFail() {
		thugLifeGod.getDuckName();
		assertNotEquals("Name", thugLifeGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getWindDuckNameTest() {
		windGod.getDuckName();
		assertEquals("Wind Name", windGod.getDuckName());
	}
	
	@Test
	// * Tests the getter for a ducks name */
	public void getWindDuckNameTestFail() {
		windGod.getDuckName();
		assertNotEquals("Name", windGod.getDuckName());
	}
	
}
