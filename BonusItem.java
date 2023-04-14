import java.awt.Color;
import java.awt.Point;

/**
 * Class representing a MovableGameObject the player is rewarded for colliding with
 * 
 * Could be bonus points, shield, speed boost, etc.
 *
 * @author Michael Cummings
 * @version 4.14.23
 */
public class BonusItem extends MovableGameObject
{
    String bonusItemName = "BonusItem";
    Color bonusItemColor = Color.YELLOW;
    int bonusItemWidth = 4;
    int bonusItemHeight = 4;
    int bonusItemSpeed = 1;

    /**
     * Constructor for objects of class BonusItem
     */
    public BonusItem()
    {
        this.setGameObjectName(bonusItemName);
        this.setGameObjectColor(bonusItemColor);
        this.setGameObjectLocation(0, 0);
        this.setGameObjectWidth(bonusItemWidth);
        this.setGameObjectHeight(bonusItemHeight);
        this.setMovableGameObjectSpeed(bonusItemSpeed);
        this.setGameObjectNoCollide(false);
    }

    /**
     * Overloaded constructor for BonusItem objects
     */
    public BonusItem(int x, int y)
    {
        this.setGameObjectName(bonusItemName);
        this.setGameObjectColor(bonusItemColor);
        this.setGameObjectLocation(x, y);
        this.setGameObjectWidth(bonusItemWidth);
        this.setGameObjectHeight(bonusItemHeight);
        this.setMovableGameObjectSpeed(bonusItemSpeed);
        this.setGameObjectNoCollide(false);
    }
}
