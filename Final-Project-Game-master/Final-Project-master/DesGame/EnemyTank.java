import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyTank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyTank extends Actor
{
    //This integer varible represents the ammount of shots it takes to eliminate the enemy tank
    protected int health = 5;
    
    //This integer variable represents the ammount of time it takes to reload
    protected int enemyReloadTime;
    
    //This boolean variable represents if the enemy tank should be reloading or not
    protected boolean enemyReloading = false;
    /**
     * Act - do whatever the EnemyTank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkInteraction();
        checkDeath();
        if (enemyReloading == true)
        {
            enemyReloadTime --;
        }
        if (enemyReloadTime <= 0)
        {
            enemyReloading = false;
        }
    }  
    
    /**
     * checkInteraction checks to see what the enemy tank is interacting with
     * and tells it what to do based off of that information. It also makes
     * the enemy tank turn towards the player's tank
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    protected void checkInteraction()
    {
        TankWorld world = (TankWorld)getWorld();
        Tanky tankSelect = world.getTankArray();
        
        if (getWorld() != null)
        {
            turnTowards(tankSelect.getPlayerTankX(),tankSelect.getPlayerTankY() );
            if (enemyReloading == false)
            {
                shoot();
                enemyReloading = true;
            }
        }
        
        if ( isTouching( Wall.class ))
        {
            turn(1);
        }
        if ( isAtEdge() )
        {
            move(1);
            turn(1);
        }
        if ( isTouching( Bullet.class ))
        {
            health --;
            removeTouching(Bullet.class);
        }
        
    }
    
    /**
     * checkDeath checks to see if the enemy tank's health reached zero
     * and displays an exploding image before being removing the enemy tank
     * from the world
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    protected void checkDeath()
    {
        if ( health == 0 )
        {
            setImage("bang.png");
            GreenfootImage bang = getImage();
            bang.scale(50,50);
            setImage(bang);
            Greenfoot.delay(15);
            getWorld().removeObject(this);
        }
    }
    
    /**
     * shoot adds an enemyBullet that will shoot out away from where the
     * enemy tank is facing. shoot also sets the enemy reload time back up
     * to full after a shot is taken
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    protected void shoot()
    {
        EnemyBullet toAdd = new EnemyBullet();
        
        toAdd.setRotation( getRotation() );
        
        getWorld().addObject(toAdd, getX(), getY());
        
        enemyReloadTime = 200;
    }
}
