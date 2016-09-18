package uq.deco2800.ducktales.jobframework;

import org.junit.Test;
import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.features.jobframework.Priest;
import static org.junit.Assert.*;

/**
 * @author Nicolas Turner (TheFractal on github and Fractal on slack)
 */
public class PriestTest {
    private Priest priest = new Priest();
    @Test
    public void Test() {
        Peon peon = new Peon(10, 10);
        peon.setStrength(50);
        peon.setIntelligence(50);
        
        assertEquals(peon.getJob(),"Jobless");
        
        boolean Qualified = priest.isQualified(peon);
        assertEquals(Qualified, priest.isQualified(peon));
        if (Qualified){
            assertEquals(peon.applyForJob(priest), "You're hired!");
            assertEquals(peon.getJob(), "Priest");
        } else if ( peon.getStrength()<priest.getRequiredStrength()
                &&  peon.getIntelligence()<priest.getRequiredIntelligence()){
            assertEquals(peon.applyForJob(priest),"Peon is not qualified in both aspects");
        } else if (peon.getStrength()<priest.getRequiredStrength()){
            assertEquals(peon.applyForJob(priest),"Peon strength is not high enough");
        } else {
            assertEquals(peon.applyForJob(priest),"Peon intelligence is not high enough");
        }
    }
}