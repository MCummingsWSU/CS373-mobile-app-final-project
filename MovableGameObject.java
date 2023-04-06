import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * A parent class for entities within a video game (player and non-player characters, collectable items, barriers, etc.)
 *
 * @author Michael Cummings
 * @version 3.29.2023
 */
public class MovableGameObject implements GameObject
{
    private Point gameObjectLocation = new Point();
    private double gameObjectWidth, gameObjectHeight, gameObjectSpeed;
    private String gameObjectName;
    private Color gameObjectColor;
    
    /**
     * Default constructor for MovableGameObject
     */
    public MovableGameObject()
    {
        this.gameObjectName = "ObjectName";
        this.gameObjectColor = Color.RED;
        this.gameObjectLocation.setLocation(0,0);
        this.gameObjectWidth = 1;
        this.gameObjectHeight = 1;
        this.gameObjectSpeed = 0;
    }

    /**
     * Overloaded constructor for objects of class MovableGameObject
     */
    public MovableGameObject(Color color, int locationX, int locationY, String name, double width, double height, double speed)
    {
        this.gameObjectName = name;
        this.gameObjectColor = color;
        this.gameObjectLocation.setLocation(locationX, locationY);
        this.gameObjectWidth = width;
        this.gameObjectHeight = height;
        this.gameObjectSpeed = speed;
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
     * Method to return a Rectangle with dimensions equal to the coordinate boundaries of the GameObject
     */
    public Rectangle getGameObjectBounds()
    {
        return new Rectangle((int)this.gameObjectLocation.getX(), (int)this.gameObjectLocation.getY(), (int)this.gameObjectWidth, (int)this.gameObjectHeight);
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
