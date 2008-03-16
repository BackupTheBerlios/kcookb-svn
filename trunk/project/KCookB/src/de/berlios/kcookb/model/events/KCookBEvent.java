/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.berlios.kcookb.model.events;

import de.berlios.kcookb.model.KCookB;
import de.berlios.kcookb.model.Recipe;
import java.util.EventObject;

/**
 *
 * @author Knitter
 */
public class KCookBEvent extends EventObject {
    
    private Recipe oldRecipe;
    private Recipe newRecipe;
    
    public KCookBEvent(KCookB source, Recipe oldRecipe, Recipe newRecipe) {
        super(source);
        this.oldRecipe = oldRecipe;
        this.newRecipe = newRecipe;
    }
    
    @Override
    public KCookB getSource() {
       return (KCookB)super.getSource();
    }
    
    public Recipe getOldRecipe() {
        return oldRecipe;
    }
    
    public Recipe getNewRecipe() {
        return newRecipe;
    }

}
