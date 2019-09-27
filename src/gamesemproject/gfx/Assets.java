
package gamesemproject.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    
    //for quick modifications
    //__________________________________________________________________________
    private static String sheetPath = "/assets/textures/sheet1.png"; //the path for the spritesheet
    public static final int terrainWidth = 96; //to crop assets out of the sheet
    public static final int terrainHeight = 96;
    private static final int tileWidth = 32, tileHeight = 32;
    //__________________________________________________________________________
    
    //assets
    //static variables, Assets class will be loaded at the beginning of the game 
    // accessing assets will be through this class, (not an instance of it)
    public static BufferedImage blank,terrain,rock1,rock2,rock3,base,fireBase,bonusBase; //list of graphic assets
    public static BufferedImage[] player;
      public static BufferedImage[] btn_start;
      public static BufferedImage image;
    
    public static void init(){ // initialize all assets for the game
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(sheetPath)); //sheet is a local variable for the current method
        blank = sheet.crop(0, 0, 1, 1); //a blank image
        loadPlayer("/assets/textures/playerA/", "a");
        terrain = sheet.crop(0, 32, terrainWidth, terrainHeight);
         btn_start =  new BufferedImage[2];
        btn_start[0] = ImageLoader.loadImage("/assets/textures/start11.png");
        btn_start[1] = ImageLoader.loadImage("/assets/textures/start12.PNG");
        image=ImageLoader.loadImage("/assets/textures/sheet1.png");
        rock1 = sheet.crop(0, 0, tileWidth, tileHeight);
        rock2 = sheet.crop(32, 0, tileWidth, tileHeight);
        rock3 = sheet.crop(64, 0, tileWidth, tileHeight);
        base = sheet.crop(96, 128, 64, 64);
        fireBase = sheet.crop(96, 64, 64, 64);
        bonusBase = sheet.crop(96, 0, 64, 64);
    }
    
    private static void loadPlayer(String dir,String name){
        player = new BufferedImage[4];
        player[0] = ImageLoader.loadImage(dir+name+"Up.png");
        player[1] = ImageLoader.loadImage(dir+name+"Right.png");
        player[2] = ImageLoader.loadImage(dir+name+"Down.png");
        player[3] = ImageLoader.loadImage(dir+name+"Left.png");
    }
    
}
