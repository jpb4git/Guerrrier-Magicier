import java.awt.*;

public class Guerrier extends Entity{
    /**
     *
     */
    private Arme arme;
    /**
     *
     */
    private String bouclier;


    /**
     * Constructor
     */
    public Guerrier(){
        super();
    }

    /**
     * overload Constructor
     * @param name
     */
    public Guerrier(String name){
        super();
    }

    /**
     * overload Constructor
     * @param name
     * @param minHealth
     * @param maxHealth
     * @param minStrength
     * @param maxStrength
     */
    public Guerrier(String name,int minHealth,int maxHealth,int minStrength,int maxStrength){
        super(name,minHealth,maxHealth,minStrength,maxStrength);
    }



}
