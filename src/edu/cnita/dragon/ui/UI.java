package edu.cnita.dragon.ui;

import edu.cnita.dragon.entities.Entity;

public interface UI {

    void showMenu();
    void listeEntity();
    Entity createEntity();
    void editEntity();
    void formulaireEntity(Entity entity);
    void deleteEntity();
    void AddEntity();
}
