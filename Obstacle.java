import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A class representing an obstacle that can collide with the player that appears at the top of the game screen
 *
 * @author Michael Cummings
 * @version 4.3.23
 */
public class Obstacle extends MovableGameObject
{
    String obstacleName = "Obstacle";
    Color obstacleColor = Color.RED;
    int obstacleWidth = 16;
    int obstacleHeight = 16;
    int obstacleSpeed = 2;
    
    /**
     * Constructor for objects of class Obstacle
     */
    public Obstacle()
    {
        this.setGameObjectName(obstacleName);
        this.setGameObjectColor(obstacleColor);
        this.setGameObjectLocation(0, 0);
        this.setGameObjectWidth(obstacleWidth);
        this.setGameObjectHeight(obstacleHeight);
        this.setMovableGameObjectSpeed(obstacleSpeed);
    }
    
    /**
     * Constructor for objects of class Obstacle
     */
    public Obstacle(int x, int y)
    {
        this.setGameObjectName(obstacleName);
        this.setGameObjectColor(obstacleColor);
        this.setGameObjectLocation(x, y);
        this.setGameObjectWidth(obstacleWidth);
        this.setGameObjectHeight(obstacleHeight);
        this.setMovableGameObjectSpeed(obstacleSpeed);
    }
}
