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
import sk.upjs.doctororganizer.DAO.TermDao;
import sk.upjs.doctororganizer.Entities.Term;
import sk.upjs.doctororganizer.Factory.DaoFactory;

/**
 *
 * @author Patrik Rojek
 */
public class TermListModelForPatient extends DefaultListModel<Term> {

    TermDao dao;
    Long patientId;
    String date;
    
    public TermListModelForPatient(Long patientId) {
        this.patientId = patientId;
        dao = DaoFactory.INSTANCE.getTermDao();
    }

    @Override
    public int getSize() {
        return dao.getTermsByPatientId(patientId).size();
    }

    @Override
    public Term getElementAt(int index) {
        return dao.getTermsByPatientId(patientId).get(index);
    }
    
    public void refreshList() {
        this.fireContentsChanged(this, 0, this.getSize());
    }

}

