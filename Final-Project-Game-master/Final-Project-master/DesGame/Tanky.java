import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tanky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tanky extends Actor
{
    //This integer represents the speed at which the tank moves and turns
    private int tankSpeed = 2;
    
    //This integer represents the amount of time it takes for the player's tank to reload
    protected int reloadTime;
    
    //This boolean represents whether the tank is reloading or not
    protected boolean reloading = false;
    
    //This double represents the amount of health the player's tank currently has
    private double health = 8;
    
    //This integer represents the maximum amount of health the player's tank can have
    private int maxHealth = 8;
    /**
     * Act - do whatever the Tanky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeysPressed();
        selfDammage();
        if (reloading == true)
        {
            reloadTime --;
        }
        if (reloadTime <= 0)
        {
            reloading = false;
        }
    }
    
    /**
     * This is the constructor for the Tanky class (the code inside just
     * scales the image representing Tanky to be smaller)
     * 
     * @param None There are no parameters
     * @return Noting is returned
     */
    public Tanky()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 15, image.getHeight() - 15);
        setImage(image);
        
    }
    
    /**
     * shoot adds a bullet that will shoot out away from where the
     * player's tank is facing. shoot also sets the reload time back up
     * to full after a shot is taken
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    protected void shoot()
    {
        Bullet toAdd = new Bullet();
        
        toAdd.setRotation( getRotation() );
        
        getWorld().addObject(toAdd, getX(), getY());
        
        reloadTime = 30;
    }
    
    /**
     * selfDammage takes health away from the player tank when shot and removes
     * it from the world when it's health is below zero
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    protected void selfDammage()
    {
        TankWorld world = (TankWorld)getWorld();
        int lvl = world.getLevel();
        if ( isTouching( EnemyBullet.class ))
        {
            health --;
            removeTouching(EnemyBullet.class);
        }
        
        
        if ( health <= 0 )
        {
            setImage("bang.png");
            GreenfootImage image2 = getImage();
            image2.scale(50,50);
            setImage(image2);
            Greenfoot.delay(15);
            setImage("RIP_grave_T.png");
            GreenfootImage image3 = getImage();
            image3.scale(50,50);
            setImage(image3);
            Greenfoot.playSound("no.mp3");
            
            Greenfoot.stop();
        }
    }
    
    /**
     * checkKeysPressed allows the player tank to move and shoot when curtain
     * keys are pressed
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    protected void checkKeysPressed()
    {
        
        if (Greenfoot.isKeyDown("UP"))
        {
            if (canMoveForward() )
            {
                move(tankSpeed);
            }
        }
        else if (Greenfoot.isKeyDown("DOWN"))
        {
            if ( canMoveBackward() )
            {
                move(-tankSpeed);
            }
        }
        if(Greenfoot.isKeyDown("LEFT"))
        {
            if(true == true)
            {
                turn(-tankSpeed);
            }
        }
        else if(Greenfoot.isKeyDown("RIGHT"))
        {
            if(true == true)
            {
                turn(tankSpeed);
            }
        }
        if (Greenfoot.isKeyDown("SPACE") && reloading == false)
        {
            shoot();
            reloading = true;
            
        }
        
    }
    
    /**
     * canMoveForward checks to see if the player tank can move forward
     * 
     * @param None There are no parameters
     * @return boolean movable (which represents) whether or not the player 
     * tank is blocked by a wall
     */
    private boolean canMoveForward()
    {
        boolean movable = true;
        int deltaX = (int)( (getImage().getWidth()/2+tankSpeed) * Math.cos( Math.toRadians( getRotation() ) ) );
        int deltaY = (int)( (getImage().getWidth()/2+tankSpeed) * Math.sin( Math.toRadians( getRotation() ) ) );
        
        if ( getOneObjectAtOffset(deltaX, deltaY, Wall.class)!= null)
        {
            movable = false;
        }
        return movable;
    }
    
    /**
     * canMoveBackward checks to see if the player tank can move forward
     * 
     * @param None There are no parameters
     * @return boolean movable (which represents) whether or not the player 
     * tank is blocked by a wall
     */
    private boolean canMoveBackward()
    {
        boolean movable = true;
        int deltaX = (int)( (getImage().getWidth()/2+tankSpeed) * Math.cos( Math.toRadians( getRotation() ) ) );
        int deltaY = (int)( (getImage().getWidth()/2+tankSpeed) * Math.sin( Math.toRadians( getRotation() ) ) );
        
        if ( getOneObjectAtOffset(-deltaX, -deltaY, Wall.class)!= null)
        {
            movable = false;
        }
        return movable;
    }
    
    /**
     * resetHealth resets the player tank's health to the maximum amount of
     * health whenever the player finishes a level
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public void resetHealth()
    {
        health = maxHealth;
    }
    
    /**
     * getPlayerTankX gets the x position of the player's tank
     */
    public int getPlayerTankX()
    {
        return getX();
    }
    
    /**
     * getPlayerTankY gets the y position of the player's tank
     */
    public int getPlayerTankY()
    {
        return getY();
    }
}
