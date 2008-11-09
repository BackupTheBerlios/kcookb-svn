/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.berlios.kcookb.testing;

import de.berlios.kcookb.model.KCBEngine;
import de.berlios.kcookb.model.Recipe;

/**
 *
 * @author Knitter
 */
public class Development {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KCBEngine eng = new KCBEngine();
        eng.openBook("c:\\test.kcb");
        for(Recipe r : eng.listAllRecipes()) {
            System.out.println(r.getName());
        }
        eng.closeBook();
    }

}
