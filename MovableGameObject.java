import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


/**
 * A parent class for entities within a video game (player and non-player characters, collectable items, barriers, etc.)
 *
 * @author Michael Cummings
 * @version 3.23.2023
 */
public class MovableGameObject
{
    private Point gameObjectLocation;
    private int gameObjectWidth, gameObjectHeight, gameObjectSpeed;
    private String gameObjectName;
    private Color gameObjectColor;

    /**
     * Constructor for objects of class MovableGameObject
     */
    public MovableGameObject(Color color, Point location, String name, int width, int height, int speed)
    {
        this.gameObjectColor = color;
        this.gameObjectLocation = location;
        this.gameObjectName = name;
        this.gameObjectWidth = width;
        this.gameObjectHeight = height;
        this.gameObjectSpeed = speed;
    }
    
    /**
     * Method to manually set a MovableGameObject's Color
     * 
     * @param   color
     */
    public void setMovableGameObjectColor(Color color)
    {
        this.gameObjectColor = color;
    }
    
    /**
     * Method to return a MovableGameObject's Color
     * 
     * @return Color
     */
    public Color getMovableGameObjectColor()
    {
        return this.gameObjectColor;
    }
    
    /**
     * Method to manually set a MovableGameObject's Point location
     * 
     * @param   location
     */
    public void setMovableGameObjectLocationPoint(Point location)
    {
        this.gameObjectLocation.setLocation(location);
    }
    
    /**
     * Method to manually set a MovableGameObject's Point location
     * 
     * @param   x,y intended x-coordinate and y-coordinate of the object
     */
    public void setMovableGameObjectLocationXYCoordinates(int x, int y)
    {
        this.gameObjectLocation.setLocation(x, y);
    }
    
    /**
     * Method to return a MovableGameObject's Point location
     * 
     * @return  Point
     */
    public Point getMovableGameObjectLocation()
    {
        return this.gameObjectLocation.getLocation();
    }
    
    /**
     * Method to manually set a MovableGameObject's name
     * 
     * @param   name
     */
    public void setMovableGameObjectName(String name)
    {
        this.gameObjectName = name;
    }
    
    /**
     * Method to return a MovableGameObject's Name
     * 
     * @return  Name
     */
    public String getMovableGameObjectName()
    {
        return this.gameObjectName;
    }
    
    /**
     * Method to manually set a MovableGameObject's width
     * 
     * @param   width
     */
    public void setMovableGameObjectWidth(int width)
    {
        this.gameObjectWidth = width;
    }
    
    /**
     * Method to return a MovableGameObject's width
     * 
     * @return  width
     */
    public int getMovableGameObjectWidth()
    {
        return this.gameObjectWidth;
    }
    
    /**
     * Method to manually set a MovableGameObject's height
     * 
     * @param   height
     */
    public void setMovableGameObjectHeight(int height)
    {   
        this.gameObjectHeight = height;
    }
    
    /**
     * Method to return a MovableGameObject's height
     * 
     * @return  height
     */
    public int getMovableGameObjectHeight()
    {
        return this.gameObjectHeight;
    }
    
    /**
     * Method to set a MovableGameObject's speed
     * 
     * @param speed
     */
    public void setMovableGameObjectSpeed(int speed)
    {
        this.gameObjectSpeed = speed;
    }
    
    /**
     * Method to return a MovableGameObject's speed
     * 
     * @return  speed
     */
    public int getMovableGameObjectSpeed()
    {
        return this.gameObjectSpeed;
    }

    /**
     * A method to detect whether two MovableGameObjects occupy the same Point
     *
     * @param  MovableGameObject a,b    Two MovableGameObjects
     * @return    isColliding   boolean value indicating whether the two objects are occupying the same space in the game
     */
    public static boolean collision(MovableGameObject a, MovableGameObject b)
    {
        return a.gameObjectLocation.equals(b.gameObjectLocation);
    }
}
