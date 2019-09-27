
package gamesemproject.entities.staticEntities;

import gamesemproject.Handler;
import gamesemproject.entities.Entity;


public abstract class StaticEntity extends Entity {
    protected static final int DEFAULT_RESISTANCE = 100;
    
    
    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        this.health = DEFAULT_RESISTANCE;
    }
    
}
