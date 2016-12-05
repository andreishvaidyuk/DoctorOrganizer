package sk.upjs.doctororganizer.DAO;

import java.util.List;
import sk.upjs.doctororganizer.Entities.Term;

public interface TermDao {

    void add(Term term);

    List<Term> getAll();

    Term getTermById(long id);
    
    List<Term> getTermByDoctorOfficeId(Long doctorOfficeId);

    void upgrade(Term term);

    void delete(long id);
}
