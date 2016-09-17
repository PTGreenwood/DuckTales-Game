package uq.deco2800.ducktales.features.market;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Model that stores marketplace data
 * @author Mark Belonogoff
 *
 */
public class MarketModel {
	
	//TODO: Add data structure for items: id, name, function to add / delete
	
	private List<MocTrade> allTrades;
	
	private HashMap<String, Integer> userInventory;
	
	public MarketModel() {
		
		// Create a list of MocTrades for All Trades
		List<String> itemNames = new ArrayList<String>();
		
		itemNames.add("stone");
		itemNames.add("lumber");
		itemNames.add("meat");
		
		List<Integer> quantities = new ArrayList<Integer>();
		
		for (int i = 1; i < 10; i++) {
			quantities.add(i);
		}
		
		List<String> userNames = new ArrayList<String>();
		
		userNames.add("JSmith");
		userNames.add("KanyeNest");
		userNames.add("ABeakman");
		
		allTrades = new ArrayList<MocTrade>();
		
		for (int i = 0; i < 6; i++) {
			// create some moc trades
			
			String mocItem = itemNames.get(i % itemNames.size());
			
			Integer mocQuantity = quantities.get(i % quantities.size());
			
			String mocUserName = userNames.get(i % userNames.size());
			
			String mocItemPictureFilePath = null;
			
			MocTrade mocTrade = new MocTrade(mocItem, mocQuantity, 
					mocUserName, mocItemPictureFilePath);
			
			allTrades.add(mocTrade);
			
		}
		
		// Create a HashMap of the user's inventory
		userInventory = new HashMap<String, Integer>();
		for (int i = 0; i < itemNames.size(); i++) {
			int amount = 1 + i;
			userInventory.put(itemNames.get(i), amount);
		}
		
	}
	
	
	public List<MocTrade> getAllTrades() {
		return new ArrayList<MocTrade>(allTrades);
	}
	
	public HashMap<String, Integer> getUserInventory() {
		return userInventory;
	}
	
	public Set<String> getUserInventoryItemNames() {
		return userInventory.keySet();
	}
	
	public int getInventoryAmountForItem(String item) {
		
		return userInventory.get(item);
		
	}
	
	
	

}