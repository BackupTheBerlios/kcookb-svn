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
package de.berlios.kcookb.old.utils;

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
