package sk.upjs.doctororganizer.DAO;

import java.util.List;
import sk.upjs.doctororganizer.Entities.Doctor;

public interface DoctorDao {

    void add(Doctor doctor);

    List<Doctor> getAll();

    Doctor getId(Long id);

    void upgrade(Doctor doctor);

    void delete(Long id);
}
