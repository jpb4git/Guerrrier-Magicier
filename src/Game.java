import java.util.List;
import java.util.Scanner;

public class Game {
    // liste des personnages
    private List<Entity> heros ;
    // listes des armes dispos
    private List<Obj> Armes ;
    // liste des sorts Dispo
    private List<Obj> Sorts ;


    /**
     * enumeration des type de personnage
     */
    private enum TypeHero{
        guerrier,
        magicien
    }

    /**
     * methode static  playGame
     */
    public static void playGame(){
        Game g = new Game();


        g.createPersonna();

    }


    private void  init(){

    }

   private void createPersonna(){

        String name;
        TypeHero type;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue dans Game choisissez La classe de votre personnage :: " + TypeHero.guerrier + "  |  " + TypeHero.magicien + " ? :");
        String str = sc.nextLine();

        System.out.println("Vous avez choisi : " + str);





    }

    /**
     *
     * @param name
     * @param Strength
     * @return Arme
     */
    public Arme createWeapon(String name,int Strength ){

        return new Arme(name,Strength);
    }
}
