/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.model;

import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Knitter
 */
public class Recipe {
    
    //TODO: add/remove list elements methods
    //TODO: remove get/set methods for lists

    private String title;   
    private Date preparation;
    private Date cooking;
    private RecipeDificulty dificulty;
    private RecipePrice price;
    private LinkedList<Ingredient> ingredients;
    private NutricionalTable table;
    private RecipeType type;
    private int doses;
    private LinkedList<String> sequence;
    private String principal;
    private LinkedList<Note> notes;
    private LinkedList<Tip> tips;
    private double rating;
    private boolean stared;
    private LinkedList<RecipeTag> tags;
    private String method;
    private Date freazer;
    private Date fridge;
    private Date added;

    public Recipe(String title, Date preparation, Date cooking, RecipeDificulty dificulty,
            RecipePrice price, LinkedList<Ingredient> ingredients, NutricionalTable table,
            RecipeType type, int doses, LinkedList<String> sequence, String principal,
            LinkedList<Note> notes, LinkedList<Tip> tips, double rating, boolean stared,
            LinkedList<RecipeTag> tags, String method, Date freazer, Date fridge) {

        this.title = title;
        this.preparation = preparation;
        this.cooking = cooking;
        this.dificulty = dificulty;
        this.price = price;
        this.ingredients = ingredients;
        this.table = table;
        this.type = type;
        this.doses = doses;
        this.sequence = sequence;
        this.principal = principal;
        this.notes = notes;
        this.tips = tips;
        this.rating = rating;
        this.stared = stared;
        this.tags = tags;
        this.method = method;
        this.freazer = freazer;
        this.fridge = fridge;
        added = new Date(System.currentTimeMillis());
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

    public LinkedList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(LinkedList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

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

    public LinkedList<String> getSequence() {
        return sequence;
    }

    public void setSequence(LinkedList<String> sequence) {
        this.sequence = sequence;
    }

    public NutricionalTable getTable() {
        return table;
    }

    public void setTable(NutricionalTable table) {
        this.table = table;
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

    public LinkedList<Note> getNotes() {
        return notes;
    }

    public void setNotes(LinkedList<Note> notes) {
        this.notes = notes;
    }

    public LinkedList<Tip> getTips() {
        return tips;
    }

    public void setTips(LinkedList<Tip> tips) {
        this.tips = tips;
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

    public LinkedList<RecipeTag> getTags() {
        return tags;
    }

    public void setTags(LinkedList<RecipeTag> tags) {
        this.tags = tags;
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
        return this.title.equalsIgnoreCase(other.title);
    }
    
    public String toString() {
        return title;
    }
}
