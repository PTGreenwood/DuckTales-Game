package uq.deco2800.ducktales.features.peonupgrades;

//import resources.toolsUpgrade.lumberjack;

public class PeonUpgradeModifier {
	public int baseLumberRate = 1;
	public int newLumberRate = 0;
	public int baseStoneRate = 1;
	public int baseMetalRate = 1;
	
	//tool modifier for lumberjack
	public void lumberAxe1(){
		newLumberRate = baseLumberRate + 1;
	}
	public void lumberAxe2(){
		baseLumberRate += 2;
	}
	public void lumberAxe3(){
		baseLumberRate += 3;
	}
	
	
	public void stoneChisel1(){
		baseStoneRate += 0;
	}
	public void stoneChisel2(){
		baseStoneRate += 1;
	}
	public void stoneChisel3(){
		baseStoneRate += 2;
	}
	
	
	
}
