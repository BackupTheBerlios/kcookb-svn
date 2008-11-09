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
package de.berlios.kcookb.old.gui;

import java.util.Date;

/**
 *
 * @author Knitter
 */
public class BookInfo {
    
    private String author;
    private String email;
    private Date created;
    
    public BookInfo(String author, String email) {
        this.author = author;
        this.email = email;
        created = new Date();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        
        if(!(obj instanceof BookInfo)) {
            return false;
        }
        
        BookInfo other = (BookInfo)obj;
        return author.equals(other.author) && email.equals(other.email) 
                && created.equals(other.created);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.author != null ? this.author.hashCode() : 0);
        hash = 79 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 79 * hash + (this.created != null ? this.created.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString() {
        return "KCookB catalog, " + created.toString();
    }

}
