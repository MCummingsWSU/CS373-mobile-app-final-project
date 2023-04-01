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
 * @version 4.1.23
 */
public class Obstacle extends MovableGameObject
{
    /**
     * Constructor for objects of class Obstacle
     */
    public Obstacle(int x, int y)
    {
        this.setGameObjectName("Obstacle");
        this.setGameObjectColor(Color.RED);
        this.setGameObjectLocation(x, y);
        this.setGameObjectWidth(16);
        this.setGameObjectHeight(16);
        this.setMovableGameObjectSpeed(2);
    }}
