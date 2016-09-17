/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uq.deco2800.ducktales.jobframework;

import org.junit.Test;
import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.features.jobframework.Lumberjack;
import static org.junit.Assert.*;
/**
 *
 * @author Eduardo
 */
public class LumberjackTest {

    private Lumberjack lumberjack;
    @Test
    public void lumberjackTest(){
        /*instantiating a peon*/
        Peon peon = new Peon(10, 10);
        assertEquals(peon.getJob(), "unemployed");
        
        /**
         * Qualification of the peon as a builder
         */
        boolean qualified = lumberjack.isQualified(peon);
        assertEquals(qualified, lumberjack.isQualified(peon));
        if (qualified){
            assertEquals(peon.applyForJob(lumberjack), "You're hired!");
            assertEquals(peon.getJob(), "Lumberjack");
        } else if ( peon.getStrength()<lumberjack.getRequiredStrength()
                &&  peon.getIntelligence()<lumberjack.getRequiredIntelligence()){
            assertEquals(peon.applyForJob(lumberjack),"Peon is not qualified in both aspects");
        } else if (peon.getStrength()<lumberjack.getRequiredStrength()){
            assertEquals(peon.applyForJob(lumberjack),"Peon strength is not high enough");
        } else {
            assertEquals(peon.applyForJob(lumberjack),"Peon intelligence is not high enough");
        }
    }
    @Test
    public void lumberTest(){
        Peon peon = new Peon(10, 10);
        assertEquals(peon.getJob(), "unemployed");
        peon.setStrength(lumberjack.getRequiredStrength()+1);
        peon.setIntelligence(lumberjack.getRequiredIntelligence()+1);
        assertTrue(lumberjack.isQualified(peon));
        assertEquals(peon.applyForJob(lumberjack), "You're hired!");
        assertEquals(peon.getJob(), "Lumberjack");
        
        
    }
}
