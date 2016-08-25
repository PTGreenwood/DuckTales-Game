package uq.deco2800.ducktales.entities;

import uq.deco2800.ducktales.entities.agententities.Peon;

/**
 * Base class for all Jobs
 * 
 * @author Edward Liao (eduardlio on github and slack)
 */
public abstract class Job {
    
    protected int requiredStrength;
    protected int requiredIntelligence;
    
    protected int mentorStrength;
    protected int mentorIntelligence;
    
    protected String jobName;
    /**
     * Constructor method for Job
     * 
     * @param requiredStrength
     * @param requiredIntelligence
     * @param mentorStrength
     * @param mentorIntelligence 
     * @param jobName 
     */
    public Job(int requiredStrength, int requiredIntelligence, 
            int mentorStrength, int mentorIntelligence, String jobName) {
        this.requiredStrength = requiredStrength;
        this.requiredIntelligence = requiredIntelligence;
        this.mentorStrength = mentorStrength;
        this.mentorIntelligence = mentorIntelligence;
        this.jobName = jobName;
    }
    /**
     * Returns the name of the job
     * @return jobName
     */
    public String getJobName(){
        return jobName;
    }
    /**
     * Returns the requirements for the given job
     * @return reqs, int[] of Required Values
     */
    public int [] getRequirements(){
        int [] reqs = {this.getRequiredStrength(), this.getRequiredIntelligence()};
        return reqs;
    }
    /**
     * Returns the required strength for the job
     * @return requiredStrength
     */
    public int getRequiredStrength(){
        return requiredStrength;
    }
    /**
     * Returns the required intelligence for the job
     * @return requiredIntelligence
     */
    public int getRequiredIntelligence(){
        return requiredIntelligence;
    }
    /**
     * Returns the requirements to become a Mentor in
     * the given job
     * @return reqs, int[] of Required Values
     */
}