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
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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
        System.out.println("upgrade");
        DoctorOffice office = null;
        MysqlDoctorOfficeDao instance = null;
        instance.upgrade(office);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MysqlDoctorOfficeDao.
     */
    @Test
    public void testDelete() {
        
    }

    /**
     * Test of getSpecializations method, of class MysqlDoctorOfficeDao.
     */
    @Test
    public void testGetSpecializations() {
        System.out.println("getSpecializations");
        MysqlDoctorOfficeDao instance = null;
        List<DoctorOffice> expResult = null;
        List<DoctorOffice> result = instance.getSpecializations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBySpecializationAndCity method, of class MysqlDoctorOfficeDao.
     */
    @Test
    public void testGetBySpecializationAndCity() {
        System.out.println("getBySpecializationAndCity");
        String specialization = "";
        String city = "";
        MysqlDoctorOfficeDao instance = null;
        List<DoctorOffice> expResult = null;
        List<DoctorOffice> result = instance.getBySpecializationAndCity(specialization, city);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCities method, of class MysqlDoctorOfficeDao.
     */
    @Test
    public void testGetCities() {
        System.out.println("getCities");
        MysqlDoctorOfficeDao instance = null;
        List<DoctorOffice> expResult = null;
        List<DoctorOffice> result = instance.getCities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
