package uq.deco2800.ducktales.features.peonupgrades;

import uq.deco2800.ducktales.features.jobframework.JobType;
/**
 * Contains and describes the attributes for each level of tool
 * also describes the resource cost for each resource
 * @author Daniel Leong
 */
public enum ToolType {
        AXElevel1("axe", JobType.LUMBERJACK,11, 10, 5, 0, 10),
        AXElevel2("axe", JobType.LUMBERJACK,16,20, 10, 0, 20),
        AXElevel3("axe", JobType.LUMBERJACK,26,100, 30, 0, 50),
        
        HAMMERlevel1("axe", JobType.BUILDER,5, 10, 5, 0, 10),
        HAMMERlevel2("axe", JobType.BUILDER,10, 50, 20, 0, 30),
        HAMMERlevel3("axe", JobType.BUILDER,20.0, 100, 35, 0, 70),
        
        PICKlevel1("axe", JobType.MINER,6, 10, 5, 0, 10),
        PICKlevel2("axe", JobType.MINER,11, 30, 15, 0, 20),
        PICKlevel3("axe", JobType.MINER,21, 80, 40, 0, 60),
        
        HOElevel1("axe", JobType.FARMER,11, 10, 5, 0, 10),
        HOElevel2("axe", JobType.FARMER,16, 20, 10, 0, 20),
        HOElevel3("axe", JobType.FARMER,21, 100, 30, 0, 50),
        
        CLOTHESlevel1("axe", JobType.TEACHER,6, 10, 5, 0, 10),
        CLOTHESleve2("axe", JobType.TEACHER,11, 20, 0, 0, 60),
        CLOTHESleve3("axe", JobType.TEACHER,21, 80, 0, 0, 130),
        
        TONGSlevel1("axe", JobType.BLACKSMITH,6.0, 10, 5, 0, 10),
        TONGSleve2("axe", JobType.BLACKSMITH,11, 20, 0, 0, 60),
        TONGSleve3("axe", JobType.BLACKSMITH,21, 80, 0, 0, 130),
        
        INSTRUMENTSlevel1("axe", JobType.DOCTOR, 6, 10, 5, 0, 10),
        INSTRUMENTSleve2("axe", JobType.DOCTOR, 11, 20, 0, 0, 60),
        INSTRUMENTSleve3("axe", JobType.DOCTOR, 21, 80, 0, 0, 130),
        
        ROLLINGPINlevel1("axe", JobType.BAKER, 6, 10, 5, 0, 10),
        ROLLINGPINleve2("axe", JobType.BAKER, 11, 20, 0, 0, 60),
        ROLLINGPINleve3("axe", JobType.BAKER,21, 80, 0, 0, 130),
        
        CHISELlevel1("axe", JobType.MASON,6, 10, 5, 0, 10),
        CHISELleve2("axe", JobType.MASON,11, 20, 0, 0, 60),
        CHISELleve3("axe", JobType.MASON,21, 80, 0, 0, 130),
        
        NOTHING("nothing", JobType.JOBLESS,0.0, 0, 0, 0, 0);
        
        private final String name;
        private final JobType job;
        private final double qualificationModifier;
        private final int timberCost;
        private final int metalCost;
        private final int stoneCost;
        private final int foodCost;
        
        private ToolType(String name, JobType job, double qualificationModifier, int timberCost, int metalCost, 
        		int stoneCost, int foodCost){
        	this.name = name;
        	this.job = job;
        	this.qualificationModifier = qualificationModifier;
        	this.timberCost = timberCost;
        	this.metalCost = metalCost;
        	this.stoneCost = stoneCost;
        	this.foodCost = foodCost;
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
        public int timberCost(){
        	return this.timberCost;
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
}