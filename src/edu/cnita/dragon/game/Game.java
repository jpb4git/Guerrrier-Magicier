package edu.cnita.dragon.game;
import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.ui.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Console console;
    List<Entity> entities;

    // Getters
    public List<Entity> getEntities() {
        return entities;
    }
    public Console getConsole() {
        return console;
    }

    /**  Constructor  */
    public Game (){
         this.entities = new ArrayList<>();
         this.console = new Console(this.getEntities());
    }


    public void playGame(){
        this.getConsole().showMenu();
    }

}
