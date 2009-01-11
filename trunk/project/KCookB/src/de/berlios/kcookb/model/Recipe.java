/*
 *  Recipe.java
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

import de.berlios.kcookb.model.listeners.RecipeEvent;
import de.berlios.kcookb.model.listeners.RecipeListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

/**
 * The most important class of the system, this class represents a recipe and
 * all it's details.
 * 
 * @author Knitter
 */
public class Recipe {

    private long id;
    private String name;
    private int servings;
    private double rating;
    private boolean stared;
    private String directions;
    private GregorianCalendar added;
    private int difficulty;
    private int priceTag;
    private double price;
    private List<Ingredient> ingredients;
    private String suggestion;
    private RecipeType type;
    private List<Tag> tags;
    private Nutricional table;
    private int calories;
    private TimeUnit prepTime;
    private TimeUnit cooking;
    private int freazer;
    private int fridge;
    private String mainImage;
    private Vector<RecipeListener> listeners;

    public Recipe(String name, int servings, double rating, boolean stared,
            String directions, GregorianCalendar added, int difficulty, int priceTag,
            double price, List<Ingredient> ingredients, String suggestion,
            RecipeType type, List<Tag> tags, Nutricional table, int calories,
            TimeUnit prepTime, TimeUnit cooking, int freazer, int fridge, String mainImage, long id) {

        this.name = name;
        this.servings = servings;
        this.rating = rating;
        this.stared = stared;
        this.directions = directions;
        this.added = added;
        this.difficulty = difficulty;
        this.priceTag = priceTag;
        this.price = price;
        this.ingredients = ingredients;
        this.suggestion = suggestion;
        this.type = type;
        this.tags = tags;
        this.table = table;
        this.calories = calories;
        this.prepTime = prepTime;
        this.cooking = cooking;
        this.freazer = freazer;
        this.fridge = fridge;
        this.mainImage = mainImage;
        listeners = new Vector<RecipeListener>();
    }

    public Recipe(String name, long id) {
        this(name, 0, 0.0, false, "", null, RecipeConstants.DIFFICULTY_LEVEL_EASY,
                RecipeConstants.PRICE_LEVEL_CHEAP, 0.0, null, "", null, null,
                null, 0, null, null, 0, 0, "", id);
    }

    public long getId() {
        return id;
    }
    
    public GregorianCalendar getAdded() {
        return added;
    }

    public void setAdded(GregorianCalendar added) {
        this.added = added;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public TimeUnit getCooking() {
        return cooking;
    }

    public void setCooking(TimeUnit cooking) {
        this.cooking = cooking;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public int getFreazer() {
        return freazer;
    }

    public void setFreazer(int freazer) {
        this.freazer = freazer;
    }

    public int getFridge() {
        return fridge;
    }

    public void setFridge(int fridge) {
        this.fridge = fridge;
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<Ingredient>(ingredients);
    }

    public void addIngredient(Ingredient ingredient) {
        if (ingredients == null) {
            ingredients = new ArrayList<Ingredient>();
        }
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        if (ingredients != null) {
            ingredients.remove(ingredient);
        }
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String image) {
        mainImage = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeUnit getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(TimeUnit prepTime) {
        this.prepTime = prepTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPriceTag() {
        return priceTag;
    }

    public void setPriceTag(int priceTag) {
        this.priceTag = priceTag;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public boolean isStared() {
        return stared;
    }

    public void setStared(boolean stared) {
        this.stared = stared;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public Nutricional getTable() {
        return table;
    }

    public void setTable(Nutricional table) {
        this.table = table;
    }

    public List<Tag> getTags() {
        return new ArrayList<Tag>(tags);
    }

    public void addTags(Tag tag) {
        if (tags == null) {
            tags = new ArrayList<Tag>();
        }
        tags.add(tag);
    }

    public void removeTag(Tag tag) {
        if (tags != null) {
            tags.remove(tag);
        }
    }

    public RecipeType getType() {
        return type;
    }

    public void setType(RecipeType type) {
        this.type = type;
    }

    /**
     *
     * @param e
     */
    //TODO: Sync not needed?
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

    /**
     *
     * @param l
     * @return
     */
    //TODO: Sync not needed?
    public synchronized boolean addListener(RecipeListener l) {
        if (listeners == null) {
            listeners = new Vector<RecipeListener>();
        }
        return listeners.add(l);
    }

    /**
     * 
     * @param l
     * @return
     */
    //TODO: Sync not needed?
    public synchronized boolean removeListener(RecipeListener l) {
        if (listeners != null) {
            return listeners.remove(l);
        }

        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}