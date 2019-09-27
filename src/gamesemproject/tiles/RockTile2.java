
package gamesemproject.tiles;

import gamesemproject.gfx.Assets;


public class RockTile2 extends Tile {
    
    public RockTile2(int id) {
        super(Assets.rock2, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
