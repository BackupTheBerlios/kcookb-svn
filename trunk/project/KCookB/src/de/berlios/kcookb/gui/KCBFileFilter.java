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
package de.berlios.kcookb.gui;

import java.io.File;
import java.util.ResourceBundle;
import javax.swing.filechooser.FileFilter;

public class KCBFileFilter extends FileFilter {

    private ResourceBundle rb;

    public KCBFileFilter() {
        super();
        rb = ResourceBundle.getBundle(KCookB.BUNDLE_PATH);
    }

    @Override
    public boolean accept(File f) {
        /*if (f.isDirectory()) {
        return true;
        }
        //TODO: check filtering options*/
        return true;
    }

    @Override
    public String getDescription() {
        return rb.getString("KCookB.fileDescription");
    }
}
