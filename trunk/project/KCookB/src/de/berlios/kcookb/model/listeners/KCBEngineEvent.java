/*
 *  KCBEngineEvent.java
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
package de.berlios.kcookb.model.listeners;

import java.util.EventObject;
import de.berlios.kcookb.model.KCBEngine;
import de.berlios.kcookb.model.Recipe;

/**
 * Represents an event used by engine listeners.
 *
 * @see KCBEngineListener
 * 
 * @author Knitter
 */
public class KCBEngineEvent extends EventObject {

    private Recipe oldRecipe;
    private Recipe newRecipe;
    private String bookName;

    public KCBEngineEvent(KCBEngine source, Recipe oldRecipe, Recipe newRecipe, String bookName) {
        super(source);
        this.oldRecipe = oldRecipe;
        this.newRecipe = newRecipe;
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public Recipe getNewRecipe() {
        return newRecipe;
    }

    public Recipe getOldRecipe() {
        return oldRecipe;
    }
}
