package uq.deco2800.ducktales.features.jobframework;

import uq.deco2800.ducktales.features.entities.agententities.Peon;

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
    protected JobType JOBTYPE;
    /**
     * Main constructor of the {@link Job} class.
     * 
     * @param requiredStrength
     * @param requiredIntelligence
     * @param mentorStrength
     * @param mentorIntelligence 
     * @param jobName 
     */
    public Job(int requiredStrength, int requiredIntelligence, 
            int mentorStrength, int mentorIntelligence, String jobName, JobType JOBTYPE) {
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
        this.JOBTYPE = JOBTYPE;
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
     * GOING TO NEED TO REVISE THIS PART
     * to determine picking which peons to assign to the task
     * 
     * Determines overall how qualified a peon is for the job
     * @param peon
     * @return a double determining how qualified a peon is
     *          for this job. 
     */
    public double qualifiedPercent(Peon peon){
        if(!isQualified(peon))
            return -1;
        double str = peon.getStrength()/this.getRequiredStrength();
        double intel = peon.getIntelligence()/this.getRequiredIntelligence();
        double total = (str+intel)/2;
        peon.setQualification(total);
        return total;
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
        	peon.setJob(jobName);
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
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        return this.jobName;
    }
}