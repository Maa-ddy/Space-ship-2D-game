
package gamesemproject.entities.creatures;

import gamesemproject.Handler;
import gamesemproject.entities.Entity;
import java.util.ArrayList;


public abstract class Creature extends Entity {
    
    public static final int DEFAULT_CREATURE_WIDTH = 32,
                            DEFAULT_CREATURE_HEIGHT = 32;
    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 5.0f;
    

    protected float speed;
    protected float xMove, yMove;
    
    
    public Creature(Handler handler,float x,float y,int width, int height){
        super(handler,x,y,width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }
    
    protected void move(){
    // in general, this is how a creature moves,     
    //but xMove & yMove will be modified depending on the type of the creature
        x += xMove;
        y += yMove;
    }
    
    protected Entity collidesWithStatic(){
        ArrayList<Entity> temp = handler.getWorld().getEntityManager().getStaticEntities();
        for (Entity e : temp){
            if (e.getCollisionBox().intersects(this.collisionBox)){
                return e;
            }
        }
        Player player = handler.getWorld().getEntityManager().getPlayer();
        if (player.collisionBox.intersects(this.collisionBox) && player != this){
            return player;
        }
        return null;
    }
    
    //abstract methods (apart from those coming from the Entity class):
    protected abstract void die();
    
    
    //getters & setters
    public float getSpeed(){ return speed; }
    public void setSpeed(float speed){ this.speed = speed; }
    
    
}
