import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * An interface detailing the actions the game should take depending on input from the player and in-game timers
 *
 * @author Michael Cummings
 * @version 3.30.29
 */
public interface GameTimePulse
{
    /**
     * Method to detect whether the game has ended (player has collided with an object)
     *
     * @return    gameOver
     */
    public boolean gameIsOver();
    
    /**
     * Method to detect whether the player has made any inputs
     */
    public void gamePlayerInput(KeyListener gameInput);
    
    /**
     * Method to create a new list of items currently on screen, then check if any of those items are off the screen, then calls GameObject methods to instantiate new obstacles
     */
    public void gameItemPlacement();
    
    /**
     * Method to check if the player has collided with any obstacles (not checking if obstacles collide with each other in this game)
     */
    public void gameObjectCollisionDetection();
    
    /**
     * Method to check if the player is on screen
     */
    public void gamePlayerIsOnScreen();
    
    /**
     * Method to increment the game's point counter, record high score
     */
    public void gamePointCounter();
}
