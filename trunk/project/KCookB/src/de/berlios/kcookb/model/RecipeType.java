/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.model;

/**
 *
 * @author Knitter
 */
public class RecipeType {

    private String name;

    public RecipeType(String name) {
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RecipeType)) {
            return false;
        }
        return name.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return name;
    }
}
