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
package de.berlios.kcookb.model;

/**
 * Represents a basic nutricional table.
 * 
 * @author Knitter
 */
public class Nutricional {

    private int energy;
    private int protein;
    private int carbon;
    private int carbonSuggar;
    private int fat;
    private int fatSaturate;
    private int fiber;
    private double womenEnergyPercentage;
    private double womenCarbonSuggarPercentage;
    private double womenFatPercentage;
    private double womenFatSaturatePercentage;
    private double manEnergyPercentage;
    private double manCarbonSuggarPercentage;
    private double manFatPercentage;
    private double manFatSaturatePercentage;
    private Recipe recipe;

    public Nutricional() {
        this(0, 0, 0, 0, 0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null);
    }

    public Nutricional(int energy, int protein, int carbon, int carbonSuggar,
            int fat, int fatSaturate, int fiber, Recipe recipe) {
        this(energy, protein, carbon, carbonSuggar, fat, fatSaturate, fiber, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, recipe);
    }

    public Nutricional(int energy, int protein, int carbon, int carbonSuggar,
            int fat, int fatSaturate, int fiber, double womenEnergyPercentage,
            double womenCarbonSuggarPercentage, double womenFatPercentage,
            double womenFatSaturatePercentage, double manEnergyPercentage,
            double manCarbonSuggarPercentage, double manFatPercentage,
            double manFatSaturatePercentage, Recipe recipe) {

        this.energy = energy;
        this.protein = protein;
        this.carbon = carbon;
        this.carbonSuggar = carbonSuggar;
        this.fat = fat;
        this.fatSaturate = fatSaturate;
        this.fiber = fiber;
        this.womenEnergyPercentage = womenEnergyPercentage;
        this.womenCarbonSuggarPercentage = womenCarbonSuggarPercentage;
        this.womenFatPercentage = womenFatPercentage;
        this.womenFatSaturatePercentage = womenFatSaturatePercentage;
        this.manEnergyPercentage = manEnergyPercentage;
        this.manCarbonSuggarPercentage = manCarbonSuggarPercentage;
        this.manFatPercentage = manFatPercentage;
        this.manFatSaturatePercentage = manFatSaturatePercentage;
        this.recipe = recipe;
    }

    public int getCarbon() {
        return carbon;
    }

    public void setCarbon(int carbon) {
        this.carbon = carbon;
    }

    public int getCarbonSuggar() {
        return carbonSuggar;
    }

    public void setCarbonSuggar(int carbonSuggar) {
        this.carbonSuggar = carbonSuggar;
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

    public int getFatSaturate() {
        return fatSaturate;
    }

    public void setFatSaturate(int fatSaturate) {
        this.fatSaturate = fatSaturate;
    }

    public int getFiber() {
        return fiber;
    }

    public void setFiber(int fiber) {
        this.fiber = fiber;
    }

    public double getManCarbonSuggarPercentage() {
        return manCarbonSuggarPercentage;
    }

    public void setManCarbonSuggarPercentage(double manCarbonSuggarPercentage) {
        this.manCarbonSuggarPercentage = manCarbonSuggarPercentage;
    }

    public double getManEnergyPercentage() {
        return manEnergyPercentage;
    }

    public void setManEnergyPercentage(double manEnergyPercentage) {
        this.manEnergyPercentage = manEnergyPercentage;
    }

    public double getManFatPercentage() {
        return manFatPercentage;
    }

    public void setManFatPercentage(double manFatPercentage) {
        this.manFatPercentage = manFatPercentage;
    }

    public double getManFatSaturatePercentage() {
        return manFatSaturatePercentage;
    }

    public void setManFatSaturatePercentage(double manFatSaturatePercentage) {
        this.manFatSaturatePercentage = manFatSaturatePercentage;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public double getWomenCarbonSuggarPercentage() {
        return womenCarbonSuggarPercentage;
    }

    public void setWomenCarbonSuggarPercentage(double womenCarbonSuggarPercentage) {
        this.womenCarbonSuggarPercentage = womenCarbonSuggarPercentage;
    }

    public double getWomenEnergyPercentage() {
        return womenEnergyPercentage;
    }

    public void setWomenEnergyPercentage(double womenEnergyPercentage) {
        this.womenEnergyPercentage = womenEnergyPercentage;
    }

    public double getWomenFatPercentage() {
        return womenFatPercentage;
    }

    public void setWomenFatPercentage(double womenFatPercentage) {
        this.womenFatPercentage = womenFatPercentage;
    }

    public double getWomenFatSaturatePercentage() {
        return womenFatSaturatePercentage;
    }

    public void setWomenFatSaturatePercentage(double womenFatSaturatePercentage) {
        this.womenFatSaturatePercentage = womenFatSaturatePercentage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Nutricional)) {
            return false;
        }

        Nutricional other = (Nutricional) obj;
        return energy == other.energy && protein == other.protein &&
                carbon == other.carbon && carbonSuggar == other.carbonSuggar &&
                fat == other.fat && fatSaturate == other.fatSaturate &&
                fiber == other.fiber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.energy;
        hash = 23 * hash + this.protein;
        hash = 23 * hash + this.carbon;
        hash = 23 * hash + this.carbonSuggar;
        hash = 23 * hash + this.fat;
        hash = 23 * hash + this.fatSaturate;
        hash = 23 * hash + this.fiber;
        return hash;
    }
}
