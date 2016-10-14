package uq.deco2800.ducktales.features.peonupgrades;

import uq.deco2800.ducktales.features.entities.agententities.Peon;

//import resources.toolsUpgrade.lumberjack;

public class PeonUpgradeModifier {
	public int BaseLumberRate = 1;
	public int NewLumberRate = 0;
	public int BaseStoneRate = 1;
	public int BaseMetalRate = 1;
	
	//tool modifier for lumberjack
	public void LumberAxe1(){
		NewLumberRate = BaseLumberRate + 1;
	}
	public void LumberAxe2(){
		BaseLumberRate += 2;
	}
	public void LumberAxe3(){
		BaseLumberRate += 3;
	}
	
	
	public void StoneChisel1(){
		BaseStoneRate += 0;
	}
	public void StoneChisel2(){
		BaseStoneRate += 1;
	}
	public void StoneChisel3(){
		BaseStoneRate += 2;
	}
	
	
	
}
