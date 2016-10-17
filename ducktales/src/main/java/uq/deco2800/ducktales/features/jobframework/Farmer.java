package uq.deco2800.ducktales.features.jobframework;

import uq.deco2800.ducktales.features.entities.peons.Peon;

/**
 * Generates the Farmer job
 * 
 * @author Nicolas Turner (TheFractal on github and Fractal on slack)
 */
public class Farmer extends Job {
    protected static int requiredStrength = 3;
    protected static int requiredIntelligence = 4;
    protected static int mentorStrength = 6;
    protected static int mentorIntelligence = 8;
    protected static String jobName = "Farmer";
    protected static final JobType JOBTYPE = JobType.FARMER;
    
    public Farmer() {
		super(requiredStrength, requiredIntelligence, 
                        mentorStrength, mentorIntelligence, 
                        JOBTYPE);
    }

    /**
     * Defines whether or not the given peon is 
     * qualified to become a mentor as a Farmer
     * 
     * @param peon
     * @return true iff peon strength >= mentor strength
     *          &&  peon intelligence >= mentor intelligence
     */
    @Override
    public boolean canBeMentor(Peon peon){
        if (peon.getStrength()>= this.getMentorStrength()
                && peon.getIntelligence()>=this.getMentorIntelligence()
                ){
            return true;
        }
        return false;
    }
}