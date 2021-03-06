package uq.deco2800.ducktales.features.jobframework;

import uq.deco2800.ducktales.features.entities.peons.Peon;

/**
 * Generates the Builder job
 * 
 * @author Edward Liao (eduardlio on github and slack)
 */
public class Builder extends Job {
    protected static int requiredStrength = 7;
    protected static int requiredIntelligence = 5;
    protected static int mentorStrength = 14;
    protected static int mentorIntelligence = 10;
    protected static String jobName = "Builder";
    protected static final JobType JOBTYPE = JobType.BUILDER;
    
    public Builder() {
		super(requiredStrength, requiredIntelligence, 
                        mentorStrength, mentorIntelligence, 
                        JOBTYPE);
    }
    public void build(Peon peon){
        // TODO implementation with Buildings
        peon.madeABuilding();
    }
    /**
     * Defines whether or not the given peon is 
     * qualified to become a mentor as a Lumberjack
     * 
     * @param peon
     * @return true iff peon strength >= mentor strength
     *          &&  peon intelligence >= mentor intelligence
     *          &&  peon has chopped 15 trees
     */
    @Override
    public boolean canBeMentor(Peon peon){
        if (peon.getStrength()>= this.getMentorStrength()
                && peon.getIntelligence()>=this.getMentorIntelligence()
                && peon.getBuildingsMade()>=20
                ){
            return true;
        }
        return false;
    }
}
