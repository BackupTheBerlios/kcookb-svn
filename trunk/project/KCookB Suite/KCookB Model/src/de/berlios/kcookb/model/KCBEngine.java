/**
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
package de.berlios.kcookb.model;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import de.berlios.kcookb.model.events.KCBEngineEvent;
import de.berlios.kcookb.model.events.KCBEngineListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KCBEngine {

    //private Set<Recipe> recipes;
    private transient Vector<KCBEngineListener> listeners;
    private ObjectContainer db;

    public KCBEngine() {
        listeners = new Vector<KCBEngineListener>();
    }

    public void openBook(String file) {
        db = Db4o.openFile(file);
    }

    public void closeBook() {
        if (db != null) {
            try {
                db.commit();
                db.close();
            } catch (Db4oIOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "Unable to close book.", ex);

            }
        }
    }

    public void addRecipe(Recipe recipe) {
        if (db != null) {
            try {
                db.store(recipe);
                db.commit();
                fireRecipeAdded(new KCBEngineEvent(this));
            } catch (DatabaseClosedException ex) {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "Unable to add a new recipe.", ex);
            } catch (DatabaseReadOnlyException ex) {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "Unable to add a new recipe.", ex);
            } catch (Db4oIOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "Unable to add a new recipe.", ex);
            }
        }
    }

    public void removeRecipe(Recipe recipe) {
        if (db != null) {
            try {
                db.delete(recipe);
                db.commit();
                fireRecipeAdded(new KCBEngineEvent(this));
            } catch (DatabaseClosedException ex) {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "Unable to delete a recipe.", ex);
            } catch (DatabaseReadOnlyException ex) {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "Unable to delete a recipe.", ex);
            } catch (Db4oIOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "Unable to delete a recipe.", ex);
            }
        }
    }

    public void fireRecipeRemoved(KCBEngineEvent e) {
        if (listeners != null) {
            for (KCBEngineListener l : listeners) {
                l.recipeAdded(e);
            }
        }
    }

    public void fireRecipeAdded(KCBEngineEvent e) {
        if (listeners != null) {
            for (KCBEngineListener l : listeners) {
                l.recipeAdded(e);
            }
        }
    }

    public synchronized boolean addListener(KCBEngineListener l) {
        if (listeners == null) {
            listeners = new Vector<KCBEngineListener>();
        }
        return listeners.add(l);
    }

    public synchronized boolean removeListener(KCBEngineListener l) {
        if (listeners != null) {
            return listeners.remove(l);
        }

        return false;
    }
    /*private ObjectContainer db = null;
    private ArrayList<Recipe> unsavedRecipes = null;
    private Vector<KCookBListener> listeners = null;
    private BookInfo info;
    private String baseFolder;

    public KCookB() {
    //info = new BookInfo(Settings.getSettings().getOwner(), Settings.getSettings().getEmail());
    info = new BookInfo("owner", "email");
    unsavedRecipes = new ArrayList<Recipe>(100);
    listeners = new Vector<KCookBListener>();

    }

    public KCookB(String filename) {
    this();
    openDB(filename);
    }

    private void openDB(String filename) {
    closeCatalog();
    db = Db4o.openFile(filename);
    }

    public void openCatalog(String name) {
    openDB(name);
    List rs = db.get(BookInfo.class);
    info = (BookInfo) rs.get(0);
    }

    public void closeCatalog() {
    if (db != null) {
    db.close();
    listeners.clear();
    db = null;
    }
    }

    public BookInfo getInfo() {
    return info;
    }

    public void addRecipe(String title, Date preparation, Date cooking, RecipeDificulty dificulty,
    RecipePrice price, LinkedList<Ingredient> ingredients, RecipeType type,
    int doses, LinkedList<String> sequence, String principal,
    Note note, LinkedList<Tip> tips, double rating, boolean stared,
    LinkedList<RecipeTag> tags, String method, Date freazer, Date fridge) {

    Recipe rec = new Recipe(title, preparation, cooking, dificulty, price,
    ingredients, type, doses, sequence, principal, note,
    tips, rating, stared, tags, method, freazer, fridge);

    db.set(rec);
    fireRecipeAdded(new KCookBEvent(this, null, rec));
    }

    public void removeRecipe(Recipe recipe) throws NonCoerentDatabaseException {
    List<Recipe> found = db.get(recipe);
    if (found.size() != 1) {
    throw new NonCoerentDatabaseException("Database is in an incoerent state!");
    }

    Recipe rec = found.get(0);
    db.delete(rec);
    fireRecipeDeleted(new KCookBEvent(this, rec, null));
    }

    //TODO: comment
    public void save() {
    if (unsavedRecipes != null) {
    for (Recipe rec : unsavedRecipes) {
    db.set(rec);
    }
    }
    }

    //TODO: comment
    public boolean hasChanges() {
    return !unsavedRecipes.isEmpty();
    }

    public void undo() {
    //TODO: undo
    }

    public void redo() {
    //TODO: redo
    }

    public List<Recipe> getAllRecipes() {
    return db.get(Recipe.class);
    }

    public List<Tip> getAllTips() {
    return db.get(Tip.class);
    }

    public List<RecipeType> getAllTypes() {
    return db.get(RecipeType.class);
    }

    public List<Meal> getMeals() {
    return db.get(Meal.class);
    }

    public List<RecipeTag> getAllTags() {
    return db.get(RecipeTag.class);
    }

    public List<Recipe> search(final String name, boolean inDescription, boolean inIngredients,
    boolean inLable, boolean inRating, boolean inType, RecipeDificulty difficulty, RecipePrice price) {
    return db.query(new Predicate<Recipe>() {

    @Override
    public boolean match(Recipe rec) {
    //TODO: search method
    return false;
    }
    });
    }

    public List<Recipe> searchByName(final String name) {
    return db.query(new Predicate<Recipe>() {

    @Override
    public boolean match(Recipe rec) {
    return rec.getTitle().toLowerCase().matches("*" + name.toLowerCase() + "*");
    }
    });
    }

    public List<Recipe> getAllStared() {
    return db.query(new Predicate<Recipe>() {

    @Override
    public boolean match(Recipe rec) {
    return rec.isStared();
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

    public void addKCookBChangedListener(KCookBListener l) {
    if (listeners == null) {
    listeners = new Vector<KCookBListener>();
    }

    listeners.add(l);
    }

    public void removeKCookBChangedListener(KCookBListener l) {
    if (listeners != null) {
    listeners.remove(l);
    }
    }

    private void fireRecipeDeleted(KCookBEvent ev) {
    for (KCookBListener l : listeners) {
    l.recipeAdded(ev);
    }
    }

    private void fireRecipeAdded(KCookBEvent ev) {
    for (KCookBListener l : listeners) {
    l.recipeDeleted(ev);
    }
    }
     */
}
