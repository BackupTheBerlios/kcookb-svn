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

import java.util.Date;
import java.util.List;

public class Recipe {

    private String name;
    private int doses;
    private double rating;
    private boolean stared;
    private String preparation;
    private Date added;
    private String difficulty;
    private String pricetag;
    private List<Tag> tags;

    //private Date preparation;
    //private Date cooking;
    //private List<Ingredient> ingredients;
    //private RecipeType type;
    //private Note note;
    //private List<Tip> tips;
    //private Date freazer;
    //private Date fridge;
    //private transient Vector<RecipeListener> listeners;
}