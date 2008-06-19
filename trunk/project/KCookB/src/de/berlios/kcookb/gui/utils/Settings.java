/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.gui.utils;

import java.io.Serializable;

/**
 *
 * @author Knitter
 */
public class Settings implements Serializable {

    private String owner;
    private String email;
    private boolean storeCreationDate;
    private boolean defaultCategories;
    private boolean home;
    private boolean mydocuments;
    private boolean other;
    private String otherLocation;

    public Settings(String owner, String email, boolean storeCreationDate,
            boolean defaultCategories, boolean home, boolean mydocuments,
            boolean other, String otherLocation) {
        
        this.owner = owner;
        this.email = email;
        this.storeCreationDate = storeCreationDate;
        this.defaultCategories = defaultCategories;
        this.home = home;
        this.mydocuments = mydocuments;
        this.other = other;
        this.otherLocation = otherLocation;
    }
}
