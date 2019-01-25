import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(5);
        checkEdgeHit();
        
    } 
    /**
     * checkHitOrMiss checks to see if the bullet hit the edge of the world
     * and removes it from the world when it does
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    protected void checkEdgeHit()
    {
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
