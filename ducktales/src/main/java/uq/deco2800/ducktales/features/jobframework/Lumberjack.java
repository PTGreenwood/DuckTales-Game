package uq.deco2800.ducktales.features.jobframework;

import uq.deco2800.ducktales.features.entities.resourceentities.Tree;
import uq.deco2800.ducktales.features.entities.agententities.Peon;

/**
 * Generates the Lumberjack job
 * 
 * @author Edward Liao (eduardlio on github and slack)
 *
 *I think this is the correct way of doing things. Will need to be checked.
 */
public class Lumberjack extends Job {
    protected static int requiredStrength = 6;
    protected static int requiredIntelligence = 1;
    protected static int mentorStrength = 12;
    protected static int mentorIntelligence = 2;
    protected static String jobName = "Lumberjack";
    protected static JobType JOBTYPE = JobType.LUMBJERJACK;
    public Lumberjack(int requiredStrength, int requiredIntelligence, int mentorStrength, 
            int mentorIntelligence, String jobName, JobType JOBTYPE) {
		super(requiredStrength, requiredIntelligence, 
                        mentorStrength, mentorIntelligence, 
                        jobName, JOBTYPE);
    }
    // chops a tree
    public void chop(Peon peon, Tree tree){
        // the lumber method from Tree.java
        tree.lumber(peon);
        // increase the peon's strength by 2
        peon.StrengthExp(2);
        peon.choppedATree();
        if (peon.getTreesChopped()>=10){
            peon.IntelligenceExp(1);
        }
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
                && peon.getTreesChopped()>=15
                ){
            return true;
        }
        return false;
    }
    /**
     * Define peon lumber the tree, peon will 
     * get the value of resources
     * @param peon
     * Keep update the resources value when
     * peon finished lumber a tree
     */    
    public void treeResources(Peon peon){
		if (peon.getTreesChopped()>0){
    		for (int i=1; i>0; i++){
    			peon.getResources();
    		}
    	}	   		   		
	}
}