package main.items;

/**
 * The Sword class implements the Item interface.
 * It set attack points and description of this sword.
 * 
 * This class is a child class of the parent class 'Item'.
 * It only can export its data.
 * 
 * @author Yavor Yankov
 * @version 26/12/2020
 */
public class Sword implements Item 
{
    private String name;        // name of this sword
    private int points;         // attack points of this sword
    private String description; // description of this sword

    /**
     * The constructor intialize new sword as it recieves its
     * attack points and description.
     * 
     * @param name of this sword
     * @param points of this sword
     * @param description of this sword
     */
    public Sword(String name, int points, String description)
    {
        this.name = name;
        this.points = points;
        this.description = description;
    }
    
    /**
     * @return the name of this sword
     */
    @Override
    public String getName() 
    {
        return this.name;
    }

    /**
     * @return the attack points of this sword 
     */
    @Override
    public int getPoints() 
    {
        return this.points;
    }

    /**
     * @return the description of this sword
     */
    @Override
    public String getDescription() 
    {
        return this.description;
    }
}
