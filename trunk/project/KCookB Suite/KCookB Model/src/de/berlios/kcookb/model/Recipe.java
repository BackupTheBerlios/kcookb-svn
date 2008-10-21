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

import de.berlios.kcookb.model.listeners.RecipeEvent;
import de.berlios.kcookb.model.listeners.RecipeListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Recipe {

    private String name;
    private int doses;
    private double rating;
    private boolean stared;
    private String preparation;
    private Date added;
    private int difficulty;
    private int price;
    private List<Ingredient> ingredients;
    private String suggestion;
    private RecipeType type;
    private List<Tag> tags;
    private Nutricional table;
    private Vector<RecipeListener> listeners;
    //private Date preparation;
    //private Date cooking;
    //private Date freazer;
    //private Date fridge;

    public void fireRecipeChanged(RecipeEvent e) {
        Vector<RecipeListener> copy;
        if (listeners != null) {

            synchronized (this) {
                copy = new Vector(listeners);
            }

            for (RecipeListener l : copy) {
                l.recipeChanged(e);
            }
        }
    }

    public synchronized boolean addListener(RecipeListener l) {
        if (listeners == null) {
            listeners = new Vector<RecipeListener>();
        }
        return listeners.add(l);
    }

    public synchronized boolean removeListener(RecipeListener l) {
        if (listeners != null) {
            return listeners.remove(l);
        }

        return false;
    }
}