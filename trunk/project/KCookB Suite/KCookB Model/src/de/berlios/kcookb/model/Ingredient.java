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

    private static final String DEFAULT_QUANTITY = "q.b.";
    private String quantity;
    private String name;

    public Ingredient(String name, String quantity) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
        this.quantity = quantity;
    }

    public Ingredient(String name) {
        this(name, DEFAULT_QUANTITY);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }

        if(!(obj instanceof Ingredient)) {
            return false;
        }

        Ingredient other = (Ingredient) obj;
        return name.compareToIgnoreCase(other.name) == 0 && name.compareToIgnoreCase(other.quantity) == 0;
    }
}
