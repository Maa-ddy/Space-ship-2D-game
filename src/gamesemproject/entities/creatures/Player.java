
package gamesemproject.entities.creatures;

import gamesemproject.Handler;
import gamesemproject.entities.Entity;
import gamesemproject.gfx.Assets;
import gamesemproject.states.State;
import gamesemproject.tiles.Tile;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Player extends Creature {

    private int direction; //0, 1, 2, 3 for up,right,down,left resp.
    private int score;
    
    
    public Player(Handler handler, float x, float y){
        // we create a player in EntityManager
        super(handler,x,y,DEFAULT_CREATURE_WIDTH,DEFAULT_CREATURE_HEIGHT);
        health = 300;
        score = 0;
        direction = 0; //looking up by default
    }
    
    
    
    @Override
    public void tick(){
        gi();
        move();
        handler.getCamera().centerOnEntity(this);
        avoidCollision();
        System.out.println("score = " + score);
        System.out.println("health = " + health);
     //   System.out.println("x = "+x);
       // System.out.println("y = "+y);
    }
    
    private void gi(){ //get Input
        handler.getKeyManager().tick();
        xMove = yMove = 0;
        if (handler.getKeyManager().up){
            yMove = -speed;
            direction = 0;
        }
        if (handler.getKeyManager().down){
            yMove = speed;
            direction = 2;
        }
        if (handler.getKeyManager().left){
            xMove = -speed;
            direction = 3;
        }
        if (handler.getKeyManager().right){
            xMove = speed;
            direction = 1;
        }
        
        if (handler.getKeyManager().strike){
            strike();
        }
    }
    
    private void strike(){
        int xError = 0,yError = 0;
        switch (direction){
            case 0: xError = 13; break;
            case 1: xError = 32; yError = 13; break;
            case 2: xError = 13; yError = 32; break;
            case 3: yError = 13; break;
            
        }
        handler.getWorld().getEntityManager().addDynamicEntity(new Missile(handler,x+xError,y+yError,direction,Color.red,10));
    }
    
    public void addBonus(int amount){
        score += amount;
    }
    
    private void avoidCollision(){
        updateCollisionBox();
       
        Entity temp = collidesWithStatic();
        
        if (temp != null || collidesWithTile()){
            //add some logic here for bonus entities
            switch (direction){
                case 0: y += speed; break;
                case 1: x -= speed; break;
                case 2: y -= speed; break;
                case 3: x += speed; break;
            }
        }
    }
    
    private boolean collidesWithTile(){
      
        float tx = x,ty = y;
        
        switch (direction){
            case 0: ty -= 8;break;
            case 1: tx += 8;break;
            case 2: ty += 8;break;
            case 3: tx -= 8;break;
        }
        
        return handler.getWorld().getTile(Math.round(ty/Tile.DEFAULT_TILE_WIDTH),Math.round(tx/Tile.DEFAULT_TILE_WIDTH)).isSolid();
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(Assets.player[direction], (int) (x - handler.getCamera().getXOffset()), (int) (y - handler.getCamera().getYOffset()),creatureWidth, creatureHeight,null);
        
       
    }
    

    @Override
    protected void die() {
        
    }

    @Override
    public void hurt(int amount) {
        health -= amount;
       
    }
    
    //getters & setters:
    public int getScore(){ return score; }
    public Rectangle getCollisionBox(){ return this.collisionBox; }
    
}
