
/**
 * Class representing a BonusItemGold MovableGameObject
 * 
 * Adds a set amount to Game.gamePointsScore
 *
 * @author Michael Cummings
 * @version 4.14.23
 */
public class BonusItemGold extends BonusItem
{
    String bonusItemName = "BonusItemGold";
    final int GOLD_POINT_VALUE = 500;
    int bonusItemPointValue;

    /**
     * Constructor for objects of class BonusItemGold
     */
    public BonusItemGold()
    {
        this.setGameObjectName(bonusItemName);
        this.setGameObjectColor(bonusItemColor);
        this.setGameObjectLocation(0, 0);
        this.setGameObjectWidth(bonusItemWidth);
        this.setGameObjectHeight(bonusItemHeight);
        this.setMovableGameObjectSpeed(bonusItemSpeed);
        this.setBonusItemPointValue(GOLD_POINT_VALUE);
        this.setGameObjectNoCollide(false);
    }
    
    /**
     * Constructor for objects of class BonusItemGold
     */
    public BonusItemGold(int x, int y)
    {
        this.setGameObjectName(bonusItemName);
        this.setGameObjectColor(bonusItemColor);
        this.setGameObjectLocation(x, y);
        this.setGameObjectWidth(bonusItemWidth);
        this.setGameObjectHeight(bonusItemHeight);
        this.setMovableGameObjectSpeed(bonusItemSpeed);
        this.setBonusItemPointValue(GOLD_POINT_VALUE);
        this.setGameObjectNoCollide(false);
    }

    /**
     * Method to set a BonusItem's point value to grant to the player when collided with
     *
     * @param  points
     */
    public void setBonusItemPointValue(int points)
    {
        this.bonusItemPointValue = points;
    }
    
    /**
     * Method to get a BonusItem's point value
     * 
     * @return  points
     */
    public int getBonusItemPointValue()
    {
        return this.bonusItemPointValue;
    }
}
