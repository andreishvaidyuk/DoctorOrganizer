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

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.doctororganizer.DAO.DoctorDao;
import sk.upjs.doctororganizer.Entities.Doctor;
import sk.upjs.doctororganizer.Factory.DaoFactory;

/**
 *
 * @author Patrik Rojek
 */
public class MysqlDoctorDaoTest {
    
    private DoctorDao doctorDao;
    
    public MysqlDoctorDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        doctorDao = DaoFactory.INSTANCE.getDoctorDao();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class MysqlDoctorDao.
     */
    @Test
    public void testAdd() {
        int pocetPred = doctorDao.getAll().size();
        Doctor doctor = new Doctor();
        doctor.setName("Meno");
        doctor.setSurname("Priezvisko");
        doctor.setAcademic_degree("titul");
        doctor.setEmail("email@email.com");
        doctor.setPassword("0000");        
        doctorDao.add(doctor);
        int pocetPo = doctorDao.getAll().size(); 
        assertEquals(pocetPred + 1, pocetPo);
    }

    /**
     * Test of getAll method, of class MysqlDoctorDao.
     */
    @Test
    public void testGetAll() {
        List<Doctor> doctors = doctorDao.getAll();
        assertTrue(doctors != null);
    }

    /**
     * Test of getDoctorByEmail method, of class MysqlDoctorDao.
     */
    @Test
    public void testGetDoctorByEmail() {
        Doctor doctor = new Doctor();
        doctor.setName("Meno1");
        doctor.setSurname("Priezvisko1");
        doctor.setAcademic_degree("titul1");
        doctor.setEmail("email1@email.com");
        doctor.setPassword("1111");        
        doctorDao.add(doctor);
        Doctor result = doctorDao.getDoctorByEmail(doctor.getEmail());
        assertEquals(doctor.getEmail(), result.getEmail());
    }

    /**
     * Test of upgradePass method, of class MysqlDoctorDao.
     */
    @Test
    public void testUpgradePass() {
        Doctor doctor = new Doctor();
        doctor.setName("Meno2");
        doctor.setSurname("Priezvisko2");
        doctor.setAcademic_degree("titul2");
        doctor.setEmail("email2@email.com");
        doctor.setPassword("2222");        
        doctorDao.add(doctor);
        String newPass = "0000";
        doctor = doctorDao.getDoctorByEmail(doctor.getEmail());
        doctorDao.upgradePass(doctor, newPass);  
        doctor = doctorDao.getDoctorByEmail(doctor.getEmail());
        String result = doctor.getPassword();
        assertEquals(result, newPass);
    }
    
}
