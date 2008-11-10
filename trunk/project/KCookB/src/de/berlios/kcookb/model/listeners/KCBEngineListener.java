/**
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
package de.berlios.kcookb.model.listeners;

import de.berlios.kcookb.model.KCBEngine;
import java.util.EventListener;

/**
 * Interface that represents listeners to the model engine.
 *
 * @see KCBEngine
 * @see KCBEngineEvent
 * 
 * @author Knitter
 */
public interface KCBEngineListener extends EventListener {

    /**
     * Notifies listeners that a book has been opened in the engine.
     *
     * @param e generated event
     *
     * @see KCBEngineEvent
     */
    void bookOpened(KCBEngineEvent e);

    /**
     * Notifies listeners that the current book has been closed.
     *
     * @param e generated event
     *
     * @see KCBEngineEvent
     */
    void bookClosed(KCBEngineEvent e);

    /**
     * Notifies listeners that a recipe has been removed.
     *
     * @param e generated event
     *
     * @see KCBEngineEvent
     */
    void recipeAdded(KCBEngineEvent e);

    /**
     * Notifies listeners that a recipe has been removed from the opened book.
     *
     * @param e generated event
     *
     * @see KCBEngineEvent
     */
    void recipeDeleted(KCBEngineEvent e);
}
