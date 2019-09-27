package gamesemproject;

public class Launcher {
    
    public static void main(String[] args) {
        Game g = new Game("Space maze",1100,670);
        g.start();
    }
    
}

/*
planned improvements:
    ***bonus, +life Entities
    ***fatal          //
        - Entities that fires
        -     //  that must be avoided
    ***score on the screen
    ***Entity collision detection
    ***rock Tile  //        //
    ***world, Entities generation (last thing)

further improvements:
    ***make an abstract class of moving cratures (for now, itcontains player, missile)
    ***more than one type of missile

*/
