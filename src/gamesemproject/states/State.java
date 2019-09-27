
package gamesemproject.states;

import gamesemproject.Handler;
import java.awt.Graphics;

public abstract class State {
    /*
    a blueprint for the states of the game (game, menu,...) & also contains 
    the current state reference. better than having to deal with each state 
    object seperately
    */
    
    private static State currentState = null;
    protected Handler handler;
    
    
    public State(Handler handler){
        this.handler = handler;
    }
    
    
    
    
    public static void setState(State state){
        currentState = state;
    }
    
    public static State getState(){
        return currentState;
    }
    
    
    
    
    public abstract void tick(); //public because it's used from other classes
    public abstract void render(Graphics g);    
}
