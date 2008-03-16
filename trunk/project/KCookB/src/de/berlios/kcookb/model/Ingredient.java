/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.berlios.kcookb.model;

/**
 *
 * @author Knitter
 */
public class Ingredient {
    
    private String name;
    private String quantity;
       
    public Ingredient(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
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
    
    @Override
        public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        
        if(!(obj instanceof Ingredient)) {
            return false;
        }
        
        Ingredient other = (Ingredient)obj;
        return this.name.equalsIgnoreCase(other.name) && this.quantity.equalsIgnoreCase(other.quantity);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 31 * hash + (this.quantity != null ? this.quantity.hashCode() : 0);
        return hash;
    }
}
