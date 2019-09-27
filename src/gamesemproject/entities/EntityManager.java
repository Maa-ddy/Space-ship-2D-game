
package gamesemproject.entities;

import gamesemproject.Handler;
import gamesemproject.entities.creatures.Player;
import java.awt.Graphics;
import java.util.ArrayList;


public class EntityManager {
    private Handler handler;
    private ArrayList<Entity> staticEntities;
    private ArrayList<Entity> dynamicEntities;
    private Player player;
    
    
    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        staticEntities = new ArrayList<>();
        dynamicEntities = new ArrayList<>();
    }
    
    public void addStaticEntity(Entity e){
        staticEntities.add(e);
    }

    public void addDynamicEntity(Entity e){
        dynamicEntities.add(e);
    }
    
    public void tick(){
        int len = staticEntities.size();
        Entity e;
        for (int k = 0; k<len; k++){
            e = staticEntities.get(k);
            e.tick();
            if (!e.active){ staticEntities.remove(e); len--;k--;}
        }
        len = dynamicEntities.size();
        for (int k = 0; k<len; k++){
            e = dynamicEntities.get(k);
            e.tick();
            if (!e.active){ dynamicEntities.remove(e); len--;k--;}
        }
        player.tick();
    }
    
    public void render(Graphics g){
        for (Entity e : staticEntities){
            e.render(g);
        }
        for (Entity e : dynamicEntities){
            e.render(g);
        }
        player.render(g);
    }
    
    
    
    //getters & setters:
    public ArrayList<Entity> getStaticEntities(){ return staticEntities; }
    public Player getPlayer(){ return player; }
    
}
