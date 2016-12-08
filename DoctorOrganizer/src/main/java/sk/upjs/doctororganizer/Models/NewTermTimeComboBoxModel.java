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

import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.doctororganizer.DAO.TermDao;
import sk.upjs.doctororganizer.Entities.DoctorOffice;
import sk.upjs.doctororganizer.Entities.Hours;
import sk.upjs.doctororganizer.Entities.Term;
import sk.upjs.doctororganizer.Factory.DaoFactory;

public class NewTermTimeComboBoxModel extends DefaultComboBoxModel<String> {

    private TermDao dao = DaoFactory.INSTANCE.getTermDao();
    private DoctorOffice office;

    public NewTermTimeComboBoxModel(DoctorOffice office, String date) {
        this.office = office;
        String openingHours = office.getOpening_hours();
        String openingHour = openingHours.substring(0, openingHours.indexOf("-"));
        String closingHour = openingHours.substring(openingHours.indexOf("-") + 1, openingHours.length());
        Hours hours = new Hours();
        List<String> availibleHours = hours.getHoursListFromTo(hours.getAllHoursList(), openingHour, closingHour);
        /*reservedTime - all reserved times for specific date*/
        List<Term> termsList = dao.getTermByDoctorOfficeIdAndDay(office.getId(), date);
        List<String> reservedTimes = new LinkedList<>();
        for (Term term : termsList) {
            reservedTimes.add(term.getTime());
        }
        availibleHours.removeAll(reservedTimes);
        for (String availibleHour : availibleHours) {
            this.addElement(availibleHour);
        }
    }

    public void refresh(String date) {
        this.removeAllElements();
        String openingHours = office.getOpening_hours();
        String openingHour = openingHours.substring(0, openingHours.indexOf("-"));
        String closingHour = openingHours.substring(openingHours.indexOf("-") + 1, openingHours.length());
        Hours hours = new Hours();
        List<String> availibleHours = hours.getHoursListFromTo(hours.getAllHoursList(), openingHour, closingHour);
        /*reservedTime - all reserved times for specific date*/
        List<Term> termsList = dao.getTermByDoctorOfficeIdAndDay(office.getId(), date);
        List<String> reservedTimes = new LinkedList<>();
        for (Term term : termsList) {
            reservedTimes.add(term.getTime());
        }
        availibleHours.removeAll(reservedTimes);
        for (String availibleHour : availibleHours) {
            this.addElement(availibleHour);
        }
        this.fireContentsChanged(this, 0, this.getSize());
    }

}
