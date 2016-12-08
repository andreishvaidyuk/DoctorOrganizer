package sk.upjs.doctororganizer.DAO;

import java.util.List;
import sk.upjs.doctororganizer.Entities.Patient;

public interface PatientDao {

    void add(Patient patient);

    List<Patient> getAll();

    Patient getPatientById(long id);
    
    Patient getPatientByEmail(String email);

    void upgrade(Patient patient);
    
    void upgradePass(Patient patient, String newPassword);

    void delete(long id);
}
