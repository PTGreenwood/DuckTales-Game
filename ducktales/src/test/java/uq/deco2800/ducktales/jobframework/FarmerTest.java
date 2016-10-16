package uq.deco2800.ducktales.jobframework;

import org.junit.Test;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.jobframework.Farmer;
import uq.deco2800.ducktales.features.jobframework.JobType;

import static org.junit.Assert.*;

/**
 * @author Nicolas Turner (TheFractal on github and Fractal on slack)
 */
public class FarmerTest {
	private Farmer farmer = new Farmer();

	@Test
	public void qualificationTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(farmer.getRequiredStrength() + 1);
		peon.setIntelligence(farmer.getRequiredIntelligence() + 1);

		assertEquals(peon.getJob(), JobType.JOBLESS);

		boolean Qualified = farmer.isQualified(peon);
		assertEquals(Qualified, farmer.isQualified(peon));
	}

	public void applicationTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(farmer.getRequiredStrength() + 1);
		peon.setIntelligence(farmer.getRequiredIntelligence() + 1);

		assertEquals(peon.applyForJob(farmer), "You're hired!");
		assertEquals(peon.getJob(), "Farmer");
	}

	public void notQualifiedBothTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(farmer.getRequiredStrength() - 1);
		peon.setIntelligence(farmer.getRequiredIntelligence() - 1);

		assertEquals(peon.applyForJob(farmer), "Peon is not qualified in both aspects");
	}

	public void notQualifiedStrengthTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(farmer.getRequiredStrength() - 1);
		peon.setIntelligence(farmer.getRequiredIntelligence() + 1);

		assertEquals(peon.applyForJob(farmer), "Peon strength is not high enough");
	}

	public void notQualifiedIntelligenceTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(farmer.getRequiredStrength() + 1);
		peon.setIntelligence(farmer.getRequiredIntelligence() - 1);

		assertEquals(peon.applyForJob(farmer), "Peon intelligence is not high enough");
	}

	@Test
	public void notQualifiedBothMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(farmer.getMentorStrength() - 1);
		peon.setIntelligence(farmer.getMentorIntelligence() - 1);
		peon.applyForJob(farmer);

		assertFalse(farmer.canBeMentor(peon));
	}

	public void notQualifiedStrengthMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setIntelligence(farmer.getMentorIntelligence() + 1);

		assertFalse(farmer.canBeMentor(peon));
	}

	public void notQualifiedIntelligenceMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(farmer.getMentorStrength() + 1);
		peon.setIntelligence(farmer.getMentorIntelligence() - 1);

		assertFalse(farmer.canBeMentor(peon));
	}

	public void qualifiedBothMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(farmer.getMentorStrength() + 1);
		peon.setIntelligence(farmer.getMentorIntelligence() + 1);

		assertTrue(farmer.canBeMentor(peon));
	}
}