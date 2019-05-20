package edu.cnita.dragon.game;
import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.ui.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Console console;
    List<Entity> entities;


    /**  Constructor  */
    public Game (){
         this.entities = new ArrayList<>();
         this.console = new Console(this);
    }

    /**
     * method static  playGame
     */
    public static void playGame(){
        Game game = new Game();
        game.console.showMenu();
    }
    // Getters
    public List<Entity> getEntities() {
        return entities;
    }
}
