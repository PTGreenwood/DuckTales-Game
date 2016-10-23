package uq.deco2800.ducktales.features.inventory;

/**
 * @author Benson & Jake 
 * 		   A class for
 *         retrieving and updating the amount of different resources, “Amount”
 *         field should be any whole number, positive or negative (depending if
 *         adding or spending)
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
	 * @param timber:
	 *            the value for the timber resource type.
	 * @param meat:
	 *            the value for the meat resource type.
	 * @param wool:
	 *            the value for the wool resource type.
	 * @param feather:
	 *            the value for the feather resource type.
	 * @param rock:
	 *            the value for the rock resource type.
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

	public class InsufficientResourceException extends Exception {
		public InsufficientResourceException(String message) {
			super(message);
		}
	}

	/**
	 * Sets the timber amount to be the amount specified
	 * 
	 * @param amount:
	 *            an integer that is greater then 0 to be the current and set
	 *            value of timber.
	 */
	public void setTimberAmount(int amount) {
		this.timberAmount = amount;
	}

	/**
	 * Returns the current value for the Timber resource.
	 * 
	 * @return Returns the current value for the Timber resource.
	 */
	public int getTimberAmount() {
		return this.timberAmount;
	}

	/**
	 * Update the value for the timber resource value when spending or
	 * accumulation occurs.
	 * 
	 * @param amount
	 *            The amount of spending or accumulation that has occurred. Can
	 *            be a positive or negative whole number.
	 * 
	 * @throws InsufficientResourceException
	 *             throws an exception when the updating of the value will cause
	 *             the amount of that resource type to fall below zero.
	 */
	public void updateTimberAmount(int amount) throws InsufficientResourceException{

		/*
		 * Checks if the change in the timber amount will cause the value to
		 * fall below zero.
		 */
		if (this.getTimberAmount() + amount < 0) {
			throw new InsufficientResourceException("Insufficient resources " + "for update");

		}

		this.timberAmount += amount;
	}

	/**
	 * Sets the meat amount to be the amount specified
	 * 
	 * @param amount:
	 *            an integer that is greater then 0 to be the current and set
	 *            value of meat.
	 */
	public void setMeatAmount(int amount) {
		this.meatAmount = amount;
	}

	/**
	 * Returns the current value for the Meat resource.
	 * 
	 * @return Returns the current value for the Meat resource.
	 */
	public int getMeatAmount() {
		return this.meatAmount;
	}

	/**
	 * Update the value for the meat resource value when spending or
	 * accumulation occurs.
	 * 
	 * @param amount
	 *            The amount of spending or accumulation that has occurred. Can
	 *            be a positive or negative whole number.
	 * 
	 * @throws InsufficientResourceException
	 *             throws an exception when the updating of the value will cause
	 *             the amount of that resource type to fall below zero.
	 */
	public void updateMeatAmount(int amount) throws InsufficientResourceException {

		/*
		 * Checks if the change in the meat amount will cause the value to fall
		 * below zero.
		 */
		if (this.getMeatAmount() + amount < 0) {
			throw new InsufficientResourceException("Insufficient resources " + "for update");
		}

		this.meatAmount += amount;
	}

	/**
	 * Sets the wool amount to be the amount specified
	 * 
	 * @param amount:
	 *            an integer that is greater then 0 to be the current and set
	 *            value of wool.
	 */
	public void setWoolAmount(int amount) {
		this.woolAmount = amount;
	}

	/**
	 * Returns the current value for the Wool resource.
	 * 
	 * @return Returns the current value for the Wool resource.
	 */
	public int getWoolAmount() {
		return this.woolAmount;
	}

	/**
	 * Update the value for the wool resource value when spending or
	 * accumulation occurs.
	 * 
	 * @param amount
	 *            The amount of spending or accumulation that has occurred. Can
	 *            be a positive or negative whole number.
	 * 
	 * @throws InsufficientResourceException
	 *             throws an exception when the updating of the value will cause
	 *             the amount of that resource type to fall below zero.
	 */
	public void updateWoolAmount(int amount) throws InsufficientResourceException {

		/*
		 * Checks if the change in the wool amount will cause the value to fall
		 * below zero.
		 */
		if (this.getWoolAmount() + amount < 0) {
			throw new InsufficientResourceException("Insufficient resources " + "for update");
		}

		this.woolAmount += amount;
	}

	/**
	 * Sets the feather amount to be the amount specified
	 * 
	 * @param amount:
	 *            an integer that is greater then 0 to be the current and set
	 *            value of feather.
	 */
	public void setFeatherAmount(int amount) {
		this.featherAmount = amount;
	}

	/**
	 * Returns the current value for the Feather resource.
	 * 
	 * @return Returns the current value for the Feather resource.
	 */
	public int getFeatherAmount() {
		return this.featherAmount;
	}

	/**
	 * Update the value for the feather resource value when spending or
	 * accumulation occurs.
	 * 
	 * @param amount
	 *            The amount of spending or accumulation that has occurred. Can
	 *            be a positive or negative whole number.
	 * 
	 * @throws InsufficientResourceException
	 *             throws an exception when the updating of the value will cause
	 *             the amount of that resource type to fall below zero.
	 */
	public void updateFeatherAmount(int amount) throws InsufficientResourceException {

		/*
		 * Checks if the change in the feather amount will cause the value to
		 * fall below zero.
		 */
		if (this.getFeatherAmount() + amount < 0) {
			throw new InsufficientResourceException("Insufficient resources " + "for update");
		}

		this.featherAmount += amount;
	}

	/**
	 * Sets the stone amount to be the amount specified
	 * 
	 * @param amount:
	 *            an integer that is greater then 0 to be the current and set
	 *            value of stone.
	 */
	public void setStoneAmount(int amount) {
		this.stoneAmount = amount;
	}

	/**
	 * Returns the current value for the Stone resource.
	 * 
	 * @return Returns the current value for the Stone resource.
	 */
	public int getStoneAmount() {
		return this.stoneAmount;
	}

	/**
	 * Update the value for the stone resource value when spending or
	 * accumulation occurs.
	 * 
	 * @param amount
	 *            The amount of spending or accumulation that has occurred. Can
	 *            be a positive or negative whole number.
	 * 
	 * @throws InsufficientResourceException
	 *             throws an exception when the updating of the value will cause
	 *             the amount of that resource type to fall below zero.
	 */
	public void updateStoneAmount(int amount) throws InsufficientResourceException {

		/*
		 * Checks if the change in the stone amount will cause the value to fall
		 * below zero.
		 */
		if (this.getStoneAmount() + amount < 0) {
			throw new InsufficientResourceException("Insufficient resources " + "for update");
		}

		this.stoneAmount += amount;
	}

}
