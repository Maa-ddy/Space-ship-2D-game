
package gamesemproject.gfx;

import gamesemproject.Handler;
import gamesemproject.entities.Entity;


public class Camera {
    
    private Handler handler;
    private float xOffset,yOffset;
    
    public Camera(Handler handler, float xOffset, float yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    private void move(int dx, int dy){
        xOffset += dx;
        yOffset += dy;
    }
    
    public void centerOnEntity(Entity e){
        int mapWidth, mapHeight, windowWidth, windowHeight;
        mapWidth = handler.getWorld().getMapWidth();
        mapHeight = handler.getWorld().getMapHeight();
        windowWidth = handler.getWindowWidth();
        windowHeight = handler.getWindowHeight();
        xOffset = Math.min(Math.max(e.getX() - windowWidth/2,0),mapWidth*32 - windowWidth);
        yOffset = Math.min(Math.max(e.getY() - windowHeight/2,0),mapHeight*32 - windowHeight);
    }
    
    public float getXOffset(){ return xOffset; }
    public float getYOffset(){ return yOffset; }
    
}
