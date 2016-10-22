package uq.deco2800.ducktales.features.inventory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Jake & Benson
 * 
 *         This class test the methods including set a inventory, get current
 *         resources' amount, updating amount.
 */

public class InventoryManagerTest {
	// * Test initialize a inventory container */
	private InventoryManager inventory = new InventoryManager(0, 0, 0, 0, 0);

	@Test
	// * Tests the get function of inventoryManager class */
	public void getTimberAmountNoChangeTest() throws Exception {
		assertEquals(0, inventory.getTimberAmount());
	}

	@Test
	// * Tests the get and update function of inventoryManager class */
	public void getTimberAmountUpdateTest() throws Exception {
		inventory.updateTimberAmount(2);
		assertEquals(2, inventory.getTimberAmount());
	}
	
	@Test
	/* Tests the update function of inventoryManager class with a 
	 * negative value
	 */
	public void updateTimberAmountNegativeTest() throws Exception {
		inventory.setTimberAmount(20);
		inventory.updateTimberAmount(-4);
		assertEquals(16, inventory.getTimberAmount());
	}

	@Test
	/*
	 * Tests the update function when the update will cause the value to fall
	 * below zero and thus throw an exception.
	 */
	(expected = Exception.class)
	public void updateTimberAmountTest() throws Exception {
		inventory.updateTimberAmount(-4);
	}

	@Test
	// * Tests the get function of inventoryManager class */
	public void getMeatAmountNoChangeTest() throws Exception {
		assertEquals(0, inventory.getMeatAmount());
	}

	@Test
	// * Tests the get and update function of inventoryManager class */
	public void getMeatAmountUpdateTest() throws Exception {
		inventory.updateMeatAmount(2);
		assertEquals(2, inventory.getMeatAmount());
	}
	
	@Test
	/* Tests the update function of inventoryManager class with a 
	 * negative value
	 */
	public void updateMeatAmountNegativeTest() throws Exception {
		inventory.setMeatAmount(20);
		inventory.updateMeatAmount(-4);
		assertEquals(16, inventory.getMeatAmount());
	}

	@Test
	/*
	 * Tests the update function when the update will cause the value to fall
	 * below zero and thus throw an exception.
	 */
	(expected = Exception.class)
	public void updateMeatAmountTest() throws Exception {
		inventory.updateMeatAmount(-4);
	}
	
	@Test
	/* Tests the update function of inventoryManager class with a 
	 * negative value
	 */
	public void updateWoolAmountNegativeTest() throws Exception {
		inventory.setWoolAmount(20);
		inventory.updateWoolAmount(-4);
		assertEquals(16, inventory.getWoolAmount());
	}

	@Test
	// * Tests the get function of inventoryManager class */
	public void getWoolAmountNoChangeTest() throws Exception {
		assertEquals(0, inventory.getWoolAmount());
	}

	@Test
	// * Tests the get and update function of inventoryManager class */
	public void getWoolAmountUpdateTest() throws Exception {
		inventory.updateWoolAmount(2);
		assertEquals(2, inventory.getWoolAmount());
	}

	@Test
	/*
	 * Tests the update function when the update will cause the value to fall
	 * below zero and thus throw an exception.
	 */
	(expected = Exception.class)
	public void updateWoolAmountTest() throws Exception {
		inventory.updateWoolAmount(-4);
	}

	@Test
	/* Tests the update function of inventoryManager class with a 
	 * negative value
	 */
	public void updateFeahterAmountNegativeTest() throws Exception {
		inventory.setFeatherAmount(20);
		inventory.updateFeatherAmount(-4);
		assertEquals(16, inventory.getFeatherAmount());
	}
	
	@Test
	// * Tests the get function of inventoryManager class */
	public void getFeatherAmountNoChangeTest() throws Exception {
		assertEquals(0, inventory.getFeatherAmount());
	}

	@Test
	// * Tests the get and update function of inventoryManager class */
	public void getFeatherAmountUpdateTest() throws Exception {
		inventory.updateFeatherAmount(2);
		assertEquals(2, inventory.getFeatherAmount());
	}

	@Test
	/*
	 * Tests the update function when the update will cause the value to fall
	 * below zero and thus throw an exception.
	 */
	(expected = Exception.class)
	public void updateFeatherAmountTest() throws Exception {
		inventory.updateFeatherAmount(-4);
	}
	
	@Test
	/* Tests the update function of inventoryManager class with a 
	 * negative value
	 */
	public void updateStoneAmountNegativeTest() throws Exception {
		inventory.setStoneAmount(20);
		inventory.updateStoneAmount(-4);
		assertEquals(16, inventory.getStoneAmount());
	}

	@Test
	// * Tests the get function of inventoryManager class */
	public void getStoneAmountNoChangeTest() throws Exception {
		assertEquals(0, inventory.getStoneAmount());
	}

	@Test
	// * Tests the get and update function of inventoryManager class */
	public void getStoneAmountUpdateTest() throws Exception {
		inventory.updateStoneAmount(2);
		assertEquals(2, inventory.getStoneAmount());
	}

	@Test
	/*
	 * Tests the update function when the update will cause the value to fall
	 * below zero and thus throw an exception.
	 */
	(expected = Exception.class)
	public void updateStoneAmountTest() throws Exception {
		inventory.updateStoneAmount(-4);
	}

}