import java.util.List;

abstract class Entity {

    private String Nom;
    private int Health;
    private int Strength;


    Entity(){

    }

    /**
     * Constructor
     */
    Entity(String nom, int minHealth, int maxHealth, int minStrength, int maxStrength){
        Nom = nom;
        // Image = img;
        Health = generateRandom(minHealth,maxHealth);
        Strength = generateRandom(minStrength,maxStrength);
    }

    int generateRandom(int min, int max){
        //4    +   (int)(0.0 <> 1.0       *      ((12 - 4 )              + 1))
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    String getNom() {
        return Nom;
    }

    int getHealth() {
        return Health;
    }

    int getStrength() {
        return Strength;
    }

    void setNom(String nom) {
        Nom = nom;
    }

    void setHealth(int health) {
        Health = health;
    }

    void setStrength(int strength) {
        Strength = strength;
    }

    abstract void showInfo();

    abstract void editEntity();
}
