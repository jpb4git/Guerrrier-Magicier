
import java.awt.image.BufferedImage;

public class Entity {

    private String Nom;
    private BufferedImage Image;
    private int Health;
    private int Strength;


    public Entity(){

    }


    public Entity(String nom ,int minHealth,int maxHealth,int minStrength , int maxStrength){
        Nom = nom;

       // Image = img;
        Health = generateHealth(minHealth,maxHealth);
        Strength = generateStrength(minStrength,maxStrength);

    }

    private int generateHealth(int minHealth,int maxHealth){
        return minHealth + (int)(Math.random() * ((maxHealth - minHealth) + 1));
    }

    private int generateStrength(int minStrength,int maxStrength){
        return minStrength + (int)(Math.random() * ((maxStrength - minStrength) + 1));
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return Nom;
    }

    public int getHealth() {
        return Health;
    }

    public int getStrength() {
        return Strength;
    }
}
