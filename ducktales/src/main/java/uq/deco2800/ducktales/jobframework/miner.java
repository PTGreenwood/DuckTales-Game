package uq.deco2800.ducktales.jobframework;

/**
 * Generates the miner job
 * 
 * @author Nicolas Turner (fractal on github and slack)
 *
 *I think this is the correct way of doing things. Will need to be checked.
 */
public class miner extends Job {

	protected static int requiredStrength = 6;
    protected static int requiredIntelligence = 1;
    
    protected static int mentorStrength = 9;
    protected static int mentorIntelligence = 2;
    
    protected static String jobName = "Miner";	

	public miner(int requiredStrength, int requiredIntelligence, int mentorStrength, int mentorIntelligence, String jobName) {
		super(requiredStrength, requiredIntelligence, mentorStrength, mentorIntelligence, jobName);
	}
}
