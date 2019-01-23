import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeButton extends Actor
{
    //These TankSimulatorText variables will store information in the constructor
    private TankSimulatorText titleBar;
    private TankSimulatorText menuItems;

    //These color variables store the foreground and background colors of the class
    private Color mainFG;
    private Color mainBG;

    //These color variables store the second foreground and background colors of the class
    private Color secondFG;
    private Color secondBG;

    //These integer variables store the heights of the title and dropdown options
    private int titleHeight;
    private int menuHeight;

    //This integer variable stores the fontsize for text on the upgrade button
    private int fontSize = 24;

    //This boolean variable stores whether or not the drop down menu is visible
    private boolean visible = false;

    

    /**
     * A constructor for objects of class Menu
     * 
     * @param title is the text displayed in the main section of the menu
     * @param items is the text that is displayed in the submenu section of the menu
     * @param size is the text size that will be used to display the text from the menu
     * @param mfg is the main foreground color (or the text color for the main section) of the menu
     * @param mbg is the main background color (or the background color for the main section) of the menu
     * @param sfg is the submenu foreground color (or the text color for the submenu section) of the menu
     * @param sbg is the submenu background color (or the background color for the submenu section) of the menu
     * @param commands stores an object that deals with the functionality of the menu
     * @return An object of type Menu
     */
    public UpgradeButton(String title, String items, int size, Color mfg, Color mbg, Color sfg, Color sbg)
    {
        mainFG = mfg;

        mainBG = mbg;

        secondFG = sfg;

        secondBG = sbg;

        fontSize = size;

        titleBar = new TankSimulatorText( title, fontSize, true, mainFG, mainBG );

        menuItems = new TankSimulatorText( items, fontSize, true, secondFG, secondBG );

    }

    /**
     * addedToWorld is a method that is run when a new object of this class
     * is added to the world
     * 
     * @param w is the reference to the world it is added to
     * @return Nothing is returned
     */
    protected void addedToWorld( World w ) 
    {
        w.addObject(titleBar, getX(), getY());
        titleHeight = titleBar.getImage().getHeight();
        menuHeight = menuItems.getImage().getHeight();

    }

    /**
     * Act - do whatever the Menu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        handleMouse();

    }    

    /**
     * handleMouse allows for the drop down menu (Cost: ___$) to appear 
     * whenever the title for it is clicked (UPGRADE TANK) and makes the
     * drop down menu dissapear when the mouse is clicked elsewhere. It also
     * causes different things to appear depending on the amount of money
     * the player has and what tank the player is currently using.
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void handleMouse()
    {
        MouseInfo mouse;
        int menuIndex;
        if(Greenfoot.mouseClicked(titleBar))
        {
            if(visible == false)
            {
                getWorld().addObject(menuItems, this.getX(), this.getY() + (titleHeight + menuHeight)/2);
            }
            else
            {
                getWorld().removeObject(menuItems);
            }
            visible = !visible;
        }
        if(Greenfoot.mouseClicked(menuItems))
        {
            mouse = Greenfoot.getMouseInfo();
            menuIndex = ((mouse.getY() - menuItems.getY() + menuHeight /2) -1 ) / fontSize;
            visible = false;
            getWorld().removeObject(menuItems);
            TankWorld world = (TankWorld)getWorld();
            int upgradeNum = world.getUpgradeNum();
            int money = world.getScore();

            if (money >= 200 && upgradeNum == 0)
            {
                world.addToUpgradeNum();
                world.spendMoney(200);
            }
            else if (money >= 400 && upgradeNum == 1)
            {
                world.addToUpgradeNum();
                world.spendMoney(400);
            }
        }
    }
}
