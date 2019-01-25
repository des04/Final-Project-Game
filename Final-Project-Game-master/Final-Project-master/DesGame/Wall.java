import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkInteraction();
    }
    
    /**
     * checkInteraction removes bullets from the world when they touch the
     * wall class
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void checkInteraction()
    {
        if (isTouching(Bullet.class))
        {
            removeTouching(Bullet.class);
        }
        if (isTouching(EnemyBullet.class))
        {
            removeTouching(EnemyBullet.class);
        }
    }
    
    
}
