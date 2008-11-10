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
package de.berlios.kcookb.model.listeners;

import de.berlios.kcookb.model.Recipe;

/**
 * Recipe listener interface.
 *
 * Represents all objects that want to be notified of changes in a given recipe.
 * 
 * @author knitter
 */
public interface RecipeListener {

    /**
     * Notifies the listener that this recipe has changed.
     *
     * @param e generated event with information about the changes.
     *
     * @see Recipe
     * @see RecipeEvent
     */
    void recipeChanged(RecipeEvent e);
}
