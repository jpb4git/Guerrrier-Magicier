
import java.awt.image.BufferedImage;

public class Entity {

    private String Nom;
    private BufferedImage Image;
    private int Health;
    private int Strength;


    public Entity(){

    }


    public Entity(String nom, BufferedImage img, int health, int strength){
        Nom = nom;
        Image = img;
        Health = health;
        Strength = strength;

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
}
