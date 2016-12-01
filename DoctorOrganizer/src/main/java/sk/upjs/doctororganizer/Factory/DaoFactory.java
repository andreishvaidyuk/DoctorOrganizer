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
package sk.upjs.doctororganizer.Factory;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.doctororganizer.DAO.*;
import sk.upjs.doctororganizer.MysqlDAO.*;

public enum DaoFactory {
    INSTANCE;

    private DoctorDao mysqlDoctorDao;
    private DoctorOfficeDao mysqlDoctorOfficeDao;
    private PatientDao mysqlPatienDao;
    private TermDao mysqlTermDao;

    public DoctorDao getDoctorDao() {
        return getMysqlDoctorDao();
    }

    public DoctorOfficeDao getDoctorOfficeDao() {
        return getMysqlDoctorOfficeDao();
    }

    public PatientDao getPatientDao() {
        return getMysqlPatienDao();
    }

    public TermDao getTermDao() {
        return getMysqlTermDao();
    }

    private DoctorDao getMysqlDoctorDao() {
        if (mysqlDoctorDao == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/doctororganizer?serverTimezone=Europe/Bratislava");
            dataSource.setUser("root");
            dataSource.setPassword("heslo");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            mysqlDoctorDao = new MysqlDoctorDao(jdbcTemplate);
        }
        return mysqlDoctorDao;
    }

    private DoctorOfficeDao getMysqlDoctorOfficeDao() {
        if (mysqlDoctorOfficeDao == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/doctororganizer?serverTimezone=Europe/Bratislava");
            dataSource.setUser("root");
            dataSource.setPassword("heslo");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            mysqlDoctorOfficeDao = new MysqlDoctorOfficeDao(jdbcTemplate);
        }
        return mysqlDoctorOfficeDao;
    }

    private PatientDao getMysqlPatienDao() {
        if (mysqlPatienDao == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/doctororganizer?serverTimezone=Europe/Bratislava");
            dataSource.setUser("root");
            dataSource.setPassword("heslo");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            mysqlPatienDao = new MysqlPatientDao(jdbcTemplate);
        }
        return mysqlPatienDao;
    }

    private TermDao getMysqlTermDao() {
        if (mysqlTermDao == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/doctororganizer?serverTimezone=Europe/Bratislava");
            dataSource.setUser("root");
            dataSource.setPassword("heslo");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            mysqlTermDao = new MysqlTermDao(jdbcTemplate);
        }
        return mysqlTermDao;
    }

}
