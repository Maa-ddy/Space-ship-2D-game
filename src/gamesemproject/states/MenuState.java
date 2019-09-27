
package gamesemproject.states;

import gamesemproject.Handler;
import gamesemproject.display.Display;
import gamesemproject.gfx.Assets;
import gamesemproject.ui.ClickListenner;
import gamesemproject.ui.UIImageButton;
import gamesemproject.ui.UIManager;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class MenuState extends State {
private UIManager uiManager;
    
    public MenuState(final Handler handler){
        super(handler);
          uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        

        uiManager.addObject(new UIImageButton(10,10,1080,660,Assets.btn_start,new ClickListenner(){

           @Override
           public void onClick() {
               handler.getMouseManager().setUIManager(null);
               State.setState(handler.getGame().gameState);
           }
       }));
    }
    
    
    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
    
    
    
}
