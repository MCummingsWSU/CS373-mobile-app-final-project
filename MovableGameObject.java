import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * A parent class for entities within a video game (player and non-player characters, collectable items, barriers, etc.)
 *
 * @author Michael Cummings
 * @version 3.29.2023
 */
public class MovableGameObject implements GameObject
{
    private Point gameObjectLocation;
    private double gameObjectWidth, gameObjectHeight, gameObjectSpeed;
    private double gameObjectRightXCoordinate = this.gameObjectLocation.getX() + this.gameObjectWidth / 2;
    private double gameObjectLeftXCoordinate = this.gameObjectLocation.getX() - this.gameObjectWidth / 2;
    private double gameObjectTopYCoordinate = this.gameObjectLocation.getY() - this.gameObjectHeight / 2;
    private double gameObjectBottomYCoordinate = this.gameObjectLocation.getY() + this.gameObjectHeight / 2;
    private String gameObjectName;
    private Color gameObjectColor;
    
    /**
     * 
     */
    public MovableGameObject()
    {
        this.gameObjectName = "ObjectName";
        this.gameObjectColor = Color.RED;
        this.gameObjectLocation.setLocation(0,0);
        this.gameObjectWidth = 1;
        this.gameObjectHeight = 1;
        this.gameObjectSpeed = 0;
        this.gameObjectRightXCoordinate = this.gameObjectLocation.getX() + this.gameObjectWidth / 2;
        this.gameObjectLeftXCoordinate = this.gameObjectLocation.getX() - this.gameObjectWidth / 2;
        this.gameObjectTopYCoordinate = this.gameObjectLocation.getY() - this.gameObjectHeight / 2;
        this.gameObjectBottomYCoordinate = this.gameObjectLocation.getY() + this.gameObjectHeight / 2;
    }

    /**
     * Constructor for objects of class MovableGameObject
     */
    public MovableGameObject(Color color, int locationX, int locationY, String name, double width, double height, double speed)
    {
        this.gameObjectName = name;
        this.gameObjectColor = color;
        this.gameObjectLocation.setLocation(locationX, locationY);
        this.gameObjectWidth = width;
        this.gameObjectHeight = height;
        this.gameObjectSpeed = speed;
        this.gameObjectRightXCoordinate = this.gameObjectLocation.getX() + this.gameObjectWidth / 2;
        this.gameObjectLeftXCoordinate = this.gameObjectLocation.getX() - this.gameObjectWidth / 2;
        this.gameObjectTopYCoordinate = this.gameObjectLocation.getY() - this.gameObjectHeight / 2;
        this.gameObjectBottomYCoordinate = this.gameObjectLocation.getY() + this.gameObjectHeight / 2;
    }
    
    /**
     * Method to manually set a GameObject's Color
     * 
     * @param   color
     */
    public void setGameObjectColor(Color color)
    {
        this.gameObjectColor = color;
    }
    
    /**
     * Method to return a GameObject's Color
     * 
     * @return Color
     */
    public Color getGameObjectColor()
    {
        return this.gameObjectColor;
    }
    
    /**
     * Method to manually set a GameObject's Point location
     * 
     * @param   location
     */
    public void setGameObjectLocation(Point location)
    {
        this.gameObjectLocation.setLocation(location);
    }
    
    /**
     * Method to manually set a GameObject's Point location
     * 
     * @param   x,y intended x-coordinate and y-coordinate of the object
     */
    public void setGameObjectLocation(int x, int y)
    {
        this.gameObjectLocation.setLocation(x, y);
    }
    
    /**
     * Method to manually set a GameObject's Point location
     * 
     * @param   x,y intended x-coordinate and y-coordinate of the object
     */
    public void setGameObjectLocation(double x, double y)
    {
        this.gameObjectLocation.setLocation(x, y);
    }
    
    /**
     * Method to return a GameObject's Point location
     * 
     * @return  Point
     */
    public Point getGameObjectLocation()
    {
        return this.gameObjectLocation.getLocation();
    }
    
    /**
     * Method to manually set a GameObject's rightmost X coordinate based on its location and width
     * 
     * @param   location, width
     */
    public void setGameObjectRightXCoordinate(Point location, double width)
    {
        this.gameObjectRightXCoordinate = location.getX() + width / 2;    
    }
    
    /**
     * Method to manually set a GameObject's rightmost X coordinate based on an int representing the x-coordinate of the object's location and the object's width
     * 
     * @param   location, width
     */
    public void setGameObjectRightXCoordinate(int x, double width)
    {
        this.gameObjectRightXCoordinate = x + width / 2;    
    }
    
    /**
     * Method to manually set a GameObject's rightmost X coordinate based on a double representing the x-coordinate of the object's location and the object's width
     * 
     * @param   location, width
     */
    public void setGameObjectRightXCoordinate(double x, double width)
    {
        this.gameObjectRightXCoordinate = x + width / 2;    
    }
    
    /**
     * Method to return a GameObject's rightmost X coordinate
     * 
     * @return  x
     */
    public double getGameObjectRightXCoordinate()
    {
        return this.gameObjectRightXCoordinate;
    }
    
    /**
     * Method to manually set a GameObject's leftmost X coordinate based on a Point representing its location and a double representing the object's width
     * 
     * @param   location, width
     */
    public void setGameObjectLeftXCoordinate(Point location, double width)
    
    {
        this.gameObjectLeftXCoordinate = location.getX() - width / 2;
    }
    
    /**
     * Method to manually set a GameObject's leftmost X coordinate based on an int x representing the x-coordinate of the GameObject's location, and a double representing the object's width
     * 
     * @param   x, width
     */
    public void setGameObjectLeftXCoordinate(int x, double width)
    {
        this.gameObjectLeftXCoordinate = x - width / 2;
    }
    
    /**
     * Method to manually set a GameObject's leftmost X coordinate based on a double x representing the x-coordinate of the GameObject's location, and a double representing the object's width
     * 
     * @param   x, width
     */
    public void setGameObjectLeftXCoordinate(double x, double width)
    {
        this.gameObjectLeftXCoordinate = x - width / 2;
    }
    
    /**
     * Method to return a GameObject's leftmost X coordinate
     * 
     * @return  x
     */
    public double getGameObjectLeftXCoordinate()
    {
        return this.gameObjectLeftXCoordinate;
    }
    
    /**
     * Method to manually set a GameObject's top Y coordinate using a Point location and a double height
     * 
     * @param   location, width
     */
    public void setGameObjectTopYCoordinate(Point location, double height)
    {
        this.gameObjectTopYCoordinate = location.getY() - height / 2;
    }
    
    /**
     * Method to manually set a GameObject's top Y coordinate using an int y and a double height
     * 
     * @param   y, width
     */
    public void setGameObjectTopYCoordinate(int y, double height)
    {
        this.gameObjectTopYCoordinate = y - height / 2;
    }
    
    /**
     * Method to manually set a GameObject's top Y coordinate using a double y and a double height
     * 
     * @param y, width
     */
    public void setGameObjectTopYCoordinate(double y, double height)
    {
        this.gameObjectTopYCoordinate = y - height / 2;
    }
    
    /**
     * Method to return a GameObject's top Y coordinate
     * 
     * @return  y
     */
    public double getGameObjectTopYCoordinate()
    {
        return this.gameObjectTopYCoordinate;
    }
    
    /**
     * Method to manually set a GameObject's bottom Y coordinate using a Point location and a double height
     * 
     * @param location, height
     */
    public void setGameObjectBottomYCoordinate(Point location, double height)
    {
        this.gameObjectBottomYCoordinate = location.getY() + height / 2;
    }
    
    /**
     * Method to manually set a GameObject's bottom Y coordinate using an int y and a double height
     * 
     * @param y, height
     */
    public void setGameObjectBottomYCoordinate(int y, double height)
    {
        this.gameObjectBottomYCoordinate = y + height / 2;
    }
    
    /**
     * Method to manually set a GameObject's bottom Y coordinate using a double y and a double height
     * 
     * @param y, height
     */
    public void setGameObjectBottomYCoordinate(double y, double height)
    {
        this.gameObjectBottomYCoordinate = y + height / 2;
    }
    
    /**
     * Method to get a GameObject's bottom Y coordinate
     * 
     * @return y
     */
    public double getGameObjectBottomYCoordinate()
    {
        return this.gameObjectBottomYCoordinate;
    }
    
    /**
     * Method to manually set a GameObject's name
     * 
     * @param   name
     */
    public void setGameObjectName(String name)
    {
        this.gameObjectName = name;
    }
    
    /**
     * Method to return a GameObject's Name
     * 
     * @return  Name
     */
    public String getGameObjectName()
    {
        return this.gameObjectName;
    }
    
    /**
     * Method to manually set a GameObject's width
     * 
     * @param   width
     */
    public void setGameObjectWidth(double width)
    {
        this.gameObjectWidth = width;
    }
    
    /**
     * Method to return a GameObject's width
     * 
     * @return  width
     */
    public double getGameObjectWidth()
    {
        return this.gameObjectWidth;
    }
    
    /**
     * Method to manually set a GameObject's height
     * 
     * @param   height
     */
    public void setGameObjectHeight(double height)
    {   
        this.gameObjectHeight = height;
    }
    
    /**
     * Method to return a GameObject's height
     * 
     * @return  height
     */
    public double getGameObjectHeight()
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
     * Method to translate a MovableGameObject along the x or y axis
     * 
     * @param dx, dy
     */
    public void translateMovableGameObject(int dx, int dy)
    {
        this.gameObjectLocation.translate(dx, dy);
    }
}
