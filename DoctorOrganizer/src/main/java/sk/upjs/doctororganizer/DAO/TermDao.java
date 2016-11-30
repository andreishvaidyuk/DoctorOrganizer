package sk.upjs.doctororganizer.DAO;

import java.util.List;
import sk.upjs.doctororganizer.Entities.Term;

public interface TermDao {

    void add(Term term);

    List<Term> getAll();

    Term getId(Long id);

    void upgrade(Term term);

    void delete(Long id);
}
