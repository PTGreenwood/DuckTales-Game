package uq.deco2800.ducktales.jobframework;

import org.junit.Test;
import uq.deco2800.ducktales.features.entities.agententities.Peon;
import uq.deco2800.ducktales.features.jobframework.Doctor;
import static org.junit.Assert.*;

/**
 * @author Nicolas Turner (TheFractal on github and Fractal on slack)
 */
public class DoctorTest {
    private Doctor doctor = new Doctor();
    @Test
    public void Test() {
        Peon peon = new Peon(10, 10);
        peon.setStrength(doctor.getRequiredStrength()+1);
        peon.setIntelligence(doctor.getRequiredIntelligence()+1);
          
        assertEquals(peon.getJob(),"Jobless");
        
        boolean Qualified = doctor.isQualified(peon);
        assertEquals(Qualified, doctor.isQualified(peon));
        if (Qualified){
            assertEquals(peon.applyForJob(doctor), "You're hired!");
            assertEquals(peon.getJob(), "Doctor");
        } else if ( peon.getStrength()<doctor.getRequiredStrength()
                &&  peon.getIntelligence()<doctor.getRequiredIntelligence()){
            assertEquals(peon.applyForJob(doctor),"Peon is not qualified in both aspects");
        } else if (peon.getStrength()<doctor.getRequiredStrength()){
            assertEquals(peon.applyForJob(doctor),"Peon strength is not high enough");
        } else {
            assertEquals(peon.applyForJob(doctor),"Peon intelligence is not high enough");
        }
    }
    @Test
    public void DoctorMentorTest(){
        Peon peon = new Peon(10, 10);
        peon.setStrength(doctor.getMentorStrength()-1);
        peon.setIntelligence(doctor.getMentorIntelligence()-1);
        peon.applyForJob(doctor);
        // peon doesn't have the intelligence or strength to be mentor
        assertFalse(doctor.canBeMentor(peon));
        // peon has the intelligence but not the strength
        peon.setIntelligence(doctor.getMentorIntelligence()+1);
        assertFalse(doctor.canBeMentor(peon));
        // peon has the strength but not the intelligence
        peon.setStrength(doctor.getMentorStrength()+1);
        peon.setIntelligence(doctor.getMentorIntelligence()-1);
        assertFalse(doctor.canBeMentor(peon));
        // peon has enough in both
        peon.setStrength(doctor.getMentorStrength()+1);
        peon.setIntelligence(doctor.getMentorIntelligence()+1);
        assertTrue(doctor.canBeMentor(peon));
    }
}