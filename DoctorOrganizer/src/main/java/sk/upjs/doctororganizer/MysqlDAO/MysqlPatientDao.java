package sk.upjs.doctororganizer.MysqlDAO;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.doctororganizer.DAO.PatientDao;
import sk.upjs.doctororganizer.Entities.Patient;

public class MysqlPatientDao implements PatientDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlPatientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Patient patient) {
        String sql = "INSERT INTO `patient` (`name`, `surname`, `adress`, `date_of_birth`, `id_number`, `insured_at`, `phone_number`, `email`, `password`) VALUES (?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, patient.getName(), patient.getSurname(), patient.getAdress(), patient.getDate_of_birth(), patient.getId_number(), patient.getInsured_at(), patient.getPhone_number(), patient.getEmail(), patient.getPassword());
    }

    @Override
    public List<Patient> getAll() {
        String sql = "SELECT id, name, surname, adress, date_of_birth, id_number, insured_at, phone_number, email, password FROM patient";
        BeanPropertyRowMapper<Patient> bprm = new BeanPropertyRowMapper<>(Patient.class);
        return jdbcTemplate.query(sql, bprm);
    }

    @Override
    public Patient getId(long id) {
        String sql = "SELECT id, name, surname, adress, date_of_birth, id_number, insured_at, phone_number, email, password FROM patient WHERE id = " + id;
        BeanPropertyRowMapper<Patient> bprm = new BeanPropertyRowMapper<>(Patient.class);
        return jdbcTemplate.query(sql, bprm).get(0);
    }

    @Override
    public void upgrade(Patient patient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM patient WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Patient getPatientByEmail(String email) {
        String sql = "SELECT id, name, surname, adress, date_of_birth, id_number, insured_at, phone_number, email, password FROM patient WHERE email = \'" + email + "\'";
        BeanPropertyRowMapper<Patient> bprm = new BeanPropertyRowMapper<>(Patient.class);
        List<Patient> list = jdbcTemplate.query(sql, bprm);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

}
