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

import de.berlios.kcookb.model.events.RecipeListener;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Knitter
 */
public class Recipe {

    private String title;
    private Date preparation;
    private Date cooking;
    private RecipeDificulty dificulty;
    private RecipePrice price;
    private List<Ingredient> ingredients;
    private RecipeType type;
    private int doses;
    private List<String> sequence;
    private String principal;
    private Note note;
    private List<Tip> tips;
    private double rating;
    private boolean stared;
    private List<RecipeTag> tags;
    private String method;
    private Date freazer;
    private Date fridge;
    private Date added;
    private Vector<RecipeListener> listeners;

    public Recipe(String title, Date preparation, Date cooking, RecipeDificulty dificulty,
            RecipePrice price, List<Ingredient> ingredients, RecipeType type, 
            int doses, List<String> sequence, String principal, Note note, 
            List<Tip> tips, double rating, boolean stared, List<RecipeTag> tags, 
            String method, Date freazer, Date fridge) {

        this.title = title;
        this.preparation = preparation;
        this.cooking = cooking;
        this.dificulty = dificulty;
        this.price = price;
        this.ingredients = (ingredients != null ? ingredients : new LinkedList<Ingredient>());
        this.type = type;
        this.doses = doses;
        this.sequence = (sequence != null ? sequence : new LinkedList<String>());
        this.principal = principal;
        this.note = note;
        this.tips = (tips != null ? tips : new LinkedList<Tip>());
        this.rating = rating;
        this.stared = stared;
        this.tags = (tags != null ? tags : new LinkedList<RecipeTag>());
        this.method = method;
        this.freazer = freazer;
        this.fridge = fridge;
        added = new Date();

        listeners = new Vector<RecipeListener>();
    }

    public Date getCooking() {
        return cooking;
    }

    public void setCooking(Date cooking) {
        this.cooking = cooking;
    }

    public RecipeDificulty getDificulty() {
        return dificulty;
    }

    public void setDificulty(RecipeDificulty dificulty) {
        this.dificulty = dificulty;
    }

    public int getDoses() {
        return doses;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }

    public void addIngredient(Ingredient ingredient) {
        if (ingredients == null) {
            ingredients = new LinkedList<Ingredient>();
        }
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        if (ingredients != null) {
            ingredients.remove(ingredient);
        }
    }

    //TODO: see if these set/get methods are necessary
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(LinkedList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSequence() {
        return sequence;
    }

    public void setSequence(LinkedList<String> sequence) {
        this.sequence = sequence;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public List<Tip> getTips() {
        return tips;
    }

    public void setTips(LinkedList<Tip> tips) {
        this.tips = tips;
    }

    public List<RecipeTag> getTags() {
        return tags;
    }

    public void setTags(LinkedList<RecipeTag> tags) {
        this.tags = tags;
    }
    /*END OF TODO*/

    public Date getPreparation() {
        return preparation;
    }

    public void setPreparation(Date preparation) {
        this.preparation = preparation;
    }

    public RecipePrice getPrice() {
        return price;
    }

    public void setPrice(RecipePrice price) {
        this.price = price;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public void addSequenceElement(String name) {
        if (sequence == null) {
            sequence = new LinkedList<String>();
        }
        sequence.add(name);
    }

    public void removeSequenceElement(String name) {
        if (sequence != null) {
            sequence.remove(name);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RecipeType getType() {
        return type;
    }

    public void setType(RecipeType type) {
        this.type = type;
    }

    public void addTip(Tip tip) {
        if (tips == null) {
            tips = new LinkedList<Tip>();
        }
        tips.add(tip);
    }

    public void removeTip(Tip tip) {
        if (tips != null) {
            tips.remove(tip);
        }
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isStared() {
        return stared;
    }

    public void setStared(boolean stared) {
        this.stared = stared;
    }

    public void addTag(RecipeTag tag) {
        if (tags == null) {
            tags = new LinkedList<RecipeTag>();
        }
        tags.add(tag);
    }

    public void removeTag(RecipeTag tag) {
        if (tags != null) {
            tags.remove(tag);
        }
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getFreazer() {
        return freazer;
    }

    public void setFreazer(Date freazer) {
        this.freazer = freazer;
    }

    public Date getFridge() {
        return fridge;
    }

    public void setFridge(Date fridge) {
        this.fridge = fridge;
    }

    public Date getAdded() {
        return added;
    }

    public void addListener(RecipeListener l) {
        if (listeners == null) {
            listeners = new Vector<RecipeListener>();
        }
        listeners.add(l);
    }

    public void removeListener(RecipeListener l) {
        if (listeners != null) {
            listeners.remove(l);
        }
    }

    /**
     * This does not extensibly compare two recipe objects, only the name is 
     * important to this implementation.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Recipe)) {
            return false;
        }

        Recipe other = (Recipe) obj;
        return this.title.equalsIgnoreCase(other.title) && type.equals(other.type);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 13 * hash + (this.type != null ? this.type.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return title;
    }
}
