package sk.upjs.doctororganizer.MysqlDAO;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.doctororganizer.DAO.DoctorOfficeDao;
import sk.upjs.doctororganizer.Entities.DoctorOffice;

public class MysqlDoctorOfficeDao implements DoctorOfficeDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlDoctorOfficeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(DoctorOffice office) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DoctorOffice> getAll() {
        String sql = "SELECT id, city, street, house_number, hospital, specialization, opening_hours, phone_number, id_doctor FROM doctor_office";
        BeanPropertyRowMapper<DoctorOffice> bprm = new BeanPropertyRowMapper<>(DoctorOffice.class);
        return jdbcTemplate.query(sql, bprm);
    }

    @Override
    public DoctorOffice getId(long id) {
        String sql = "SELECT id, city, street, house_number, hospital, specialization, opening_hours, phone_number, id_doctor FROM doctor_office WHERE id = " + id;
        BeanPropertyRowMapper<DoctorOffice> bprm = new BeanPropertyRowMapper<>(DoctorOffice.class);
        return jdbcTemplate.query(sql, bprm).get(0);
    }

    @Override
    public void upgrade(DoctorOffice office) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM doctor_office WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

}
