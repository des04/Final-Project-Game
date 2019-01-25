import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBullet extends Actor
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
     * checkEdgeHit checks to see if the enemy bullet hit the wall and removes
     * it from the world if it does
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
