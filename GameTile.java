import java.util.ArrayList;

/**
 * A class representing a square section of a video game's play area. 
 * Contains a boolean on whether it is occupied, and an ArrayList of objects inside of it.
 *
 * @author Michael Cummings
 * @version 3.29.23
 */
public class GameTile
{
    private boolean isTaken;
    private ArrayList<MovableGameObject> gameObjectsInTile = new ArrayList<MovableGameObject>();

    /**
     * Constructor for objects of class GameTile
     */
    public GameTile()
    {
        gameObjectsInTile.clear();
        isTaken = false;
    }
    
    /**
     * Method to set a tile's state to unoccupied or occupied
     */
    public void setGameTileTaken(boolean taken)
    {
        this.isTaken = taken;
    }

    /**
     * Method to return a boolean indicating whether the GameTile is occupied
     * 
     * @return  taken
     */
    public boolean getGameTileTaken()
    {
        return this.isTaken;
    }
}
