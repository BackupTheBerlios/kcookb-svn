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
package de.berlios.kcookb.model;

import java.util.LinkedList;

/**
 *
 * @author Knitter
 */
public class Meal {

    private LinkedList<Recipe> recipes;

    public Meal(LinkedList<Recipe> recipes) {
        this.recipes = recipes;
    }

    /**
     * This method will fail if any of the two objects contains a null list of
     * recipes.
     * 
     * @param obj object to compare this one to.
     * @return true if this object is equal to the passed object.
     * 
     * @see Recipe.equals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Meal)) {
            return false;
        }

        Meal other = (Meal) obj;
        if (this.recipes != null && other.recipes != null) {
            for (Recipe r : recipes) {
                if (!other.recipes.contains(r)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.recipes != null ? this.recipes.hashCode() : 0);
        return hash;
    }
}
