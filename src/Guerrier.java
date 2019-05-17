import java.util.Scanner;

public class Guerrier extends Entity{
    /**
     *
     */
    private Obj arme;
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
    }

    void setOffense(Obj a){
        this.arme = a;
    }
    void setDeffense(String bouclier){
        this.bouclier = bouclier;
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
        String name;
        // Game.TypeHero type;
        System.out.println(this.getNom() + "Health:" + this.getHealth()+ "Strength:" + this.getStrength()+ "Shield:" + this.bouclier);
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue dans Game choisissez un Nom pour votre personnage  : " );
        name = sc.nextLine();
        System.out.println(" L'archétype  de votre personnage :: 1 pour " + Game.TypeHero.GUERRIER + "  |  2 pour  " + Game.TypeHero.MAGICIEN + " ? :");
        String str = sc.nextLine();
        if (Integer.parseInt(str) == 1 ){
            System.out.println("Vous avez choisi : " + Game.TypeHero.GUERRIER);
            type = Game.TypeHero.GUERRIER;
            Guerrier guerrier = new Guerrier(name ,type.minHealth,type.maxHealth,type.minStrength,type.maxStrength);
            guerrier.setDeffense("Bouclier En Bois");
            System.out.println(arme.getStrength());
            guerrier.setOffense(arme);
            return guerrier;
        }else{
            System.out.println("Vous avez choisi : " + Game.TypeHero.MAGICIEN.toString());
            type = Game.TypeHero.MAGICIEN;
            Magicien magicien  = new Magicien(name ,type.minHealth,type.maxHealth,type.minStrength,type.maxStrength);
            magicien.setOffense(sort);
            magicien.setDeffense("vigor");
            return  magicien;
    }
*/
    }
}
