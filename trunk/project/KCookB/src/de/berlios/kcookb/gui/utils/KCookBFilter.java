/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.gui.utils;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Knitter
 */
public class KCookBFilter extends FileFilter {
    
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String ext = FileUtils.getExtension(f);
        if (ext != null && ext.compareToIgnoreCase(FileUtils.KCOOKB_EXTENSION) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return FileUtils.KCOOKB_DESCRIPTION;
    }
}
