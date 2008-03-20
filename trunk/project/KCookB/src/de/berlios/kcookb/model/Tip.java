/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.berlios.kcookb.model;

/**
 *
 * @author Knitter
 */
public class Tip {
    
    private String name;
    private String text;
    
    public Tip(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        
        if(!(obj instanceof Tip)) {
            return false;
        }
        
        Tip other = (Tip)obj;
        return this.name.equalsIgnoreCase(other.name) && this.text.equalsIgnoreCase(other.text);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 37 * hash + (this.text != null ? this.text.hashCode() : 0);
        return hash;
    }
}
