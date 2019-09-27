
package gamesemproject.states;

import gamesemproject.Handler;
import gamesemproject.worlds.World;
import java.awt.Graphics;

public class GameState extends State {
    World world;
    
    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"res/worlds/test_world.txt");
        handler.setWorld(world);
    }
    
    
    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }
    
}
