import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Guerrier extends Entity{
    /**
     *
     */
    private Obj arme;

    // listes des armes dispo pour la classe Guerrier
    private List<Obj> Armes = new ArrayList<>();

    /**
     *
     */
    private String bouclier;


    /**
     * Constructor
     */
    public Guerrier(){
        super();
    }

    /**
     * overload Constructor
     *
     */
    public Guerrier(String name){
        super();
    }


    Guerrier(String name, int minHealth, int maxHealth, int minStrength, int maxStrength){
        super(name,minHealth,maxHealth,minStrength,maxStrength);
        this.Armes =  createListWeapon();
        this.setOffense();
        this.setDeffense("Bouclier En Bois");
    }

    private List<Obj>  createListWeapon(){
        List<Obj> armes = new ArrayList<>();
        armes.add(new Arme ("cleave Hachette",3));
        armes.add(new Arme ("spliter Hachette",3));
        armes.add(new Arme ("crackle Hachette",3));
        return armes;
    }

    void setOffense(){
        this.arme = this.Armes.get(generateRandom(0,this.Armes.size()-1));
    }
    void setDeffense(String bouclier){
        this.bouclier = bouclier;
    }

    protected void setBouclier(String bouclier) {
        this.bouclier = bouclier;
    }

    protected void setArme(Obj arme){
        this.arme = arme;
    }



    public void showInfo(){
        System.out.println("____________________________");
        System.out.println("|-----------" + this.getClass().getSimpleName() + "---");
        System.out.println("|Name : " + this.getNom());
        System.out.println("|Health : " + this.getHealth());
        System.out.println("|Strength : " + this.getStrength());
        System.out.println("|----------------------------");
        System.out.println("|Weapon : " + arme.getNom());
        System.out.println("|Strength Weapon : " + arme.getStrength());
        System.out.println("|----------------------------");
        System.out.println("|Defensif Shield : " + bouclier);
        System.out.println("____________________________");

    }

    public void editEntity() {
        Scanner sc = new Scanner(System.in);
        String str;
        TypeEntity type =  TypeEntity.GUERRIER;



        System.out.println(this.getNom() + " | Health:" + this.getHealth()+ " | Strength:" + this.getStrength()+ " | Shield:" + this.bouclier + " | Arme :"+ this.arme.getNom());



        System.out.println("EDITION ][ Nom Entity  : " );
        str = sc.nextLine();
        if (!str.equals("")){
            this.setNom(str);
        }


        System.out.println("EDITION ][ Nom Bouclier  : " );
        str = sc.nextLine();
        if (!str.equals("")) {
            this.setBouclier(str);
        }

        System.out.println("EDITION ][ Relancer les dés de vie ?  y/n  : " );
        str = sc.nextLine();
        if (str.equals("y")){
            this.setHealth(this.generateRandom(type.minHealth,type.maxHealth));
        }

        System.out.println("EDITION ][ Relancer les dés de puissance ?  y/n  : " );
        str = sc.nextLine();
        if (str.equals("y")){
            this.setStrength(this.generateRandom(type.minStrength,type.maxStrength));
        }

        System.out.println("EDITION ][ Relancer les dés pour l'arme ?  y/n  : " );
        str = sc.nextLine();
        if (str.equals("y")){
            //souhait
            this.setArme(this.Armes.get(this.generateRandom(0,this.Armes.size()-1)));
        }


        //------------------------------------------------------------------------------
        System.out.println("Modification récapitulatif :");
        System.out.println(this.getNom() + " | Health:" + this.getHealth()+ " | Strength:" + this.getStrength()+ " | Shield:" + this.bouclier + " | Arme :"+ this.arme.getNom());
    }

}
