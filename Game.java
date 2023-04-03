import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A class representing an instance of a mobile game
 *
 * @author Michael Cummings
 * @version 4.3.23
 */
public class Game extends JFrame
{
    private boolean gameOver;
    private JPanel gameGraphics;
    private KeyListener gameInput;
    public static final int gameWidth = 480;
    public static final int gameHeight = 854;//9:16 480p aspect ratio
    public String gameTitle = "WorkingTitle";
    private boolean[] keyboard;
    private ArrayList<MovableGameObject> gameWorldObjects;
    private Player gamePlayerCharacter;
    private int gamePlayerCharacterStartXCoordinate = gameWidth / 2;
    private int gamePlayerCharacterStartYCoordinate = gameHeight + 16;
    private long gamePointsScore;
    private long gamePointsHighScore = 0;
    //private int gameTimeCounter; Used for adjusting difficulty, can come back to this later
    private long gameTimeDelay; //Need this for graphics rendering code
    private Random gameRandomSeed; //Will hold a random value generated at initialization that will be used to decide the coordinates to place Obstacles
    
    /**
     * Method to instantiate an Obstacle MovableGameObject
     * Intended to make Obstacles appear at a random point along the x-axis from 16 to 464, and at a random point from -32 to -886 on the y-axis to give the player time to react as it moves down the screen and up the y-axis
     */
    public Obstacle createMovableGameObjectObstacle()
    {
        return new Obstacle((int)(gameRandomSeed.nextDouble() * (gameWidth + 16)) - 32, (int)(gameRandomSeed.nextDouble() * -gameHeight - 32));
    }
    
    /**
     * Method to instantiate a Player MovableGameObject
     * @param x, y
     */
    public Player createMovableGameObjectPlayer()
    {
        return new Player(gamePlayerCharacterStartXCoordinate, gamePlayerCharacterStartYCoordinate);
    }
    
    /**
     * Method to prepare the initial conditions to run the game
     */
    public void gameInitialize()
    {
        gameOver = false;
        
        keyboard = new boolean[KeyEvent.KEY_LAST]; 
        gameInput = new KeyListener()
        {
            public void keyTyped(KeyEvent key)
            {
            }
            public void keyPressed(KeyEvent key)
            {
                keyboard[key.getKeyCode()] = true;
            }
            public void keyReleased(KeyEvent key)
            {
                keyboard[key.getKeyCode()] = false;
            }
        };
        
        gamePlayerCharacter = createMovableGameObjectPlayer(); //Values subject to change once I see how the game looks on a phone screen
        gamePointsScore = 0;
        gameRandomSeed = new Random((long)(Math.random() * Long.MAX_VALUE));
        gameWorldObjects = new ArrayList<>();
        
        
        for (int i = 0; i < 10; i++) //maybe create method later to produce a value for i to count up to for more Obstacles to appear at once as the player keeps winning the game? Function of game time and/or points
        {
            gameWorldObjects.add(createMovableGameObjectObstacle()); //Have only created one type of Obstacle for now, maybe rewrite to call a dedicated MovableObject spawner method that can add different types of Obstacles (regular, large, fast, etc.)
        }
    }
    
    /**
     * Method detailing the actions the game should take every time the frame refreshes, depending on user input and the state of the game
     */
    public void gameTimePulse()
    {
        if(gameOver)
        {
            if(keyboard[KeyEvent.VK_SPACE]) //Lets the player start a new game from the gameOver state
            {
                gameInitialize();
            }
            return;
        }
        
        if(keyboard[KeyEvent.VK_A] || keyboard[KeyEvent.VK_LEFT]) //player should be able to move from [8,838] on the x-axis to keep entire Player object in screen space
        {
            if(gamePlayerCharacter.getGameObjectLocation().getX() - gamePlayerCharacter.getGameObjectLeftXCoordinate() > 0)
            {
                gamePlayerCharacter.translateMovableGameObject((int)gamePlayerCharacter.getMovableGameObjectSpeed() * -1, 0);
            }
        }
        if(keyboard[KeyEvent.VK_D] || keyboard[KeyEvent.VK_RIGHT])
        {
            if(gamePlayerCharacter.getGameObjectLocation().getX() + gamePlayerCharacter.getGameObjectRightXCoordinate() < gameWidth)
            {
                gamePlayerCharacter.translateMovableGameObject((int)gamePlayerCharacter.getMovableGameObjectSpeed(), 0);
            }
        }
        
        ArrayList<MovableGameObject> gameWorldObjectsAlreadyRendered = new ArrayList<>();
        for(MovableGameObject movableGameObject: gameWorldObjects)
        {
            gameWorldObjectsAlreadyRendered.add(movableGameObject);
        }
        
        for(MovableGameObject movableGameObject: gameWorldObjectsAlreadyRendered)
        {
            movableGameObject.translateMovableGameObject(0, (int)movableGameObject.getMovableGameObjectSpeed());
            if(movableGameObject.getGameObjectLocation().getY() - movableGameObject.getGameObjectHeight() > gameHeight)
            {
                gamePointsScore += 100;
                if(gamePointsScore > gamePointsHighScore)
                {
                    gamePointsHighScore = gamePointsScore;
                }
                gameWorldObjects.remove(movableGameObject);
                gameWorldObjects.add(createMovableGameObjectObstacle());
            }
            else
            {
                if(GameObject.collision(gamePlayerCharacter, movableGameObject))
                {
                    gameOver = true;
                }
            }
        }
    }
    
    /**
     * TODO: Graphics rendering method
     */

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        Game newGame = new Game();
        newGame.setVisible(false);
        newGame.setSize(gameWidth, gameHeight);
        
        //TODO: Create setup method to initialize KeyListener, Graphics and JFrame, implement GameTimePulse
        //Create driver / main method
    }
}
