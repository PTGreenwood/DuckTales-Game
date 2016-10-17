package uq.deco2800.ducktales.features.peonupgrades;

//import resources.toolsUpgrade.lumberjack;
//personal notes: peon.tool.axe
//change to doubles
//make things private

public class PeonUpgradeModifier {
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
