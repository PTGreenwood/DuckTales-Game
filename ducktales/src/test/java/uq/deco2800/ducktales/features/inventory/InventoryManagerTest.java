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
    public void getWoodAmount() throws Exception {
        inventory.updateTimberAmount(2);
        assertEquals(2, inventory.getTimberAmount());
        System.out.println("getWoodAmount()");
    }

    @Test
    public void updateWoodAmount() throws Exception {
        inventory.updateTimberAmount(-4);
        assertEquals(0, inventory.getTimberAmount());
        System.out.println("getWoodAmount()");
    }

    @Test
    public void getOresAmount() throws Exception {
        inventory.updateStoneAmount(46);
        assertEquals(46, inventory.getStoneAmount());
        System.out.println("getOresAmount()");
    }

    @Test
    public void updateOresAmount() throws Exception {
        inventory.updateStoneAmount(-5);
        inventory.updateStoneAmount(1);
        assertEquals(1, inventory.getStoneAmount());
        System.out.println("getOresAmount()");
    }

    @Test
    public void getFoodAmount() throws Exception {
        inventory.updateMeatAmount(-10);
        inventory.updateMeatAmount(20);
        assertEquals(20, inventory.getMeatAmount());
        System.out.println("getFoodAmount()");
    }

    @Test
    public void updateFoodAmount() throws Exception {
        inventory.updateMeatAmount(4);
        assertEquals(4, inventory.getMeatAmount());
        System.out.println("getFoodAmount()");
    }

}