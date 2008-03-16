/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.berlios.kcookb.db4otest;

/**
 *
 * @author Knitter
 */
public class PersonObject {
    
    private int id;
    private String name;
    private String surname;
    private int ageInYears;
    
    public PersonObject(int id, String name, String surname, int ageInYears) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.ageInYears = ageInYears;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public void setAgeInYears(int ageInYears) {
        this.ageInYears = ageInYears;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
