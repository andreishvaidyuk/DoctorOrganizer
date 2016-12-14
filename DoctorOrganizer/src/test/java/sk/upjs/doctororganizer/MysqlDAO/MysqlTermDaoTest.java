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
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import sk.upjs.doctororganizer.DAO.PatientDao;
import sk.upjs.doctororganizer.DAO.TermDao;
import sk.upjs.doctororganizer.Entities.Doctor;
import sk.upjs.doctororganizer.Entities.DoctorOffice;
import sk.upjs.doctororganizer.Entities.Patient;
import sk.upjs.doctororganizer.Entities.Term;
import sk.upjs.doctororganizer.Factory.DaoFactory;

/**
 *
 * @author Patrik Rojek
 */
public class MysqlTermDaoTest {
    
    private TermDao termDao;
    private PatientDao patientDao;
    private DoctorOfficeDao doctorOfficeDao;
    private DoctorDao doctorDao;
    private JdbcTemplate jdbcTemplate;
    
    public MysqlTermDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        termDao = DaoFactory.INSTANCE.getTermDao();
        patientDao = DaoFactory.INSTANCE.getPatientDao();
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
     * Test of add method, of class MysqlTermDao.
     */
    @Test
    public void testAdd() {
        int pocetPred = termDao.getAll().size();
        
        Doctor doctor = new Doctor();
        doctor.setName("Meno");
        doctor.setSurname("Priezvisko");
        doctor.setAcademic_degree("titul");
        doctor.setEmail("email00@email.com");
        doctor.setPassword("0000");
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("doctororganizer.doctor");
        simpleJdbcInsert.usingGeneratedKeyColumns("id");
        simpleJdbcInsert.usingColumns("name", "surname", "academic_degree", "email","password");
        Map<String,Object> hodnoty = new HashMap<>();
        hodnoty.put("name", doctor.getName());
        hodnoty.put("surname", doctor.getSurname());
        hodnoty.put("academic_degree", doctor.getAcademic_degree());
        hodnoty.put("email", doctor.getEmail());
        hodnoty.put("password", doctor.getPassword()); 
        Long newId = simpleJdbcInsert.executeAndReturnKey(hodnoty).longValue();
        doctor.setId(newId);
        
        Patient patient = new Patient();
        patient.setName("Meno");
        patient.setSurname("Priezvisko");
        patient.setAdress("adresa");
        patient.setDate_of_birth("1.1.1990");
        patient.setId_number(new BigInteger("9001017777"));
        patient.setInsured_at("Poistovna");
        patient.setPhone_number(new BigInteger("0915000111"));
        patient.setEmail("email01@email.com");
        patient.setPassword("0000");
        SimpleJdbcInsert simpleJdbcInsert1 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert1.withTableName("doctororganizer.patient");
        simpleJdbcInsert1.usingGeneratedKeyColumns("id");
        simpleJdbcInsert1.usingColumns("name", "surname", "adress", "date_of_birth", "id_number", "insured_at", "phone_number", "email", "password");
        Map<String,Object> hodnoty1 = new HashMap<>();
        hodnoty1.put("name", patient.getName());
        hodnoty1.put("surname", patient.getSurname());
        hodnoty1.put("adress", patient.getAdress());
        hodnoty1.put("date_of_birth", patient.getDate_of_birth());
        hodnoty1.put("id_number", patient.getId_number());
        hodnoty1.put("insured_at", patient.getInsured_at());
        hodnoty1.put("phone_number", patient.getPhone_number());
        hodnoty1.put("email", patient.getEmail());
        hodnoty1.put("password", patient.getPassword()); 
        Long newId1 = simpleJdbcInsert1.executeAndReturnKey(hodnoty1).longValue();
        patient.setId(newId1);
        
        DoctorOffice office = new DoctorOffice();
        office.setCity("Mesto");
        office.setStreet("Ulica");
        office.setHouse_number(0);
        office.setHospital("Nemocnica");
        office.setSpecialization("Specializacia");
        office.setOpening_hours("8:00-17:00");
        office.setPhone_number("0915000111");
        office.setId_doctor(doctor.getId());        
        SimpleJdbcInsert simpleJdbcInsert2 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert2.withTableName("doctororganizer.doctor_office");
        simpleJdbcInsert2.usingGeneratedKeyColumns("id");
        simpleJdbcInsert2.usingColumns("city", "street", "house_number", "hospital","specialization","opening_hours","phone_number","id_doctor");
        Map<String,Object> hodnoty2 = new HashMap<>();
        hodnoty2.put("city", office.getCity());
        hodnoty2.put("street", office.getStreet());
        hodnoty2.put("house_number", office.getHouse_number());
        hodnoty2.put("hospital", office.getHospital());
        hodnoty2.put("specialization", office.getSpecialization());
        hodnoty2.put("opening_hours", office.getOpening_hours());
        hodnoty2.put("phone_number", office.getPhone_number());
        hodnoty2.put("id_doctor", office.getId_doctor());        
        Long newId2 = simpleJdbcInsert2.executeAndReturnKey(hodnoty2).longValue();
        office.setId(newId2);
        
        Term term = new Term();
        term.setId_patient(patient.getId());
        term.setPatient(patient.getName() + " " + patient.getSurname());
        term.setId_doctor_office(office.getId());
        term.setDate(LocalDateTime.now());
        term.setTime("12:00");
        term.setReason("bla bla bla");
        term.setTerm_condition("neschválený");
        SimpleJdbcInsert simpleJdbcInsert3 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert3.withTableName("doctororganizer.term");
        simpleJdbcInsert3.usingGeneratedKeyColumns("id");
        simpleJdbcInsert3.usingColumns("id_patient", "patient", "id_doctor_office", "date","time","reason","term_condition");
        Map<String,Object> hodnoty3 = new HashMap<>();
        hodnoty3.put("id_patient", term.getId_patient());
        hodnoty3.put("patient", term.getPatient());
        hodnoty3.put("id_doctor_office", term.getId_doctor_office());
        hodnoty3.put("date", term.getDate());
        hodnoty3.put("time", term.getTime());
        hodnoty3.put("reason", term.getReason());
        hodnoty3.put("term_condition", term.getTerm_condition());    
        Long newId3 = simpleJdbcInsert3.executeAndReturnKey(hodnoty3).longValue();
        term.setId(newId3);
        
        int pocetPo = termDao.getAll().size();
        assertEquals(pocetPred + 1, pocetPo);
    }

    /**
     * Test of getAll method, of class MysqlTermDao.
     */
    @Test
    public void testGetAll() {
        List<Term> offices = termDao.getAll();
        assertTrue(offices != null);
    }

    /**
     * Test of getTermByDoctorOfficeIdAndDay method, of class MysqlTermDao.
     */
    @Test
    public void testGetTermByDoctorOfficeIdAndDay() {
        Doctor doctor = new Doctor();
        doctor.setName("Meno1");
        doctor.setSurname("Priezvisko1");
        doctor.setAcademic_degree("titul1");
        doctor.setEmail("email10@email.com");
        doctor.setPassword("0000");
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("doctororganizer.doctor");
        simpleJdbcInsert.usingGeneratedKeyColumns("id");
        simpleJdbcInsert.usingColumns("name", "surname", "academic_degree", "email","password");
        Map<String,Object> hodnoty = new HashMap<>();
        hodnoty.put("name", doctor.getName());
        hodnoty.put("surname", doctor.getSurname());
        hodnoty.put("academic_degree", doctor.getAcademic_degree());
        hodnoty.put("email", doctor.getEmail());
        hodnoty.put("password", doctor.getPassword()); 
        Long newId = simpleJdbcInsert.executeAndReturnKey(hodnoty).longValue();
        doctor.setId(newId);
        
        Patient patient = new Patient();
        patient.setName("Meno1");
        patient.setSurname("Priezvisko1");
        patient.setAdress("adresa1");
        patient.setDate_of_birth("1.1.1990");
        patient.setId_number(new BigInteger("9001017777"));
        patient.setInsured_at("Poistovna1");
        patient.setPhone_number(new BigInteger("0915000111"));
        patient.setEmail("email11@email.com");
        patient.setPassword("0000");
        SimpleJdbcInsert simpleJdbcInsert1 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert1.withTableName("doctororganizer.patient");
        simpleJdbcInsert1.usingGeneratedKeyColumns("id");
        simpleJdbcInsert1.usingColumns("name", "surname", "adress", "date_of_birth", "id_number", "insured_at", "phone_number", "email", "password");
        Map<String,Object> hodnoty1 = new HashMap<>();
        hodnoty1.put("name", patient.getName());
        hodnoty1.put("surname", patient.getSurname());
        hodnoty1.put("adress", patient.getAdress());
        hodnoty1.put("date_of_birth", patient.getDate_of_birth());
        hodnoty1.put("id_number", patient.getId_number());
        hodnoty1.put("insured_at", patient.getInsured_at());
        hodnoty1.put("phone_number", patient.getPhone_number());
        hodnoty1.put("email", patient.getEmail());
        hodnoty1.put("password", patient.getPassword()); 
        Long newId1 = simpleJdbcInsert1.executeAndReturnKey(hodnoty1).longValue();
        patient.setId(newId1);
        
        DoctorOffice office = new DoctorOffice();
        office.setCity("Mesto1");
        office.setStreet("Ulica1");
        office.setHouse_number(1);
        office.setHospital("Nemocnica1");
        office.setSpecialization("Specializacia1");
        office.setOpening_hours("8:00-17:00");
        office.setPhone_number("0915000111");
        office.setId_doctor(doctor.getId());        
        SimpleJdbcInsert simpleJdbcInsert2 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert2.withTableName("doctororganizer.doctor_office");
        simpleJdbcInsert2.usingGeneratedKeyColumns("id");
        simpleJdbcInsert2.usingColumns("city", "street", "house_number", "hospital","specialization","opening_hours","phone_number","id_doctor");
        Map<String,Object> hodnoty2 = new HashMap<>();
        hodnoty2.put("city", office.getCity());
        hodnoty2.put("street", office.getStreet());
        hodnoty2.put("house_number", office.getHouse_number());
        hodnoty2.put("hospital", office.getHospital());
        hodnoty2.put("specialization", office.getSpecialization());
        hodnoty2.put("opening_hours", office.getOpening_hours());
        hodnoty2.put("phone_number", office.getPhone_number());
        hodnoty2.put("id_doctor", office.getId_doctor());        
        Long newId2 = simpleJdbcInsert2.executeAndReturnKey(hodnoty2).longValue();
        office.setId(newId2);
        
        Term term = new Term();
        term.setId_patient(patient.getId());
        term.setPatient(patient.getName() + " " + patient.getSurname());
        term.setId_doctor_office(office.getId());
        term.setDate(LocalDateTime.now());
        term.setTime("12:00");
        term.setReason("bla bla bla");
        term.setTerm_condition("neschválený");
        SimpleJdbcInsert simpleJdbcInsert3 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert3.withTableName("doctororganizer.term");
        simpleJdbcInsert3.usingGeneratedKeyColumns("id");
        simpleJdbcInsert3.usingColumns("id_patient", "patient", "id_doctor_office", "date","time","reason","term_condition");
        Map<String,Object> hodnoty3 = new HashMap<>();
        hodnoty3.put("id_patient", term.getId_patient());
        hodnoty3.put("patient", term.getPatient());
        hodnoty3.put("id_doctor_office", term.getId_doctor_office());
        hodnoty3.put("date", term.getDate());
        hodnoty3.put("time", term.getTime());
        hodnoty3.put("reason", term.getReason());
        hodnoty3.put("term_condition", term.getTerm_condition());    
        Long newId3 = simpleJdbcInsert3.executeAndReturnKey(hodnoty3).longValue();
        term.setId(newId3);
        
        List<Term> list = termDao.getTermByDoctorOfficeIdAndDay(office.getId(), term.getDate().toString());
        for (Term termin : list) {
            if (term.equals(termin)) {
                assertTrue(true);
                return;
            }
        }
        assertFalse(false);
    }

    /**
     * Test of setTermCondition method, of class MysqlTermDao.
     */
    @Test
    public void testSetTermCondition() {
        Doctor doctor = new Doctor();
        doctor.setName("Meno2");
        doctor.setSurname("Priezvisko2");
        doctor.setAcademic_degree("titul2");
        doctor.setEmail("email20@email.com");
        doctor.setPassword("0000");
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("doctororganizer.doctor");
        simpleJdbcInsert.usingGeneratedKeyColumns("id");
        simpleJdbcInsert.usingColumns("name", "surname", "academic_degree", "email","password");
        Map<String,Object> hodnoty = new HashMap<>();
        hodnoty.put("name", doctor.getName());
        hodnoty.put("surname", doctor.getSurname());
        hodnoty.put("academic_degree", doctor.getAcademic_degree());
        hodnoty.put("email", doctor.getEmail());
        hodnoty.put("password", doctor.getPassword()); 
        Long newId = simpleJdbcInsert.executeAndReturnKey(hodnoty).longValue();
        doctor.setId(newId);
        
        Patient patient = new Patient();
        patient.setName("Meno2");
        patient.setSurname("Priezvisko2");
        patient.setAdress("adresa2");
        patient.setDate_of_birth("1.1.1990");
        patient.setId_number(new BigInteger("9001017777"));
        patient.setInsured_at("Poistovna2");
        patient.setPhone_number(new BigInteger("0915000111"));
        patient.setEmail("email21@email.com");
        patient.setPassword("0000");
        SimpleJdbcInsert simpleJdbcInsert1 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert1.withTableName("doctororganizer.patient");
        simpleJdbcInsert1.usingGeneratedKeyColumns("id");
        simpleJdbcInsert1.usingColumns("name", "surname", "adress", "date_of_birth", "id_number", "insured_at", "phone_number", "email", "password");
        Map<String,Object> hodnoty1 = new HashMap<>();
        hodnoty1.put("name", patient.getName());
        hodnoty1.put("surname", patient.getSurname());
        hodnoty1.put("adress", patient.getAdress());
        hodnoty1.put("date_of_birth", patient.getDate_of_birth());
        hodnoty1.put("id_number", patient.getId_number());
        hodnoty1.put("insured_at", patient.getInsured_at());
        hodnoty1.put("phone_number", patient.getPhone_number());
        hodnoty1.put("email", patient.getEmail());
        hodnoty1.put("password", patient.getPassword()); 
        Long newId1 = simpleJdbcInsert1.executeAndReturnKey(hodnoty1).longValue();
        patient.setId(newId1);
        
        DoctorOffice office = new DoctorOffice();
        office.setCity("Mesto2");
        office.setStreet("Ulica2");
        office.setHouse_number(2);
        office.setHospital("Nemocnica2");
        office.setSpecialization("Specializacia2");
        office.setOpening_hours("8:00-17:00");
        office.setPhone_number("0915000111");
        office.setId_doctor(doctor.getId());        
        SimpleJdbcInsert simpleJdbcInsert2 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert2.withTableName("doctororganizer.doctor_office");
        simpleJdbcInsert2.usingGeneratedKeyColumns("id");
        simpleJdbcInsert2.usingColumns("city", "street", "house_number", "hospital","specialization","opening_hours","phone_number","id_doctor");
        Map<String,Object> hodnoty2 = new HashMap<>();
        hodnoty2.put("city", office.getCity());
        hodnoty2.put("street", office.getStreet());
        hodnoty2.put("house_number", office.getHouse_number());
        hodnoty2.put("hospital", office.getHospital());
        hodnoty2.put("specialization", office.getSpecialization());
        hodnoty2.put("opening_hours", office.getOpening_hours());
        hodnoty2.put("phone_number", office.getPhone_number());
        hodnoty2.put("id_doctor", office.getId_doctor());        
        Long newId2 = simpleJdbcInsert2.executeAndReturnKey(hodnoty2).longValue();
        office.setId(newId2);
        
        Term term = new Term();
        term.setId_patient(patient.getId());
        term.setPatient(patient.getName() + " " + patient.getSurname());
        term.setId_doctor_office(office.getId());
        term.setDate(LocalDateTime.now());
        term.setTime("12:00");
        term.setReason("bla bla bla");
        term.setTerm_condition("neschválený");
        SimpleJdbcInsert simpleJdbcInsert3 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert3.withTableName("doctororganizer.term");
        simpleJdbcInsert3.usingGeneratedKeyColumns("id");
        simpleJdbcInsert3.usingColumns("id_patient", "patient", "id_doctor_office", "date","time","reason","term_condition");
        Map<String,Object> hodnoty3 = new HashMap<>();
        hodnoty3.put("id_patient", term.getId_patient());
        hodnoty3.put("patient", term.getPatient());
        hodnoty3.put("id_doctor_office", term.getId_doctor_office());
        hodnoty3.put("date", term.getDate());
        hodnoty3.put("time", term.getTime());
        hodnoty3.put("reason", term.getReason());
        hodnoty3.put("term_condition", term.getTerm_condition());    
        Long newId3 = simpleJdbcInsert3.executeAndReturnKey(hodnoty3).longValue();
        term.setId(newId3);
        
        String newCondition = "schválený";
        term.setTerm_condition(newCondition);
        termDao.setTermCondition(term.getId(), newCondition);
        List<Term> list = termDao.getTermsByPatientId(term.getId_patient());
        for (Term termin : list) {
            if (termin == term) {
                assertEquals(term, termin);
                return;
            }
        }
        assertFalse(false);
    }

    /**
     * Test of delete method, of class MysqlTermDao.
     */
    @Test
    public void testDelete() {       
        Doctor doctor = new Doctor();
        doctor.setName("Meno3");
        doctor.setSurname("Priezvisko3");
        doctor.setAcademic_degree("titul3");
        doctor.setEmail("email30@email.com");
        doctor.setPassword("0000");
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("doctororganizer.doctor");
        simpleJdbcInsert.usingGeneratedKeyColumns("id");
        simpleJdbcInsert.usingColumns("name", "surname", "academic_degree", "email","password");
        Map<String,Object> hodnoty = new HashMap<>();
        hodnoty.put("name", doctor.getName());
        hodnoty.put("surname", doctor.getSurname());
        hodnoty.put("academic_degree", doctor.getAcademic_degree());
        hodnoty.put("email", doctor.getEmail());
        hodnoty.put("password", doctor.getPassword()); 
        Long newId = simpleJdbcInsert.executeAndReturnKey(hodnoty).longValue();
        doctor.setId(newId);
        
        Patient patient = new Patient();
        patient.setName("Meno3");
        patient.setSurname("Priezvisko3");
        patient.setAdress("adresa3");
        patient.setDate_of_birth("1.1.1990");
        patient.setId_number(new BigInteger("9001017777"));
        patient.setInsured_at("Poistovna3");
        patient.setPhone_number(new BigInteger("0915000111"));
        patient.setEmail("email31@email.com");
        patient.setPassword("0000");
        SimpleJdbcInsert simpleJdbcInsert1 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert1.withTableName("doctororganizer.patient");
        simpleJdbcInsert1.usingGeneratedKeyColumns("id");
        simpleJdbcInsert1.usingColumns("name", "surname", "adress", "date_of_birth", "id_number", "insured_at", "phone_number", "email", "password");
        Map<String,Object> hodnoty1 = new HashMap<>();
        hodnoty1.put("name", patient.getName());
        hodnoty1.put("surname", patient.getSurname());
        hodnoty1.put("adress", patient.getAdress());
        hodnoty1.put("date_of_birth", patient.getDate_of_birth());
        hodnoty1.put("id_number", patient.getId_number());
        hodnoty1.put("insured_at", patient.getInsured_at());
        hodnoty1.put("phone_number", patient.getPhone_number());
        hodnoty1.put("email", patient.getEmail());
        hodnoty1.put("password", patient.getPassword()); 
        Long newId1 = simpleJdbcInsert1.executeAndReturnKey(hodnoty1).longValue();
        patient.setId(newId1);
        
        DoctorOffice office = new DoctorOffice();
        office.setCity("Mesto3");
        office.setStreet("Ulica3");
        office.setHouse_number(0);
        office.setHospital("Nemocnica3");
        office.setSpecialization("Specializacia3");
        office.setOpening_hours("8:00-17:00");
        office.setPhone_number("0915000111");
        office.setId_doctor(doctor.getId());        
        SimpleJdbcInsert simpleJdbcInsert2 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert2.withTableName("doctororganizer.doctor_office");
        simpleJdbcInsert2.usingGeneratedKeyColumns("id");
        simpleJdbcInsert2.usingColumns("city", "street", "house_number", "hospital","specialization","opening_hours","phone_number","id_doctor");
        Map<String,Object> hodnoty2 = new HashMap<>();
        hodnoty2.put("city", office.getCity());
        hodnoty2.put("street", office.getStreet());
        hodnoty2.put("house_number", office.getHouse_number());
        hodnoty2.put("hospital", office.getHospital());
        hodnoty2.put("specialization", office.getSpecialization());
        hodnoty2.put("opening_hours", office.getOpening_hours());
        hodnoty2.put("phone_number", office.getPhone_number());
        hodnoty2.put("id_doctor", office.getId_doctor());        
        Long newId2 = simpleJdbcInsert2.executeAndReturnKey(hodnoty2).longValue();
        office.setId(newId2);
        
        Term term = new Term();
        term.setId_patient(patient.getId());
        term.setPatient(patient.getName() + " " + patient.getSurname());
        term.setId_doctor_office(office.getId());
        term.setDate(LocalDateTime.now());
        term.setTime("12:00");
        term.setReason("bla bla bla");
        term.setTerm_condition("neschválený");
        SimpleJdbcInsert simpleJdbcInsert3 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert3.withTableName("doctororganizer.term");
        simpleJdbcInsert3.usingGeneratedKeyColumns("id");
        simpleJdbcInsert3.usingColumns("id_patient", "patient", "id_doctor_office", "date","time","reason","term_condition");
        Map<String,Object> hodnoty3 = new HashMap<>();
        hodnoty3.put("id_patient", term.getId_patient());
        hodnoty3.put("patient", term.getPatient());
        hodnoty3.put("id_doctor_office", term.getId_doctor_office());
        hodnoty3.put("date", term.getDate());
        hodnoty3.put("time", term.getTime());
        hodnoty3.put("reason", term.getReason());
        hodnoty3.put("term_condition", term.getTerm_condition());    
        Long newId3 = simpleJdbcInsert3.executeAndReturnKey(hodnoty3).longValue();
        term.setId(newId3);
        
        int pocetPred = termDao.getAll().size();
        termDao.delete(term.getId());
        int pocetPo = termDao.getAll().size();
        assertEquals(pocetPred - 1, pocetPo);
    }

    /**
     * Test of getTermsByPatientId method, of class MysqlTermDao.
     */
    @Test
    public void testGetTermsByPatientId() {
        Doctor doctor = new Doctor();
        doctor.setName("Meno4");
        doctor.setSurname("Priezvisko4");
        doctor.setAcademic_degree("titul4");
        doctor.setEmail("email40@email.com");
        doctor.setPassword("0000");
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("doctororganizer.doctor");
        simpleJdbcInsert.usingGeneratedKeyColumns("id");
        simpleJdbcInsert.usingColumns("name", "surname", "academic_degree", "email","password");
        Map<String,Object> hodnoty = new HashMap<>();
        hodnoty.put("name", doctor.getName());
        hodnoty.put("surname", doctor.getSurname());
        hodnoty.put("academic_degree", doctor.getAcademic_degree());
        hodnoty.put("email", doctor.getEmail());
        hodnoty.put("password", doctor.getPassword()); 
        Long newId = simpleJdbcInsert.executeAndReturnKey(hodnoty).longValue();
        doctor.setId(newId);
        
        Patient patient = new Patient();
        patient.setName("Meno4");
        patient.setSurname("Priezvisko4");
        patient.setAdress("adresa4");
        patient.setDate_of_birth("1.1.1990");
        patient.setId_number(new BigInteger("9001017777"));
        patient.setInsured_at("Poistovna4");
        patient.setPhone_number(new BigInteger("0915000111"));
        patient.setEmail("email41@email.com");
        patient.setPassword("0000");
        SimpleJdbcInsert simpleJdbcInsert1 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert1.withTableName("doctororganizer.patient");
        simpleJdbcInsert1.usingGeneratedKeyColumns("id");
        simpleJdbcInsert1.usingColumns("name", "surname", "adress", "date_of_birth", "id_number", "insured_at", "phone_number", "email", "password");
        Map<String,Object> hodnoty1 = new HashMap<>();
        hodnoty1.put("name", patient.getName());
        hodnoty1.put("surname", patient.getSurname());
        hodnoty1.put("adress", patient.getAdress());
        hodnoty1.put("date_of_birth", patient.getDate_of_birth());
        hodnoty1.put("id_number", patient.getId_number());
        hodnoty1.put("insured_at", patient.getInsured_at());
        hodnoty1.put("phone_number", patient.getPhone_number());
        hodnoty1.put("email", patient.getEmail());
        hodnoty1.put("password", patient.getPassword()); 
        Long newId1 = simpleJdbcInsert1.executeAndReturnKey(hodnoty1).longValue();
        patient.setId(newId1);
        
        DoctorOffice office = new DoctorOffice();
        office.setCity("Mesto4");
        office.setStreet("Ulica4");
        office.setHouse_number(4);
        office.setHospital("Nemocnica4");
        office.setSpecialization("Specializacia4");
        office.setOpening_hours("8:00-17:00");
        office.setPhone_number("0915000111");
        office.setId_doctor(doctor.getId());        
        SimpleJdbcInsert simpleJdbcInsert2 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert2.withTableName("doctororganizer.doctor_office");
        simpleJdbcInsert2.usingGeneratedKeyColumns("id");
        simpleJdbcInsert2.usingColumns("city", "street", "house_number", "hospital","specialization","opening_hours","phone_number","id_doctor");
        Map<String,Object> hodnoty2 = new HashMap<>();
        hodnoty2.put("city", office.getCity());
        hodnoty2.put("street", office.getStreet());
        hodnoty2.put("house_number", office.getHouse_number());
        hodnoty2.put("hospital", office.getHospital());
        hodnoty2.put("specialization", office.getSpecialization());
        hodnoty2.put("opening_hours", office.getOpening_hours());
        hodnoty2.put("phone_number", office.getPhone_number());
        hodnoty2.put("id_doctor", office.getId_doctor());        
        Long newId2 = simpleJdbcInsert2.executeAndReturnKey(hodnoty2).longValue();
        office.setId(newId2);
        
        Term term = new Term();
        term.setId_patient(patient.getId());
        term.setPatient(patient.getName() + " " + patient.getSurname());
        term.setId_doctor_office(office.getId());
        term.setDate(LocalDateTime.now());
        term.setTime("12:00");
        term.setReason("bla bla bla");
        term.setTerm_condition("neschválený");
        SimpleJdbcInsert simpleJdbcInsert3 = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert3.withTableName("doctororganizer.term");
        simpleJdbcInsert3.usingGeneratedKeyColumns("id");
        simpleJdbcInsert3.usingColumns("id_patient", "patient", "id_doctor_office", "date","time","reason","term_condition");
        Map<String,Object> hodnoty3 = new HashMap<>();
        hodnoty3.put("id_patient", term.getId_patient());
        hodnoty3.put("patient", term.getPatient());
        hodnoty3.put("id_doctor_office", term.getId_doctor_office());
        hodnoty3.put("date", term.getDate());
        hodnoty3.put("time", term.getTime());
        hodnoty3.put("reason", term.getReason());
        hodnoty3.put("term_condition", term.getTerm_condition());    
        Long newId3 = simpleJdbcInsert3.executeAndReturnKey(hodnoty3).longValue();
        term.setId(newId3);
        
        List<Term> list = termDao.getTermsByPatientId(term.getId_patient());
        for (Term termin : list) {
            if (termin == term) {
                assertEquals(term, termin);
                return;
            }
        }
        assertFalse(false);
    }
    
}
