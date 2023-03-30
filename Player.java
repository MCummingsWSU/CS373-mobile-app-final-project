import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A class representing the character the player controls in the game
 *
 * @author Michael Cummings
 * @version 3.30.23
 */
public class Player extends MovableGameObject
{   
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        this.setGameObjectName("Player");
        this.setGameObjectColor(Color.BLACK);
        this.setGameObjectWidth(16);
        this.setGameObjectHeight(16);
        this.setGameObjectLocation(Game.gameWidth / 2, Game.gameHeight - 16);
        this.setMovableGameObjectSpeed(4);
    }
}
