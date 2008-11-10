/*
 *  RecipeConstants.java
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
 * This interface contains all constant values used in the model.
 * 
 * @author Knitter
 */
public interface RecipeConstants {

    /**
     * Represents the easiest level of difficulty for a recipe
     */
    public static final int DIFFICULTY_LEVEL_EASY = 0;
    /**
     * Medium level of difficulty
     */
    public static final int DIFFICULTY_LEVEL_MEDIUM = 1;
    /**
     * The hardest level of difficulty
     */
    public static final int DIFFICULTY_LEVEL_HARD = 2;
    /**
     * Price tag that represents the most cheap of recipes
     */
    public static final int PRICE_LEVEL_CHEAP = 3;
    /**
     * Price tag for medium priced recipes
     */
    public static final int PRICE_LEVEL_AFFORDABLE = 4;
    /**
     * Price tag for the most expensive recipes
     */
    public static final int PRICE_LEVEL_EXPENSIVE = 5;
}
