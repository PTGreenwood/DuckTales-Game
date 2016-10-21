package uq.deco2800.ducktales.features.inventory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ben on 18/9/16.
 * This class test the methods including set a inventory, get current resources' amount,
 * updating amount.
 */
public class InventoryManagerTest {
    //* Test initialize a inventory container */
        private InventoryManager inventory = new InventoryManager(0, 0, 0, 0, 0);


    @Test
    //* Test the get and update function of inventoryManager class */
    public void getWoodAmountTest() throws Exception {
        inventory.updateTimberAmount(2);
        assertEquals(2, inventory.getTimberAmount());
    }

    @Test
    (expected=Exception.class)
    public void updateTimberAmountTest() throws Exception {
    	inventory.updateTimberAmount(-4);
    }

    @Test
    public void getStoneAmountTest() throws Exception {
        inventory.updateStoneAmount(46);
        assertEquals(46, inventory.getStoneAmount());
    }
    
    @Test
    (expected=Exception.class)
    public void updateStoneAmountTest() throws Exception {
    	inventory.updateStoneAmount(-4);
    }

    @Test
    public void getMeatAmountTest() throws Exception {
        inventory.updateMeatAmount(20);
        assertEquals(20, inventory.getMeatAmount());
    }

    @Test
    (expected=Exception.class)
    public void updateMeatAmountTest() throws Exception {
    	inventory.updateStoneAmount(-4);
    }

}