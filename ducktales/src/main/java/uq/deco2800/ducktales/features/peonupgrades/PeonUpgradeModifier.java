package uq.deco2800.ducktales.features.peonupgrades;

//import resources.toolsUpgrade.lumberjack;
//personal notes: peon.tool.axe
//change to doubles
//make things private

public class PeonUpgradeModifier {
<<<<<<< HEAD
	private double BaseLumberRate = 10;
	
	private double BaseStoneRate = 7;
	
	private double BaseMetalRate = 1;
	
	
	//tool modifier for lumberjack
	private void LumberAxe1(){
		BaseLumberRate += 3;
	}
	private void LumberAxe2(){
		BaseLumberRate += 6;
	}
	private void LumberAxe3(){
		BaseLumberRate += 10;
	}
	
	
	private void StoneChisel1(){
		BaseStoneRate += 0;
	}
	private void StoneChisel2(){
		BaseStoneRate += 3;
	}
	private void StoneChisel3(){
		BaseStoneRate += 7;
=======
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
>>>>>>> master
	}
	
	private void MetalPick1(){
		BaseMetalRate += 0;
	}
	private void MetalPick2(){
		BaseMetalRate += 0;
	}
	private void MetalPick3(){
		BaseMetalRate += 0;
	}
	
}
