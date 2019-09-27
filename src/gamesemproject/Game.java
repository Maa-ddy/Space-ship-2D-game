
package gamesemproject;

import gamesemproject.display.Display;
import gamesemproject.gfx.Assets;
import gamesemproject.gfx.Camera;
import gamesemproject.input.KeyManager;
import gamesemproject.input.MouseManager;
import gamesemproject.states.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;


public class Game implements Runnable { 
    private Display display; // we should access the display object to control displaying game objects
    private String windowTitle;
    private int windowWidth, windowHeight;
    
    private Thread thread;
    private boolean running = false; // indicates weather the game is running or not
    
    private BufferStrategy bs;
    private Graphics g;
    private MouseManager mouseManager;
    //states :
    public State gameState,menuState;
    
    //input :
    private KeyManager keyManager;
    
    //Handler:
    private Handler handler;
    
    //camera
    private Camera camera;
    
    public Game(String title,int width, int height){
        windowTitle = title;
        windowWidth = width;
        windowHeight = height;
        keyManager = new KeyManager(); // i have no idea why this isn't in init()
        mouseManager=new MouseManager();
    }
    

    
    
    public void init(){ // initialize everything for the game including graphics, states...
        //init() is called inside the run()
        display = new Display(windowTitle,windowWidth,windowHeight); //here the window is created
        display.getCanvas().createBufferStrategy(3); // create a bs for the display object
        bs = display.getCanvas().getBufferStrategy(); // get the bs of the display object
      
        display.getFrame().addKeyListener(keyManager); //this is for the FRAME to capture user input
       display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();//initialises assets including sprite sheets and sounds
        
        handler = new Handler(this);
        camera = new Camera(handler,0,0);
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(menuState);
    }
    
    public void tick(){
        keyManager.tick();//update the keys pressed or released before everything!
        if (State.getState() != null){
            State.getState().tick();
        }

    }
    
    public void render(){

        //this MUST be here
        g = bs.getDrawGraphics();// create a graphics object from the bs.
        g.clearRect(0,0,windowWidth,windowHeight);//clear the whole screen before starting the render cycle
        
        if (State.getState() != null){
            State.getState().render(g);
        }
        
        //_____________________
        
        bs.show(); // let the buffer do the magic !
        g.dispose(); //??
    }
    
    public void run(){
        init(); // initialized everything before starting. init() should be called here so nothing is initialized or loaded until we run the game
        int fps = 60;
        long t1,t2;
        double timePerFrame = 1000000000/fps;
        t1 = System.nanoTime();
        double delta = 0;
        
        // game loop:
        while (running){
            t2 = System.nanoTime();
            delta += (t2-t1)/timePerFrame; //accumulate until reaching a one frame duration
            t1 =t2;
            if (delta>=1){
                tick();//update game variables and objects
                render();//render depending on the updates made by tick()
                delta--;//prepare for the new frame duration
            }
        }
        
        stop(); // just in case
         
    }
    
    
    
    
    //getters & setters
    //___________________________________________________________________________________________
    public KeyManager getKeyManager(){ return keyManager; }
     public MouseManager getMouseManager() {
        return mouseManager;
    }
    public Camera getCamera(){ return camera; }
    
    public int getWidth(){ return windowWidth; }
    public int getHeight(){ return windowHeight; }
    
    
    //this is for the thread to work. i do not have an extended knowledge about this part of code.
    //_____________________________________________________________________________________________
    public synchronized void start(){ //should be synchronized to control the thread 
        if (!running){
            running = true; //the game is currently running
            thread = new Thread(this); // create a  thread of this class
            thread.start(); // this will call the run() method of this class
        }
    }
    
    public synchronized void stop(){
        if (running){
            running = false; // the game has just stopped here
            try { //auto surrounded by the IDE
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //_____________________________________________________________________________________________
}
