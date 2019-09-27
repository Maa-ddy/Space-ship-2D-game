
package gamesemproject;

import gamesemproject.gfx.Camera;
import gamesemproject.input.KeyManager;
import gamesemproject.input.MouseManager;
import gamesemproject.worlds.World;

public class Handler {
    
    private Game game;
    private World world;
    
    public Handler(Game game){
        this.game = game;
    }
    
    public KeyManager getKeyManager(){ return game.getKeyManager(); }
    
    public int getWindowWidth(){ return game.getWidth(); }
    public int getWindowHeight(){ return game.getHeight(); }
    
    public Camera getCamera(){ return game.getCamera(); }
    
    public Game getGame(){ return game; }
    public void setGame(Game game){ this.game = game; }
    
    public World getWorld(){ return world; }
    public void setWorld(World world){ this.world = world; }
    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }
}
