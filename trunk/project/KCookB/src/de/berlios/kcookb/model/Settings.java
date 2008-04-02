/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.berlios.kcookb.model;

/**
 *
 * @author ei10635
 */
public class Settings {

    private static final Settings me = new Settings();
    
    private Settings() {
        //TODO: read user data if it exists, if not, fall back to defaults.
    }
    
    public static final Settings getSettings() {
        return me;
    }
}
