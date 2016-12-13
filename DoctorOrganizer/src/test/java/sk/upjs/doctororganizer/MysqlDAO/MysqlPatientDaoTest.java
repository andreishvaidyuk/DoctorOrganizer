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

import java.math.BigInteger;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.doctororganizer.DAO.PatientDao;
import sk.upjs.doctororganizer.Entities.Patient;
import sk.upjs.doctororganizer.Factory.DaoFactory;

/**
 *
 * @author Patrik Rojek
 */
public class MysqlPatientDaoTest {
    
    private PatientDao patientDao;
    
    public MysqlPatientDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        patientDao = DaoFactory.INSTANCE.getPatientDao();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class MysqlPatientDao.
     */
    @Test
    public void testAdd() {
        int pocetPred = patientDao.getAll().size();
        Patient patient = new Patient();
        patient.setName("Meno");
        patient.setSurname("Priezvisko");
        patient.setAdress("adresa");
        patient.setDate_of_birth("1.1.1990");
        patient.setId_number(new BigInteger("9001017777"));
        patient.setInsured_at("Poistovna");
        patient.setPhone_number(new BigInteger("0915000111"));
        patient.setEmail("email@email.com");
        patient.setPassword("0000");        
        patientDao.add(patient);
        int pocetPo = patientDao.getAll().size(); 
        assertEquals(pocetPred + 1, pocetPo);
    }

    /**
     * Test of getAll method, of class MysqlPatientDao.
     */
    @Test
    public void testGetAll() {
        List<Patient> patients = patientDao.getAll();
        assertTrue(patients != null);
    }

    /**
     * Test of getPatientByEmail method, of class MysqlPatientDao.
     */
    @Test
    public void testGetPatientByEmail() {
        Patient patient = new Patient();
        patient.setName("Meno1");
        patient.setSurname("Priezvisko1");
        patient.setAdress("adresa1");
        patient.setDate_of_birth("1.1.1990");
        patient.setId_number(new BigInteger("9001017777"));
        patient.setInsured_at("Poistovna1");
        patient.setPhone_number(new BigInteger("0915000111"));
        patient.setEmail("email1@email.com");
        patient.setPassword("1111");        
        patientDao.add(patient);
        Patient result = patientDao.getPatientByEmail(patient.getEmail());
        assertEquals(patient.getEmail(), result.getEmail());
    }

    /**
     * Test of upgradePass method, of class MysqlPatientDao.
     */
    @Test
    public void testUpgradePass() {
        Patient patient = new Patient();
        patient.setName("Meno2");
        patient.setSurname("Priezvisko2");
        patient.setAdress("adresa2");
        patient.setDate_of_birth("1.1.1990");
        patient.setId_number(new BigInteger("9001017777"));
        patient.setInsured_at("Poistovna2");
        patient.setPhone_number(new BigInteger("0915000111"));
        patient.setEmail("email2@email.com");
        patient.setPassword("2222");        
        patientDao.add(patient);
        String newPass = "0000";
        patient = patientDao.getPatientByEmail(patient.getEmail());
        patientDao.upgradePass(patient, newPass);    
        patient = patientDao.getPatientByEmail(patient.getEmail());
        String result = patient.getPassword();
        assertEquals(result, newPass);
    }
    
}
