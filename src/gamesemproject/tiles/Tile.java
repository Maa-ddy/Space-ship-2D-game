
package gamesemproject.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Tile {
    
    public static final int DEFAULT_TILE_WIDTH = 32,
                            DEFAULT_TILE_HEIGHT = 32;
    public static Tile[] tiles = new Tile[256];
    private static Tile blank = new Blank(0);
    private static Tile terrain = new Terrain(1);
    private static Tile rock1 = new RockTile1(2);
    private static Tile rock2 = new RockTile2(3);
    private static Tile rock3 = new RockTile3(4);
    
    
    protected BufferedImage texture;
    protected final int  id;
    
    public Tile(BufferedImage texture,int id){
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g,int x , int y){
        g.drawImage(texture, x, y, null);
    }
    
    
    public boolean isSolid(){
        return false;
    }
    
    
    
}
