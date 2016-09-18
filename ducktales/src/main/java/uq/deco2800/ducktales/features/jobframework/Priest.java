package uq.deco2800.ducktales.features.jobframework;

import uq.deco2800.ducktales.features.entities.agententities.Peon;

/**
 * Generates the Priest job
 * 
 * @author Nicolas Turner (TheFractal on github and Fractal on slack)
 */
public class Priest extends Job {
	
    protected static int requiredStrength = 3;
    protected static int requiredIntelligence = 9;
    protected static int mentorStrength = 5;
    protected static int mentorIntelligence = 14;
    protected static String jobName = "Doctor";
    protected static final JobType JOBTYPE = JobType.PRIEST;
    
    public Priest() {
		super(requiredStrength, requiredIntelligence, 
                        mentorStrength, mentorIntelligence, 
                        jobName, JOBTYPE);
    }

    /**
     * Defines whether or not the given peon is 
     * qualified to become a mentor as a Priest
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