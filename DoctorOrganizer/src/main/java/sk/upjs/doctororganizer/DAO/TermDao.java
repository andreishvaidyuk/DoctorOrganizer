package sk.upjs.doctororganizer.DAO;

import java.util.List;
import sk.upjs.doctororganizer.Entities.Term;

public interface TermDao {

    void add(Term term);

    List<Term> getAll();

    Term getId(long id);

    void upgrade(Term term);

    void delete(long id);
}
