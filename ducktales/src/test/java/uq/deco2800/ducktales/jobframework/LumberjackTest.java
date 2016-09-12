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
        Peon peon = null;
        int peonStrength = peon.getStrength();
        int peonInt = peon.getIntelligence();
        int requiredStrength = lumberjack.getRequiredStrength();
        int requiredIntelligence = lumberjack.getRequiredIntelligence();
        assertEquals(peon.getJob(), "unemployed");
    }
}
