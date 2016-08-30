package uq.deco2800.ducktales.jobframework;

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
        if (requiredStrength <= 0)
            this.requiredStrength = 1;
        if (requiredIntelligence <=0)
            this.requiredIntelligence =1;
        if (mentorStrength <= requiredStrength)
            this.mentorStrength = requiredStrength+1;
        if (mentorIntelligence <= requiredIntelligence)
            this.mentorIntelligence = requiredIntelligence+1;
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
    public int [] getMentorRequirements(){
        int [] reqs = {this.getMentorStrength(), this.getMentorIntelligence()};
        return reqs;      
    }
    /**
     * Returns the required strength to become
     * a mentor in the job
     * @return mentorStrength
     */
    public int getMentorStrength(){
        return mentorStrength;
    }
    /**
     * Returns the required intelligence to become
     * a mentor in the job
     * @return mentorIntelligence;
     */
    public int getMentorIntelligence(){
        return mentorIntelligence;
    }
    /**
     * Defines whether or not the given peon is 
     * qualified to do the job
     * @param peon
     * @return true iff peon is qualified, false otherwise
     */
    public boolean isQualified(Peon peon){
        if (peon.getStrength() >= this.getRequiredStrength() &&
                peon.getIntelligence() >= this.getRequiredIntelligence()){
            return true;
        }
        return false;
    }
    /**
     * Defines whether or not the given peon is 
     * qualified to become a mentor in the job
     * @param peon
     * @return true iff peon is qualified and is already working, false otherwise
     */
    public boolean canBeMentor(Peon peon){
        if (peon.getStrength() >= this.getMentorStrength()
                && peon.getIntelligence()>=this.getMentorIntelligence()
                ){
            return true;
        }
        return false;
    }
}