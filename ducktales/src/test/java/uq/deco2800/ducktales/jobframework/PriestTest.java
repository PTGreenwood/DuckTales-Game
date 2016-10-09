package uq.deco2800.ducktales.jobframework;

import org.junit.Test;
import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.features.jobframework.Priest;
import static org.junit.Assert.*;

/**
 * @author Nicolas Turner (TheFractal on github and Fractal on slack)
 */
public class PriestTest {
	private Priest priest = new Priest();

	@Test
	public void qualificationTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(priest.getRequiredStrength() + 1);
		peon.setIntelligence(priest.getRequiredIntelligence() + 1);

		assertEquals(peon.getJob(), "Jobless");

		boolean Qualified = priest.isQualified(peon);
		assertEquals(Qualified, priest.isQualified(peon));
	}

	public void applicationTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(priest.getRequiredStrength() + 1);
		peon.setIntelligence(priest.getRequiredIntelligence() + 1);

		assertEquals(peon.applyForJob(priest), "You're hired!");
		assertEquals(peon.getJob(), "Priest");
	}

	public void notQualifiedBothTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(priest.getRequiredStrength() - 1);
		peon.setIntelligence(priest.getRequiredIntelligence() - 1);

		assertEquals(peon.applyForJob(priest), "Peon is not qualified in both aspects");
	}

	public void notQualifiedStrengthTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(priest.getRequiredStrength() - 1);
		peon.setIntelligence(priest.getRequiredIntelligence() + 1);

		assertEquals(peon.applyForJob(priest), "Peon strength is not high enough");
	}

	public void notQualifiedIntelligenceTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(priest.getRequiredStrength() + 1);
		peon.setIntelligence(priest.getRequiredIntelligence() - 1);

		assertEquals(peon.applyForJob(priest), "Peon intelligence is not high enough");
	}

	@Test
	public void notQualifiedBothMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(priest.getMentorStrength() - 1);
		peon.setIntelligence(priest.getMentorIntelligence() - 1);
		peon.applyForJob(priest);

		assertFalse(priest.canBeMentor(peon));
	}

	public void notQualifiedStrengthMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setIntelligence(priest.getMentorIntelligence() + 1);

		assertFalse(priest.canBeMentor(peon));
	}

	public void notQualifiedIntelligenceMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(priest.getMentorStrength() + 1);
		peon.setIntelligence(priest.getMentorIntelligence() - 1);

		assertFalse(priest.canBeMentor(peon));
	}

	public void qualifiedBothMentorTest() {
		Peon peon = new Peon(10, 10);
		peon.setStrength(priest.getMentorStrength() + 1);
		peon.setIntelligence(priest.getMentorIntelligence() + 1);

		assertTrue(priest.canBeMentor(peon));
	}
}