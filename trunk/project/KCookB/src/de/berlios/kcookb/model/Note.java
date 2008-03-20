/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.model;

/**
 *
 * @author Knitter
 */
public class Note {

    private String title;
    private String text;
    private Recipe owner;

    public Note(String title, String text, Recipe owner) {
        this.title = title;
        this.text = text;
        this.owner = owner;
    }

    public Recipe getOwner() {
        return owner;
    }

    public void setOwner(Recipe owner) {
        this.owner = owner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Note)) {
            return false;
        }

        Note other = (Note) obj;
        return this.text.equalsIgnoreCase(other.text) && this.title.equalsIgnoreCase(other.title) 
                && this.owner.equals(other.owner);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 23 * hash + (this.text != null ? this.text.hashCode() : 0);
        hash = 23 * hash + (this.owner != null ? this.owner.hashCode() : 0);
        return hash;
    }
}
