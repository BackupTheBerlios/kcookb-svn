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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileView;

public class KCBFileView extends FileView {

    private ImageIcon fIcon;
    private ResourceBundle rb;

    public KCBFileView() {
        //fIcon = new ImageIcon(getClass().getResource("de/berlios/kcookb/resources/book_add.png"));
        rb = ResourceBundle.getBundle(KCookB.BUNDLE_PATH);
    }

    @Override
    public String getTypeDescription(File f) {
        return rb.getString("KCookB.fileDescription");
    }

    @Override
    public Icon getIcon(File f) {
        if (f.isDirectory()) {
            File[] lst = f.listFiles();
            if (lst != null) {
                for (File f2 : lst) {
                    if (f2.isFile() && f2.getName().equalsIgnoreCase(".kcookb.catalog")) {
                        return fIcon;
                    }
                }
            }
        }
        return null;
    }
}
