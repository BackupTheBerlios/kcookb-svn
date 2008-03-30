/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.berlios.kcookb.model;

import java.util.Date;

/**
 *
 * @author Knitter
 */
public class CatalogInfo {
    
    private String author;
    private String email;
    private Date created;
    
    public CatalogInfo(String author, String email) {
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
        
        if(!(obj instanceof CatalogInfo)) {
            return false;
        }
        
        CatalogInfo other = (CatalogInfo)obj;
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
