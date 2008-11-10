/**
 *  Copyright (C) 2008  Sérgio Lopes
 *
 *  This file is part of KCookB.
 *
 *  KCookB is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  KCookB is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with KCookB. If not, see <http://www.gnu.org/licenses/gpl.html>.
 */
package de.berlios.kcookb.model;

/**
 * This class is a wrapper for time unit defined by an hour value and a minute
 * value. TimeUnit is used to mesure the time that take to prepare or cook a
 * recipe.
 *
 * The class does not work as a clock and only stores values. There will be
 * minimal validation, such that hours can't be negative and minutes belong to
 * the interval [0 - 59], either than that, all values are valid.
 *
 * @author Knitter
 */
public class TimeUnit {

    private int minute;
    private int hour;

    /**
     * Creates a TimeUnit.
     *
     * @param hour hour value.
     * @param minute minutes value.
     */
    public TimeUnit(int hour, int minute) {
        setHour(hour);
        setMinute(minute);
    }

    /**
     * Creates a TimeUnit with the given minutes and an hour of zero.
     *
     * @param minute minutes value.
     */
    public TimeUnit(int minute) {
        this(0, minute);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour >= 0) {
            this.hour = hour;
        }
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TimeUnit)) {
            return false;
        }

        TimeUnit other = (TimeUnit) obj;
        return hour == other.hour && minute == other.minute;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.minute;
        hash = 53 * hash + this.hour;
        return hash;
    }

    @Override
    public String toString() {
        return hour + ":" + minute;
    }
}
