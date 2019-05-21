package edu.cnita.dragon.game;
import edu.cnita.dragon.entities.Entity;
import edu.cnita.dragon.ui.Console;
import edu.cnita.dragon.ui.UI;
import static edu.cnita.dragon.EnumArchetype.EnumActionMenu.*;

public class Game {

    UI console;

    public void setEntities(Entity[] entities) {
        this.entities = entities;
    }

    Entity[] entities;

    // Getters
    public Entity[] getEntities() {
        return entities;
    }
    public UI getConsole() {
        return console;
    }

    /**  Constructor  */
    public Game (){

         this.entities = new Entity[0];
         this.console = new Console(this.getEntities());
    }


    public void playGame(){
        int response = 0;

        response = this.getConsole().showMenu();

        while (response !=  EXIT_GLOBAL.getValue()) {

            if (CREATE_ENTITY.getValue() == response){
                AddEntity();
            }else if (EDIT_ENTITY.getValue() == response){
                SubMenuPrepareEntries();
            }else if (LISTE_ENTITIES.getValue() == response){
                showListEntity();
            }else if (DELETE_ENTITY.getValue() == response){
                SubMenuPrepareEntriesDelete();
            }else{
                this.getConsole().showMenuHeader();
            }
            response = this.getConsole().showMenu();
        }
    }
    //--------------------------------------------------------------------
    //EDITING ENTITY -----------------------------------------------------
    //--------------------------------------------------------------------
    public void SubMenuPrepareEntries(){
        int response;
        response = EntityToStringMenu();
        // Sub menu edit Entity
        while (response != 999){
            this.getEntities()[response] = this.getConsole().formEntity(this.getEntities()[response]);

            response = EntityToStringMenu();
        }
    }
    private int  EntityToStringMenu(){

        String[] actionArr = new  String[this.getEntities().length + 1];
        for (int i = 0 ; i < this.getEntities().length ;i++) {
            actionArr[i] =  this.getEntities()[i].getNom() + " Tapez " + i + "  |  ";
        }
        actionArr[actionArr.length - 1 ] = " Quittez le mode édition :: 999 ";
        return this.getConsole().showEditMenuEntity(actionArr);
    }

    //--------------------------------------------------------------------
    //EDITING ENTITY -----------------------------------------------------
    //--------------------------------------------------------------------


    //--------------------------------------------------------------------
    //DELETE ENTITY -----------------------------------------------------
    //--------------------------------------------------------------------
    public void SubMenuPrepareEntriesDelete(){
        int response;
        response = EntityToStringMenuDelete();
        while (response != 999){
          this.setEntities(removeEntityFromArray(this.getEntities(),response));
          response = EntityToStringMenuDelete();
        }
    }

    private int  EntityToStringMenuDelete(){
        String[] actionArr = new  String[this.getEntities().length + 1];
        for (int i = 0 ; i < this.getEntities().length ;i++) {
            actionArr[i] =  this.getEntities()[i].getNom() + " Tapez " + i + "  |  ";
        }
        actionArr[actionArr.length - 1 ] = " Quittez le mode Suppression :: 999 ";
        return this.getConsole().showDeleteMenuEntity(actionArr);
    }


    public void AddEntity(){
        Entity newEntity = this.getConsole().createEntity();
        this.setEntities(addEntityToArray(this.getEntities(),newEntity));
    }
    /**
     * ShowListEntity envoie les informations des entités à la console
     */
    public void  showListEntity (){
        for (int i = 0 ; i < this.getEntities().length ;i++) {
            this.getConsole().showEntity(this.getEntities()[i].getType().toString(), this.getEntities()[i].getNom(), this.getEntities()[i].getHealth(),this.getEntities()[i].getStrength(), this.getEntities()[i].getOffense().getNom(), this.getEntities()[i].getOffense().getStrength(), this.getEntities()[i].getDefense());
        }
    }
    /**
     *
     * @param arrEntity array d'entités
     * @param elemIndex index de l'element à supprimer
     * @return Entity[] un tableau d'entités
     */
    public Entity[] removeEntityFromArray(Entity[] arrEntity , int elemIndex){
        Entity[] newArr = new Entity[arrEntity.length - 1];

        for(int i = 0; i < arrEntity.length; i++){
            if(i == elemIndex){
                for(int index = 0; index < i; index++){
                    newArr[index] = arrEntity[index];
                }
                for(int j = i; j < arrEntity.length - 1; j++){
                    newArr[j] = arrEntity[j+1];
                }
                break;
            }
        }
        return newArr;
    }

    /**
     *
     * @param arrEntity  Entity[] array of entities
     * @param elem Entity to add
     * @return Entity[] new array with added Entity
     */
    public Entity[] addEntityToArray(Entity[] arrEntity , Entity elem){
        int currentSize = arrEntity.length;
        int newSize = currentSize + 1;

        Entity[] tempArray = new Entity[newSize];
        for (int i=0; i < currentSize; i++)
        {
            tempArray[i] = arrEntity [i];
        }
        tempArray[newSize- 1] = elem;
       return  tempArray;

    }

}
