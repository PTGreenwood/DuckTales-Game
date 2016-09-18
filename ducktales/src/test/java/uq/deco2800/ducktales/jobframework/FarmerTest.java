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
        peon.setStrength(50);
        peon.setIntelligence(50);
        
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
}