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
import uq.deco2800.ducktales.features.entities.resourceentities.Tree;
/**
 *
 * @author Eduardo
 */
public class LumberjackTest {

    private Lumberjack lumberjack = new Lumberjack();
    @Test
    public void lumberjackTest(){
        /*instantiating a peon*/
        Peon peon = new Peon(10, 10);
        assertEquals(peon.getJob(), "Jobless");
        
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
        assertEquals(peon.getJob(), "Jobless");
        peon.setStrength(lumberjack.getRequiredStrength()+1);
        peon.setIntelligence(lumberjack.getRequiredIntelligence()+1);
        int peonInitialStrength = peon.getStrength();
        int peonInitialIntelligence = peon.getIntelligence();
        assertTrue(lumberjack.isQualified(peon));
        assertEquals(peon.applyForJob(lumberjack), "You're hired!");
        assertEquals(peon.getJob(), "Lumberjack");
        
        Tree tree = new Tree(11, 11);
        /**
         * after chopping a tree, the peon should gain 2 strength points
         * i.e. the difference between the intialPeonStrength and
         * the new peon Strength should be two
         * The amount of trees chopped should be 1
         */
        lumberjack.chop(peon, tree);        
        assertEquals(2, (peon.getStrength()-peonInitialStrength));
        assertEquals(1,peon.getTreesChopped());
        /**
         * After chopping a total of 10 trees, the peon
         * should gain 1 intelligence point
         * should have a total gain of 20 strength points
         * amount of trees chopped should be 10
         */
        for (int i = 1; i<10;i++){
            lumberjack.chop(peon,tree);
        }
        assertEquals(20, peon.getStrength()-peonInitialStrength);
        assertEquals(1, peon.getIntelligence()-peonInitialIntelligence);
        assertEquals(10, peon.getTreesChopped());
    }
    @Test
    public void LumberMentorTest(){
        Peon peon = new Peon(10, 10);
        assertEquals(peon.getJob(), "Jobless");
        peon.setStrength(lumberjack.getMentorStrength()+1);
        peon.setIntelligence(lumberjack.getMentorIntelligence()+1);
        
        // shouldn't be a mentor yet
        assertFalse(peon.getMentorStatus());
        // can't be a mentor yet
        assertFalse(lumberjack.canBeMentor(peon));
        // hasn't cut enough trees
        assertFalse(peon.getTreesChopped()>=15);
        int count = 0;
        Tree tree = new Tree(11,11);
        while (count < 15){
            lumberjack.chop(peon, tree);
            count++;
        }
        // should have chopped 15 trees
        assertTrue(peon.getTreesChopped()>=15);
        // should be able to be a mentor
        assertTrue(lumberjack.canBeMentor(peon));
    }
}
