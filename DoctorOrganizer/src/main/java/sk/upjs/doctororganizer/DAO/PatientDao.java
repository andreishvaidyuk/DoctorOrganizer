package sk.upjs.doctororganizer.DAO;

import java.util.List;
import sk.upjs.doctororganizer.Entities.Patient;

public interface PatientDao {
    void add(Patient patient);
    
    List<Patient> getAll();
    Patient getId(Long id);
    
    void upgrade(Patient patient);
    
    void delete(Long id);
}
