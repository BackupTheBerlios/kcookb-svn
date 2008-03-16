/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.model;

import java.awt.Image;
import java.util.Date;
import java.util.LinkedList;

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
    private LinkedList<Ingredient> ingredients;
    private NutricionalTable table;
    private String type;
    private int doses;
    private LinkedList<Image> sequence;
    private Image principal;
    private LinkedList<Note> notes;
    private LinkedList<Note> tips;
    private double rating;
    private boolean stared;
    private LinkedList<String> tags;
    private String method;
    private Date freazer;
    private Date fridge;

    public Recipe(String title, Date preparation, Date cooking, RecipeDificulty dificulty,
            RecipePrice price, LinkedList<Ingredient> ingredients, NutricionalTable table,
            String type, int doses, LinkedList<Image> sequence, Image principal,
            LinkedList<Note> notes, LinkedList<Note> tips, double rating, boolean stared,
            LinkedList<String> tags, String method, Date freazer, Date fridge) {

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

    public Image getPrincipal() {
        return principal;
    }

    public void setPrincipal(Image principal) {
        this.principal = principal;
    }

    public LinkedList<Image> getSequence() {
        return sequence;
    }

    public void setSequence(LinkedList<Image> sequence) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LinkedList<Note> getNotes() {
        return notes;
    }

    public void setNotes(LinkedList<Note> notes) {
        this.notes = notes;
    }

    public LinkedList<Note> getTips() {
        return tips;
    }

    public void setTips(LinkedList<Note> tips) {
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

    public LinkedList<String> getTags() {
        return tags;
    }

    public void setTags(LinkedList<String> tags) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 17 * hash + (this.preparation != null ? this.preparation.hashCode() : 0);
        hash = 17 * hash + (this.cooking != null ? this.cooking.hashCode() : 0);
        hash = 17 * hash + (this.dificulty != null ? this.dificulty.hashCode() : 0);
        hash = 17 * hash + (this.price != null ? this.price.hashCode() : 0);
        hash = 17 * hash + (this.ingredients != null ? this.ingredients.hashCode() : 0);
        hash = 17 * hash + (this.table != null ? this.table.hashCode() : 0);
        hash = 17 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 17 * hash + this.doses;
        hash = 17 * hash + (this.sequence != null ? this.sequence.hashCode() : 0);
        hash = 17 * hash + (this.principal != null ? this.principal.hashCode() : 0);
        hash = 17 * hash + (this.notes != null ? this.notes.hashCode() : 0);
        hash = 17 * hash + (this.tips != null ? this.tips.hashCode() : 0);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.rating) ^ (Double.doubleToLongBits(this.rating) >>> 32));
        hash = 17 * hash + (this.stared ? 1 : 0);
        hash = 17 * hash + (this.tags != null ? this.tags.hashCode() : 0);
        hash = 17 * hash + (this.method != null ? this.method.hashCode() : 0);
        hash = 17 * hash + (this.freazer != null ? this.freazer.hashCode() : 0);
        hash = 17 * hash + (this.fridge != null ? this.fridge.hashCode() : 0);
        return hash;
    }
}
