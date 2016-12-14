/*
 * Copyright (C) 2016 Patrik Rojek
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

import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import sk.upjs.doctororganizer.DAO.DoctorDao;
import sk.upjs.doctororganizer.DAO.DoctorOfficeDao;
import sk.upjs.doctororganizer.Entities.Doctor;
import sk.upjs.doctororganizer.Entities.DoctorOffice;
import sk.upjs.doctororganizer.Factory.DaoFactory;

/**
 *
 * @author Patrik Rojek
 */
public class MysqlDoctorOfficeDaoTest {

    private DoctorOfficeDao doctorOfficeDao;
    private DoctorDao doctorDao;
    private JdbcTemplate jdbcTemplate;

    public MysqlDoctorOfficeDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        doctorOfficeDao = DaoFactory.INSTANCE.getDoctorOfficeDao();
        doctorDao = DaoFactory.INSTANCE.getDoctorDao();
        
        MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/doctororganizer?serverTimezone=Europe/Bratislava");
            dataSource.setUser("root");
            dataSource.setPassword("heslo");
            jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class MysqlDoctorOfficeDao.
     */
    @Test
    public void testAdd() {
        int pocetPred = doctorOfficeDao.getAll().size();
        Doctor doctor = new Doctor();
        doctor.setName("Meno");
        doctor.setSurname("Priezvisko");
        doctor.setAcademic_degree("titul");
        doctor.setEmail("email@email.com");
        doctor.setPassword("0000");
        doctorDao.add(doctor);
        DoctorOffice office = new DoctorOffice();
        office.setCity("Mesto");
        office.setStreet("Ulica");
        office.setHouse_number(1);
        office.setHospital("Nemocnica");
        office.setSpecialization("Specializacia");
        office.setOpening_hours("8:00-17:00");
        office.setPhone_number("0915000111");
        office.setId_doctor(doctorDao.getDoctorByEmail(doctor.getEmail()).getId());
        doctorOfficeDao.add(office);
        int pocetPo = doctorOfficeDao.getAll().size();
        assertEquals(pocetPred + 1, pocetPo);
    }

    /**
     * Test of getAll method, of class MysqlDoctorOfficeDao.
     */
    @Test
    public void testGetAll() {
        List<DoctorOffice> offices = doctorOfficeDao.getAll();
        assertTrue(offices != null);
    }

    /**
     * Test of getByDoctorId method, of class MysqlDoctorOfficeDao.
     */
    @Test
    public void testGetByDoctorId() {
        Doctor doctor = new Doctor();
        doctor.setName("Meno1");
        doctor.setSurname("Priezvisko1");
        doctor.setAcademic_degree("titul1");
        doctor.setEmail("email1@email.com");
        doctor.setPassword("0000");
        doctorDao.add(doctor);
        DoctorOffice office = new DoctorOffice();
        office.setCity("Mesto1");
        office.setStreet("Ulica1");
        office.setHouse_number(1);
        office.setHospital("Nemocnica1");
        office.setSpecialization("Specializacia1");
        office.setOpening_hours("8:00-17:00");
        office.setPhone_number("0915000111");
        office.setId_doctor(doctorDao.getDoctorByEmail(doctor.getEmail()).getId());
        doctorOfficeDao.add(office);
        doctor = doctorDao.getDoctorByEmail(doctor.getEmail());
        List<DoctorOffice> list = doctorOfficeDao.getByDoctorId(doctor.getId());
        for (DoctorOffice dO : list) {
            if (dO.getCity().equals(office.getCity()) && dO.getStreet().equals(office.getStreet())
                    && dO.getHouse_number() == office.getHouse_number() 
                    && dO.getHospital().equals(office.getHospital())
                    && dO.getSpecialization().equals(office.getSpecialization())
                    && dO.getOpening_hours().equals(office.getOpening_hours())
                    && dO.getPhone_number().equals(office.getPhone_number())
                    && Objects.equals(dO.getId_doctor(), office.getId_doctor())) {
                assertTrue(true);
                return;
            }
        }
        assertTrue(false);
    }

    /**
     * Test of upgrade method, of class MysqlDoctorOfficeDao.
     */
    @Test
    public void testUpgrade() {
       Doctor doctor = new Doctor();
        doctor.setName("Meno2");
        doctor.setSurname("Priezvisko2");
        doctor.setAcademic_degree("titul2");
        doctor.setEmail("email2@email.com");
        doctor.setPassword("0000");
        doctorDao.add(doctor);
        DoctorOffice office = new DoctorOffice();
        office.setCity("Mesto2");
        office.setStreet("Ulica2");
        office.setHouse_number(3);
        office.setHospital("Nemocnica2");
        office.setSpecialization("Specializacia2");
        office.setOpening_hours("8:00-17:00");
        office.setPhone_number("0915000111");
        office.setId_doctor(doctorDao.getDoctorByEmail(doctor.getEmail()).getId());
        
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("doctororganizer.doctor_office");
        simpleJdbcInsert.usingGeneratedKeyColumns("id");
        simpleJdbcInsert.usingColumns("city", "street", "house_number", "hospital","specialization","opening_hours","phone_number","id_doctor");
        Map<String,Object> hodnoty = new HashMap<>();
        hodnoty.put("city", office.getCity());
        hodnoty.put("street", office.getStreet());
        hodnoty.put("house_number", office.getHouse_number());
        hodnoty.put("hospital", office.getHospital());
        hodnoty.put("specialization", office.getSpecialization());
        hodnoty.put("opening_hours", office.getOpening_hours());
        hodnoty.put("phone_number", office.getPhone_number());
        hodnoty.put("id_doctor", office.getId_doctor());        
        Long newId = simpleJdbcInsert.executeAndReturnKey(hodnoty).longValue();
        office.setId(newId);
        
        office.setCity("Mesto2Updated");
        office.setStreet("Ulica2Updated");
        doctorOfficeDao.upgrade(office);
        List<DoctorOffice> list = doctorOfficeDao.getByDoctorId(office.getId_doctor());
        for (DoctorOffice doctorOffice : list) {
            if (doctorOffice == office) {
                assertEquals(office, doctorOffice);
                return;
            }
        }
        assertFalse(false);                
    }

    /**
     * Test of delete method, of class MysqlDoctorOfficeDao.
     */
    @Test
    public void testDelete() {
        Doctor doctor = new Doctor();
        doctor.setName("Meno3");
        doctor.setSurname("Priezvisko3");
        doctor.setAcademic_degree("titul3");
        doctor.setEmail("email3@email.com");
        doctor.setPassword("0000");
        doctorDao.add(doctor);
        DoctorOffice office = new DoctorOffice();
        office.setCity("Mesto3");
        office.setStreet("Ulica3");
        office.setHouse_number(3);
        office.setHospital("Nemocnica3");
        office.setSpecialization("Specializacia3");
        office.setOpening_hours("8:00-17:00");
        office.setPhone_number("0915000111");
        office.setId_doctor(doctorDao.getDoctorByEmail(doctor.getEmail()).getId());
        
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("doctororganizer.doctor_office");
        simpleJdbcInsert.usingGeneratedKeyColumns("id");
        simpleJdbcInsert.usingColumns("city", "street", "house_number", "hospital","specialization","opening_hours","phone_number","id_doctor");
        Map<String,Object> hodnoty = new HashMap<>();
        hodnoty.put("city", office.getCity());
        hodnoty.put("street", office.getStreet());
        hodnoty.put("house_number", office.getHouse_number());
        hodnoty.put("hospital", office.getHospital());
        hodnoty.put("specialization", office.getSpecialization());
        hodnoty.put("opening_hours", office.getOpening_hours());
        hodnoty.put("phone_number", office.getPhone_number());
        hodnoty.put("id_doctor", office.getId_doctor());        
        Long newId = simpleJdbcInsert.executeAndReturnKey(hodnoty).longValue();
        office.setId(newId);
        
        int pocetPred = doctorOfficeDao.getAll().size();
        doctorOfficeDao.delete(newId);
        int pocetPo = doctorOfficeDao.getAll().size();
        assertEquals(pocetPred - 1, pocetPo);      
    }

    /**
     * Test of getSpecializations method, of class MysqlDoctorOfficeDao.
     */
    @Test
    public void testGetSpecializations() {
        Doctor doctor = new Doctor();
        doctor.setName("Meno4");
        doctor.setSurname("Priezvisko4");
        doctor.setAcademic_degree("titul4");
        doctor.setEmail("email4@email.com");
        doctor.setPassword("0000");
        doctorDao.add(doctor);
        DoctorOffice office = new DoctorOffice();
        office.setCity("Mesto4");
        office.setStreet("Ulica4");
        office.setHouse_number(4);
        office.setHospital("Nemocnica4");
        office.setSpecialization("Specializacia4");
        office.setOpening_hours("8:00-17:00");
        office.setPhone_number("0915000111");
        office.setId_doctor(doctorDao.getDoctorByEmail(doctor.getEmail()).getId());
        
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("doctororganizer.doctor_office");
        simpleJdbcInsert.usingGeneratedKeyColumns("id");
        simpleJdbcInsert.usingColumns("city", "street", "house_number", "hospital","specialization","opening_hours","phone_number","id_doctor");
        Map<String,Object> hodnoty = new HashMap<>();
        hodnoty.put("city", office.getCity());
        hodnoty.put("street", office.getStreet());
        hodnoty.put("house_number", office.getHouse_number());
        hodnoty.put("hospital", office.getHospital());
        hodnoty.put("specialization", office.getSpecialization());
        hodnoty.put("opening_hours", office.getOpening_hours());
        hodnoty.put("phone_number", office.getPhone_number());
        hodnoty.put("id_doctor", office.getId_doctor());        
        Long newId = simpleJdbcInsert.executeAndReturnKey(hodnoty).longValue();
        office.setId(newId);
        
        List<DoctorOffice> list = doctorOfficeDao.getSpecializations();
        for (DoctorOffice doctorOffice : list) {
            if (doctorOffice.getSpecialization().equals(office.getSpecialization())) {
                assertTrue(true);
                return;
            }
        }
        assertFalse(false);       
    }

    /**
     * Test of getBySpecializationAndCity method, of class MysqlDoctorOfficeDao.
     */
    @Test
    public void testGetBySpecializationAndCity() {
        Doctor doctor = new Doctor();
        doctor.setName("Meno5");
        doctor.setSurname("Priezvisko5");
        doctor.setAcademic_degree("titul5");
        doctor.setEmail("email5@email.com");
        doctor.setPassword("0000");
        doctorDao.add(doctor);
        DoctorOffice office = new DoctorOffice();
        office.setCity("Mesto5");
        office.setStreet("Ulica5");
        office.setHouse_number(5);
        office.setHospital("Nemocnica5");
        office.setSpecialization("Specializacia5");
        office.setOpening_hours("8:00-17:00");
        office.setPhone_number("0915000111");
        office.setId_doctor(doctorDao.getDoctorByEmail(doctor.getEmail()).getId());
        
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("doctororganizer.doctor_office");
        simpleJdbcInsert.usingGeneratedKeyColumns("id");
        simpleJdbcInsert.usingColumns("city", "street", "house_number", "hospital","specialization","opening_hours","phone_number","id_doctor");
        Map<String,Object> hodnoty = new HashMap<>();
        hodnoty.put("city", office.getCity());
        hodnoty.put("street", office.getStreet());
        hodnoty.put("house_number", office.getHouse_number());
        hodnoty.put("hospital", office.getHospital());
        hodnoty.put("specialization", office.getSpecialization());
        hodnoty.put("opening_hours", office.getOpening_hours());
        hodnoty.put("phone_number", office.getPhone_number());
        hodnoty.put("id_doctor", office.getId_doctor());        
        Long newId = simpleJdbcInsert.executeAndReturnKey(hodnoty).longValue();
        office.setId(newId);
        
        List<DoctorOffice> list = doctorOfficeDao.getBySpecializationAndCity(office.getSpecialization(), office.getCity());
        for (DoctorOffice doctorOffice : list) {
            if (doctorOffice.equals(office)) {
                assertTrue(true);
                return;
            }
        }
        assertFalse(false);
    }

    /**
     * Test of getCities method, of class MysqlDoctorOfficeDao.
     */
    @Test
    public void testGetCities() {
        Doctor doctor = new Doctor();
        doctor.setName("Meno6");
        doctor.setSurname("Priezvisko6");
        doctor.setAcademic_degree("titul6");
        doctor.setEmail("email6@email.com");
        doctor.setPassword("0000");
        doctorDao.add(doctor);
        DoctorOffice office = new DoctorOffice();
        office.setCity("Mesto6");
        office.setStreet("Ulica6");
        office.setHouse_number(6);
        office.setHospital("Nemocnica6");
        office.setSpecialization("Specializacia6");
        office.setOpening_hours("8:00-17:00");
        office.setPhone_number("0915000111");
        office.setId_doctor(doctorDao.getDoctorByEmail(doctor.getEmail()).getId());
        
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("doctororganizer.doctor_office");
        simpleJdbcInsert.usingGeneratedKeyColumns("id");
        simpleJdbcInsert.usingColumns("city", "street", "house_number", "hospital","specialization","opening_hours","phone_number","id_doctor");
        Map<String,Object> hodnoty = new HashMap<>();
        hodnoty.put("city", office.getCity());
        hodnoty.put("street", office.getStreet());
        hodnoty.put("house_number", office.getHouse_number());
        hodnoty.put("hospital", office.getHospital());
        hodnoty.put("specialization", office.getSpecialization());
        hodnoty.put("opening_hours", office.getOpening_hours());
        hodnoty.put("phone_number", office.getPhone_number());
        hodnoty.put("id_doctor", office.getId_doctor());        
        Long newId = simpleJdbcInsert.executeAndReturnKey(hodnoty).longValue();
        office.setId(newId);
        
        List<DoctorOffice> list = doctorOfficeDao.getCities();
        for (DoctorOffice doctorOffice : list) {
            if (doctorOffice.getCity().equals(office.getCity())) {
                assertTrue(true);
                return;
            }
        }
        assertFalse(false);   
    }

}
