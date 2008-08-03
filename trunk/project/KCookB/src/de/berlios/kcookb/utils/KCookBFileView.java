/**
 *  Copyright (C) 2008  Sérgio Lopes
 *
 *  This file is part of KCookB.
 *
 *  KCookB is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
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
package de.berlios.kcookb.utils;

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
    /*    super();
        kcIcon = new ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-new-book.png"));
        */
    }
    
    /*@Override
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
    }*/
}
