package uq.deco2800.ducktales.features.peonupgrades;

import java.util.ArrayList;
import java.util.Arrays;

import uq.deco2800.ducktales.features.jobframework.JobType;
/**
 * Contains and describes the attributes for each level of tool
 * also describes the resource cost for each resource
 * @author Daniel Leong
 */
public enum ToolType {
        AXElevel1("Bronze", 0, 0, JobType.LUMBERJACK, 11.0, 10, 5, 0, 10, false),
        AXElevel2("Silver", 1, 0, JobType.LUMBERJACK, 16.0,20, 10, 0, 20, true),
        AXElevel3("Gold", 2, 0, JobType.LUMBERJACK, 26.0,100, 30, 0, 50, true),

        PICKlevel1("Bronze", 0, 1, JobType.MINER, 6.0, 10, 5, 0, 10, false),
        PICKlevel2("Silver", 1, 1, JobType.MINER, 11.0, 30, 15, 0, 20, true),
        PICKlevel3("Gold", 2, 1, JobType.MINER, 21.0, 80, 40, 0, 60, true),
        
        HAMMERlevel1("Bronze", 0, 2, JobType.BUILDER, 5.0, 10, 5, 0, 10, false),
        HAMMERlevel2("Silver", 1, 2, JobType.BUILDER, 10.0, 50, 20, 0, 30, true),
        HAMMERlevel3("Gold", 2, 2, JobType.BUILDER, 20.0, 100, 35, 0, 70, true),

        INSTRUMENTSlevel1("Bronze", 0, 3, JobType.DOCTOR, 6.0, 10, 5, 0, 10, false),
        INSTRUMENTSlevel2("Silver", 1, 3, JobType.DOCTOR, 11.0, 20, 0, 0, 60, true),
        INSTRUMENTSlevel3("Gold", 2,  3,JobType.DOCTOR, 21.0, 80, 0, 0, 130, true),
        
        HOElevel1("Bronze", 0, 4, JobType.FARMER, 11.0, 10, 5, 0, 10, false),
        HOElevel2("Silver", 1, 4, JobType.FARMER, 16.0, 20, 10, 0, 20, true),
        HOElevel3("Gold", 2, 4, JobType.FARMER, 21.0, 100, 30, 0, 50, true),
        
        CLOTHESlevel1("Bronze", 0, 5, JobType.TEACHER, 6.0, 10, 5, 0, 10, false),
        CLOTHESlevel2("Silver", 1, 5, JobType.TEACHER, 11.0, 20, 0, 0, 60, true),
        CLOTHESlevel3("Gold", 2, 5, JobType.TEACHER, 21.0, 80, 0, 0, 130, true),

        TONGSlevel1("Bronze", 0, 6, JobType.BLACKSMITH, 6.0, 10, 5, 0, 10, false),
        TONGSlevel2("Silver", 1, 6, JobType.BLACKSMITH, 11.0, 20, 0, 0, 60, true),
        TONGSlevel3("Gold", 2, 6, JobType.BLACKSMITH, 21.0, 80, 0, 0, 130, true),
               
        ROLLINGPINlevel1("Bronze", 0, 7, JobType.BAKER, 6.0, 10, 5, 0, 10, false),
        ROLLINGPINlevel2("Silver", 1, 7, JobType.BAKER, 11.0, 20, 0, 0, 60, true),
        ROLLINGPINlevel3("Gold", 2, 7, JobType.BAKER, 21.0, 80, 0, 0, 130, true),
        
        CHISELlevel1("Bronze", 0, 8, JobType.MASON, 6.0, 10, 5, 0, 10, false),
        CHISELlevel2("Silver", 1, 8, JobType.MASON, 11.0, 20, 0, 0, 60, true),
        CHISELlevel3("Gold", 2, 8, JobType.MASON, 21.0, 80, 0, 0, 130, true),

        HOLINESSlevel1("Bronze", 0, 8, JobType.PRIEST, 0.0, 10, 5, 0, 10, false),
        HOLINESSlevel2("Silver", 1, 8, JobType.PRIEST, 0.0, 20, 0, 0, 60, true),
        HOLINESSlevel3("Gold", 2, 8, JobType.PRIEST, 0.0, 80, 0, 0, 130, true),
        
    	NOTHING("Empty", 0, 9, JobType.JOBLESS, 0.0, 0, 0, 0, 0, false);
    
        private final String name;
        private final JobType job;
        private final int toolLevel;
        private final int arrayNumber;
        private final double qualificationModifier;
        private final int timberCost;
        private final int metalCost;
        private final int stoneCost;
        private final int foodCost;
        private final boolean craftable;
        
        
        
        private ToolType(String name, int toolLevel, int arrayNumber, JobType job, double qualificationModifier, int timberCost, int metalCost, 
        		int stoneCost, int foodCost, boolean craftable){
        	
        	this.name = name;
        	this.toolLevel = toolLevel;
        	this.arrayNumber = arrayNumber;
        	this.job = job;
        	this.qualificationModifier = qualificationModifier;
        	this.timberCost = timberCost;
        	this.metalCost = metalCost;
        	this.stoneCost = stoneCost;
        	this.foodCost = foodCost;
        	this.craftable = craftable;
        	
        	
        }
        
       
        public String getName(){
        	return ""+ this.name;
        }
        public double getQualificationModifier(){
        	return this.qualificationModifier;
        }
        public JobType getJob(){
        	return this.job;
        }
        public int getTimberCost(){
        	return this.timberCost;
        }
        public int getMetalCost(){
        	return this.metalCost;
        }
        public int getStoneCost(){
        	return this.stoneCost;
        }
        public int getFoodCost(){
        	return this.foodCost;
        }
        public boolean getIfCraftable() {
        	return this.craftable;
        }
        public int getToolLevel() {
        	return this.toolLevel;
        }
        public int getNextToolLevel() {
        	if(this.toolLevel < 3 && this.toolLevel >=0) {
        		return this.toolLevel + 1;
        	}
        	//IF out of bounds. return the original tool level.
        	return -1;
        }
        public int getArrayNumber() {
        	return this.arrayNumber;
        }
        
        
}