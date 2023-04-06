import java.awt.Color;
import java.awt.Point;

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
     * Default constructor for objects of class Obstacle
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
     * Overloaded constructor for objects of class Obstacle
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
