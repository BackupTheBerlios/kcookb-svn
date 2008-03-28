/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.model;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import de.berlios.kcookb.exceptions.NonCoerentDatabaseException;
import de.berlios.kcookb.model.events.KCookBChangedListener;
import de.berlios.kcookb.model.events.KCookBEvent;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Knitter
 */
public class KCookB {

    private ObjectContainer db = null;
    private LinkedList<Recipe> unsavedRecipes = null;
    private Vector<KCookBChangedListener> bookChandeListeners = null;

    public KCookB() {
        unsavedRecipes = new LinkedList<Recipe>();
        bookChandeListeners = new Vector<KCookBChangedListener>();
    }

    public KCookB(String filename) {
        this();
        openDB(filename);
    }

    /**
     * Opens the database file. Attempting to open a file without closing a 
     * previous open file will make that previous file closed. All uncommited 
     * changes will be commit, if that is not desire all changes should be
     * rolled back and the file explicitly closed before atempting to open 
     * another one.
     * 
     * Trying to open a lock file will cause a runtime exception to be throwen, 
     * namely <code>DatabaseFileLockedException</code>.
     * 
     * @param filename The new file to be open
     */
    private void openDB(String filename) {
        closeCatalog();
        db = Db4o.openFile(filename);
    }

    /**
     * Opens a database file.
     * 
     * @param name The file to be open.
     * @see de.berlios.kcookb.model.KCookB.openCatalog
     */
    public void openCatalog(String name) {
        openDB(name);
    }

    /**
     * Closes an open database file, if it exists.
     * Trying to close a closed file will produce no efect.
     */
    public void closeCatalog() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    /**
     * 
     * @param title
     * @param preparation
     * @param cooking
     * @param dificulty
     * @param price
     * @param ingredients
     * @param table
     * @param type
     * @param doses
     * @param sequence
     * @param principal
     * @param notes
     * @param tips
     * @param rating
     * @param stared
     * @param tags
     * @param method
     * @param freazer
     * @param fridge
     */
    public void addRecipe(String title, Date preparation, Date cooking, RecipeDificulty dificulty,
            RecipePrice price, LinkedList<Ingredient> ingredients, NutricionalTable table,
            String type, int doses, LinkedList<String> sequence, String principal,
            LinkedList<Note> notes, LinkedList<Tip> tips, double rating, boolean stared,
            LinkedList<String> tags, String method, Date freazer, Date fridge) {

        Recipe rec = new Recipe(title, preparation, cooking, dificulty, price,
                ingredients, table, type, doses, sequence, principal, notes,
                tips, rating, stared, tags, method, freazer, fridge);

        db.set(rec);

        fireRecipeAdded(new KCookBEvent(this, null, rec));
    }

    /**
     * 
     * @param recipe
     * @throws de.berlios.kcookb.exceptions.NonCoerentDatabaseException
     */
    public void removeRecipe(Recipe recipe) throws NonCoerentDatabaseException {
        List<Recipe> found = db.get(recipe);
        if (found.size() != 1) {
            throw new NonCoerentDatabaseException("Database is in an incoerent state!");
        }

        Recipe rec = found.get(0);
        db.delete(rec);
        fireRecipeDeleted(new KCookBEvent(this, rec, null));
    }

    /**
     * Saves any unsave changes submited to this book.
     */
    public void save() {
        if(unsavedRecipes != null) {
        for (Recipe rec : unsavedRecipes) {
            db.set(rec);
        }
        }
    }

    /**
     * Gets all existing recipes. The returned list is not ordered and 
     * <em>all</em> recipes will be returned.
     * 
     * Uses special case of Query by Example API.
     * 
     * @return A list with all existing recipes.
     */
    public List<Recipe> getAllRecipes() {
        return db.get(Recipe.class);
    }

    /**
     * Gets all tips available in this book. The returned list is not ordered.
     * 
     * Uses special case of Query by Example API.
     * 
     * @return A list will all existing tips.
     */
    public List<Recipe> getAllTips() {
        return db.get(Tip.class);
    }

    /**
     * Searches the book for any recipe that has the <code>name</code> string in
     * it's title.
     * This method matches any recipe that has <code>name</code> in it, the 
     * regular expressiong used is <code>*name*</code>. The search is case 
     * insentive.
     * 
     * Uses Native Query API.
     * 
     * @param name The string to search the recipes for.
     * @return A list containing the recipes found, if any.
     */
    public List<Recipe> searchByName(final String name) {
        return db.query(new Predicate<Recipe>() {

            @Override
            public boolean match(Recipe rec) {
                return rec.getTitle().toLowerCase().matches("*" + name.toLowerCase() + "*");
            }
        });
    }

    public List<Recipe> searchByType(final String type) {
        return db.query(new Predicate<Recipe>() {

            @Override
            public boolean match(Recipe rec) {
                return rec.getType().equalsIgnoreCase(type);
            }
        });
    }

    public List<Recipe> searchByTag(final String tag) {
        return db.query(new Predicate<Recipe>() {

            @Override
            public boolean match(Recipe rec) {
                return rec.getTags().contains(tag);
            }
        });
    }

    public List<Recipe> searchWithTags(final List<String> tags) {
        List<Recipe> temp = getAllRecipes();
        ArrayList<Recipe> rs = new ArrayList<Recipe>();

        for (String t : tags) {
            for (Recipe r : temp) {
                if (r.getTags().contains(t)) {
                    rs.add(r);
                }
            }
        }

        return rs;
    }

    public List<Recipe> searchWithIngredients(List<Ingredient> ingredients) {
        List<Recipe> temp = getAllRecipes();
        ArrayList<Recipe> rs = new ArrayList<Recipe>();

        for (Ingredient i : ingredients) {
            for (Recipe r : temp) {
                if (r.getIngredients().contains(i)) {
                    rs.add(r);
                }
            }
        }

        return rs;
    }

    public List<Recipe> searchByRating(final double rating) {
        return db.query(new Predicate<Recipe>() {

            @Override
            public boolean match(Recipe rec) {
                return rec.getRating() >= rating;
            }
        });
    }

    public List<Recipe> searchByDifficulty(final RecipeDificulty dificulty) {
        return db.query(new Predicate<Recipe>() {

            @Override
            public boolean match(Recipe rec) {
                return rec.getDificulty() == dificulty;
            }
        });
    }

    public List<Recipe> searchByPrice(final RecipePrice price) {
        return db.query(new Predicate<Recipe>() {

            @Override
            public boolean match(Recipe rec) {
                return rec.getPrice() == price;
            }
        });
    }

    public void addKCookBChangedListener(KCookBChangedListener l) {
        if (bookChandeListeners == null) {
            bookChandeListeners = new Vector<KCookBChangedListener>();
        }

        bookChandeListeners.add(l);
    }

    public void removeKCookBChangedListener(KCookBChangedListener l) {
        if (bookChandeListeners != null) {
            bookChandeListeners.remove(l);
        }
    }

    private void fireRecipeDeleted(KCookBEvent ev) {
        for (KCookBChangedListener l : bookChandeListeners) {
            l.recipeAdded(ev);
        }
    }

    private void fireRecipeAdded(KCookBEvent ev) {
        for (KCookBChangedListener l : bookChandeListeners) {
            l.recipeDeleted(ev);
        }
    }
}
