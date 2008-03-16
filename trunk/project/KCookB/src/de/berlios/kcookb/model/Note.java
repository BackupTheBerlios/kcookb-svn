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
public class Note {

    private String title;
    private String text;
    private LinkedList<Recipe> associeted;

    public Note(String title, String text, LinkedList<Recipe> associeted) {
        this.title = title;
        this.text = text;
        this.associeted = associeted;
    }

    public LinkedList<Recipe> getAssocieted() {
        return associeted;
    }

    public void setAssocieted(LinkedList<Recipe> associeted) {
        this.associeted = associeted;
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
        if (this.associeted != null && other.associeted != null) {
            for (Recipe r : associeted) {
                if (!other.associeted.contains(r)) {
                    return false;
                }
            }
        }
        return this.text.equalsIgnoreCase(other.text) && this.title.equalsIgnoreCase(other.title);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 23 * hash + (this.text != null ? this.text.hashCode() : 0);
        hash = 23 * hash + (this.associeted != null ? this.associeted.hashCode() : 0);
        return hash;
    }
}
