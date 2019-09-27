package gamesemproject.entities.creatures;

import gamesemproject.Handler;
import gamesemproject.entities.Entity;
import gamesemproject.tiles.Tile;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Missile extends Creature { //it's considered a creature because it has the ability to move
    private int direction;
    private int range;
    private int distance;//distance crossed
    private Color color;
    
    public Missile(Handler handler, float x, float y,int direction,Color color,int range) {
        super(handler, x, y, 5, 5);
        this.direction = direction;
        this.speed = 10;
        this.distance = 0;
        this.range = range*Tile.DEFAULT_TILE_HEIGHT; // range of Missile = 5 blocks
        this.color = color;
        /*
        //to make an infinite range missile
        switch (direction){
            case 0:     range = (int)y; break; //the range is the y coordinate of the player 
            case 2:     range = (int)(handler.getWorld().getMapHeight()*Tile.DEFAULT_TILE_HEIGHT - y); break;
            case 3:     range = (int)x; break;
            case 1:     range = (int)(handler.getWorld().getMapWidth()*Tile.DEFAULT_TILE_WIDTH - x); break;
        }
        */
    }

    @Override
    public void tick(){
        if (distance>range){
            die();
            return;
        }
        gi();
        move();
        updateCollisionBox();
        Entity temp = collidesWithStatic(); // we only hurt static entities for now
        if (temp != null){
            temp.hurt(2);
            die(); // the missiles disappears
        }
        distance += speed;        
    }
    
    private void gi(){
        xMove = yMove = 0;
        switch (direction) {
            case 0:
                yMove = -speed;
                break;
            case 2:
                yMove = speed;
                break;
            case 3:
                xMove = -speed;
                break;
            case 1:
                xMove = speed;
                break;
        }
    }
    
    
    

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.drawRect((int)(x-handler.getCamera().getXOffset()), (int)(y-handler.getCamera().getYOffset()), 5, 5);
    }
    
    @Override
    protected void die(){
        //maybe some graphics here?
        this.active = false;
    }

    @Override
    public void hurt(int amount) {
        
    }
    
}
