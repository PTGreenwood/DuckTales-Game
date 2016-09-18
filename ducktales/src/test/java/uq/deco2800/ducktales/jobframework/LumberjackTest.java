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
    public void BuilderMentorTest(){
        Peon peon = new Peon(10, 10);
        peon.setStrength(lumberjack.getMentorStrength()-1);
        peon.setIntelligence(lumberjack.getMentorIntelligence()-1);
        peon.applyForJob(lumberjack);
        assertFalse(peon.getMentorStatus());
        // peon doesn't have the intelligence or strength to be mentor
        assertFalse(lumberjack.canBeMentor(peon));
        // peon has the intelligence but not the strength
        peon.setIntelligence(lumberjack.getMentorIntelligence()+1);
        assertFalse(lumberjack.canBeMentor(peon));
        // peon has the strength but not the intelligence
        peon.setStrength(lumberjack.getMentorStrength()+1);
        peon.setIntelligence(lumberjack.getMentorIntelligence()-1);
        assertFalse(lumberjack.canBeMentor(peon));
        // peon has enough in both but didn't build chop enough trees
        peon.setStrength(lumberjack.getMentorStrength()+1);
        peon.setIntelligence(lumberjack.getMentorIntelligence()+1);
        assertFalse(lumberjack.canBeMentor(peon));
        // can be mentor
        Tree tree = new Tree(11,11);
        for (int i = 0; i<21; i++){
            lumberjack.chop(peon, tree);
        }
        peon.setStrength(lumberjack.getMentorStrength()+1);
        peon.setIntelligence(lumberjack.getMentorIntelligence()+1);
        assertTrue(lumberjack.canBeMentor(peon));
    }
}
