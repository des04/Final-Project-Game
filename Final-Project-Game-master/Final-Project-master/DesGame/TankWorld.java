import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Name: Desmond Langan
 * Course:Software Development
 * Teacher: Mr Hardman
 * Date: January twenty-third of the year two thousand and nineteen
 */
public class TankWorld extends World
{
    //This Tanky array containes all of the playable tanks
    private Tanky tankSelect[] = {new Tanky(), new OGTank(), new EpicTank()};
    
    //This ProceedButton variable represents the proceedButton
    private ProceedButton proceedButton = new ProceedButton();
    
    //This integer variable represents the level that the player is at
    private int lvl = 0;
    
    //This boolean variable decides whether or not the level needs to be changed
    private boolean lvlMustChange = true;
    
    //These TankSimulatorText variables all represent the big green and blue text at the top of the screen and what it can say
    private TankSimulatorText text = new TankSimulatorText ("TANK SIMULATOR", 44, true, Color.BLUE, Color.GREEN);
    private TankSimulatorText winText = new TankSimulatorText ("YOU WON! THANKS FOR PLAYING!", 44, true, Color.BLUE, Color.GREEN);
    
    //These UpgradeButton variables all represent the upgrade button and the different things it can say
    private UpgradeButton cannotUpgradeButton = new UpgradeButton ("UPGRADE TANK", "Insufficient funds", 18, Color.BLUE, Color.GREEN, Color.BLUE, Color.GREEN);
    private UpgradeButton firstUpgradeButton = new UpgradeButton ("UPGRADE TANK", "Cost: 200$", 18, Color.BLUE, Color.GREEN, Color.BLUE, Color.GREEN);
    private UpgradeButton secondUpgradeButton = new UpgradeButton ("UPGRADE TANK", "Cost: 400$", 18, Color.BLUE, Color.GREEN, Color.BLUE, Color.GREEN);
    private UpgradeButton thirdUpgradeButton = new UpgradeButton ("UPGRADE TANK", "Cost: 600$", 18, Color.BLUE, Color.GREEN, Color.BLUE, Color.GREEN);
    
    //This integer varaible represents the current element that the Tanky array is at
    private int tankUpgradeNum = 0;
    
    //This Score variable represents the score class (and will be helpful with the code in place for the money)
    private Score score;
    
    //This Volume variable represents the volume button on the screen in the menu
    private Volume volume = new Volume();
    /**
     * Constructor for objects of class TankWorld.
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public TankWorld()
    {    
        super(600, 400, 1); 
        score = new Score();
        addObject(score,67,12);
    }

    /**
     * act is the method that is called whenever the 'Act' or 'Run' button 
     * is selected, it repeats itself.
     */
    public void act()
    {
        if( lvlMustChange == true )
        {
            setLevel();
        }
        else
        {
            checkWin();
        }
    }

    /**
     * setLevel sets the level that will be played during the act cycle. The
     * level is set to be a menu whenever the lvl integer is an even number.
     * Whenever the mouse is clicked on the proceed button the lvl integer
     * increeses. The level is set to be a level whenever the lvl integer is
     * uneven.
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void setLevel()
    {
        if (lvl == 0 || lvl == 2 || lvl == 4 || lvl == 6 || lvl == 8 || lvl == 10 || lvl == 12 || lvl == 14 || lvl == 16 || lvl == 18 )
        {
            addMenuObjects();
            if (Greenfoot.mouseClicked(proceedButton))
            {
                lvl ++;
            }
        }
        else if (lvl == 1)
        {
            addLevelOneObjects();
            lvlMustChange = false;
        }
        else if (lvl == 3)
        {
            addLevelTwoObjects();
            lvlMustChange = false;
        }
        else if (lvl == 5)
        {
            addLevelThreeObjects();
            lvlMustChange = false;
        }
        else if (lvl == 7)
        {
            addLevelFourObjects();
            lvlMustChange = false;
        }
        else if (lvl == 9)
        {
            addLevelFiveObjects();
            lvlMustChange = false;
        }
        else if (lvl == 11)
        {
            addLevelSixObjects();
            lvlMustChange = false;
        }
        else if (lvl == 13)
        {
            addLevelSevenObjects();
            lvlMustChange = false;
        }
        else if (lvl == 15)
        {
            addLevelEightObjects();
            lvlMustChange = false;
        }
        else if (lvl == 17)
        {
            addLevelNineObjects();
            lvlMustChange = false;
        }
        else if (lvl == 19)
        {
            addLevelTenObjects();
            lvlMustChange = false;
        }
        else
        {
            removeObjects(getObjects(null));
            addObject(winText,300, 50);
            Greenfoot.stop();
        }
    }

    /**
     * addMenuObjects adds the menu objects to the world and removes the
     * walls from the world.
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addMenuObjects()
    {     
        List walls = getObjects(Wall.class);
        removeObjects(walls);
        addObject(text, 300,50);
        if (score.getMoney() >= 200 && tankUpgradeNum == 0)
        {
            addObject(firstUpgradeButton, getWidth()/2, getHeight()/2);
        }
        else if (score.getMoney() >= 400 && tankUpgradeNum == 1)
        {
            addObject(secondUpgradeButton, getWidth()/2, getHeight()/2);
        }
        else if (score.getMoney() >= 600 && tankUpgradeNum == 2)
        {
            addObject(thirdUpgradeButton, getWidth()/2, getHeight()/2);
        }
        else if (tankUpgradeNum == 3)
        {

        }
        else
        {
            addObject(cannotUpgradeButton, getWidth()/2, getHeight()/2);
        }
        tankSelect[tankUpgradeNum].resetHealth();
        addObject(volume, 100, getHeight()-100);
        addObject(proceedButton, getWidth()-100, getHeight()-100);
    }

    /**
     * removeMenuObjects removes the menu objects from the world
     * 
     * @param None Nothing is returned
     * @param Nothing is returned
     */
    private void removeMenuObjects()
    {
        List tankSimulatorText = getObjects(TankSimulatorText.class);
        removeObjects(tankSimulatorText);

        List proceedButton = getObjects(ProceedButton.class);
        removeObjects(proceedButton);

        List upgradeButton = getObjects(UpgradeButton.class);
        removeObjects(upgradeButton);

        List volume = getObjects(Volume.class);
        removeObjects(volume);
    }

    /**
     * addWalls adds the walls to the world
     * 
     * @There is an integer parameter called wallAmmount that represents the
     * ammount of walls added
     * @return Nothing is returned
     */
    private void addWalls(int wallAmmount)
    {
        for (int i = 0; i < wallAmmount; i++)
        {
            addObject(new Wall(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));

        }

    }

    /**
     * addLevelOneObjects adds the level one objects
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addLevelOneObjects()
    {
        removeMenuObjects();

        addObject( tankSelect[tankUpgradeNum], getWidth()/2, getHeight()/2);
        addObject( new EnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addWalls(4);
        checkWin();
    }

    /**
     * addLevelTwoObjects adds the level two objects to the world
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addLevelTwoObjects()
    {
        removeMenuObjects();

        addObject( tankSelect[tankUpgradeNum], getWidth()/2, getHeight()/2 );
        addObject( new EnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new EnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addWalls(3);
    }

    /**
     * addLevelThreeObjects adds the level three objects to the world
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addLevelThreeObjects()
    {
        removeMenuObjects();

        addObject( tankSelect[tankUpgradeNum], getWidth()/2, getHeight()/2 );
        addObject( new EnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addWalls(4);
    }

    /**
     * addLevelFourObjects adds the level four objects to the world
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addLevelFourObjects()
    {
        removeMenuObjects();

        addObject( tankSelect[tankUpgradeNum], getWidth()/2, getHeight()/2 );
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addWalls(5);
    }

    /**
     * addLevelFiveObjects adds the level five objects to the world
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addLevelFiveObjects()
    {
        removeMenuObjects();

        addObject( tankSelect[tankUpgradeNum], getWidth()/2, getHeight()/2 );
        addObject( new EnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new EnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new EnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addWalls(5);
    }

    /**
     * addLevelSixObjects adds the level six objects to the world
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addLevelSixObjects()
    {
        removeMenuObjects();

        addObject( tankSelect[tankUpgradeNum], getWidth()/2, getHeight()/2 );
        addObject( new EnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new EnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addWalls(5);
    }
    
    /**
     * addLevelSevenObjects adds the level seven objects to the world
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addLevelSevenObjects()
    {
        removeMenuObjects();
        
        addObject( tankSelect[tankUpgradeNum], getWidth()/2, getHeight()/2 );
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addWalls(2);
    }
    
    /**
     * addLevelEightObjects adds the level eight objects to the world
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addLevelEightObjects()
    {
        removeMenuObjects();
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( tankSelect[tankUpgradeNum], getWidth()/2, getHeight()/2 );
        addWalls(1);
    }
    
    /**
     * addLevelNineObjects adds the level nine objects to the world
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addLevelNineObjects()
    {
        removeMenuObjects();
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addWalls(4);
    }
    
    /**
     * addLevelTenObjects adds the level ten objects to the world
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addLevelTenObjects()
    {
        removeMenuObjects();
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addObject( new HardEnemyTank(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        addWalls(2);
    }

    /**
     * checkWin causes the menu to pop up if the player eliminates all of the
     * enemy tanks
     * 
     * @param None There are no parameters 
     * @return Nothing is returned
     */
    private void checkWin()
    {
        if (getObjects(EnemyTank.class).isEmpty())
        {
            lvl++;
            addToScore();
            lvlMustChange = true;
        }
    }

    /**
     * addToScore creates an animation of the player's money increesing
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addToScore()
    {
        for (int i = 0; i <= 99; i++)
        {
            score.addToScore();
            Greenfoot.delay(1);
        }
    }

    /**
     * getScore gets the player's score(money)
     * 
     * @param None There are no parameters
     * @return score.getMoney is returned. score.getMoney() gets the money
     * variable from the score class
     */
    public int getScore()
    {
        return score.getMoney();
    }

    /**
     * spendMoney creates an animation of the player's money decreasing
     * 
     * @param int moneySpent (which represents) the ammount of money that
     * will be decreased
     * @return Nothing is returned
     */
    public void spendMoney(int moneySpent)
    {
        for (int i = 0; i < moneySpent; i ++)
        {
            score.subtractFromScore();
            Greenfoot.delay(1);
        }
    }

    /**
     * addToUpgradeNum adds to the tankUpgradeNum variable (which represents)
     * the upgrade number that the tank is at
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public void addToUpgradeNum()
    {
        removeObject(tankSelect[tankUpgradeNum]);
        tankUpgradeNum++;
    }

    /**
     * getUpgradeNum gets the tankUpgradeNum variable
     * 
     * @param None There are no parameters
     * @return int tankUpgradeNum (which represents) the tank upgrade level
     */
    public int getUpgradeNum()
    {
        return tankUpgradeNum;
    }

    /**
     * getTankArray gets the tank array
     * 
     * @param None There are no parameters
     * @return Tanky tankSelect[] which is an array for all of the playable
     * tanks
     */
    public Tanky getTankArray()
    {
        return tankSelect[tankUpgradeNum];
    }

    /**
     * getLevel gets the current level
     * 
     * @param None There are no parameters
     * @return int lvl which represents the level of the player
     */
    public int getLevel()
    {
        return lvl;
    }
}
