
package gamesemproject.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sheet;
    
    public SpriteSheet(BufferedImage image){
        sheet = image; //create a sprite sheet using the image passed to the constructor
    }
    
    public BufferedImage crop(int x, int y, int width, int height){
        return sheet.getSubimage(x, y, width, height);
    }
    
}
