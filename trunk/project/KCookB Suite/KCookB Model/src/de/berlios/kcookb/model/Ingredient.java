/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.model;

/**
 *
 * @author knitter
 */
public class Ingredient {

    private String value;

    public Ingredient(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Ingredient cannot be null");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Ingredient)) {
            return false;
        }

        Ingredient other = (Ingredient) obj;
        return value.compareToIgnoreCase(other.value) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }
}
