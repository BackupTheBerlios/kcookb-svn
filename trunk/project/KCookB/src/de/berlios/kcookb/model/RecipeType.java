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
 * This is just a wrapper class around String due to db4o constraints.
 *
 * @author Knitter
 */
public class RecipeType {

    private String name;

    /**
     * Creates a recipe type.
     *
     * @param name, the name of this tag. If the name is null an
     * IllegalArgumenteException is thrown.
     */
    public RecipeType(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Type name cannot be null nor empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Compares another object with this tag.
     * The object is considered equal in the  following conditions:
     * - it is not null and
     * - it is the same as this tag or
     * - it is an instance of the Tag class and it's name is equal to this
     * tag's name, ignoring case.
     *
     * @param obj, the object to with use for comparing.
     * @return true, if the two objects are equal to one another
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Tag)) {
            return false;
        }

        return name.equalsIgnoreCase(((RecipeType) obj).name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return name;
    }
}
