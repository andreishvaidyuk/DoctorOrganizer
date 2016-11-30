/*
 * Copyright (C) 2016 acer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Doctor> getAll() {
        String sql = "SELECT id, name, surname, academic_degree, email, password FROM doctor";
        BeanPropertyRowMapper<Doctor> bprm = new BeanPropertyRowMapper<>(Doctor.class);
        return jdbcTemplate.query(sql, bprm);
    }

    @Override
    public Doctor getId(Long id) {
        String sql = "SELECT id, name, surname, academic_degree, email, password FROM doctor WHERE id = " + id;
        BeanPropertyRowMapper<Doctor> bprm = new BeanPropertyRowMapper<>(Doctor.class);
        return jdbcTemplate.query(sql, bprm).get(0);
    }

    @Override
    public void upgrade(Doctor doctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
