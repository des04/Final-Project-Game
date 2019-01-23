import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    //This is an integer variable that will represent the number for the ammount of money the player has
    private int money;
    
    /**
     * The constructor for the Score class (it draws a string in the top left
     * corner of the screen showing the ammount of money the player has)
     */
    public Score()
    {
        money = 0;
        GreenfootImage img = new GreenfootImage(150,30);
        img.drawString("Money: " + money + "$", 30,25);
        setImage(img);
        
    }
    
    /**
     * addToScore adds to the ammount of money the player has by adding to the
     * money variable and updating the string shown in the top left corner
     * of the screen
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public void addToScore()
    {
        money++;
        GreenfootImage img = getImage();
        img.clear();
        img.drawString("Money: " + money + "$", 30, 25);
    }
    
    /**
     * subtractFromScore subtracts from the ammount of money the player has 
     * by subtracting from the money variable and updating the string shown
     * in the top left corner of the screen
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public void subtractFromScore()
    {
        money--;
        GreenfootImage img = getImage();
        img.clear();
        img.drawString("Money: " + money + "$", 30, 25);
    }
    
    /**
     * getMoney gets the ammount of money that the player currently has
     * 
     * @param None There are no parameters
     * @return int money (which represents) the ammount of money the player
     * currently has
     */
    public int getMoney()
    {
        return money;
    }
}
