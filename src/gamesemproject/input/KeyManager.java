
package gamesemproject.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up,down,left,right,strike; //must be public because it's going to be used outside from this
    
    public KeyManager(){
        keys = new boolean[256];
    }
    
    public void tick(){
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        strike = keys[KeyEvent.VK_X];
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
        
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    
}
