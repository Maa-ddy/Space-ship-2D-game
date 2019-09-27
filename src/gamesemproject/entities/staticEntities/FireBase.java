
package gamesemproject.entities.staticEntities;

import gamesemproject.Handler;
import gamesemproject.entities.creatures.Missile;
import gamesemproject.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;

public class FireBase extends StaticEntity {

    private final int FIRE_FREQUENCY = 50;
    private int fireCount;
    
    public FireBase(Handler handler, float x, float y) {
        super(handler, x, y, 64, 64);
        fireCount = 0;
        collisionBox.width = 45;
        collisionBox.height = 48;
    }
    @Override
    public void tick() {
        updateCollisionBox();
        fire();
    }
    
    private void fire(){
        fireCount++;
        if (fireCount%FIRE_FREQUENCY <= 6){
            handler.getWorld().getEntityManager().addDynamicEntity(new Missile(handler, x+30, y, 0, Color.green,8));
            handler.getWorld().getEntityManager().addDynamicEntity(new Missile(handler, x+56, y+30, 1, Color.green,8));
            handler.getWorld().getEntityManager().addDynamicEntity(new Missile(handler, x+30, y+56, 2, Color.green,8));
            handler.getWorld().getEntityManager().addDynamicEntity(new Missile(handler, x, y+30, 3, Color.green,8));
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.fireBase, (int)(x-handler.getCamera().getXOffset()), (int)(y-handler.getCamera().getYOffset()), null);
        /*
        g.setColor(Color.green);
        g.drawRect((int)(x-handler.getCamera().getXOffset())+10, (int)(y-handler.getCamera().getYOffset())+8, 45, 48);
        */
    }

    @Override
    protected void die() {
        this.active = false;
    }

    @Override
    public void hurt(int amount) {
        this.health -= amount;
        if (health<=0){ // if it dies, the player killed it
            handler.getWorld().getEntityManager().getPlayer().addBonus(100);
            die();
        }
    }
    
    @Override
    protected void updateCollisionBox(){
            collisionBox.x = (int)(x-handler.getCamera().getXOffset()) +10;
            collisionBox.y = (int)(y-handler.getCamera().getYOffset()) +8;
    }

    
}
