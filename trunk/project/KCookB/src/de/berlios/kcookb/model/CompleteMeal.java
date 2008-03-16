/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.model;

import java.util.LinkedList;

/**
 *
 * @author Knitter
 */
public class CompleteMeal {

    private LinkedList<Recipe> recipes;

    public CompleteMeal(LinkedList<Recipe> recipes) {
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

        if (!(obj instanceof CompleteMeal)) {
            return false;
        }

        CompleteMeal other = (CompleteMeal) obj;
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
