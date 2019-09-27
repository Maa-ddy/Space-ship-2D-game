
package gamesemproject.entities.staticEntities;

import gamesemproject.Handler;
import gamesemproject.entities.creatures.Player;
import gamesemproject.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;

public class BonusBase extends StaticEntity {
    

    public BonusBase(Handler handler, float x, float y) {
        super(handler, x, y, 64, 64);
        collisionBox.width = 45;
        collisionBox.height = 48;
    }

    
    
    @Override
    public void tick() {
        updateCollisionBox();
        hurt(0); //hurt is used to detect collision for this special type of entity
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bonusBase, (int)(x-handler.getCamera().getXOffset()), (int)(y-handler.getCamera().getYOffset()), null);
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
        Player player = handler.getWorld().getEntityManager().getPlayer();
        if (player.getCollisionBox().intersects(this.collisionBox)){
            player.addBonus(50);
            die();
        }
    }
    
    @Override
    protected void updateCollisionBox(){
            collisionBox.width = 1;
            collisionBox.height = 1;
            collisionBox.x = (int)(x-handler.getCamera().getXOffset()) +32;
            collisionBox.y = (int)(y-handler.getCamera().getYOffset()) +32;

    }
    
    
}
