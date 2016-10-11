package uq.deco2800.ducktales.jobframework;

import org.junit.Test;
import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.features.jobframework.JobType;
import uq.deco2800.ducktales.features.jobframework.Miner;
import static org.junit.Assert.*;

/**
 * @author Nicolas Turner (TheFractal on github and Fractal on slack)
 */
public class MinerTest {
	private Miner miner = new Miner();

	@Test
	public void qualificationTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(miner.getRequiredStrength() + 1);
		peon.setIntelligence(miner.getRequiredIntelligence() + 1);

		assertEquals(peon.getJob(), JobType.JOBLESS);

		boolean Qualified = miner.isQualified(peon);
		assertEquals(Qualified, miner.isQualified(peon));
	}

	public void applicationTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(miner.getRequiredStrength() + 1);
		peon.setIntelligence(miner.getRequiredIntelligence() + 1);

		assertEquals(peon.applyForJob(miner), "You're hired!");
		assertEquals(peon.getJob(), "Miner");
	}

	public void notQualifiedBothTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(miner.getRequiredStrength() - 1);
		peon.setIntelligence(miner.getRequiredIntelligence() - 1);

		assertEquals(peon.applyForJob(miner), "Peon is not qualified in both aspects");
	}

	public void notQualifiedStrengthTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(miner.getRequiredStrength() - 1);
		peon.setIntelligence(miner.getRequiredIntelligence() + 1);

		assertEquals(peon.applyForJob(miner), "Peon strength is not high enough");
	}

	public void notQualifiedIntelligenceTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(miner.getRequiredStrength() + 1);
		peon.setIntelligence(miner.getRequiredIntelligence() - 1);

		assertEquals(peon.applyForJob(miner), "Peon intelligence is not high enough");
	}

	@Test
	public void notQualifiedBothMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(miner.getMentorStrength() - 1);
		peon.setIntelligence(miner.getMentorIntelligence() - 1);
		peon.applyForJob(miner);

		assertFalse(miner.canBeMentor(peon));
	}

	public void notQualifiedStrengthMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setIntelligence(miner.getMentorIntelligence() + 1);

		assertFalse(miner.canBeMentor(peon));
	}

	public void notQualifiedIntelligenceMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(miner.getMentorStrength() + 1);
		peon.setIntelligence(miner.getMentorIntelligence() - 1);

		assertFalse(miner.canBeMentor(peon));
	}

	public void qualifiedBothMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(miner.getMentorStrength() + 1);
		peon.setIntelligence(miner.getMentorIntelligence() + 1);

		assertTrue(miner.canBeMentor(peon));
	}
}