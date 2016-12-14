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
package sk.upjs.doctororganizer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Patrik Rojek
 */
public class PasswordHashTest {
    
    public PasswordHashTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of hash method, of class PasswordHash.
     */
    @Test
    public void testHash() throws Exception {
        String password = "0000";
        String expResult = "9AF15B336E6A9619928537DF30B2E6A2376569FCF9D7E773ECCEDE65606529A0";
        String result = PasswordHash.hash(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of isExpectedPassword method, of class PasswordHash.
     */
    @Test
    public void testIsExpectedPassword() throws Exception {
        System.out.println("isExpectedPassword");
        String password = "0000";
        String hash = "9AF15B336E6A9619928537DF30B2E6A2376569FCF9D7E773ECCEDE65606529A0";
        assertTrue(PasswordHash.isExpectedPassword(password, hash));
    }
    
}
