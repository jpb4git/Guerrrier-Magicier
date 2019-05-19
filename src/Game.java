
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Game {

    // liste des Entitys
    List<Entity> entities = new ArrayList<>();
    /**
     * Entry point   : method static  playGame
     */
    static void playGame(){
        Game game = new Game();
        game.showMenu(game);

    }
    private void showMenu(Game game){
        clearScreen();
        Scanner sc = new Scanner(System.in);
        System.out.println("_______________________________________________________________________________________________________________" );
        System.out.println("Ajouter une Entité :: 1 | Liste Entités :: 2 | éditer une Entité :: 3 | Supprimer une entité :: 4 | Quitter :: 5" );
        System.out.println("_______________________________________________________________________________________________________________" );
        String str = sc.nextLine();

        while(Integer.parseInt(str) != 5){

            switch (Integer.parseInt(str)){
                case 1:
                  game.AddEntity(game);
                break;
                case 2:
                  game.listeEntity(game);
                break;
                case 3:
                 // sub menu edition ENtity
                 game.editEntity(game);
                 break;
                case 4:
                    game.deleteEntity(game);
                    break;
                default:

            }
            clearScreen();
            System.out.println("_______________________________________________________________________________________________________________" );
            System.out.println("Ajouter une Entité :: 1 | Liste Entités :: 2 | éditer une Entité :: 3 | Supprimer une entité :: 4 | Quitter :: 5" );
            System.out.println("_______________________________________________________________________________________________________________" );
            str = sc.nextLine();
        }
    }
    private void listeEntity(Game game){

        for (Entity hero: game.entities) {
            hero.showInfo();
        }
    }
    private void AddEntity(Game game){
        Entity NewEntity = game.createEntity();
        this.entities.add(NewEntity);
    }
    private Entity createEntity(){
        clearScreen();
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue dans Game choisissez un Nom pour votre personnage  : " );
        name = sc.nextLine();
        System.out.println(" L'archétype  de votre personnage :: 1 pour " + TypeEntity.GUERRIER + "  |  2 pour  " + TypeEntity.MAGICIEN + " ? :");
        String str = sc.nextLine();

        if (Integer.parseInt(str) == 1 ){
            System.out.println("Vous avez choisi : " + TypeEntity.GUERRIER);
            return new Guerrier(name ,TypeEntity.GUERRIER.minHealth,TypeEntity.GUERRIER.maxHealth,TypeEntity.GUERRIER.minStrength,TypeEntity.GUERRIER.maxStrength);
        }else{
            System.out.println("Vous avez choisi : " + TypeEntity.MAGICIEN);
            return  new Magicien(name ,TypeEntity.MAGICIEN.minHealth,TypeEntity.MAGICIEN.maxHealth,TypeEntity.MAGICIEN.minStrength,TypeEntity.MAGICIEN.maxStrength);
        }
    }
    private void editEntity(Game game){
        int i = 0;
        String str;
        Scanner sc = new Scanner(System.in);

        System.out.println("__________");
        System.out.println("EDITION   ");
        System.out.println("__________");

        for (Entity hero: game.entities) {
           System.out.print( hero.getNom() + " Tapez " + i + "  |  ");
           i++;
        }
        System.out.println("Quittez le mode édition :: q ");
        str = sc.nextLine();

        while (!str.equals("q")){
            Game.clearScreen();

            // formulaire edition avec index
            game.entities.get(Integer.parseInt(str)).editEntity();


            i = 0;
            System.out.println("__________");
            System.out.println("EDITION   ");
            System.out.println("__________");
            for (Entity hero: game.entities) {
                System.out.print( hero.getNom() + " Tapez " + i + "  |  ");
                i++;
            }
            System.out.println("Quittez le mode édition :: q ");
            str = sc.nextLine();

        }


    }
    private void deleteEntity(Game game){
        int i = 0;
        String str;
        Scanner sc = new Scanner(System.in);

        System.out.println("__________");
        System.out.println("DELETE    ");
        System.out.println("__________");

        for (Entity hero: game.entities) {
            System.out.print( hero.getNom() + " Tapez " + i + "  |  ");
            i++;
        }
        System.out.println("Quittez le mode Delete :: q ");
        str = sc.nextLine();

        while (!str.equals("q")){
            Game.clearScreen();

            //delete Entity
            game.entities.remove(Integer.parseInt(str));


            i = 0;
            System.out.println("__________");
            System.out.println("DELETE    ");
            System.out.println("__________");
            for (Entity hero: game.entities) {
                System.out.print( hero.getNom() + " Tapez " + i + "  |  ");
                i++;
            }
            System.out.println("Quittez le mode Delete :: q ");
            str = sc.nextLine();

        }





    }
    private static void clearScreen() {

        System.out.print("\033[H\033[2J");
    }
}
