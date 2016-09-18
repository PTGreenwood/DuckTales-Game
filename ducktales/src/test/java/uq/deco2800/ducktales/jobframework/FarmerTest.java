package uq.deco2800.ducktales.jobframework;

import org.junit.Test;
import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.features.jobframework.Farmer;
import static org.junit.Assert.*;

/**
 * @author Nicolas Turner (TheFractal on github and Fractal on slack)
 */
public class FarmerTest {
    private Farmer farmer = new Farmer();
    @Test
    public void Test() {
        Peon peon = new Peon(10, 10);
        peon.setStrength(farmer.getRequiredStrength()+1);
        peon.setIntelligence(farmer.getRequiredIntelligence()+1);
        
        assertEquals(peon.getJob(),"Jobless");
        
        boolean Qualified = farmer.isQualified(peon);
        assertEquals(Qualified, farmer.isQualified(peon));
        if (Qualified){
            assertEquals(peon.applyForJob(farmer), "You're hired!");
            assertEquals(peon.getJob(), "Farmer");
        } else if ( peon.getStrength()<farmer.getRequiredStrength()
                &&  peon.getIntelligence()<farmer.getRequiredIntelligence()){
            assertEquals(peon.applyForJob(farmer),"Peon is not qualified in both aspects");
        } else if (peon.getStrength()<farmer.getRequiredStrength()){
            assertEquals(peon.applyForJob(farmer),"Peon strength is not high enough");
        } else {
            assertEquals(peon.applyForJob(farmer),"Peon intelligence is not high enough");
        }
    }
    @Test
    public void FarmerMentorTest(){
        Peon peon = new Peon(10, 10);
        peon.setStrength(farmer.getMentorStrength()-1);
        peon.setIntelligence(farmer.getMentorIntelligence()-1);
        peon.applyForJob(farmer);
        // peon doesn't have the intelligence or strength to be mentor
        assertFalse(farmer.canBeMentor(peon));
        // peon has the intelligence but not the strength
        peon.setIntelligence(farmer.getMentorIntelligence()+1);
        assertFalse(farmer.canBeMentor(peon));
        // peon has the strength but not the intelligence
        peon.setStrength(farmer.getMentorStrength()+1);
        peon.setIntelligence(farmer.getMentorIntelligence()-1);
        assertFalse(farmer.canBeMentor(peon));
        // peon has enough in both
        peon.setStrength(farmer.getMentorStrength()+1);
        peon.setIntelligence(farmer.getMentorIntelligence()+1);
        assertTrue(farmer.canBeMentor(peon));
    }
        
}