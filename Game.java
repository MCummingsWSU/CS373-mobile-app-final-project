import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
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
 * @version 4.17.23
 */
public class Game extends JFrame
{
    private boolean gameOver;
    private JPanel gameWindow;
    private KeyListener gameInput;
    public static int gameWidth = 480;
    public static int gameHeight = 854;//9:16 480p aspect ratio
    public String gameTitle = "WorkingTitle";
    private boolean[] keyboard;
    private ArrayList<MovableGameObject> gameWorldObjects;
    private Player gamePlayerCharacter;
    private int gamePlayerCharacterStartXCoordinate = gameWidth / 2;
    private int gamePlayerCharacterStartYCoordinate = gameHeight - 64;
    private int gamePlayerCharacterContinuesRemaining; //Represents number of collisions player has left before gameOver state evaluates true
    private long gamePointsScore;
    private long gamePointsHighScore = 0;
    private int gamePointsCounter;
    private int gameDifficultyLevel; 
    private int gameFramesPerSecondTarget = 120;
    private long gameFrameDrawTime = 1000 / gameFramesPerSecondTarget;  //1000 ms / 120 fps ~= 1 frame / 8.33 ms
    private Random gameRandomSeed; //Will hold a random value generated at initialization that will be used to decide the coordinates to place Obstacles
    
    /**
     * Method to call one of the createMovableGameObject() methods, depending on a random number and gameDifficultyLevel
     */
    public MovableGameObject movableGameObjectObstacleSpawner()
    {
        double gameRandomDouble = gameRandomSeed.nextDouble();
        int gameRandomInt = (int)Math.round(gameRandomDouble * 10) + 1;
        
        if(gameRandomInt == 1)
        {
            return createMovableGameObjectBonusItemGold();
        }
        if(gameRandomInt + gameDifficultyLevel >= 13 && gameRandomInt + gameDifficultyLevel <= 15)
        {
            return createMovableGameObjectObstacleFast();
        }
        if((gameRandomInt + gameDifficultyLevel == 16))
        {
            return createMovableGameObjectObstacleLarge();
        }
        return createMovableGameObjectObstacle();
    }
    
    /**
     * Method to instantiate an Obstacle MovableGameObject
     * Intended to make Obstacles appear at a random point along the x-axis from 16 to 448, and at a random point from -32 to -886 on the y-axis to give the player time to react as it moves down the screen and up the y-axis
     * 
     * @return Obstacle
     */
    public Obstacle createMovableGameObjectObstacle()
    {
        return new Obstacle((int)(gameRandomSeed.nextDouble() * (gameWidth - 48) + 16), (int)(gameRandomSeed.nextDouble() * -gameHeight - 32));
    }
    
    /**
     * Method to instantiate an ObstacleLarge MovableGameObject
     * 
     * @return  ObstacleLarge
     */
    public ObstacleLarge createMovableGameObjectObstacleLarge()
    {
        return new ObstacleLarge((int)(gameRandomSeed.nextDouble() * (gameWidth - 64) + 32), (int)(gameRandomSeed.nextDouble() * -gameHeight - 64));
    }
    
    /**
     * Method to instantiate an ObstacleFast MovableGameObject
     * 
     * @return  ObstacleFast
     */
    public ObstacleFast createMovableGameObjectObstacleFast()
    {
        return new ObstacleFast((int)(gameRandomSeed.nextDouble() * (gameWidth - 48) + 16), (int)(gameRandomSeed.nextDouble() * -gameHeight - 32));
    }
    
    /**
     * Method to instantiate a BonusItem MovableGameObject
     * 
     * @return  BonusItem
     */
    public BonusItem createMovableGameObjectBonusItemGold()
    {
        return new BonusItemGold((int)(gameRandomSeed.nextDouble() * (gameWidth - 48) + 16), (int)(gameRandomSeed.nextDouble() * -gameHeight - 32));
    }
    
    /**
     * Method to instantiate a Player MovableGameObject
     * 
     * @return  Player
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
        gamePlayerCharacter = createMovableGameObjectPlayer(); //Values subject to change once I see how the game looks on a phone screen
        gamePlayerCharacterContinuesRemaining = 2;
        gamePointsScore = 0;
        gamePointsCounter = 0;
        gameDifficultyLevel = 0;
        gameRandomSeed = new Random();
        gameWorldObjects = new ArrayList<>();
        
        for (int i = 0; i < 10; i++)
        {
            gameWorldObjects.add(movableGameObjectObstacleSpawner()); 
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
        
        if(keyboard[KeyEvent.VK_A] || keyboard[KeyEvent.VK_LEFT]) //player should be able to move from [8,448] on the x-axis to keep entire Player object in screen space
        {
            if(gamePlayerCharacter.getGameObjectLocation().getX() - gamePlayerCharacter.getGameObjectWidth() / 2 > 0)
            {
                gamePlayerCharacter.translateMovableGameObject((int)gamePlayerCharacter.getMovableGameObjectSpeed() * -1, 0);
            }
        }
        if(keyboard[KeyEvent.VK_D] || keyboard[KeyEvent.VK_RIGHT])
        {
            if(gamePlayerCharacter.getGameObjectLocation().getX() + gamePlayerCharacter.getGameObjectWidth() + (gamePlayerCharacter.getGameObjectWidth() / 2)  < gameWidth - gamePlayerCharacter.getGameObjectWidth())
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
                if(!(movableGameObject instanceof BonusItem))
                {
                    gamePointsScore += 100;
                    gamePointsCounter += 100;
                }
                if((int)gamePointsCounter / 5000 > 0)
                {
                    if(gameDifficultyLevel < 10)
                    {
                        gameDifficultyLevel++;
                    }
                    gamePointsCounter = 0;
                }
                if(gamePointsScore > gamePointsHighScore)
                {
                    gamePointsHighScore = gamePointsScore;
                }
                gameWorldObjects.remove(movableGameObject);
                gameWorldObjects.add(movableGameObjectObstacleSpawner());
                for(int i = 1; i < gameDifficultyLevel; i++)
                {
                    if((int)(gameRandomSeed.nextDouble() * 100) == 1)
                    {
                        gameWorldObjects.add(movableGameObjectObstacleSpawner());
                    }
                }
            }
            else
            {
                if(GameObject.collision(gamePlayerCharacter, movableGameObject))
                {
                    if(movableGameObject instanceof BonusItemGold)
                    {
                        gamePointsScore += ((BonusItemGold)movableGameObject).getBonusItemPointValue();
                        gamePointsCounter += ((BonusItemGold)movableGameObject).getBonusItemPointValue();
                        if((int)gamePointsCounter / 5000 > 0)
                            {
                                if(gameDifficultyLevel < 10)
                                {
                                    gameDifficultyLevel++;
                                }
                                gamePointsCounter = 0;
                            }
                        if(gamePointsScore > gamePointsHighScore)
                            {
                                gamePointsHighScore = gamePointsScore;
                            }
                        gameWorldObjects.remove(movableGameObject);
                        gameWorldObjects.add(movableGameObjectObstacleSpawner());
                    }
                    else
                    {
                        if(gamePlayerCharacterContinuesRemaining > 0)
                        {
                            gamePlayerCharacterContinuesRemaining--;
                            gamePointsCounter = 0;
                            if(gameDifficultyLevel - 3 >= 0)
                            {
                                gameDifficultyLevel -= 3;
                            }
                            else
                            {
                                gameDifficultyLevel = 0;
                            }
                            gameWorldObjects.remove(movableGameObject);
                        }
                        else{
                        gameOver = true;}
                    }
                }
            }
        }
    }
    
    /**
     * Method to draw objects after the game's conditions are initialized using Graphics package
     */
    public void gameGraphicsInitialRender(Graphics gameGraphics)
    {
        gameGraphics.setColor(Color.GRAY);
        gameGraphics.fillRect(0, 0, gameWidth, gameHeight); //Background
        
        for(MovableGameObject movableGameObject: gameWorldObjects)
        {
            gameGraphics.setColor(movableGameObject.getGameObjectColor());
            gameGraphics.fillRect((int)movableGameObject.getGameObjectLocation().getX(),
                                    (int)movableGameObject.getGameObjectLocation().getY(),
                                    (int)movableGameObject.getGameObjectWidth(),
                                    (int)movableGameObject.getGameObjectHeight()
                                    ); 
        }
        
        gameGraphics.setColor(gamePlayerCharacter.getGameObjectColor());
        gameGraphics.fillRect((int)gamePlayerCharacter.getGameObjectLocation().getX(),
                                (int)gamePlayerCharacter.getGameObjectLocation().getY(),
                                (int)gamePlayerCharacter.getGameObjectWidth(),
                                (int)gamePlayerCharacter.getGameObjectHeight()
                                );
        
        gameGraphics.setFont(new Font("Consolas", Font.PLAIN, 22));
        gameGraphics.setColor(Color.WHITE);
        gameGraphics.drawString("" + gamePointsScore, gameWidth - gameGraphics.getFontMetrics().stringWidth("" + gamePointsScore) - 16, 22);
        gameGraphics.drawString("" + ("LIVES: " + gamePlayerCharacterContinuesRemaining), 8, 22);
        gameGraphics.drawString("" + ("DIFFICULTY: " + gameDifficultyLevel), 8, 44);
    
        gameGraphics.setColor(Color.GREEN);
        gameGraphics.drawString("" + ("HIGH SCORE: " + gamePointsHighScore), gameWidth - gameGraphics.getFontMetrics().stringWidth("" + "HIGH SCORE: " + gamePointsHighScore) - 16, 44);
        
        gameGraphics.setFont(getFont().deriveFont(11));
        gameGraphics.setColor(Color.WHITE);
        gameGraphics.drawString("" + "Spacebar to start a new game", gameWidth - gameGraphics.getFontMetrics().stringWidth("" + "Spacebar to start a new game") - 16, 55);
        gameGraphics.drawString("" + "A / Left Arrow to move left", gameWidth - gameGraphics.getFontMetrics().stringWidth("" + "A / Left Arrow to move left") - 16, 66);
        gameGraphics.drawString("" + "D / Right Arrow to move right", gameWidth - gameGraphics.getFontMetrics().stringWidth("" + "D / Right Arrow to move right") - 16, 77);
        gameGraphics.drawString("" + "Avoid RED!", gameWidth - gameGraphics.getFontMetrics().stringWidth("" + "Avoid RED!") - 16, 88);
        gameGraphics.drawString("" + "Touch GOLD for points!", gameWidth - gameGraphics.getFontMetrics().stringWidth("" + "Touch GOLD for points!") - 16, 99);
        
        
        if(gameOver)
        {
            gameGraphics.setFont(getFont().deriveFont(88.0f));
            gameGraphics.drawString("" + "GAME", gameWidth / 2 - gameWidth / 4, gameHeight / 2);
            gameGraphics.drawString("" + "OVER", gameWidth / 2 - gameWidth / 4, gameHeight / 2 + 88);
        }
    }
    
    /**
     * Method to render the JPanel to the screen and animate it
     */
    public void gameGraphicsSetup()
    {
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
        
        gameWindow = new JPanel()
        {
            private long gameTimeSinceLastLoop = System.currentTimeMillis();
            private long gameTimer = -1000; //-1000 Represents time in milliseconds to wait before beginning game loop
            private boolean gameIsInitialized = false;
            
            public void paint(Graphics gameGraphics)
            {
                if(!gameIsInitialized)
                    gameInitialize();
                gameIsInitialized = true;
                
                gameGraphics.clearRect(0, 0, gameWidth, gameHeight);
                
                long gameTimeCurrent = System.currentTimeMillis();
                long gameTimeDelta = gameTimeCurrent - gameTimeSinceLastLoop;
                
                gameTimeSinceLastLoop = gameTimeCurrent;
                
                gameTimer += gameTimeDelta;

                while(gameTimer >= gameFrameDrawTime)
                {
                    gameTimer -= gameFrameDrawTime;
                    gameTimePulse();
                }
                
                gameGraphicsInitialRender(gameGraphics);
                repaint();
            }
        };
    }

    /**
     * Default constructor for objects of class Game
     */
    public Game()
    {
        newGame = this;
        newGame.setVisible(false);
        newGame.setSize(gameWidth, gameHeight);
        newGame.setResizable(false);
        newGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newGame.setTitle(gameTitle);
        
        gameGraphicsSetup();
        newGame.addKeyListener(gameInput);
        
        newGame.add(gameWindow);
        newGame.setVisible(true);
    }
    
    public static Game newGame;
    public static void main(String[] args)
    {
        new Game();
    }
}