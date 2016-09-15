package uq.deco2800.ducktales.features.market;

public class AllTradesController {
	
	private MarketManager marketManager;
	
	public AllTradesController() {
		this.marketManager = MarketVistaNavigator.getMainController();
		System.out.println("AllTradesController created");
	}

}
