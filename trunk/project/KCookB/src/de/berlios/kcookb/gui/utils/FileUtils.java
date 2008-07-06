/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.gui.utils;

import java.io.File;

/**
 *
 * @author Knitter
 */
public class FileUtils {

    public static final String KCOOKB_EXTENSION = "KCB";
    public static final String KCOOKB_DESCRIPTION = "KCB recipe book";

    public static String getExtension(File f) {
        int x = -1;
        String filename = f.getName();
        return ((x = filename.lastIndexOf(".")) > 0 ? filename.substring(x + 1) : "").toLowerCase();
    }
}
