
package gamesemproject.tiles;

import gamesemproject.gfx.Assets;


public class RockTile3 extends Tile {
    
    public RockTile3( int id) {
        super(Assets.rock3, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
