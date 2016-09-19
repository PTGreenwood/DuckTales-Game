package uq.deco2800.ducktales.features.market;

/**
 * Supplies the market view with dummy data, in order to implement and test
 * the UI
 * 
 * @author Mark Belonogoff
 *
 */
public class MocTrade {
	
	/** The name of the item type in the trades */
	private String itemName;
	
	/** The amount of the item type in the trades */
	private Integer quantity;
	
	/** The user who posted the trade */
	private String userName;
	
	/** File path to the item's picture */
	private String itemPictureFilePath;
	
	/**
	 * Constructs a MocTrade instance given the item name, quantity, 
	 * userName and file path to the item's marketplace picture.
	 * 
	 * @param itemName The name of the item type in the trades
	 * 
	 * @param quantity The amount of the item type in the trades
	 * 
	 * @param userName user who posted the trade
	 * 
	 * @param itemPictureFilePath File path to the item's picture
	 */
	public MocTrade(String itemName, Integer quantity, 
			String userName, String itemPictureFilePath) {
		
		this.itemName = itemName;
		this.quantity = quantity;
		this.userName = userName;
		this.itemPictureFilePath = itemPictureFilePath;
		
	}
	
	/**
	 * Returns the item Name in the MocTrade.
	 * @return the item's name
	 */
	public String getItemName() {
		return this.itemName;
	}
	
	/**
	 * Returns the quantity of the item type in the MocTrade.
	 * @return The quantity
	 */
	public Integer getQuantity() {
		return this.quantity;
	}
	
	/**
	 * Returns the userName currently logged in person..
	 * @return The username of the logged in user.
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * Returns the file path to the item's marketplace picture.
	 * @return file path to the marketplace picture
	 */
	public String getItemPictureFilePath() {
		return this.itemPictureFilePath	;
	}
	

}
