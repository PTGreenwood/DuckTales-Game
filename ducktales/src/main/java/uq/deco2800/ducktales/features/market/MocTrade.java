package uq.deco2800.ducktales.features.market;

public class MocTrade {
	
	private String itemName;
	private Integer quantity;
	private String userName;
	private String itemPictureFilePath;
	
	
	public MocTrade(String itemName, Integer quantity, 
			String userName, String itemPictureFilePath) {
		
		this.itemName = itemName;
		this.quantity = quantity;
		this.userName = userName;
		this.itemPictureFilePath = itemPictureFilePath;
		
	}
	
	
	public String getItemName() {
		return this.itemName;
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getItemPictureFilePath() {
		return this.itemPictureFilePath	;
	}
	

}
