import java.awt.Color;
import java.awt.Point;

/**
 * A class representing an obstacle that can collide with the player that appears at the top of the game screen
 *
 * @author Michael Cummings
 * @version 4.3.23
 */
public class ObstacleLarge extends Obstacle
{
    String obstacleName = "ObstacleLarge";
    Color obstacleColor = Color.RED;
    int obstacleWidth = 32;
    int obstacleHeight = 32;
    int obstacleSpeed = 1;
    
    /**
     * Default constructor for objects of class ObstacleLarge
     */
    public ObstacleLarge()
    {
        this.setGameObjectName(obstacleName);
        this.setGameObjectColor(obstacleColor);
        this.setGameObjectLocation(0, 0);
        this.setGameObjectWidth(obstacleWidth);
        this.setGameObjectHeight(obstacleHeight);
        this.setMovableGameObjectSpeed(obstacleSpeed);
        this.setGameObjectNoCollide(false);
    }
    
    /**
     * Overloaded constructor for objects of class ObstacleLarge
     */
    public ObstacleLarge(int x, int y)
    {
        this.setGameObjectName(obstacleName);
        this.setGameObjectColor(obstacleColor);
        this.setGameObjectLocation(x, y);
        this.setGameObjectWidth(obstacleWidth);
        this.setGameObjectHeight(obstacleHeight);
        this.setMovableGameObjectSpeed(obstacleSpeed);
        this.setGameObjectNoCollide(false);
    }
}
