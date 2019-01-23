import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HardEnemyTank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HardEnemyTank extends EnemyTank
{
    /**
     * Act - do whatever the HardEnemyTank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkInteraction();
        checkDeath();
        if (enemyReloading == true)
        {
            enemyReloadTime -= 2;
        }
        if (enemyReloadTime <= 0)
        {
            enemyReloading = false;
        }
    }  
    
    /**
     * The constructor for the HardEnemyTankClass (it changes the enemy tank
     * image to the hard enemy tank image and scales it down)
     */
    public HardEnemyTank()
    {
        setImage("HardEnemyTank.png");
        GreenfootImage hardTankImg = getImage();
        hardTankImg.scale(70,70);
        setImage(hardTankImg);
    }
}
