package uq.deco2800.ducktales.features.jobframework;

import uq.deco2800.ducktales.features.entities.agententities.Peon;

/**
 * Generates the miner job
 * 
 * @author Nicolas Turner (TheFractal on github and Fractal on slack)
 */
public class Miner extends Job {

	protected static int requiredStrength = 6;
    protected static int requiredIntelligence = 1;
    protected static int mentorStrength = 9;
    protected static int mentorIntelligence = 2;
    protected static String jobName = "Miner";	
    protected static final JobType JOBTYPE = JobType.MINER;

    public Miner() {
		super(requiredStrength, requiredIntelligence, 
                        mentorStrength, mentorIntelligence, 
                        JOBTYPE);
    }

    /**
     * Defines whether or not the given peon is 
     * qualified to become a mentor as a Miner
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
