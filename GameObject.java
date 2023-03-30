import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

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
    public void setGameObjectRightXCoordinate(Point location, double width);
    
    /**
     * 
     */
    public void setGameObjectRightXCoordinate(double x, double width);
    
    /**
     * 
     */
    public void setGameObjectRightXCoordinate(int x, double width);
    
    /**
     * 
     */
    public double getGameObjectRightXCoordinate();
    
    /**
     * 
     */
    public void setGameObjectLeftXCoordinate(Point location, double width);
    
    /**
     * 
     */
    public void setGameObjectLeftXCoordinate(double x, double width);
    
    /**
     * 
     */
    public void setGameObjectLeftXCoordinate(int x, double width);
    
    /**
     * 
     */
    public double getGameObjectLeftXCoordinate();
    
    /**
     * 
     */
    public void setGameObjectTopYCoordinate(Point location, double height);
    
    /**
     * 
     */
    public void setGameObjectTopYCoordinate(double y, double height);
    
    /**
     * 
     */
    public void setGameObjectTopYCoordinate(int y, double height);
    
    /**
     * 
     */
    public double getGameObjectTopYCoordinate();
    
    /**
     * 
     */
    public void setGameObjectBottomYCoordinate(Point location, double height);
    
    /**
     * 
     */
    public void setGameObjectBottomYCoordinate(double y, double height);
    
    /**
     * 
     */
    public void setGameObjectBottomYCoordinate(int y, double height);
    
    /**
     * 
     */
    public double getGameObjectBottomYCoordinate();
    
    /**
     * 
     */
    public static boolean collision(GameObject a, GameObject b)
    {
    return a.getGameObjectLeftXCoordinate() < b.getGameObjectRightXCoordinate() &&
            a.getGameObjectRightXCoordinate() > b.getGameObjectLeftXCoordinate() &&
            a.getGameObjectTopYCoordinate() > b.getGameObjectBottomYCoordinate() &&
            a.getGameObjectBottomYCoordinate() < b.getGameObjectTopYCoordinate();
    };
}
