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
package sk.upjs.doctororganizer.Models;

import javax.swing.AbstractListModel;
import sk.upjs.doctororganizer.DAO.TermDao;
import sk.upjs.doctororganizer.Entities.Term;
import sk.upjs.doctororganizer.Factory.DaoFactory;

public class TermListModel extends AbstractListModel<Term> {

    TermDao dao;
    Long doctorOfficeId;
    
    public TermListModel(Long doctorOfficeId) {
        this.doctorOfficeId = doctorOfficeId;
        dao = DaoFactory.INSTANCE.getTermDao();
    }

    @Override
    public int getSize() {
       return dao.getTermByDoctorOfficeId(doctorOfficeId).size();
    }

    @Override
    public Term getElementAt(int index) {
       return dao.getTermByDoctorOfficeId(doctorOfficeId).get(index);
    }
    
}
