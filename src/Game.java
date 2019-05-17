
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Game {

    // liste des Entitys
    private List<Entity> entity  = new ArrayList<>();
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
    private List<Obj>  initWeapon(){
        List<Obj> armes = new ArrayList<>();
        armes.add(createWeapon("Hache en Bronze",2));
        armes.add(createWeapon("Hache en fer",3));
        armes.add(createWeapon("Hache en bismut",4));
        return armes;
    }
    private List<Obj>  initSort(){
        List<Obj> sort = new ArrayList<>();
        sort.add(createSort("Luminix",2));
        sort.add(createSort("Freeze",3));
        sort.add(createSort("FireBall",4));
        return sort;
    }

    /**
     * method static  playGame
     */
    static void playGame(){
        Game game = new Game();
        game.init(game);
        game.showMenu(game);

    }
    private void showMenu(Game game){
        System.out.print("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);
        System.out.println("_______________________________________________________________________________________________________________" );
        System.out.println("Ajouter une Entité :: 1 | Liste Entités :: 2 | éditer une Entité :: 3 | Parcourir le donjon :: 4 | Quitter :: 5" );
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
                 game.editEntity(game);
                 break;
                case 4:
                break;
                case 5:
                break;
            }
            System.out.print("\033[H\033[2J");
            System.out.println("_______________________________________________________________________________________________________________" );
            System.out.println("Ajouter une Entité :: 1 | Liste Entités :: 2 | éditer une Entité :: 3 | Parcourir le donjon :: 4 | Quitter :: 5" );
            System.out.println("_______________________________________________________________________________________________________________" );
            str = sc.nextLine();
        }
    }

    private void init(Game game){
        game.Armes = game.initWeapon();
        game.Sorts = game.initSort();
        // Temporaire
        //game.printObj(game.Armes);
       // game.printObj(game.Sorts);
    }
    private void listeEntity(Game game){

        for (Entity hero: game.entity) {
            hero.showInfo();
        }
    }
    private void AddEntity(Game game){
        Entity NewEntity = game.createEntity(game.Armes.get(0),game.Sorts.get(0));
        this.entity.add(NewEntity);
    }
    private void editEntity(Game game){
        int i = 0;
        String str;
        Scanner sc = new Scanner(System.in);

        System.out.println("Editer : ");
        for (Entity hero: game.entity) {
           System.out.print( hero.getNom() + " Tapez " + i + "  |  ");
           i++;
        }
        System.out.println("Quittez le mode edition :: q ");
        str = sc.nextLine();

        while (str.equals("q")){
            Game.clearScreen();

            // formulaire edition avec index
            game.entity.get(i).editEntity();



            System.out.println("Editer : ");
            for (Entity hero: game.entity) {
                System.out.print( hero.getNom() + " Tapez " + i + "  |  ");
                i++;
            }
            System.out.println("Quittez le mode edition :: q ");
            str = sc.nextLine();



        }


    }

    /**
     * création de l'entity
     */
   private Entity createEntity(Obj arme,Obj sort){
       String name;
       TypeHero type;
       Scanner sc = new Scanner(System.in);
       System.out.println("Bienvenue dans Game choisissez un Nom pour votre personnage  : " );
       name = sc.nextLine();
       System.out.println(" L'archétype  de votre personnage :: 1 pour " + TypeHero.GUERRIER + "  |  2 pour  " + TypeHero.MAGICIEN + " ? :");
       String str = sc.nextLine();
       if (Integer.parseInt(str) == 1 ){
            System.out.println("Vous avez choisi : " + TypeHero.GUERRIER);
            type = TypeHero.GUERRIER;
            Guerrier guerrier = new Guerrier(name ,type.minHealth,type.maxHealth,type.minStrength,type.maxStrength);
            guerrier.setDeffense("Bouclier En Bois");
            System.out.println(arme.getStrength());
            guerrier.setOffense(arme);
            return guerrier;
       }else{
            System.out.println("Vous avez choisi : " + TypeHero.MAGICIEN.toString());
            type = TypeHero.MAGICIEN;
            Magicien magicien  = new Magicien(name ,type.minHealth,type.maxHealth,type.minStrength,type.maxStrength);
            magicien.setOffense(sort);
            magicien.setDeffense("vigor");
            return  magicien;
       }
   }
   private Arme createWeapon(String name,int Strength ){

        return new Arme(name,Strength);
    }
   private Sort createSort(String name,int Strength ){

        return new Sort(name,Strength);
    }
   /*
   private void printObj(List e){

        for(e item : e)
                System.out.println(" name : " + ((Obj)item).getNom());
        });


             for (int i = 0; i < e.size();i++ ){
                 Obj o = (Obj) e.get(i);
                 System.out.println("donnée à l'indice " + i + " = " + ((Obj) e.get(i)).getNom());
             }

    }
    */
   public List<Obj> getArmes() {
        return Armes;
    }
   public List<Obj> getSorts() {
        return Sorts;
    }
   private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
