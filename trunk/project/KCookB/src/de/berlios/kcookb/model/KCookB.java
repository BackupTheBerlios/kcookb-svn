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
    private ArrayList<Recipe> unsavedRecipes = null;
    private Vector<KCookBChangedListener> bookChandeListeners = null;
    
    

    public KCookB() {
        unsavedRecipes = new ArrayList<Recipe>(100);
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
    
    public boolean hasChanges() {
        //TODO:
        return false;
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
            RecipeType type, int doses, LinkedList<String> sequence, String principal,
            LinkedList<Note> notes, LinkedList<Tip> tips, double rating, boolean stared,
            LinkedList<RecipeTag> tags, String method, Date freazer, Date fridge) {

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
    
    public List<Recipe> getAllTypes() {
        return db.get(RecipeType.class);
    }
    
    public List<Recipe> getMeals() {
        return db.get(Meal.class);
    }
    
    public List<Recipe> getAllTags() {
        return db.get(RecipeTag.class);
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

    public List<Recipe> searchByType(final RecipeType type) {
        return db.query(new Predicate<Recipe>() {

            @Override
            public boolean match(Recipe rec) {
                return rec.getType().equals(type);
            }
        });
    }

    public List<Recipe> searchByTag(final RecipeTag tag) {
        return db.query(new Predicate<Recipe>() {

            @Override
            public boolean match(Recipe rec) {
                return rec.getTags().contains(tag);
            }
        });
    }

    public List<Recipe> searchWithTags(final List<RecipeTag> tags) {
        List<Recipe> temp = getAllRecipes();
        ArrayList<Recipe> rs = new ArrayList<Recipe>();

        for (RecipeTag t : tags) {
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

    /**
     * Adds a new listener to the book's events.
     * If the list is null it will be created.
     * 
     * This method uses a syncronized data structure.
     * 
     * @param l Listener to be added
     * @see Vector
     */
    public void addKCookBChangedListener(KCookBChangedListener l) {
        if (bookChandeListeners == null) {
            bookChandeListeners = new Vector<KCookBChangedListener>();
        }

        bookChandeListeners.add(l);
    }

    /**
     * Removes a listener from the list of this book's listeners.
     * If the listener is not present or the list is empty or null nothing will
     * happen.
     * 
     * This method uses a syncronized data structure
     * 
     * @param l Listener to be removed
     * @see Vector
     */
    public void removeKCookBChangedListener(KCookBChangedListener l) {
        if (bookChandeListeners != null) {
            bookChandeListeners.remove(l);
        }
    }

    /**
     * Notifies all listeners that a recipe was removed.
     * 
     * @param ev The event object that encapsulates event information
     */
    private void fireRecipeDeleted(KCookBEvent ev) {
        for (KCookBChangedListener l : bookChandeListeners) {
            l.recipeAdded(ev);
        }
    }

    /**
     * Notifies all listeners that a new recipe was added.
     * 
     * @param ev The event object that encapsulates event information
     */
    private void fireRecipeAdded(KCookBEvent ev) {
        for (KCookBChangedListener l : bookChandeListeners) {
            l.recipeDeleted(ev);
        }
    }
}
