package uq.deco2800.ducktales.features.peonupgrades;

/**
 * Contains and describes the attributes for each tool
 * @author Daniel
 */
public enum ToolType {
        AXE("axe", "LUMBERJACK",1.0),
        NOTHING("nothing", "JOBLESS",0.0);
        
        private final String name;
        private final String job;
        private final double qualificationModifier;
        
        private ToolType(String name, String job, double qualificationModifier){
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
        public String getJob(){
        	return this.job;
        }
        
}