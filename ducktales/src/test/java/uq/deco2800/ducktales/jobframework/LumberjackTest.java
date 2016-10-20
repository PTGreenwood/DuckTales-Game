/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uq.deco2800.ducktales.jobframework;

import org.junit.Test;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.entities.resourceentities.Tree;
import uq.deco2800.ducktales.features.jobframework.JobType;
import uq.deco2800.ducktales.features.jobframework.Lumberjack;
import uq.deco2800.ducktales.resources.ResourceType;

import static org.junit.Assert.*;
import static uq.deco2800.ducktales.resources.ResourceType.TREE_1_SUMMER;
import static uq.deco2800.ducktales.resources.ResourceType.TREE_2_SUMMER;
import static uq.deco2800.ducktales.resources.ResourceType.TREE_3_SUMMER;

public class LumberjackTest {
	private Lumberjack lumberjack = new Lumberjack();

	@Test
	public void qualificationTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(lumberjack.getRequiredStrength() + 1);
		peon.setIntelligence(lumberjack.getRequiredIntelligence() + 1);

		assertEquals(peon.getJob(), JobType.JOBLESS);

		boolean Qualified = lumberjack.isQualified(peon);
		assertEquals(Qualified, lumberjack.isQualified(peon));
	}

	public void applicationTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(lumberjack.getRequiredStrength() + 1);
		peon.setIntelligence(lumberjack.getRequiredIntelligence() + 1);

		assertEquals(peon.applyForJob(lumberjack), "You're hired!");
		assertEquals(peon.getJob(), "Lumberjack");
	}

	public void notQualifiedBothTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(lumberjack.getRequiredStrength() - 1);
		peon.setIntelligence(lumberjack.getRequiredIntelligence() - 1);

		assertEquals(peon.applyForJob(lumberjack), "Peon is not qualified in both aspects");
	}

	public void notQualifiedStrengthTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(lumberjack.getRequiredStrength() - 1);
		peon.setIntelligence(lumberjack.getRequiredIntelligence() + 1);

		assertEquals(peon.applyForJob(lumberjack), "Peon strength is not high enough");
	}

	public void notQualifiedIntelligenceTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(lumberjack.getRequiredStrength() + 1);
		peon.setIntelligence(lumberjack.getRequiredIntelligence() - 1);

		assertEquals(peon.applyForJob(lumberjack), "Peon intelligence is not high enough");
	}

	@Test
	public void notQualifiedBothMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(lumberjack.getMentorStrength() - 1);
		peon.setIntelligence(lumberjack.getMentorIntelligence() - 1);
		peon.applyForJob(lumberjack);

		assertFalse(lumberjack.canBeMentor(peon));
	}

	public void notQualifiedStrengthMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setIntelligence(lumberjack.getMentorIntelligence() + 1);

		assertFalse(lumberjack.canBeMentor(peon));
	}

	public void notQualifiedIntelligenceMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(lumberjack.getMentorStrength() + 1);
		peon.setIntelligence(lumberjack.getMentorIntelligence() - 1);

		assertFalse(lumberjack.canBeMentor(peon));
	}

	public void qualifiedBothMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(lumberjack.getMentorStrength() + 1);
		peon.setIntelligence(lumberjack.getMentorIntelligence() + 1);

		assertTrue(lumberjack.canBeMentor(peon));
	}

	public void lumberjackChoppedMentorTest1() {
		Peon peon = new Peon(10, 10);
		// peon has enough in both but didn't chop enough trees
		peon.setStrength(lumberjack.getMentorStrength() + 1);
		peon.setIntelligence(lumberjack.getMentorIntelligence() + 1);

		assertFalse(lumberjack.canBeMentor(peon));
	}

	public void lumberjackChoppedMentorTest2() {
		final ResourceType[] SUMMER_TYPES = {TREE_1_SUMMER, TREE_2_SUMMER, TREE_3_SUMMER};
		Peon peon = new Peon(10, 10);
		Tree tree = new Tree(11, 11, SUMMER_TYPES);
		for (int i = 0; i < 21; i++) {
			lumberjack.chop(peon, tree);
		}
		peon.setStrength(lumberjack.getMentorStrength() + 1);
		peon.setIntelligence(lumberjack.getMentorIntelligence() + 1);

		assertTrue(lumberjack.canBeMentor(peon));
	}

	public void lumberTest() {
		Peon peon = new Peon(10, 10);
		assertEquals(peon.getJob(), "Jobless");
		peon.setStrength(lumberjack.getRequiredStrength() + 1);
		peon.setIntelligence(lumberjack.getRequiredIntelligence() + 1);
		int peonInitialStrength = peon.getStrength();
		int peonInitialIntelligence = peon.getIntelligence();
		assertTrue(lumberjack.isQualified(peon));
		assertEquals(peon.applyForJob(lumberjack), "You're hired!");
		assertEquals(peon.getJob(), "Lumberjack");
		
		final ResourceType[] SUMMER_TYPES = {TREE_1_SUMMER, TREE_2_SUMMER, TREE_3_SUMMER};
		Tree tree = new Tree(11, 11, SUMMER_TYPES);
		/**
		 * after chopping a tree, the peon should gain 2 strength points i.e.
		 * the difference between the intialPeonStrength and the new peon
		 * Strength should be two The amount of trees chopped should be 1
		 */
		lumberjack.chop(peon, tree);
		assertEquals(2, (peon.getStrength() - peonInitialStrength));
		assertEquals(1, peon.getTreesChopped());
		/**
		 * After chopping a total of 10 trees, the peon should gain 1
		 * intelligence point should have a total gain of 20 strength points
		 * amount of trees chopped should be 10
		 */
		for (int i = 1; i < 10; i++) {
			lumberjack.chop(peon, tree);
		}
		assertEquals(20, peon.getStrength() - peonInitialStrength);
		assertEquals(1, peon.getIntelligence() - peonInitialIntelligence);
		assertEquals(10, peon.getTreesChopped());
	}
}
