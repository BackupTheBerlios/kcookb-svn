/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.model;

/**
 *
 * @author Knitter
 */
public enum RecipePrice {

    CHEAP("Cheap"),
    EXPENSIVE("Expensive"),
    MEDIUM("Medium");
    private String name;

    private RecipePrice(String name) {
        this.name = name;
    }
}
