package main.items;

import java.util.ArrayList;
import java.util.Collections;
import main.models.Location;

/**
 * The items generator is responsible for creation
 * of all items and random generation of them in
 * different locations on the map. 
 * 
 * Each item will be generated in at least two
 * locations on the map.
 * 
 * @author Yavor Yankov
 * @version 28/12/2020
 */
public class ItemsGenerator 
{
    /**
     * All items in the game 
     * @key Keeps the name of the item
     * @value Keeps the item child class
     */
    private static final ArrayList<Item> ITEMS = new ArrayList<>();

    private Location[] locations; // locations on the map of this game

    /**
     * The constructor initialize all items
     * and generate items in different locations on the map
     * 
     * @param locations on the map
     */
    public ItemsGenerator(Location[] locations) 
    {
        this.locations = locations;

        initializeItems();
        generateItems();     
    }
    
    /**
     * Add all available items in the items collection
     */
    private void initializeItems() 
    {
        ITEMS.add(new Sword(10, "Iron Sword - with 10 attack points."));
        ITEMS.add(new Sword(15, "Emerald Sword - with 15 attack points."));
        ITEMS.add(new Dagger(5, "Bronze Dagger - with 5 attack points."));
        ITEMS.add(new Dagger(12, "Steel Dagger - with 12 attack points."));
        ITEMS.add(new Shield(20, "Vigilante Shield - increase your health with 20 points."));
        ITEMS.add(new Shield(30, "Phantom Shield - increase your health with 30 points."));
        ITEMS.add(new Apple(50, "Gold Apple - increase your health and energy with 50 points."));
        ITEMS.add(new Apple(25, "Apple - increase your health and energy with 25 points."));
        ITEMS.add(new Potion(100, "Health Potion - increase your health with 100 points."));
        ITEMS.add(new Potion(100, "Energy Potion - increase your energy with 100 points."));
    }

    /**
     * It generates the items in different locations on the map.
     * This method set at least two items per location.
     * 
     * The way it works is:
     * Firstly, shuffle all items positions in items collection.
     * 
     * In order to avoid ArrayIndexOutOfBoundsException to be thrown,
     * selection statement checks is the current location index equal to locations collection size.
     * If that so, the rest of items will be set to the last location.
     * If not, the current item will be added to the current location.
     * 
     * Because of that, one location should keep at least two items,
     * after every item is added selection statement checks are there two items
     * in the current location. If there are the location will be
     * changed with the next one.
     */
    private void generateItems() 
    {
        Collections.shuffle(ITEMS);
        
        int currentLocationIndex = 0;

        for (Item item : ITEMS) 
        {
            if (currentLocationIndex == locations.length) 
            {
                this.locations[currentLocationIndex-1].addItem(
                    getItemName(item.getDescription()),
                    item);
            
                continue;
            }
            else
            {
                this.locations[currentLocationIndex].addItem(
                    getItemName(item.getDescription()),
                    item);                
            }

            if(this.locations[currentLocationIndex].getItems().size() == 2)
            {
                currentLocationIndex++;
            }
        }
    }

    /**
     * @param itemDescription the description of an item
     * @return the item name that is before the '-' symbol
     * in the description
     */
    private String getItemName(String itemDescription) 
    {
        return itemDescription
            .split(" - ")[0]
            .toLowerCase();
    }
}