package sk.upjs.doctororganizer.MysqlDAO;

import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.doctororganizer.DAO.TermDao;
import sk.upjs.doctororganizer.Entities.Term;

public class MysqlTermDao implements TermDao {

    private final JdbcTemplate jdbcTemplate;

    public MysqlTermDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Term term) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        String date = term.getDate().format(formatter);
        String sql = "INSERT INTO `term` (`id_patient`, `patient`,"
                + " `id_doctor_office`, `date`, `time`, `reason`,"
                + " `term_condition`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, term.getId_patient(), term.getPatient(), term.getId_doctor_office(), date, term.getTime(), term.getReason(), term.getTerm_condition());
    }

    @Override
    public List<Term> getAll() {
        String sql = "SELECT id, id_patient, patient, id_doctor_office, date,"
                + " time reason, term_condition FROM term";
        BeanPropertyRowMapper<Term> bprm = new BeanPropertyRowMapper<>(Term.class);
        return jdbcTemplate.query(sql, bprm);
    }

    @Override
    public Term getTermById(long id) {
        String sql = "SELECT id, id_patient, patient, id_doctor_office, date,"
                + " time, reason, term_condition FROM term WHERE id = " + id;
        BeanPropertyRowMapper<Term> bprm = new BeanPropertyRowMapper<>(Term.class);
        return jdbcTemplate.query(sql, bprm).get(0);
    }

    @Override
    public List<Term> getTermByDoctorOfficeId(Long doctorOfficeId) {
        String sql = "SELECT id, id_patient, patient, id_doctor_office,"
                + " date, time, reason, term_condition FROM term"
                + " WHERE id_doctor_office = " + doctorOfficeId;
        BeanPropertyRowMapper<Term> bprm = new BeanPropertyRowMapper<>(Term.class);
        return jdbcTemplate.query(sql, bprm);
    }

    @Override
    public List<Term> getTermByDoctorOfficeIdAndDay(Long doctorOfficeId, String date) {
        String sql = "SELECT id, id_patient, patient, id_doctor_office,"
                + " date, time, reason, term_condition FROM term"
                + " WHERE id_doctor_office = " + doctorOfficeId + " && date = \'" + date + "\'";
        BeanPropertyRowMapper<Term> bprm = new BeanPropertyRowMapper<>(Term.class);
        return jdbcTemplate.query(sql, bprm);
    }

    @Override
    public void setTermCondition(Long termId, String newCondition) {
        jdbcTemplate.update("UPDATE term SET term_condition = ? WHERE id = ?",
                newCondition, termId);
    }

    @Override
    public void upgrade(Term term) {
        jdbcTemplate.update("UPDATE term SET"
                + " id_patient = ?, patient = ?, id_doctor_office = ?,"
                + " date = ?, time = ?, reason = ? , term_condition = ? WHERE id = ?",
                term.getId_patient(), term.getPatient(), term.getId_doctor_office(),
                term.getDate(), term.getTime(), term.getReason(), term.getTerm_condition(), term.getId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM term WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

}
