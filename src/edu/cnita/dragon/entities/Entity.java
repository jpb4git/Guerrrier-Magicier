package edu.cnita.dragon.entities;

import edu.cnita.dragon.Obj;
import edu.cnita.dragon.EnumArchetype.TypeEntity;

import java.util.List;

public abstract class Entity {

    private String Nom;
    private int Health;
    private int Strength;
    private TypeEntity type;

    //Getters
    public TypeEntity getType() {
        return type;
    }
    public String getNom() {
        return Nom;
    }
    public int getHealth() {
        return Health;
    }
    public int getStrength() {
        return Strength;
    }
    public abstract Obj getOffense();
    public abstract String  getDefense();
    public abstract List<Obj> getListOffense();

    //setters
    public void setNom(String nom) {
        Nom = nom;
    }
    public void setHealth(int health) {
        Health = health;
    }
    public void setStrength(int strength) {
        Strength = strength;
    }
    public abstract void setDefense(String defense);
    public abstract void initOffense();

    /**
     * Constructor
     */
    public Entity(){

    }
    public Entity(String nom, int minHealth, int maxHealth, int minStrength, int maxStrength,TypeEntity type){
        Nom = nom;

        Health = generateRandom(minHealth,maxHealth);
        Strength = generateRandom(minStrength,maxStrength);
        this.type = type;

    }
    public int generateRandom(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }




}
