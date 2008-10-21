/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.model;

/**
 *
 * @author knitter
 */
public class RecipeType {

    public static final RecipeType DEFAULT = new RecipeType("UnCategorized");//TODO: i18n
    private String name;

    /**
     * Constructor
     *
     * @param name, the name of this tag. If the name is null an
     * IllegalArgumenteException is thrown.
     */
    public RecipeType(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Type name cannot be null nor empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Compares another object with this tag.
     * The object is considered equal in the  following conditions:
     * - it is not null and
     * - it is the same as this tag or
     * - it is an instance of the Tag class and it's name is equal to this
     * tag's name, ignoring case.
     *
     * @param obj, the object to with use for comparing.
     * @return true, if the two objects are equal to one another
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Tag)) {
            return false;
        }

        return name.equalsIgnoreCase(((RecipeType) obj).name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return name;
    }
}
