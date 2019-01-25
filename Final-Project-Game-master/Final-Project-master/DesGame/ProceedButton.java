import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProceedButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProceedButton extends Actor
{
    /**
     * The constructor for the ProceedButton class (it scales down the image
     * for the proceed button)
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public ProceedButton()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 400, image.getHeight() - 400);
        setImage(image);
    }
}
