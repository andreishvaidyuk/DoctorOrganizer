package sk.upjs.doctororganizer.DAO;

import java.util.List;
import sk.upjs.doctororganizer.Entities.Doctor;

public interface DoctorDao {

    void add(Doctor doctor);

    List<Doctor> getAll();

    Doctor getId(long id);

    Doctor getDoctorByEmail(String email);

    void upgradePass(Doctor doctor, String newPassword);
    
    void upgrade(Doctor doctor);

    void delete(long id);
}
