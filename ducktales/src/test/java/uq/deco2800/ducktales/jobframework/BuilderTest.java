/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uq.deco2800.ducktales.jobframework;

import org.junit.Test;
import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.features.jobframework.Builder;
import static org.junit.Assert.*;

/**
 *
 * @author Eduardo
 */
public class BuilderTest {
    private Builder builder = new Builder();
    @Test
    public void BuilderTest() {
        Peon peon = new Peon(10, 10);
        
        assertEquals(peon.getJob(),"Jobless");
        
        
        boolean BuilderQualified = builder.isQualified(peon);
        assertEquals(BuilderQualified, builder.isQualified(peon));
        if (BuilderQualified){
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
