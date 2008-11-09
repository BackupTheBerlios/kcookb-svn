/**
 *  Copyright (C) 2008  Sérgio Lopes
 *
 *  This file is part of KCookB.
 *
 *  KCookB is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
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
package de.berlios.kcookb.old.model;

/**
 *
 * @author Knitter
 */
public class Note {

    private String text;
    private Recipe owner;

    public Note(String text, Recipe owner) {
        this.text = text;
        this.owner = owner;
    }

    public Recipe getOwner() {
        return owner;
    }

    public void setOwner(Recipe owner) {
        this.owner = owner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Note)) {
            return false;
        }

        Note other = (Note) obj;
        return this.text.equalsIgnoreCase(other.text) 
                && this.owner.equals(other.owner);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.text != null ? this.text.hashCode() : 0);
        hash = 23 * hash + (this.owner != null ? this.owner.hashCode() : 0);
        return hash;
    }
}
