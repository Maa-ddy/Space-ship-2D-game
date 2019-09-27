
package gamesemproject.entities.staticEntities;

import gamesemproject.Handler;
import gamesemproject.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;

public class Base extends StaticEntity {
    

    public Base(Handler handler, float x, float y) {
        super(handler, x, y, 64, 64);
        collisionBox.width = 45;
        collisionBox.height = 48;
    }

    
    
    @Override
    public void tick() {
        updateCollisionBox();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.base, (int)(x-handler.getCamera().getXOffset()), (int)(y-handler.getCamera().getYOffset()), null);
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
            handler.getWorld().getEntityManager().getPlayer().addBonus(10);
            die();
        }
    }
    
    @Override
    protected void updateCollisionBox(){
            collisionBox.x = (int)(x-handler.getCamera().getXOffset()) +10;
            collisionBox.y = (int)(y-handler.getCamera().getYOffset()) +8;
    }
    
    
}
