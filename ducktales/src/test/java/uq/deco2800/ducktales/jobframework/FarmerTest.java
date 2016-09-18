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
        
        assertEquals(peon.getJob(),"Jobless");
        
        boolean BuilderQualified = farmer.isQualified(peon);
        assertEquals(BuilderQualified, farmer.isQualified(peon));
        if (BuilderQualified){
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