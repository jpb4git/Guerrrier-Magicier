import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {



    // liste des personna
    private List<Entity> heros  = new ArrayList<>();
    // listes des armes dispo
    private List<Obj> Armes = new ArrayList<>();
    // liste des sorts Dispo
    private List<Obj> Sorts = new ArrayList<>();


    /**
     * enumeration des types  personnages
     */
    private enum TypeHero{
        GUERRIER (5,10,5,10),
        MAGICIEN (3,6,8,15);

        TypeHero(int minH,int maxH,int minS,int maxS) {
            this.minHealth   = minH;
            this.maxHealth   = maxH;
            this.minStrength = minS;
            this.maxStrength = maxS;
        }

        private final int minHealth;
        private final int maxHealth;
        private final int minStrength;
        private final int maxStrength;

    }

    /**
     * method static  playGame
     */
    public static void playGame(){
        Game game = new Game();

        game.heros.add(game.createPersona());

        game.heros.forEach(
                hero->{
                    System.out.println(hero.getNom());
                    System.out.println("-----------");
                    System.out.println("Health : " + hero.getHealth());
                    System.out.println("-----------");
                    System.out.println("Strength : " + hero.getStrength());
                    System.out.println("-----------");
                }
        );
    }


    private void  init(){
        // create liste Weapons

        // create List Sort

    }

   private Entity createPersona(){
       String name;
       TypeHero type;
       Scanner sc = new Scanner(System.in);
       System.out.println("Bienvenue dans Game choisissez un Nom pour votre personnage  : " );
       name = sc.nextLine();
       System.out.println(" L'archétype  de votre personnage :: 1 pour " + TypeHero.GUERRIER.toString() + "  |  2 pour  " + TypeHero.MAGICIEN.toString() + " ? :");
       String str = sc.nextLine();
       if (Integer.parseInt(str) == 1 ){
            System.out.println("Vous avez choisi : " + TypeHero.GUERRIER.toString());
            type = TypeHero.GUERRIER;

            Guerrier guerrier = new Guerrier(name ,type.minHealth,type.maxHealth,type.minStrength,type.maxStrength);

            return (Entity) guerrier;
       }else{
            System.out.println("Vous avez choisi : " + TypeHero.MAGICIEN.toString());
            type = TypeHero.MAGICIEN;
            Magicien magicien  = new Magicien(name ,type.minHealth,type.maxHealth,type.minStrength,type.maxStrength);
            return (Entity) magicien;
       }
       /*  a placer dans le for each pour un descriptif des heros
       System.out.println("Vous avez choisi la classe " + type.toString());
       System.out.println("Votre " + type.toString() + " porte le Nom : " + name.toString());
       System.out.println("l'archetype possède les paramètres suivants nb vie possible ["
                           + type.minHealth + "  "
                           + type.maxHealth + "]  nb force possible ["
                           + type.minStrength + "  "
                           + type.maxStrength + "]    "
                           + name.toString());
      */

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
