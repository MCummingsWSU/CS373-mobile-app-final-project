import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A class representing an instance of a mobile game
 *
 * @author Michael Cummings
 * @version 3.30.23
 */
public class Game
{
    private boolean gameOver;
    private KeyListener gameInput;
    private String gameTitle;
    private boolean[] keyboard;
    private ArrayList<GameObject> gameWorldObjects;
    private GameObject gamePlayerCharacter;
    private long gamePointsScore;
    private long gamePointsHighScore = 0;
    //private int gameTimeCounter; Used for adjusting difficulty, can come back to this later
    private long gameTimeDelay; //Need this for graphics rendering code
    private Random gameRandomSeed; //Will hold a random value generated at initialization that will be used to decide whether the game creates an obstacle on the play screen, also will be used to determine object dimensions
    
    /**
     * Method to prepare the initial conditions to run the game
     */
    public void initialize()
    {
        gameOver = false;
        keyboard = new boolean[KeyEvent.KEY_LAST]; 
        gamePlayerCharacter = new MovableGameObject(Color.BLACK, 0, 16, "Player", 16, 16, 16); //Values subject to change once I see how the game looks on a phone screen
        gamePointsScore = 0;
        gameRandomSeed = new Random((long)(Math.random() * Long.MAX_VALUE));
        gameWorldObjects = new ArrayList<>();
        
        //In progress
    }

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        Game newGame = new Game();
        
        //TODO: Create setup method to initialize KeyListener, Graphics and JFrame, implement GameTimePulse
        //Create driver / main method
    }
}