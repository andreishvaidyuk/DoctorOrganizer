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
    public DoctorOffice getId(Long id) {
        String sql = "SELECT id, city, street, house_number, hospital, specialization, opening_hours, phone_number, id_doctor FROM doctor_office WHERE id = " + id;
        BeanPropertyRowMapper<DoctorOffice> bprm = new BeanPropertyRowMapper<>(DoctorOffice.class);
        return jdbcTemplate.query(sql, bprm).get(0);
    }

    @Override
    public void upgrade(DoctorOffice office) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
