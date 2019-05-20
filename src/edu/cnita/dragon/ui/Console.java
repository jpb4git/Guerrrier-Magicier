package edu.cnita.dragon.ui;

import edu.cnita.dragon.EnumArchetype.TypeEntity;
import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.entities.archetype.Guerrier;
import edu.cnita.dragon.entities.archetype.Magicien;
import edu.cnita.dragon.game.Game;

import java.util.Scanner;
public class Console implements UI{

    private Game game;

    // Constructor
    public Console(Game game){
        this.game = game;
    }
    public void showMenu(){
        //clearScreen();
        Scanner sc = new Scanner(System.in);
        System.out.println("_______________________________________________________________________________________________________________" );
        System.out.println("Ajouter une Entité :: 1 | Liste Entités :: 2 | éditer une Entité :: 3 | Supprimer une entité :: 4 | Quitter :: 5" );
        System.out.println("_______________________________________________________________________________________________________________" );
        String str = sc.nextLine();

        while(Integer.parseInt(str) != 5){

            switch (Integer.parseInt(str)){
                case 1:
                    AddEntity();
                    break;
                case 2:
                    listeEntity();
                    break;
                case 3:
                    // sub menu edition ENtity
                   editEntity();
                    break;
                case 4:
                     deleteEntity();
                    break;
                default:

            }
           // clearScreen();
            System.out.println("_______________________________________________________________________________________________________________" );
            System.out.println("Ajouter une Entité :: 1 | Liste Entités :: 2 | éditer une Entité :: 3 | Supprimer une entité :: 4 | Quitter :: 5" );
            System.out.println("_______________________________________________________________________________________________________________" );
            str = sc.nextLine();
        }
    }
    public void listeEntity(){

        for (Entity hero: this.game.getEntities()) {
            System.out.println("____________________________");
            System.out.println("|---------- " +hero.getType().toString() + " -------");
            System.out.println("|Name : " + hero.getNom());
            System.out.println("|Health : " + hero.getHealth());
            System.out.println("|Strength : " + hero.getStrength());
            System.out.println("|----------------------------");
            System.out.println("|Weapon : " + hero.getOffense().getNom());
            System.out.println("|Strength Weapon : " + hero.getOffense().getStrength());
            System.out.println("|----------------------------");
            System.out.println("|Defensif : " + hero.getDefense());
            System.out.println("____________________________");
        }
    }
    public Entity createEntity(){
        clearScreen();
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez un Nom pour votre personnage  : " );
        name = sc.nextLine();
        System.out.println(" L'archétype  de votre personnage :: 1 pour " + TypeEntity.GUERRIER + "  |  2 pour  " + TypeEntity.MAGICIEN + " ? :");
        String str = sc.nextLine();

        if (Integer.parseInt(str) == 1 ){
            System.out.println("Vous avez choisi : " + TypeEntity.GUERRIER);


            return new Guerrier(name ,TypeEntity.GUERRIER.minHealth,
                                      TypeEntity.GUERRIER.maxHealth,
                                      TypeEntity.GUERRIER.minStrength,
                                      TypeEntity.GUERRIER.maxStrength,
                                      TypeEntity.GUERRIER);
        }else{
            System.out.println("Vous avez choisi : " + TypeEntity.MAGICIEN);
            return  new Magicien(name ,TypeEntity.MAGICIEN.minHealth,TypeEntity.MAGICIEN.maxHealth,TypeEntity.MAGICIEN.minStrength,TypeEntity.MAGICIEN.maxStrength,TypeEntity.MAGICIEN);
        }
    }
    public void editEntity(){
        int i = 0;
        String str;
        Scanner sc = new Scanner(System.in);

        System.out.println("__________");
        System.out.println("EDITION   ");
        System.out.println("__________");

        for (Entity hero: game.getEntities()) {
            System.out.print( hero.getNom() + " Tapez " + i + "  |  ");
            i++;
        }
        System.out.println("Quittez le mode édition :: q ");
        str = sc.nextLine();

        while (!str.equals("q")){
            clearScreen();

            // formulaire edition avec index
            this.FormulaireEntity(this.game.getEntities().get(Integer.parseInt(str)));


            i = 0;
            System.out.println("__________");
            System.out.println("EDITION   ");
            System.out.println("__________");
            for (Entity hero: game.getEntities()) {
                System.out.print( hero.getNom() + " Tapez " + i + "  |  ");
                i++;
            }
            System.out.println("Quittez le mode édition :: q ");
            str = sc.nextLine();

        }


    }
    public void FormulaireEntity(Entity entity){

        Scanner sc = new Scanner(System.in);
        String str;
        TypeEntity type =  entity.getType();

        System.out.println(entity.getNom() + " | Health:" + entity.getHealth()+ " | Strength:" + entity.getStrength()+ " | Defense :" + entity.getDefense() + " | Offense :"+ entity.getOffense().getNom());
        System.out.println("EDITION ][ Nom Entity  : " );
        str = sc.nextLine();
        if (!str.equals("")){
            entity.setNom(str);
        }


        System.out.println("EDITION ][ Nom Bouclier  : " );
        str = sc.nextLine();
        if (!str.equals("")) {
            entity.setDefense(str);
        }

        System.out.println("EDITION ][ Relancer les dés de vie ?  y/n  : " );
        str = sc.nextLine();
        if (str.equals("y")){
             entity.setHealth(entity.generateRandom(type.minHealth,type.maxHealth));
        }

        System.out.println("EDITION ][ Relancer les dés de puissance ?  y/n  : " );
        str = sc.nextLine();
        if (str.equals("y")){
             entity.setStrength(entity.generateRandom(type.minStrength,type.maxStrength));
        }

        System.out.println("EDITION ][ Relancer les dés pour l'arme ?  y/n  : " );
        str = sc.nextLine();
        if (str.equals("y")){
            //souhait
            entity.setOffense();
        }

        //------------------------------------------------------------------------------
        System.out.println("Modification récapitulatif :");
        System.out.println(entity.getNom() + " | Health:" + entity.getHealth()+ " | Strength:" + entity.getStrength()+ " | Defense :" + entity.getDefense() + " | Offense :"+ entity.getOffense().getNom());

    }
    public void deleteEntity(){
        int i = 0;
        String str;
        Scanner sc = new Scanner(System.in);

        System.out.println("__________");
        System.out.println("DELETE    ");
        System.out.println("__________");

        for (Entity hero: this.game.getEntities()) {
            System.out.print( hero.getNom() + " Tapez " + i + "  |  ");
            i++;
        }
        System.out.println("Quittez le mode Delete :: q ");
        str = sc.nextLine();

        while (!str.equals("q")){
            clearScreen();

            //delete Entity
            this.game.getEntities().remove(Integer.parseInt(str));


            i = 0;
            System.out.println("__________");
            System.out.println("DELETE    ");
            System.out.println("__________");
            for (Entity hero: game.getEntities()) {
                System.out.print( hero.getNom() + " Tapez " + i + "  |  ");
                i++;
            }
            System.out.println("Quittez le mode Delete :: q ");
            str = sc.nextLine();

        }





    }
    public void AddEntity(){
        Entity NewEntity = createEntity();
        this.game.getEntities().add(NewEntity);
    }
    private static void clearScreen() {

        System.out.print("\033[H\033[2J");
    }

}
