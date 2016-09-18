package uq.deco2800.ducktales.jobframework;

import org.junit.Test;
import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.features.jobframework.Miner;
import static org.junit.Assert.*;

/**
 * @author Nicolas Turner (TheFractal on github and Fractal on slack)
 */
public class MinerTest {
    private Miner miner = new Miner();
    @Test
    public void Test() {
        Peon peon = new Peon(10, 10);
        peon.setStrength(50);
        peon.setIntelligence(50);
        
        assertEquals(peon.getJob(),"Jobless");
        
        boolean Qualified = miner.isQualified(peon);
        assertEquals(Qualified, miner.isQualified(peon));
        if (Qualified){
            assertEquals(peon.applyForJob(miner), "You're hired!");
            assertEquals(peon.getJob(), "Miner");
        } else if ( peon.getStrength()<miner.getRequiredStrength()
                &&  peon.getIntelligence()<miner.getRequiredIntelligence()){
            assertEquals(peon.applyForJob(miner),"Peon is not qualified in both aspects");
        } else if (peon.getStrength()<miner.getRequiredStrength()){
            assertEquals(peon.applyForJob(miner),"Peon strength is not high enough");
        } else {
            assertEquals(peon.applyForJob(miner),"Peon intelligence is not high enough");
        }
    }
}