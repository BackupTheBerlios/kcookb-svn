/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.model;

/**
 *
 * @author Knitter
 */
public class NutricionalTable {

    private int energy;
    private int protein;
    private int fat;
    private int carbon;
    private int fiber;
    
    public NutricionalTable(int energy, int protein, int fat, int carbon, int fiber) {
        this.energy = energy;
        this.protein = protein;
        this.fat = fat;
        this.carbon = carbon;
        this.fiber = fiber;
    }

    public int getCarbon() {
        return carbon;
    }

    public void setCarbon(int carbon) {
        this.carbon = carbon;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getFiber() {
        return fiber;
    }

    public void setFiber(int fiber) {
        this.fiber = fiber;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        
        if(!(obj instanceof NutricionalTable)) {
            return false;
        }
        
        NutricionalTable other = (NutricionalTable)obj;
        return this.carbon == other.carbon && this.energy == other.energy 
                && this.fat == other.fat && this.fiber == other.fiber 
                && this.protein == other.protein;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.energy;
        hash = 47 * hash + this.protein;
        hash = 47 * hash + this.fat;
        hash = 47 * hash + this.carbon;
        hash = 47 * hash + this.fiber;
        return hash;
    }
}
