import java.awt.Color;
import java.awt.Point;

/**
 * A class representing the character the player controls in the game
 *
 * @author Michael Cummings
 * @version 4.3.23
 */
public class Player extends MovableGameObject
{   
    String playerName = "Player";
    Color playerColor = Color.BLACK;
    int playerWidth = 16;
    int playerHeight = 16;
    int playerSpeed = 4;
    
    /**
     * Default constructor for objects of class Player
     */
    public Player()
    {
        this.setGameObjectName(playerName);
        this.setGameObjectColor(playerColor);
        this.setGameObjectWidth(playerWidth);
        this.setGameObjectHeight(playerHeight);
        this.setGameObjectLocation(0, 0);
        this.setMovableGameObjectSpeed(playerSpeed);
    }
    
    /**
     * Overloaded constructor for objects of class Player
     */
    public Player(int x, int y)
    {
        this.setGameObjectName(playerName);
        this.setGameObjectColor(playerColor);
        this.setGameObjectWidth(playerWidth);
        this.setGameObjectHeight(playerHeight);
        this.setGameObjectLocation(x, y);
        this.setMovableGameObjectSpeed(playerSpeed);
    }
}
