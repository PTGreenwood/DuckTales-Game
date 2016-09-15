package uq.deco2800.ducktales.features.market;

import java.util.ArrayList;
import java.util.List;

/**
 * Model that stores marketplace data
 * @author Mark Belonogoff
 *
 */
public class MarketModel {
	
	//TODO: Add data structure for items: id, name, function to add / delete
	
	private List<MocTrade> allTrades;
	
	public MarketModel() {
		
		// Create a list of MocTrades
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
		
		for (int i = 0; i < 10; i++) {
			// create some moc trades
			
			String mocItem = itemNames.get(i % itemNames.size());
			
			Integer mocQuantity = quantities.get(i % quantities.size());
			
			String mocUserName = userNames.get(i % userNames.size());
			
			String mocItemPictureFilePath = null;
			
			MocTrade mocTrade = new MocTrade(mocItem, mocQuantity, 
					mocUserName, mocItemPictureFilePath);
			
			allTrades.add(mocTrade);
			
		}
		
		
	}
	
	
	public List<MocTrade> getAllTrades() {
		return new ArrayList<MocTrade>(allTrades);
	}
	
	
	

}