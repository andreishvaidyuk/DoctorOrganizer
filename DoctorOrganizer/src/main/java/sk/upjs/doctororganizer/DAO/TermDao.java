package sk.upjs.doctororganizer.DAO;

import java.util.List;
import sk.upjs.doctororganizer.Entities.Term;

public interface TermDao {

    void add(Term term);

    List<Term> getAll();
    
    List<Term> getTermsByPatientId(Long patientId);

    List<Term> getTermByDoctorOfficeIdAndDay(Long doctorOfficeId, String date);
    
    void setTermCondition(Long termId, String newCondition);

    void delete(long id);

}
