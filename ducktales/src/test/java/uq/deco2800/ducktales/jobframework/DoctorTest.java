package uq.deco2800.ducktales.jobframework;

import org.junit.Test;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.jobframework.Doctor;
import uq.deco2800.ducktales.features.jobframework.JobType;

import static org.junit.Assert.*;
import uq.deco2800.ducktales.features.entities.peons.PeonDebuffType;

/**
 * @author Nicolas Turner (TheFractal on github and Fractal on slack)
 */
public class DoctorTest {
	private Doctor doctor = new Doctor();

	@Test
	public void qualificationTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(doctor.getRequiredStrength() + 1);
		peon.setIntelligence(doctor.getRequiredIntelligence() + 1);

		assertEquals(peon.getJob(), JobType.JOBLESS);

		boolean Qualified = doctor.isQualified(peon);
		assertEquals(Qualified, doctor.isQualified(peon));
	}

	public void applicationTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(doctor.getRequiredStrength() + 1);
		peon.setIntelligence(doctor.getRequiredIntelligence() + 1);

		assertEquals(peon.applyForJob(doctor), "You're hired!");
		assertEquals(peon.getJob(), "Doctor");
	}

	public void notQualifiedBothTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(doctor.getRequiredStrength() - 1);
		peon.setIntelligence(doctor.getRequiredIntelligence() - 1);

		assertEquals(peon.applyForJob(doctor), "Peon is not qualified in both aspects");
	}

	public void notQualifiedStrengthTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(doctor.getRequiredStrength() - 1);
		peon.setIntelligence(doctor.getRequiredIntelligence() + 1);

		assertEquals(peon.applyForJob(doctor), "Peon strength is not high enough");
	}

	public void notQualifiedIntelligenceTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(doctor.getRequiredStrength() + 1);
		peon.setIntelligence(doctor.getRequiredIntelligence() - 1);

		assertEquals(peon.applyForJob(doctor), "Peon intelligence is not high enough");
	}

	@Test
	public void notQualifiedBothMentorTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(doctor.getMentorStrength() - 1);
		peon.setIntelligence(doctor.getMentorIntelligence() - 1);
		peon.applyForJob(doctor);

		assertFalse(doctor.canBeMentor(peon));
	}

	public void notQualifiedStrengthMentorTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setIntelligence(doctor.getMentorIntelligence() + 1);

		assertFalse(doctor.canBeMentor(peon));
	}

	public void notQualifiedIntelligenceMentorTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(doctor.getMentorStrength() + 1);
		peon.setIntelligence(doctor.getMentorIntelligence() - 1);

		assertFalse(doctor.canBeMentor(peon));
	}

	public void qualifiedBothMentorTest() {
		Peon peon = new Peon(10, 10, "John Doe");
		peon.setStrength(doctor.getMentorStrength() + 1);
		peon.setIntelligence(doctor.getMentorIntelligence() + 1);

		assertTrue(doctor.canBeMentor(peon));
	}
        
        public void CompleteHealTest(){
		Peon peon = new Peon(10, 10, "John Doe");
                assertTrue(peon.getDebuffs().isEmpty());
                peon.addDebuff(PeonDebuffType.HUNGRY);
                peon.addDebuff(PeonDebuffType.NEAR_DEATH);
                assertTrue(peon.getDebuffs().size()==2);
                doctor.CompleteHeal(peon);
                assertTrue(peon.getDebuffs().isEmpty());
        }
}