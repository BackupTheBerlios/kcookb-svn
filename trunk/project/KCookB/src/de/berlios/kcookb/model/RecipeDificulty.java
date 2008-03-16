/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.berlios.kcookb.model;

/**
 *
 * @author Knitter
 */
public enum RecipeDificulty {
    
    HARD("Hard"),
    EASY("Easy"),
    MEDIUM("Medium");
    
    private String name;
    
    private RecipeDificulty(String name) {
        this.name = name;
    }
}
