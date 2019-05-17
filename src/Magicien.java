import java.awt.*;
import java.util.List;

public class Magicien extends Entity{

    private Obj sort;
    private String Philtre;


    /**
     * Constructor
     */
    Magicien(String name,int minHealth,int maxHealth,int minStrength,int maxStrength){
        super(name,minHealth,maxHealth,minStrength,maxStrength);
    }
    void setOffense(Obj s){
        sort = s;
    }
    void setDeffense(String philtre){
    this.Philtre = philtre;
    }
    public void showInfo(){
        System.out.println("____________________________");
        System.out.println("|------------" + this.getClass().getSimpleName() + "------");
        System.out.println("|Name : " + this.getNom());
        System.out.println("|Health : " + this.getHealth());
        System.out.println("|Strength : " + this.getStrength());
        System.out.println("|----------------------------");
        System.out.println("|Sort : " + sort.getNom());
        System.out.println("|Strength Sort : " + sort.getStrength());
        System.out.println("|----------------------------");
        System.out.println("|Defensif Philtre : " + Philtre);
        System.out.println("|____________________________");
    }



    public void editEntity() {
        String name;
        System.out.println(this.getNom() + "Health:" + this.getHealth() + "Strength:" + this.getStrength() + "Philtre:" + this.Philtre);
    }
}
