package uq.deco2800.ducktales.features.achievements;



import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.threats.ThreatManager;
import uq.deco2800.ducktales.features.inventory.InventoryManager;
import uq.deco2800.ducktales.features.level.LevelHandler;
import uq.deco2800.ducktales.features.missions.MissionHandler;

/**
 * Contains all achievement methods.
 * 
 * @author Naehyung Kim and Justin Kuhnel
 * 
 */
public class AchievementHandler {
	private static final AchievementHandler INSTANCE = new AchievementHandler();
	
	/** Achievement Score */
	private int intAchieve;
	
	private LevelHandler levelHandler = LevelHandler.getInstance();
	private InventoryManager inventoryManager;
	private World world;
	public int achievementToggleWood = 0;
	public int achievementToggleOres = 0;
	public int achievementToggleFood = 0;
	public int achievementTogglePeons = 0;
	public int achievementToggleThreats = 0;
	/**
	 * Constructor of {@link Achievement}.
	 * 
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static AchievementHandler getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Main constructor of {@link Achievement} class
	 * 
	 */
	public AchievementHandler() {
		this.intAchieve = 0;		
	}
	
	/**
	 * Return achievement score
	 * 
	 * @return achievement score
	 */
	public int getAchieve() {
		return this.intAchieve;
	}
	
	/**
	 * Set achievement score
	 * 
	 * @param intAchieve
	 */
	public void setAchieve(int intAchieve) {
		this.intAchieve = intAchieve;
	}
	
	
	/**Sets value for varying difficulties of achievements, 
	for each specific difficulty adds specified value to the achievement score */
	public void achieveVeryEasy() {
		this.intAchieve = this.intAchieve + 10;
	}
	
    public void achieveEasy() {
	    this.intAchieve = this.intAchieve + 25;
    }
    
    public void achieveMedium() {
	    this.intAchieve = this.intAchieve + 50;
    }
    
    public void achieveHard() {
	    this.intAchieve = this.intAchieve + 75;
    }
    
    public void achieveVeryHard() {
	    this.intAchieve = this.intAchieve + 100;
    }
    
    
    /**
     * Contains all achievements.
     * 
     * @author Justin Kuhnel
     * @throws Exception 
     * 
     */
   public void achievementHolder() throws Exception {
	   if(MissionHandler.numberOfCompletedMissions == 1)
	    {
	    this.achieveVeryEasy();
	    }
	    
	    if(MissionHandler.numberOfCompletedMissions == 3)
	    {
	    this.achieveEasy();
	    }
	    if(MissionHandler.numberOfCompletedMissions == 5)
	    {
	    this.achieveMedium();
	    }
	    if(MissionHandler.numberOfCompletedMissions == 15)
	    {
	    this.achieveHard();
	    }
	    if(MissionHandler.numberOfCompletedMissions == 25)
	    {
	    this.achieveVeryHard();
	    }
	    if(MissionHandler.numberOfCompletedMissions == 50)
	    {
	    //some award, resource boost or multiplier, possible duck god or god skin
	    }
	    if(levelHandler.getLevel() == 1)
	    {
	    	this.achieveVeryEasy();
	    }
	    if(levelHandler.getLevel() == 5)
	    {
	    	this.achieveEasy();
	    }
	    if(levelHandler.getLevel() == 10)
	    {
	    	this.achieveMedium();
	    }
	    if(levelHandler.getLevel() == 15)
	    {
	    	this.achieveHard();
	    }
	    if(levelHandler.getLevel() == 25)
	    {
	    	this.achieveVeryHard();
	    }
	    if(levelHandler.getLevel() == 1)
	    {
	    	inventoryManager.updateTimberAmount(10);
	    	inventoryManager.updateMeatAmount(10);
	    	inventoryManager.updateWoolAmount(10);
	    	inventoryManager.updateFeatherAmount(10);
	    	inventoryManager.updateStoneAmount(10);
	    }

	   
	    /** Selects which achievement to run based upon the achievement toggle value
	    * before moving on to the next toggle value**/
	     
	    if(inventoryManager.getTimberAmount() >= 10 && achievementToggleWood == 0)
	    {
	    	this.achieveVeryEasy();
	    	achievementToggleWood ++;
	    }
	    else if(inventoryManager.getTimberAmount() >= 150 && achievementToggleWood == 1){
	    	this.achieveEasy();
	    	achievementToggleWood ++;
	    }
	    else if(inventoryManager.getTimberAmount() >= 300 && achievementToggleWood == 2){
	    	this.achieveMedium();
	    	achievementToggleWood ++;
	    }
	    else if(inventoryManager.getTimberAmount() >= 750 && achievementToggleWood == 3){
	    	this.achieveHard();
	    	achievementToggleWood ++;
	    }
	    else if(inventoryManager.getTimberAmount() >= 2500 && achievementToggleWood == 4){
	    	this.achieveVeryHard();
	    	
	    }
	   
	    /** Selects which achievement to run based upon the achievement toggle value
	     * before moving on to the next toggle value**/
	    if(inventoryManager.getStoneAmount() >= 10 && achievementToggleWood == 0)
	    {
	    	this.achieveVeryEasy();
	    	achievementToggleOres ++;
	    }
	    else if(inventoryManager.getStoneAmount() >= 150 && achievementToggleWood == 1){
	    	this.achieveEasy();
	    	achievementToggleOres ++;
	    }
	    else if(inventoryManager.getStoneAmount() >= 300 && achievementToggleWood == 2){
	    	this.achieveMedium();
	    	achievementToggleOres ++;
	    }
	    else if(inventoryManager.getStoneAmount() >= 750 && achievementToggleWood == 3){
	    	this.achieveHard();
	    	achievementToggleOres ++;
	    }
	    else if(inventoryManager.getStoneAmount() >= 2500 && achievementToggleWood == 4){
	    	this.achieveVeryHard();
	    	
	    }
	    
	    /** Selects which achievement to run based upon the achievement toggle value 
	     * before moving on to the next toggle value**/
	    if(inventoryManager.getMeatAmount() >= 10 && achievementToggleWood == 0)
	    {
	    	this.achieveVeryEasy();
	    	achievementToggleFood ++;
	    }
	    else if(inventoryManager.getMeatAmount() >= 150 && achievementToggleWood == 1){
	    	this.achieveEasy();
	    	achievementToggleFood ++;
	    }
	    else if(inventoryManager.getMeatAmount() >= 300 && achievementToggleWood == 2){
	    	this.achieveMedium();
	    	achievementToggleFood ++;
	    }
	    else if(inventoryManager.getMeatAmount() >= 750 && achievementToggleWood == 3){
	    	this.achieveHard();
	    	achievementToggleFood ++;
	    }
	    else if(inventoryManager.getMeatAmount() >= 2500 && achievementToggleWood == 4){
	    	this.achieveVeryHard();
	    	inventoryManager.updateTimberAmount(50);
	    	inventoryManager.updateStoneAmount(50);
	    	inventoryManager.updateMeatAmount(100);
	    }
	    
	    if(world.getNumberOfPeons() == 1 && achievementTogglePeons == 0){
	    	this.achieveVeryEasy();
	    	achievementTogglePeons ++;
	    }
	    else if(world.getNumberOfPeons() == 10 && achievementTogglePeons == 1){
	    	this.achieveEasy();
	    	achievementTogglePeons ++;
	    }
	    else if(world.getNumberOfPeons() == 25 && achievementTogglePeons == 2){
	    	this.achieveMedium();
	    	achievementTogglePeons ++;
	    }
	    else if(world.getNumberOfPeons() == 50 && achievementTogglePeons == 3){
	    	this.achieveHard();
	    	achievementTogglePeons ++;
	    }
	    
	    if(ThreatManager.returnEnemies().equals(1) && achievementToggleThreats == 0){
	    	this.achieveMedium();
	    }
	    else if(ThreatManager.returnEnemies().equals(5) && achievementToggleThreats == 1){
	    	this.achieveVeryHard();
	    }
	  
   }
   
}
