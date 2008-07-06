/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.gui.utils;

import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileView;

/**
 *
 * @author Knitter
 */
public class KCookBFileView extends FileView {

    private ImageIcon kcIcon;
    
    public KCookBFileView() {
        super();
        kcIcon = new ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-new-book.png"));
        
    }
    @Override
    public String getTypeDescription(File f) {
        String ext = FileUtils.getExtension(f);
        if (ext != null && ext.compareToIgnoreCase(FileUtils.KCOOKB_EXTENSION) == 0) {
            return FileUtils.KCOOKB_DESCRIPTION;
        }
        return null;
    }

    @Override
    public Icon getIcon(File f) {
        Icon icon = null;
        String ext = FileUtils.getExtension(f);
        if (ext != null && ext.compareToIgnoreCase(FileUtils.KCOOKB_EXTENSION) == 0) {
            return kcIcon;
        }
        return icon;
    }
}
