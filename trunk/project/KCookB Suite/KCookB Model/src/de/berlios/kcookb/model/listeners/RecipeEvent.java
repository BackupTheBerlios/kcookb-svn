/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.model.listeners;

import de.berlios.kcookb.model.Recipe;
import java.util.EventObject;

/**
 *
 * @author knitter
 */
public class RecipeEvent extends EventObject {

    public RecipeEvent(Recipe source) {
        super(source);
    }
}
