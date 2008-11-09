/**
 *  Copyright (C) 2008  Sérgio Lopes
 *
 *  This file is part of KCookB.
 *
 *  KCookB is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  KCookB is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with KCookB. If not, see <http://www.gnu.org/licenses/gpl.html>.
 */
package de.berlios.kcookb.old.model.events;

import de.berlios.kcookb.old.model.KCookB;
import de.berlios.kcookb.old.model.Recipe;
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
