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
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Knitter
 */
public class KCookBFilter extends FileFilter {
    
    @Override
    public boolean accept(File f) {
    /*    if (f.isDirectory()) {
            return true;
        }

        String ext = FileUtils.getExtension(f);
        if (ext != null && ext.compareToIgnoreCase(FileUtils.KCOOKB_EXTENSION) == 0) {
            return true;
        }
        return false;
     * */
        return true;
    }

    @Override
    public String getDescription() {
        return "";
        //return FileUtils.KCOOKB_DESCRIPTION;
    }
}