package edu.cnita.dragon.ui;

import edu.cnita.dragon.EnumArchetype.TypeEntity;
import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.entities.archetype.Guerrier;
import edu.cnita.dragon.entities.archetype.Magicien;
import edu.cnita.dragon.game.Game;

import java.util.List;
import java.util.Scanner;
public class Console implements UI{


    //Attributs
    private List<Entity> entities;
    //getters
    public List<Entity> getEntities() {
        return entities;
    }

    // Constructor
    public Console(List<Entity> entities){
        this.entities = entities;
    }
    //methods
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
        sc.close();// memory ....
    }
    public void listeEntity(){

        for (Entity hero: this.getEntities()) {
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
            System.out.println("Vous avez choisi : " + TypeEntity.GUERRIER.toString());


            return new Guerrier(name , TypeEntity.GUERRIER);

        }else{
            System.out.println("Vous avez choisi : " + TypeEntity.MAGICIEN);
            return  new Magicien(name ,TypeEntity.MAGICIEN);
        }
    }
    public void editEntity(){
        int i = 0;
        String str;
        Scanner sc = new Scanner(System.in);

        System.out.println("__________");
        System.out.println("EDITION   ");
        System.out.println("__________");

        for (Entity hero: this.getEntities()) {
            System.out.print( hero.getNom() + " Tapez " + i + "  |  ");
            i++;
        }
        System.out.println("Quittez le mode édition :: q ");
        str = sc.nextLine();

        while (!str.equals("q")){
            clearScreen();

            // formulaire edition avec index
            formulaireEntity(this.getEntities().get(Integer.parseInt(str)));


            i = 0;
            System.out.println("__________");
            System.out.println("EDITION   ");
            System.out.println("__________");
            for (Entity hero: this.getEntities()) {
                System.out.print( hero.getNom() + " Tapez " + i + "  |  ");
                i++;
            }
            System.out.println("Quittez le mode édition :: q ");
            str = sc.nextLine();

        }


    }
    public void formulaireEntity(Entity entity){

        Scanner sc = new Scanner(System.in);
        String str;
       // TypeEntity type =  entity.getType();

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
             entity.setHealth(entity.generateRandom(entity.getType().minHealth,entity.getType().maxHealth));
        }

        System.out.println("EDITION ][ Relancer les dés de puissance ?  y/n  : " );
        str = sc.nextLine();
        if (str.equals("y")){
             entity.setStrength(entity.generateRandom(entity.getType().minStrength,entity.getType().maxStrength));
        }

        System.out.println("EDITION ][ Relancer les dés pour l'arme ?  y/n  : " );
        str = sc.nextLine();
        if (str.equals("y")){
            //souhait
            entity.initOffense();
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

        for (Entity hero: this.getEntities()) {
            System.out.print( hero.getNom() + " Tapez " + i + "  |  ");
            i++;
        }
        System.out.println("Quittez le mode Delete :: q ");
        str = sc.nextLine();

        while (!str.equals("q")){
            clearScreen();

            //delete Entity
            this.getEntities().remove(Integer.parseInt(str));
            i = 0;
            System.out.println("__________");
            System.out.println("DELETE    ");
            System.out.println("__________");
            for (Entity hero: this.getEntities()) {
                System.out.print( hero.getNom() + " Tapez " + i + "  |  ");
                i++;
            }
            System.out.println("Quittez le mode Delete :: q ");
            str = sc.nextLine();

        }
    }
    public void AddEntity(){
        Entity NewEntity = createEntity();
        this.getEntities().add(NewEntity);
    }
    private static void clearScreen() {

        System.out.print("\033[H\033[2J");
    }

}
