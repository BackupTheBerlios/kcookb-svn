/*
 *  KBCEngine.java
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
package de.berlios.kcookb.model;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.OldFormatException;
import com.db4o.query.Predicate;
import de.berlios.kcookb.model.listeners.KCBEngineEvent;
import de.berlios.kcookb.model.listeners.KCBEngineListener;
import de.berlios.kcookb.model.listeners.RecipeEvent;
import de.berlios.kcookb.model.listeners.RecipeListener;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Controller class. Contains all methods that represent a recipe book.
 * It's the entry point to the model.
 * 
 * @author Knitter
 */
public class KCBEngine implements RecipeListener {

    private transient Vector<KCBEngineListener> listeners;
    private ObjectContainer db;

    /**
     * Creates a new KCBEngine.
     *
     * Doen't create any sort of link to the book. At this time, no book exists.
     */
    public KCBEngine() {
        listeners = new Vector<KCBEngineListener>();
    }

    /**
     * Opens a new book, if the specified file exists it is opened, else it is
     * created.
     *
     * @param file the file name to open or create.
     */
    public void openBook(String file) {
        //TODO: correct opening code
        try {
            db = Db4o.openFile(file);
        } catch (Db4oIOException ex) {
            //- I/O operation failed or was unexpectedly interrupted.
        } catch (DatabaseFileLockedException ex) {
            //- the required database file is locked by another process.
        } catch (IncompatibleFileFormatException ex) {
            //- runtime configuration is not compatible with the configuration
            //of the database file.
        } catch (OldFormatException ex) {
            //- open operation failed because the database file is in old format
            //and Configuration.allowVersionUpdates(boolean) is set to false.
        } catch (DatabaseReadOnlyException ex) {
            //- database was configured as read-only
        }
    }

    /**
     * Closes any currently opened book.
     *
     * Closing an already closed book as no effect.
     */
    public void closeBook() {
        if (db != null) {
            try {
                db.close();
                db = null;
            } catch (Db4oIOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "Unable to close book.", ex);
                throw ex;
            }
        }
    }

    public boolean hasOpenBook() {
        return db != null;
    }

    /**
     * Adds a new recipe to the opened book, if any exists.
     *
     * @param recipe the new recipe to add.
     */
    public void addRecipe(Recipe recipe) {
        if (db != null) {
            try {
                db.store(recipe);
                db.commit();
                recipe.addListener(this);
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

    /**
     * Deletes a recipe from an opened book. If there is no opened book the
     * method has no effect.
     *
     * @param recipe the recipe to delete.
     */
    public void deleteRecipe(Recipe recipe) {
        if (db != null) {
            try {
                db.delete(recipe);
                db.commit();
                recipe.removeListener(this);
                fireRecipeDeleted(new KCBEngineEvent(this));
            } catch (DatabaseClosedException ex) {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "Unable to delete a recipe.", ex);
            } catch (DatabaseReadOnlyException ex) {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "Unable to delete a recipe.", ex);
            } catch (Db4oIOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "Unable to delete a recipe.", ex);
            }
        }
    }

    /**
     * For the engine, when a recipe changes it should be update in the
     * database. Therefor an engine implements RecipeListener and updates the
     * database whenever it recieves the recipeChanged event.
     *
     * @param e event genereted at the source with the changed recipe.
     * @see RecipeListener
     */
    public void recipeChanged(RecipeEvent e) {
        if (db != null) {
            db.store((Recipe) e.getSource());
            db.commit();
        }
    }

    /**
     * Lists all existing recipes using the query shortcut for class instances.
     *
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> listAllRecipes() {
        return db.query(Recipe.class);
    }

    /**
     *
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> getStared() {
        return db.query(new Predicate<Recipe>() {

            public boolean match(Recipe rep) {
                return rep.isStared();
            }
        });
    }

    /**
     *
     * @param name
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> searchByName(final String name) {
        final Pattern pat = Pattern.compile(".*" + name + ".*", Pattern.CASE_INSENSITIVE);
        return db.query(new Predicate<Recipe>() {

            public boolean match(Recipe rep) {
                return pat.matcher(rep.getName()).matches();
            }
        });
    }

    /**
     *
     * @param tag
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> searchByTag(final String tag) {
        return db.query(new Predicate<Recipe>() {

            public boolean match(Recipe rep) {
                for (Tag t : rep.getTags()) {
                    if (t.getName().compareToIgnoreCase(tag) == 0) {
                        return true;
                    }
                }
                return false;
            }
        });
    }

    /**
     *
     * @param ingr
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> searchByIngredient(final String ingr) {
        return db.query(new Predicate<Recipe>() {

            public boolean match(Recipe rep) {
                for (Ingredient ig : rep.getIngredients()) {
                    if (ig.getValue().compareToIgnoreCase(ingr) == 0) {
                        return true;
                    }
                }
                return false;
            }
        });
    }

    /**
     *
     * @param type
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> searchByType(final String type) {
        return db.query(new Predicate<Recipe>() {

            public boolean match(Recipe rep) {
                return rep.getType().getName().compareToIgnoreCase(type) == 0;
            }
        });
    }

    /**
     *
     * @param amount
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> searchByServings(final int amount) {
        return db.query(new Predicate<Recipe>() {

            public boolean match(Recipe rep) {
                return rep.getServings() >= amount;
            }
        });
    }

    /**
     *
     * @param rate
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> searchByRating(final double rate) {
        return db.query(new Predicate<Recipe>() {

            public boolean match(Recipe rep) {
                return rep.getRating() >= rate;
            }
        });
    }

    /**
     *
     * @param time
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> searchLessThan(final TimeUnit time) {
        return db.query(new Predicate<Recipe>() {

            public boolean match(Recipe rep) {
                int repH = rep.getPrepTime().getHour() + rep.getCooking().getHour();
                int repM = rep.getPrepTime().getMinute() + rep.getCooking().getMinute();

                if (repH > time.getHour()) {
                    return false;
                }

                if (repH < time.getHour()) {
                    return true;
                }

                return (repM > time.getMinute() ? false : true);
            }
        });
    }

    /**
     *
     * @param date
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> searchBefore(final GregorianCalendar date) {
        return db.query(new Predicate<Recipe>() {

            public boolean match(Recipe rep) {
                return rep.getAdded().before(date);
            }
        });
    }

    /**
     *
     * @param date
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> searchAfter(final GregorianCalendar date) {
        return db.query(new Predicate<Recipe>() {

            public boolean match(Recipe rep) {
                return rep.getAdded().after(date);
            }
        });
    }

    /**
     *
     * @param level
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> searchByDifficulty(final int level) {
        return db.query(new Predicate<Recipe>() {

            public boolean match(Recipe rep) {
                return rep.getDifficulty() == level;
            }
        });
    }

    /**
     *
     * @param tag
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> searchByPriceTag(final int tag) {
        return db.query(new Predicate<Recipe>() {

            public boolean match(Recipe rep) {
                return rep.getPriceTag() == tag;
            }
        });
    }

    /**
     *
     * @param price
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> searchByPrice(final double price) {
        return db.query(new Predicate<Recipe>() {

            public boolean match(Recipe rep) {
                return rep.getPrice() <= price;
            }
        });
    }

    /**
     *
     * @param cal
     * @return an instance of ObjectSet as a List
     */
    public List<Recipe> searchByCalories(final int cal) {
        return db.query(new Predicate<Recipe>() {

            public boolean match(Recipe rep) {
                return rep.getCalories() <= cal;
            }
        });
    }

    /**
     *
     * @return an instance of ObjectSet as a List
     */
    public List<RecipeType> listAllTypes() {
        return db.query(RecipeType.class);
    }

    /**
     *
     * @return an instance of ObjectSet as a List
     */
    public List<Tag> listAllTags() {
        return db.query(Tag.class);
    }

    /**
     *
     * @param e
     */
    public void fireRecipeDeleted(KCBEngineEvent e) {
        Vector<KCBEngineListener> copy;
        if (listeners != null) {

            synchronized (this) {
                copy = new Vector(listeners);
            }

            for (KCBEngineListener l : copy) {
                l.recipeDeleted(e);
            }
        }
    }

    /**
     *
     * @param e
     */
    public void fireRecipeAdded(KCBEngineEvent e) {
        Vector<KCBEngineListener> copy;
        if (listeners != null) {

            synchronized (this) {
                copy = new Vector(listeners);
            }

            for (KCBEngineListener l : copy) {
                l.recipeAdded(e);
            }
        }
    }

    /**
     *
     * @param l
     * @return
     */
    //TODO: Sync not needed?
    public synchronized boolean addListener(KCBEngineListener l) {
        if (listeners == null) {
            listeners = new Vector<KCBEngineListener>();
        }
        return listeners.add(l);
    }

    /**
     * 
     * @param l
     * @return
     */
    //TODO: Sync not needed?
    public synchronized boolean removeListener(KCBEngineListener l) {
        if (listeners != null) {
            return listeners.remove(l);
        }

        return false;
    }
}
