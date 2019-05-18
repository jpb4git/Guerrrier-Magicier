
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Magicien extends Entity{


    private List<Obj> Sorts;

    private void setSort(Obj sort) {
        this.sort = sort;
    }

    private Obj sort;

    private String getPhiltre() {
        return Philtre;
    }

    private void setPhiltre(String philtre) {
        Philtre = philtre;
    }

    private String Philtre;


    /**
     * Constructor
     */
    Magicien(String name,int minHealth,int maxHealth,int minStrength,int maxStrength){
        super(name,minHealth,maxHealth,minStrength,maxStrength);
        this.Sorts =  createListSort();
        this.setOffense();
        this.setDefense("Barrière Spirituelle");

    }
    private void setOffense(){
        this.sort = this.Sorts.get(generateRandom(0,this.Sorts.size()-1));
    }
    private void setDefense(String philtre){
    this.Philtre = philtre;
    }
    private List<Obj>  createListSort(){
        List<Obj> sort = new ArrayList<>();
        sort.add(new Sort("frail FireBall",3));
        sort.add(new Sort("weak FireBall",3));
        sort.add(new Sort("feeble FireBall" ,3));
        return sort;
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
        Scanner sc = new Scanner(System.in);
        String str;
        TypeEntity type =  TypeEntity.MAGICIEN;



        System.out.println(this.getNom() + " | Health:" + this.getHealth()+ " | Strength:" + this.getStrength()+ " | Philtre :" + this.getPhiltre() + " | Sort :"+ this.sort.getNom());



        System.out.println("EDITION ][ Nom Entity  : " );
        str = sc.nextLine();
        if (!str.equals("")){
            this.setNom(str);
        }


        System.out.println("EDITION ][ Nom Philtre  : " );
        str = sc.nextLine();
        if (!str.equals("")) {
            this.setPhiltre(str);
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

        System.out.println("EDITION ][ Relancer les dés pour le sort ?  y/n  : " );
        str = sc.nextLine();
        if (str.equals("y")){
            //souhait
            this.setSort(this.Sorts.get(this.generateRandom(0,this.Sorts.size()-1)));
        }


        //------------------------------------------------------------------------------
        System.out.println("Modification récapitulatif :");
        System.out.println(this.getNom() + " | Health:" + this.getHealth()+ " | Strength:" + this.getStrength()+ " | Shield:" + this.getPhiltre() + " | Sort :"+ this.sort.getNom());

    }
}
