package sk.upjs.doctororganizer.MysqlDAO;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.doctororganizer.DAO.DoctorDao;
import sk.upjs.doctororganizer.Entities.Doctor;

public class MysqlDoctorDao implements DoctorDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlDoctorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Doctor doctor) {
        String sql = "INSERT INTO `doctor` (`name`, `surname`,"
                + " `academic_degree`, `email`, `password`) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, doctor.getName(), doctor.getSurname(),
                doctor.getAcademic_degree(), doctor.getEmail(), doctor.getPassword());
    }

    @Override
    public List<Doctor> getAll() {
        String sql = "SELECT id, name, surname, academic_degree, email, password"
                + " FROM doctor";
        BeanPropertyRowMapper<Doctor> bprm = new BeanPropertyRowMapper<>(Doctor.class);
        return jdbcTemplate.query(sql, bprm);
    }

    @Override
    public Doctor getDoctorById(long id) {
        String sql = "SELECT id, name, surname, academic_degree, email,"
                + " password FROM doctor WHERE id = " + id;
        BeanPropertyRowMapper<Doctor> bprm = new BeanPropertyRowMapper<>(Doctor.class);
        return jdbcTemplate.query(sql, bprm).get(0);
    }

    @Override
    public void upgrade(Doctor doctor) {
        jdbcTemplate.update("UPDATE doctor SET name=?,"
                + " surname=?, academic_degree=?, email=?,"
                + " password=? WHERE id=?", doctor.getName(), doctor. getSurname(),
                doctor.getAcademic_degree(), doctor.getEmail(), doctor.getEmail(),
                doctor.getPassword(), doctor.getId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM doctor WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Doctor getDoctorByEmail(String email) {
        String sql = "SELECT id, name, surname, academic_degree, email,"
                + " password FROM doctor WHERE email = \'" + email + "\'";
        BeanPropertyRowMapper<Doctor> bprm = new BeanPropertyRowMapper<>(Doctor.class);
        List<Doctor> list = jdbcTemplate.query(sql, bprm);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public void upgradePass(Doctor doctor, String newPassword) {
       String sql = "UPDATE doctor SET password = \'" + newPassword + "\'"
               + " WHERE id = " + doctor.getId();
        jdbcTemplate.execute(sql);
    }

}
