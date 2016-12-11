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
package sk.upjs.doctororganizer.Models;

import javax.swing.DefaultListModel;
import sk.upjs.doctororganizer.DAO.DoctorOfficeDao;
import sk.upjs.doctororganizer.Entities.DoctorOffice;
import sk.upjs.doctororganizer.Factory.DaoFactory;

/**
 *
 * @author Patrik Rojek
 */
public class OfficeListModelForPatient extends DefaultListModel<DoctorOffice> {

    DoctorOfficeDao dao;
    String specialization;
    String city;

    public OfficeListModelForPatient() {
        this.dao = DaoFactory.INSTANCE.getDoctorOfficeDao();
    }

    public OfficeListModelForPatient(String specialization,String city) {
        this.specialization = specialization;
        this.city = city;
        this.dao = DaoFactory.INSTANCE.getDoctorOfficeDao();
    }

    @Override
    public int getSize() {
        if (specialization != null && city != null) {
            return dao.getBySpecializationAndCity(specialization, city).size();
        } 
        return dao.getAll().size();         
    }

    @Override
    public DoctorOffice getElementAt(int index) {
        if (specialization != null && city != null) {
            return dao.getBySpecializationAndCity(specialization, city).get(index);
        } 
        return dao.getAll().get(index);           
    }

    public void refreshList() {
        fireContentsChanged(this, 0, getSize());
    }
    
}
