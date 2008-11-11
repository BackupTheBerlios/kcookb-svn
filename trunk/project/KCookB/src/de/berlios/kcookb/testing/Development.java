/*
 *  Development.java
 *
 *  Copyright (C) 2008  Sérgio Lopes
 *
 *  This file is part of KCookB.
 *
 *  KCookB is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
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
package de.berlios.kcookb.testing;

import de.berlios.kcookb.model.KCBEngine;
import de.berlios.kcookb.model.Recipe;
import java.io.File;

/**
 * Class used for testing purposes only.
 *
 * @author Knitter
 */
public class Development {

    public static void main(String[] args) {
        Development dev = new Development();
        KCBEngine eng = new KCBEngine();
        String bookname = "C:\\Documents and Settings\\Knitter\\Desktop\\book.kcb";

        eng.openBook(bookname);
        //dev.populate();
        //dev.doList();
        //dev.doSearch();
        eng.closeBook();
    }

    private void doSearch(KCBEngine eng, String value) {
        System.out.println("----------------- SEARCH -----------------");
        for (Recipe r : eng.searchByName(value)) {
            System.out.println("SEARCH: " + r.getName());
        }
    }

    private void doList(KCBEngine eng) {
        for (Recipe r : eng.listAllRecipes()) {
            System.out.println(r.getName());
        }
    }

    private void populate(KCBEngine eng) {
        eng.addRecipe(new Recipe("FreBra"));
        eng.addRecipe(new Recipe("Macarrão"));
        eng.addRecipe(new Recipe("Esparguete"));
        eng.addRecipe(new Recipe("Receita 2"));
        eng.addRecipe(new Recipe("ReceiTA 1"));
        eng.addRecipe(new Recipe("Sopa Vaca"));
        eng.addRecipe(new Recipe("VaCa Com Nabos"));
    }
}
