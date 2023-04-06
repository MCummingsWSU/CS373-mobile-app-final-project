import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * An interface containing methods for GameObjects. GameObject will be implemented in a MovableGameObject class, which will in turn be used to create subclasses for the player character and the obstacles in the game
 *
 * @author Michael Cummings
 * @version 3.30.23
 */
public interface GameObject
{
    /**
     * Method to set a GameObject's name
     * 
     * @param   name
     */
    public void setGameObjectName(String name);
    
    /**
     * Method to return a GameObject's name
     * 
     * @return  name
     */
    public String getGameObjectName();
    
    /**
     * Method to set a GameObject's Color
     * 
     * @param   color
     */
    public void setGameObjectColor(Color color);
    
    /**
     * Method to return a GameObject's Color
     * 
     * @return  color
     */
    public Color getGameObjectColor();
    
    /**
     * Method to set a GameObject's location on a 2D grid using a Point object
     * 
     * @param location
     */
    public void setGameObjectLocation(Point location);
    
    /**
     * Method to set a GameObject's location on a 2D grid using integer x and y-coordinates
     * 
     * @param   x, y
     */
    public void setGameObjectLocation(int x, int y);
    
    /**
     * Method to set a GameObject's location on a 2D grid using double x and y-coordinates
     * 
     * @param   x, y
     */
    public void setGameObjectLocation(double x, double y);
    
    /**
     * Method to return a GameObject's location on a 2D grid as a Point object containing an x-y coordinate pair
     * 
     * @return  location
     */
    public Point getGameObjectLocation();
    
    /**
     * Method to set a GameObject's width on a 2D grid
     * 
     * @param   width
     */
    public void setGameObjectWidth(double width);
    
    /**
     * Method to return a GameObject's width
     * 
     * @return  width
     */
    public double getGameObjectWidth();
    
    /**
     * Method to set a GameObject's height on a 2D grid
     * 
     * @param height
     */
    public void setGameObjectHeight(double height);
    
    /**
     * Method to return a GameObject's height
     * 
     * @return height
     */
    public double getGameObjectHeight();
    
    /**
     * Method to return a Rectangle whose dimensions are equal to the boundaries of the GameObject
     */
    public Rectangle getGameObjectBounds();

    /**
     * Method to return true if two GameObjects intersect at any point
     * 
     * @return  collision
     */
    public static boolean collision(GameObject a, GameObject b)
    {   
        if(!a.getGameObjectNoCollide() && !b.getGameObjectNoCollide())
        {
            return a.getGameObjectBounds().intersects(b.getGameObjectBounds());
        }
        return false;
    };
    
    /**
     * Method to set a boolean indicating whether a GameObject should not collide with other GameObjects
     * 
     * @param   noCollide
     */
    public void setGameObjectNoCollide(boolean noCollide);
    
    /**
     * Method to return true if a GameObject should be not be able to collide with other game objects
     * 
     * @return  noCollide
     */
    public boolean getGameObjectNoCollide();
}
