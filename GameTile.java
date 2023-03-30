import java.util.ArrayList;

/**
 * An interface representing a square section of a video game's play area. 
 * Contains a boolean on whether it is occupied, and an ArrayList of objects inside of it.
 *
 * @author Michael Cummings
 * @version 3.29.23
 */
public interface GameTile
{   
    /**
     * Method to set a tile's state to unoccupied or occupied
     * 
     * @param   taken
     */
    public void setGameTileTaken(boolean taken);

    /**
     * Method to return a boolean indicating whether the GameTile is occupied
     * 
     * @return  taken
     */
    public boolean getGameTileTaken();
    
    /**
     * Method to pass an ArrayList of GameObjects to the GameTile's gameObjectsInTile ArrayList
     */
    public void setGameTileObjectsInTile(ArrayList<GameObject> objects);
    
    /**
     * Method to return the list of GameObjects inside the GameTile as an ArrayList
     */
    public ArrayList<GameObject> getGameTileObjectsInTile();
    
    /**
     * Method to add a single GameObject to the GameTile's gameObjectsInTile list;
     */
    public void addGameObjectToGameTile(GameObject a);
    
    /**
     * Method to remove a single GameObject to the GameTile's gameObjectsInTile list;
     */
    public void removeGameObjectFromGameTile(GameObject a);
}
