import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


/**
 * A parent class for entities within a video game (player and non-player characters, collectable items, barriers, etc.)
 *
 * @author Michael Cummings
 * @version 3.29.2023
 */
public class MovableGameObject
{
    private Point gameObjectLocation;
    private double gameObjectWidth, gameObjectHeight, gameObjectSpeed;
    private double gameObjectRightXCoordinate = this.gameObjectLocation.getX() + this.gameObjectWidth / 2;
    private double gameObjectLeftXCoordinate = this.gameObjectLocation.getX() - this.gameObjectWidth / 2;
    private double gameObjectTopYCoordinate = this.gameObjectLocation.getY() + this.gameObjectHeight / 2;
    private double gameObjectBottomYCoordinate = this.gameObjectLocation.getY() - this.gameObjectHeight / 2;
    private String gameObjectName;
    private Color gameObjectColor;

    /**
     * Constructor for objects of class MovableGameObject
     */
    public MovableGameObject(Color color, Point location, String name, double width, double height, double speed)
    {
        this.gameObjectName = name;
        this.gameObjectColor = color;
        this.gameObjectLocation = location;
        this.gameObjectWidth = width;
        this.gameObjectHeight = height;
        this.gameObjectSpeed = speed;
        this.gameObjectRightXCoordinate = this.gameObjectLocation.getX() + this.gameObjectWidth / 2;
        this.gameObjectLeftXCoordinate = this.gameObjectLocation.getX() - this.gameObjectWidth / 2;
        this.gameObjectTopYCoordinate = this.gameObjectLocation.getY() + this.gameObjectHeight / 2;
        this.gameObjectBottomYCoordinate = this.gameObjectLocation.getY() - this.gameObjectHeight / 2;
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
     * Method to manually set a MovableGameObject's Point location
     * 
     * @param   x,y intended x-coordinate and y-coordinate of the object
     */
    public void setMovableGameObjectLocationXYCoordinates(double x, double y)
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
     * Method to manually set a MovableGameObject's rightmost X coordinate based on its location and width
     * 
     * @param   location, width
     */
    public void setMovableGameObjectRightXCoordinate(Point location, double width)
    {
        this.gameObjectRightXCoordinate = location.getX() + width / 2;    
    }
    
    /**
     * Method to manually set a MovableGameObject's rightmost X coordinate based on an int representing the x-coordinate of the object's location and the object's width
     * 
     * @param   location, width
     */
    public void setMovableGameObjectRightXCoordinate(int x, double width)
    {
        this.gameObjectRightXCoordinate = x + width / 2;    
    }
    
    /**
     * Method to manually set a MovableGameObject's rightmost X coordinate based on a double representing the x-coordinate of the object's location and the object's width
     * 
     * @param   location, width
     */
    public void setMovableGameObjectRightXCoordinate(double x, double width)
    {
        this.gameObjectRightXCoordinate = x + width / 2;    
    }
    
    /**
     * Method to return a MovableGameObject's rightmost X coordinate
     * 
     * @return  x
     */
    public double getMovableGameObjectRightXCoordinate()
    {
        return this.gameObjectLocation.getX() + this.gameObjectWidth / 2;
    }
    
    /**
     * Method to manually set a MovableGameObject's leftmost X coordinate based on a Point representing its location and a double representing the object's width
     * 
     * @param   location, width
     */
    public void setMovableGameObjectLeftXCoordinate(Point location, double width)
    
    {
        this.gameObjectLeftXCoordinate = location.getX() - width / 2;
    }
    
    /**
     * Method to manually set a MovableGameObject's leftmost X coordinate based on an int x representing the x-coordinate of the MovableGameObject's location, and a double representing the object's width
     * 
     * @param   x, width
     */
    public void setMovableGameObjectLeftXCoordinate(int x, double width)
    {
        this.gameObjectLeftXCoordinate = x - width / 2;
    }
    
    /**
     * Method to manually set a MovableGameObject's leftmost X coordinate based on a double x representing the x-coordinate of the MovableGameObject's location, and a double representing the object's width
     * 
     * @param   x, width
     */
    public void setMovableGameObjectLeftXCoordinate(double x, double width)
    {
        this.gameObjectLeftXCoordinate = x - width / 2;
    }
    
    /**
     * Method to return a MovableGameObject's leftmost X coordinate
     * 
     * @return  x
     */
    public double getMovableGameObjectLeftXCoordinate()
    {
        return this.gameObjectLocation.getX() - this.gameObjectWidth / 2;
    }
    
    /**
     * Method to manually set a MovableGameObject's top Y coordinate using a Point location and a double height
     * 
     * @param   location, width
     */
    public void setMovableGameObjectTopYCoordinate(Point location, double height)
    {
        this.gameObjectTopYCoordinate = location.getY() + height / 2;
    }
    
    /**
     * Method to manually set a MovableGameObject's top Y coordinate using an int y and a double height
     * 
     * @param   y, width
     */
    public void setMovableGameObjectTopYCoordinate(int y, double height)
    {
        this.gameObjectTopYCoordinate = y + height / 2;
    }
    
    /**
     * Method to manually set a MovableGameObject's top Y coordinate using a double y and a double height
     * 
     * @param y, width
     */
    public void setMovableGameObjectTopYCoordinate(double y, double height)
    {
        this.gameObjectTopYCoordinate = y + height / 2;
    }
    
    /**
     * Method to return a MovableGameObject's top Y coordinate
     * 
     * @return  y
     */
    public double getMovableGameObjectTopYCoordinate()
    {
        return this.gameObjectTopYCoordinate;
    }
    
    /**
     * Method to manually set a MovableGameObject's bottom Y coordinate using a Point location and a double height
     * 
     * @param location, height
     */
    public void setMovableGameObjectBottomYCoordinate(Point location, double height)
    {
        this.gameObjectBottomYCoordinate = location.getY() - height / 2;
    }
    
    /**
     * Method to manually set a MovableGameObject's bottom Y coordinate using an int y and a double height
     * 
     * @param y, height
     */
    public void setMovableGameObjectBottomYCoordinate(int y, double height)
    {
        this.gameObjectBottomYCoordinate = y - height / 2;
    }
    
    /**
     * Method to manually set a MovableGameObject's bottom Y coordinate using a double y and a double height
     * 
     * @param y, height
     */
    public void setMovableGameObjectBottomYCoordinate(double y, double height)
    {
        this.gameObjectBottomYCoordinate = y - height / 2;
    }
    
    /**
     * Method to get a MovableGameObject's bottom Y coordinate
     * 
     * @return y
     */
    public double getMovableGameObjectBottomYCoordinate()
    {
        return this.gameObjectBottomYCoordinate;
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
    public void setMovableGameObjectWidth(double width)
    {
        this.gameObjectWidth = width;
    }
    
    /**
     * Method to return a MovableGameObject's width
     * 
     * @return  width
     */
    public double getMovableGameObjectWidth()
    {
        return this.gameObjectWidth;
    }
    
    /**
     * Method to manually set a MovableGameObject's height
     * 
     * @param   height
     */
    public void setMovableGameObjectHeight(double height)
    {   
        this.gameObjectHeight = height;
    }
    
    /**
     * Method to return a MovableGameObject's height
     * 
     * @return  height
     */
    public double getMovableGameObjectHeight()
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
    public double getMovableGameObjectSpeed()
    {
        return this.gameObjectSpeed;
    }

    /**
     * A method to detect whether two MovableGameObjects overlap, using Cartesian coordinates. Two objects on a 2D plane may only overlap if all four conditions are true
     *
     * @param  MovableGameObject a,b    Two MovableGameObjects
     * @return    isColliding   boolean value indicating whether the two objects are touching each other in the game
     */
    public static boolean collision(MovableGameObject a, MovableGameObject b)
    {
        return a.getMovableGameObjectLeftXCoordinate() < b.getMovableGameObjectRightXCoordinate() &&
            a.getMovableGameObjectRightXCoordinate() > b.getMovableGameObjectLeftXCoordinate() &&
            a.getMovableGameObjectTopYCoordinate() > b.getMovableGameObjectBottomYCoordinate() &&
            a.getMovableGameObjectBottomYCoordinate() < b.getMovableGameObjectTopYCoordinate();
    }
}
