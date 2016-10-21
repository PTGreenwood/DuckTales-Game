package uq.deco2800.ducktales.features.inventory;

import uq.deco2800.ducktales.features.entities.worldentities.WorldEntity;

/**
 * A class for retrieving and updating the amount of different resources
 * 
 * @author Benson & Jake
 */

public class InventoryManager {

    
    public int timberAmount = 0;
    public int meatAmount = 0;
    public int woolAmount = 0;
    public int featherAmount = 0;
    public int stoneAmount = 0;
    

    /**
	 * Main constructor of the Inventory Manager class.
	 * 
	 * @param timber: the value for the timber resource type.
	 * @param meat: the value for the meat resource type.
	 * @param wool: the value for the wool resource type.
	 * @param feather: the value for the feather resource type.
	 * @param rock: the value for the rock resource type.
	 * 
	 */
    
    public InventoryManager(int timber, int meat, int wool, int feather, int rock) {
        
    	/* Initialize a inventory container */
        this.timberAmount = timber;
        this.meatAmount = meat;
        this.woolAmount = wool;
        this.featherAmount = feather;
        this.stoneAmount = rock;
    }

    /**
	 * Returns the current value for the Timber resource.
	 * 
	 * @return Returns the current value for the Timber resource.
	 */
    public int getTimberAmount(){
        return this.timberAmount;
    }

    /**
	 * Update the value for the timber resource value when spending or
	 * accumulation occurs.
	 * 
	 * @param amount
	 * 			The amount of spending or accumulation that has occurred. Can
	 * 			be a positive or negative whole number.
	 * 
	 * @throws Exception
	 * 			throws an exception when the updating of the value will cause
	 * 			the amount of that resource type to fall below zero.
	 */
    public void updateTimberAmount(int amount) throws Exception {
    	
    	/* 
    	 * Checks if the change in the timber amount will cause the value to
    	 * fall below zero.
    	 */
    	if (this.getTimberAmount() + amount < 0) {
    		throw new Exception();	
    	}
    	
    	this.timberAmount += amount;	
    }
    
    
    /**
   	 * Returns the current value for the Meat resource.
   	 * 
   	 * @return Returns the current value for the Meat resource.
   	 */
    public int getMeatAmount(){
        return this.meatAmount;
    }

    /**
	 * Update the value for the meat resource value when spending or
	 * accumulation occurs.
	 * 
	 * @param amount
	 * 			The amount of spending or accumulation that has occurred. Can
	 * 			be a positive or negative whole number.
	 * 
	 * @throws Exception
	 * 			throws an exception when the updating of the value will cause
	 * 			the amount of that resource type to fall below zero.
	 */
    public void updateMeatAmount(int amount) throws Exception {
    	
    	/* 
    	 * Checks if the change in the meat amount will cause the value to
    	 * fall below zero.
    	 */
    	if (this.getMeatAmount() + amount < 0) {
    		throw new Exception();	
    	}
    	
    	this.meatAmount += amount;	
    }
    
    
    /**
   	 * Returns the current value for the Wool resource.
   	 * 
   	 * @return Returns the current value for the Wool resource.
   	 */
    public int getWoolAmount(){
        return this.woolAmount;
    }

    /**
	 * Update the value for the wool resource value when spending or
	 * accumulation occurs.
	 * 
	 * @param amount
	 * 			The amount of spending or accumulation that has occurred. Can
	 * 			be a positive or negative whole number.
	 * 
	 * @throws Exception
	 * 			throws an exception when the updating of the value will cause
	 * 			the amount of that resource type to fall below zero.
	 */
    public void updateWoolAmount(int amount) throws Exception {
    	
    	/* 
    	 * Checks if the change in the wool amount will cause the value to
    	 * fall below zero.
    	 */
    	if (this.getWoolAmount() + amount < 0) {
    		throw new Exception();	
    	}
    	
    	this.woolAmount += amount;	
    }
    
    
    /**
   	 * Returns the current value for the Feather resource.
   	 * 
   	 * @return Returns the current value for the Feather resource.
   	 */
    public int getFeatherAmount(){
        return this.featherAmount;
    }

    /**
	 * Update the value for the feather resource value when spending or
	 * accumulation occurs.
	 * 
	 * @param amount
	 * 			The amount of spending or accumulation that has occurred. Can
	 * 			be a positive or negative whole number.
	 * 
	 * @throws Exception
	 * 			throws an exception when the updating of the value will cause
	 * 			the amount of that resource type to fall below zero.
	 */
    public void updateFeatherAmount(int amount) throws Exception {
    	
    	/* 
    	 * Checks if the change in the feather amount will cause the value to
    	 * fall below zero.
    	 */
    	if (this.getFeatherAmount() + amount < 0) {
    		throw new Exception();	
    	}
    	
    	this.featherAmount += amount;	
    }
    
    
    /**
   	 * Returns the current value for the Stone resource.
   	 * 
   	 * @return Returns the current value for the Stone resource.
   	 */
    public int getStoneAmount(){
        return this.stoneAmount;
    }

    /**
	 * Update the value for the stone resource value when spending or
	 * accumulation occurs.
	 * 
	 * @param amount
	 * 			The amount of spending or accumulation that has occurred. Can
	 * 			be a positive or negative whole number.
	 * 
	 * @throws Exception
	 * 			throws an exception when the updating of the value will cause
	 * 			the amount of that resource type to fall below zero.
	 */
    public void updateStoneAmount(int amount) throws Exception {
    	
    	/* 
    	 * Checks if the change in the stone amount will cause the value to
    	 * fall below zero.
    	 */
    	if (this.getStoneAmount() + amount < 0) {
    		throw new Exception();	
    	}
    	
    	this.stoneAmount += amount;	
    }
    
}
