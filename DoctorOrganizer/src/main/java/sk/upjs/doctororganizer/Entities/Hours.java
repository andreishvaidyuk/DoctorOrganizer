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
package sk.upjs.doctororganizer.Entities;

import java.util.LinkedList;
import java.util.List;

public class Hours {

    List<String> allHoursList = new LinkedList<>();

    public Hours() {
        allHoursList.add("00:00");
        allHoursList.add("00:30");
        allHoursList.add("01:00");
        allHoursList.add("01:30");
        allHoursList.add("02:00");
        allHoursList.add("02:30");
        allHoursList.add("03:00");
        allHoursList.add("03:30");
        allHoursList.add("04:00");
        allHoursList.add("04:30");
        allHoursList.add("05:00");
        allHoursList.add("05:30");
        allHoursList.add("06:00");
        allHoursList.add("06:30");
        allHoursList.add("07:00");
        allHoursList.add("07:30");
        allHoursList.add("08:00");
        allHoursList.add("08:30");
        allHoursList.add("09:00");
        allHoursList.add("09:30");
        allHoursList.add("10:00");
        allHoursList.add("10:30");
        allHoursList.add("11:00");
        allHoursList.add("11:30");
        allHoursList.add("12:00");
        allHoursList.add("12:30");
        allHoursList.add("13:00");
        allHoursList.add("13:30");
        allHoursList.add("14:00");
        allHoursList.add("14:30");
        allHoursList.add("15:00");
        allHoursList.add("15:30");
        allHoursList.add("16:00");
        allHoursList.add("16:30");
        allHoursList.add("17:00");
        allHoursList.add("17:30");
        allHoursList.add("18:00");
        allHoursList.add("18:30");
        allHoursList.add("19:00");
        allHoursList.add("19:30");
        allHoursList.add("20:00");
        allHoursList.add("20:30");
        allHoursList.add("21:00");
        allHoursList.add("21:30");
        allHoursList.add("22:00");
        allHoursList.add("22:30");
        allHoursList.add("23:00");
        allHoursList.add("23:30");
    }

    public List<String> getAllHoursList() {
        return allHoursList;
    }

    public List<String> getHoursListFromTo(List<String> hours ,String from, String to) {
        int start = 0;
        for (int i = 0; i < hours.size(); i++) {
            if (hours.get(i).equals(from)) {
                start = i;
                break;
            }
        }
        int end = hours.size();
        for (int i = 0; i < hours.size(); i++) {
            if (hours.get(i).equals(to)) {
                end = i;
                break;
            }
        }

        return hours.subList(start, end);
    }

}
