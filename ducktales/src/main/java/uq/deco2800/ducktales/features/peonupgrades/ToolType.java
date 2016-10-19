package uq.deco2800.ducktales.features.peonupgrades;

import uq.deco2800.ducktales.features.jobframework.JobType;
/**
 * Contains and describes the attributes for each tool
 * @author Daniel
 */
public enum ToolType {
        AXE("axe", JobType.LUMBERJACK,11.0),
        NOTHING("nothing", JobType.JOBLESS,0.0);
        
        private final String name;
        private final JobType job;
        private final double qualificationModifier;
        private final int woodCost;
        private final int metalCost;
        private final int stoneCost;
        private final int foodCost;
        
        private ToolType(String name, JobType job, double qualificationModifier, int woodCost, int metalCost, 
        		int stoneCost, int foodCost){
        	this.name = name;
        	this.job = job;
        	this.qualificationModifier = qualificationModifier;
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
}