


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
        Health = generateHealth(minHealth,maxHealth);
        Strength = generateStrength(minStrength,maxStrength);
    }


    private int generateHealth(int minHealth,int maxHealth){
        return minHealth + (int)(Math.random() * ((maxHealth - minHealth) + 1));
    }

    private int generateStrength(int minStrength,int maxStrength){
                    //4    +   (int)(0.0 <> 1.0       *      ((12 - 4 )              + 1))
        return minStrength + (int)(Math.random() * ((maxStrength - minStrength) + 1));
    }

    /**
     *

     */
    String getNom() {
        return Nom;
    }

    int getHealth() {
        return Health;
    }

    int getStrength() {
        return Strength;
    }

    abstract void showInfo();

    abstract void editEntity();
}
