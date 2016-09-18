package uq.deco2800.ducktales.jobframework;

import org.junit.Test;
import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.features.jobframework.Builder;
import static org.junit.Assert.*;

/**
 * @author Eduardo
 */
public class BuilderTest {
    private Builder builder = new Builder();
    @Test
    public void Test() {
        Peon peon = new Peon(10, 10);
        peon.setStrength(50);
        peon.setIntelligence(50);
        assertEquals(peon.getJob(),"Jobless");
        
        boolean Qualified = builder.isQualified(peon);
        assertEquals(Qualified, builder.isQualified(peon));
        if (Qualified){
            assertEquals(peon.applyForJob(builder), "You're hired!");
            assertEquals(peon.getJob(), "Builder");
        } else if ( peon.getStrength()<builder.getRequiredStrength()
                &&  peon.getIntelligence()<builder.getRequiredIntelligence()){
            assertEquals(peon.applyForJob(builder),"Peon is not qualified in both aspects");
        } else if (peon.getStrength()<builder.getRequiredStrength()){
            assertEquals(peon.applyForJob(builder),"Peon strength is not high enough");
        } else {
            assertEquals(peon.applyForJob(builder),"Peon intelligence is not high enough");
        }
    }
}
