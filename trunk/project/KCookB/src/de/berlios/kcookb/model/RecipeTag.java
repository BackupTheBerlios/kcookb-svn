/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.berlios.kcookb.model;

/**
 *
 * @author Knitter
 */
public class RecipeTag {
    
    private String name;
    
    public RecipeTag(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        return name.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
