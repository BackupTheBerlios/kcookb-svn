/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.berlios.kcookb.model.events;

import java.util.EventListener;

/**
 *
 * @author Knitter
 */
public interface KCookBChangedListener extends EventListener {
    
    void recipeAdded(KCookBEvent ev);
    void recipeDeleted(KCookBEvent ev);
}
