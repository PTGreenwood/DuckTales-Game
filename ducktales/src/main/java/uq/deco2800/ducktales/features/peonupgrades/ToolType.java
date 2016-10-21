package uq.deco2800.ducktales.features.peonupgrades;

import uq.deco2800.ducktales.features.jobframework.JobType;
/**
 * Contains and describes the attributes for each level of tool
 * also describes the resource cost for each resource
 * @author Daniel Leong
 */
public enum ToolType {
        AXElevel1("axe", JobType.LUMBERJACK,11, 10, 5, 0, 10, true),
        AXElevel2("axe", JobType.LUMBERJACK,16,20, 10, 0, 20, false),
        AXElevel3("axe", JobType.LUMBERJACK,26,100, 30, 0, 50, false),
        
        HAMMERlevel1("axe", JobType.BUILDER,5, 10, 5, 0, 10, true),
        HAMMERlevel2("axe", JobType.BUILDER,10, 50, 20, 0, 30, false),
        HAMMERlevel3("axe", JobType.BUILDER,20.0, 100, 35, 0, 70, false),
        
        PICKlevel1("axe", JobType.MINER,6, 10, 5, 0, 10, true),
        PICKlevel2("axe", JobType.MINER,11, 30, 15, 0, 25, false),
        PICKlevel3("axe", JobType.MINER,21, 80, 40, 0, 60, false),
        
        HOElevel1("axe", JobType.FARMER,11, 10, 5, 0, 10, true),
        HOElevel2("axe", JobType.FARMER,16, 20, 10, 0, 20, false),
        HOElevel3("axe", JobType.FARMER,21, 100, 30, 0, 50, false),
        
        CLOTHESlevel1("axe", JobType.PRIEST,6, 10, 5, 0, 10, true),
        CLOTHESleve2("axe", JobType.PRIEST,11, 20, 0, 0, 60, false),
        CLOTHESleve3("axe", JobType.PRIEST,21, 80, 0, 0, 130, false),
        
        TONGSlevel1("axe", JobType.BLACKSMITH,6.0, 10, 5, 0, 10, true),
        TONGSleve2("axe", JobType.BLACKSMITH,11, 20, 0, 0, 60, false),
        TONGSleve3("axe", JobType.BLACKSMITH,21, 80, 0, 0, 130, false),
        
        INSTRUMENTSlevel1("axe", JobType.DOCTOR, 6, 10, 5, 0, 10, true),
        INSTRUMENTSleve2("axe", JobType.DOCTOR, 11, 20, 0, 0, 60, false),
        INSTRUMENTSleve3("axe", JobType.DOCTOR, 21, 80, 0, 0, 130, false),
        
        ROLLINGPINlevel1("axe", JobType.BAKER, 6, 10, 5, 0, 10, true),
        ROLLINGPINleve2("axe", JobType.BAKER, 11, 20, 0, 0, 60, false),
        ROLLINGPINleve3("axe", JobType.BAKER,21, 80, 0, 0, 130, false),
        
        CHISELlevel1("axe", JobType.MASON,6, 10, 5, 0, 10, true),
        CHISELleve2("axe", JobType.MASON,11, 20, 0, 0, 60, false),
        CHISELleve3("axe", JobType.MASON,21, 80, 0, 0, 130, false),
        
        NOTHING("nothing", JobType.JOBLESS,0.0, 0, 0, 0, 0, true);
        
        private final String name;
        private final JobType job;
        private final double qualificationModifier;
        private final int woodCost;
        private final int metalCost;
        private final int stoneCost;
        private final int foodCost;
        private final boolean craftable;
        
        private ToolType(String name, JobType job, double qualificationModifier, int woodCost, int metalCost, 
        		int stoneCost, int foodCost, boolean craftable){
        	this.name = name;
        	this.job = job;
        	this.qualificationModifier = qualificationModifier;
        	this.woodCost = woodCost;
        	this.metalCost = metalCost;
        	this.stoneCost = stoneCost;
        	this.foodCost = foodCost;
        	this.craftable = craftable;
        }
        
        public String getName(){
        	return this.name;
        }
        public double getQualificationModifier(){
        	return this.qualificationModifier;
        }
        public JobType getJob(){
        	return this.job;
        }
        public int woodCost(){
        	return this.woodCost;
        }
        public int metalCost(){
        	return this.metalCost;
        }
        public int stoneCost(){
        	return this.stoneCost;
        }
        public int foodCost(){
        	return this.foodCost;
        }
        public boolean getCraftable(){
        	return this.craftable;
        }
}