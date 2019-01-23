import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OGTank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OGTank extends Tanky
{
    /**
     * Act - do whatever the OGTank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeysPressed();
        selfDammage();
        if (reloading == true)
        {
            reloadTime -= 2;
        }
        if (reloadTime <= 0)
        {
            reloading = false;
        }
    }    
}
