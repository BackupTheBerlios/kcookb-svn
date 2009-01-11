/*
 *  Ingredient.java
 * 
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
 * Wrapper class for String.
 * Represents an ingredient.
 *
 * There is no validation to the value of an ingredient, and all text is
 * acceped.
 * 
 * @author Knitter
 */
public class Ingredient {

    private String value;

    /**
     * Creates an ingredient object.
     *
     * @param value the value of this ingredient.
     * @throws IllegalArgumentException when value is an empty or null string.
     */
    public Ingredient(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Ingredient cannot be null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Ingredient)) {
            return false;
        }

        Ingredient other = (Ingredient) obj;
        return value.compareToIgnoreCase(other.value) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return value;
    }
}
