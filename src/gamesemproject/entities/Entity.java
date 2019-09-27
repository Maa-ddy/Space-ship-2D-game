
package gamesemproject.entities;

import gamesemproject.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class Entity {
    /*
    entities are going to be manipulated in the EntityManager class
    */
    
    protected int creatureWidth; // sizing of the entity
    protected int creatureHeight;
    protected float x,y; // coordinates for rendering the entity
    protected boolean active;
    protected Handler handler; 
    protected Rectangle collisionBox;
    protected int health;
    
    public Entity(Handler handler,float x,float y,int width, int height){
        this.creatureWidth = width;
        this.creatureHeight = height;
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.active = true;
        collisionBox = new Rectangle((int)x,(int)y,width,height);
    }
    
    protected void updateCollisionBox(){
            collisionBox.x = (int)(x-handler.getCamera().getXOffset());
            collisionBox.y = (int)(y-handler.getCamera().getYOffset());
    }
    
    //abstract methods:
    public abstract void hurt(int amount);
    protected abstract void die();
    public abstract void tick();
    public abstract void render(Graphics g);
    
    //getters & setters
    public float getX(){ return x; }
    public float getY(){ return y; }
    public Rectangle getCollisionBox(){ return collisionBox; }
    
}
