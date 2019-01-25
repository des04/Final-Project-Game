import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Volume here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Volume extends Actor
{
    //This GreenfootSound variable stores the game's soundtrack
    private GreenfootSound soundtrack = new GreenfootSound("soundtrack.mp3");
    
    //This boolean variable stores whether or not the music is playing
    private boolean musicPlaying = true;
    /**
     * Act - do whatever the Volume wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkClicked();
    }    

    /**
     * This is the constructor for the volume class (it sets the volume on
     * image and scales it. It also automatically plays the soundtrack)
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public Volume()
    {
        setImage("volumeOn.png");
        GreenfootImage volumeOn = getImage();
        volumeOn.scale(70,70);
        setImage(volumeOn);
        soundtrack.playLoop();
    }

    /**
     * checkClicked plays music if the player clicked on the sound icon
     * and the soundtrack wasn't already playing and does the reverse when
     * the soundtrack isn't playing.
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void checkClicked()
    {
        if (Greenfoot.mouseClicked(this))
        {
            if (musicPlaying == true)
            {
                setImage("volumeOn.png");
                GreenfootImage volumeOn = getImage();
                volumeOn.scale(70,70);
                setImage(volumeOn); 
                soundtrack.playLoop();
                musicPlaying = false;
            }
            else if (musicPlaying == false)
            {
                setImage("volumeOff.png");
                GreenfootImage volumeOff = getImage();
                volumeOff.scale(70,70);
                soundtrack.stop();
                musicPlaying = true;
            }
        }
    }
}
