/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.model;

import de.berlios.kcookb.model.events.RecipeListener;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Knitter
 */
public class Recipe {
    
    private String title;   
    private Date preparation;
    private Date cooking;
    private RecipeDificulty dificulty;
    private RecipePrice price;
    private List<Ingredient> ingredients;
    private NutricionalTable table;
    private RecipeType type;
    private int doses;
    private List<String> sequence;
    private String principal;
    private List<Note> notes;
    private List<Tip> tips;
    private double rating;
    private boolean stared;
    private List<RecipeTag> tags;
    private String method;
    private Date freazer;
    private Date fridge;
    private Date added;
    
    private Vector<RecipeListener> listeners;

    public Recipe(String title, Date preparation, Date cooking, RecipeDificulty dificulty,
            RecipePrice price, List<Ingredient> ingredients, NutricionalTable table,
            RecipeType type, int doses, List<String> sequence, String principal,
            List<Note> notes, List<Tip> tips, double rating, boolean stared,
            List<RecipeTag> tags, String method, Date freazer, Date fridge) {

        this.title = title;
        this.preparation = preparation;
        this.cooking = cooking;
        this.dificulty = dificulty;
        this.price = price;
        this.ingredients = (ingredients != null ? ingredients : new LinkedList<Ingredient>());
        this.table = table;
        this.type = type;
        this.doses = doses;
        this.sequence = (sequence != null ? sequence : new LinkedList<String>());
        this.principal = principal;
        this.notes = (notes != null ? notes : new LinkedList<Note>());
        this.tips = (tips != null ? tips : new LinkedList<Tip>());
        this.rating = rating;
        this.stared = stared;
        this.tags = (tags != null ? tags : new LinkedList<RecipeTag>());
        this.method = method;
        this.freazer = freazer;
        this.fridge = fridge;
        added = new Date();
        
        listeners = new Vector<RecipeListener>();
    }

    public Date getCooking() {
        return cooking;
    }

    public void setCooking(Date cooking) {
        this.cooking = cooking;
    }

    public RecipeDificulty getDificulty() {
        return dificulty;
    }

    public void setDificulty(RecipeDificulty dificulty) {
        this.dificulty = dificulty;
    }

    public int getDoses() {
        return doses;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }

    public void addIngredient(Ingredient ingredient) {
        if(ingredients == null) {
            ingredients = new LinkedList<Ingredient>();
        }
        ingredients.add(ingredient);
    }
    
    public void removeIngredient(Ingredient ingredient) {
        if(ingredients != null) {
        ingredients.remove(ingredient);
        }
    }
    
    //TODO: see if these set/get methods are necessary
    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    
    public void setIngredients(LinkedList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSequence() {
        return sequence;
    }

    public void setSequence(LinkedList<String> sequence) {
        this.sequence = sequence;
    }
    
    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(LinkedList<Note> notes) {
        this.notes = notes;
    }

    public List<Tip> getTips() {
        return tips;
    }

    public void setTips(LinkedList<Tip> tips) {
        this.tips = tips;
    }
    
    public List<RecipeTag> getTags() {
        return tags;
    }

    public void setTags(LinkedList<RecipeTag> tags) {
        this.tags = tags;
    }    
    /*END OF TODO*/
    
    public Date getPreparation() {
        return preparation;
    }

    public void setPreparation(Date preparation) {
        this.preparation = preparation;
    }

    public RecipePrice getPrice() {
        return price;
    }

    public void setPrice(RecipePrice price) {
        this.price = price;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public void addSequenceElement(String name) {
        if(sequence == null) {
            sequence = new LinkedList<String>();
        }
        sequence.add(name);
    }
    
    public void removeSequenceElement(String name) {
        if(sequence != null) {
        sequence.remove(name);
        }
    }

    public NutricionalTable getTable() {
        return table;
    }

    public void setTable(NutricionalTable table) {
        this.table = table;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RecipeType getType() {
        return type;
    }

    public void setType(RecipeType type) {
        this.type = type;
    }

    public void addNote(Note note) {
        if(notes == null) {
            notes = new LinkedList<Note>();
        }
        notes.add(note);
    }
    
    public void removeNote(Note note) {
        if(notes != null) {
        notes.remove(note);
        }
    }

    public void addTip(Tip tip) {
        if(tips == null) {
            tips = new LinkedList<Tip>();
        }
        tips.add(tip);
    }
    
    public void removeTip(Tip tip) {
        if(tips != null) {
        tips.remove(tip);
        }
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isStared() {
        return stared;
    }

    public void setStared(boolean stared) {
        this.stared = stared;
    }
    
    public void addTag(RecipeTag tag) {
        if(tags == null) {
            tags = new LinkedList<RecipeTag>();
        }
        tags.add(tag);
    }
    
    public void removeTag(RecipeTag tag) {
        if(tags != null) {
        tags.remove(tag);
        }
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getFreazer() {
        return freazer;
    }

    public void setFreazer(Date freazer) {
        this.freazer = freazer;
    }

    public Date getFridge() {
        return fridge;
    }

    public void setFridge(Date fridge) {
        this.fridge = fridge;
    }
    
    public Date getAdded() {
        return added;
    }
    
    public void addListener(RecipeListener l) {
        if(listeners == null) {
            listeners = new Vector<RecipeListener>();
        }
        listeners.add(l);
    }
    
    public void removeListener(RecipeListener l) {
        if(listeners != null) {
            listeners.remove(l);
        }
    }

    /**
     * This does not extensibly compare two recipe objects, only the name is 
     * important to this implementation.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Recipe)) {
            return false;
        }

        Recipe other = (Recipe) obj;
        return this.title.equalsIgnoreCase(other.title);
    }
    
    public String toString() {
        return title;
    }
}
