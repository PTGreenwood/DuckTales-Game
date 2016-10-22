package uq.deco2800.ducktales.jobframework;

import org.junit.Test;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.jobframework.Builder;
import uq.deco2800.ducktales.features.jobframework.JobType;

import static org.junit.Assert.*;

/**
 * @author Eduardo
 */
public class BuilderTest {
	private Builder builder = new Builder();

	@Test
	public void qualificationTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(builder.getRequiredStrength() + 1);
		peon.setIntelligence(builder.getRequiredIntelligence() + 1);

		assertEquals(peon.getJob(), JobType.JOBLESS);

		boolean Qualified = builder.isQualified(peon);
		assertEquals(Qualified, builder.isQualified(peon));
	}

	public void applicationTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(builder.getRequiredStrength() + 1);
		peon.setIntelligence(builder.getRequiredIntelligence() + 1);

		assertEquals(peon.applyForJob(builder), "You're hired!");
		assertEquals(peon.getJob(), "Builder");
	}

	public void notQualifiedBothTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(builder.getRequiredStrength() - 1);
		peon.setIntelligence(builder.getRequiredIntelligence() - 1);

		assertEquals(peon.applyForJob(builder), "Peon is not qualified in both aspects");
	}

	public void notQualifiedStrengthTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(builder.getRequiredStrength() - 1);
		peon.setIntelligence(builder.getRequiredIntelligence() + 1);

		assertEquals(peon.applyForJob(builder), "Peon strength is not high enough");
	}

	public void notQualifiedIntelligenceTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(builder.getRequiredStrength() + 1);
		peon.setIntelligence(builder.getRequiredIntelligence() - 1);

		assertEquals(peon.applyForJob(builder), "Peon intelligence is not high enough");
	}

	@Test
	public void notQualifiedBothMentorTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(builder.getMentorStrength() - 1);
		peon.setIntelligence(builder.getMentorIntelligence() - 1);
		peon.applyForJob(builder);

		assertFalse(builder.canBeMentor(peon));
	}

	public void notQualifiedStrengthMentorTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setIntelligence(builder.getMentorIntelligence() + 1);

		assertFalse(builder.canBeMentor(peon));
	}

	public void notQualifiedIntelligenceMentorTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(builder.getMentorStrength() + 1);
		peon.setIntelligence(builder.getMentorIntelligence() - 1);

		assertFalse(builder.canBeMentor(peon));
	}

	public void qualifiedBothMentorTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(builder.getMentorStrength() + 1);
		peon.setIntelligence(builder.getMentorIntelligence() + 1);

		assertTrue(builder.canBeMentor(peon));
	}

	public void builderBuiltMentorTest1() {
		Peon peon = new Peon(10, 10, "John Doe");
		// peon has enough in both but didn't build enough buildings
		peon.setStrength(builder.getMentorStrength() + 1);
		peon.setIntelligence(builder.getMentorIntelligence() + 1);

		assertFalse(builder.canBeMentor(peon));
	}

	public void builderBuiltMentorTest2() {
		Peon peon = new Peon(10, 10, "John Doe");
		for (int i = 0; i < 21; i++) {
			builder.build(peon);
		}

		peon.setStrength(builder.getMentorStrength() + 1);
		peon.setIntelligence(builder.getMentorIntelligence() + 1);
		assertTrue(builder.canBeMentor(peon));
	}
}
