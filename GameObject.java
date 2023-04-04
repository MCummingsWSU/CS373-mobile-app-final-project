import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * An interface containing methods for GameObjects. GameObject will be implemented in a MovableGameObject class, which will in turn be used to create subclasses for the player character and the obstacles in the game
 *
 * @author Michael Cummings
 * @version 3.30.23
 */
public interface GameObject
{
    /**
     * 
     */
    public void setGameObjectName(String name);
    
    /**
     * 
     */
    public String getGameObjectName();
    
    /**
     * 
     */
    public void setGameObjectColor(Color color);
    
    /**
     * 
     */
    public Color getGameObjectColor();
    
    /**
     * 
     */
    public void setGameObjectLocation(Point location);
    
    /**
     * 
     */
    public void setGameObjectLocation(int x, int y);
    
    /**
     * 
     */
    public void setGameObjectLocation(double x, double y);
    
    /**
     * 
     */
    public Point getGameObjectLocation();
    
    /**
     * 
     */
    public void setGameObjectWidth(double width);
    
    /**
     * 
     */
    public double getGameObjectWidth();
    
    /**
     * 
     */
    public void setGameObjectHeight(double height);
    
    /**
     * 
     */
    public double getGameObjectHeight();

    /**
     * 
     */
    public static boolean collision(GameObject a, GameObject b)
    {   
        return a.getGameObjectLocation().getX() + a.getGameObjectWidth() > b.getGameObjectLocation().getX() &&
                a.getGameObjectLocation().getY() + a.getGameObjectHeight() > b.getGameObjectLocation().getY() &&
                a.getGameObjectLocation().getX() < b.getGameObjectLocation().getX() + b.getGameObjectWidth() &&
                a.getGameObjectLocation().getY() < b.getGameObjectLocation().getY() + b.getGameObjectHeight();
    };
}
