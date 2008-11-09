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

public class TimeUnit {

    private int minute;
    private int hour;

    public TimeUnit(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public TimeUnit(int minute) {
        this(0, minute);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
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

    public String toString() {
        return hour + ":" + minute;
    }
}
