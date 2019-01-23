import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TankSimulatorText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TankSimulatorText extends Actor
{
    //This string variable will represent the message that will be written in the text box
    private String value; 
    
    //This integer variable will represent the font size  of the message that will be written in the text box
    private int fontSize;
    
    //This color variable will represent the foreground color of the text box
    private Color foreground;
    
    //This color variable will represent the background color of the text box
    private Color background;
    
    //This boolean variable will represent whether or not there is a border on the text box
    private boolean border = false;
    
    /**
     * The constructor for the TankSimulatorText class
     * 
     * @param String message represents the message that will be written in the text box
     * @param int size represents the font size  of the message that will be written in the text box
     * @param boolean isBordered represents whether or not there is a border on the text box
     * @param Color fg represents the foreground color of the text box
     * @param Color bg represents the background color of the text box
     */
    public TankSimulatorText(String message, int size, boolean isBordered, Color fg, Color bg)
    {
        value = message;
        
        fontSize = size;
        
        foreground = fg;
        
        background = bg;
        
        border = isBordered;
        
        display();
    }
    
    /**
     * display creates the textbox by combining all of the previously 
     * mentioned varibles within a rectangle
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void display()
    {
        setImage( new GreenfootImage( value, fontSize, foreground, background ) );
        if (border == true)
        {
            getImage().setColor( Color.BLACK );
            getImage().drawRect( 0, 0, getImage().getWidth()-1, getImage().getHeight()-1);
        }
    }
    
    /**
     * setText updates the text of the text box
     * 
     * @param String message which represents the message in the text box
     * @return Nothing is returned
     */
    public void setText(String message)
    {
       value = message;
       display();
    }
    
}
