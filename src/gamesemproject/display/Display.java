
package gamesemproject.display;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Display {
    private String windowTitle;
    private int windowWidth;
    private int windowHeight;
    private Dimension windowDimension;
    
    private JFrame frame;
    private Canvas canvas;
    public Display(String title,int width, int height){
        windowWidth = width;
        windowHeight = height;
        windowTitle = title;
        windowDimension = new Dimension(windowWidth, windowHeight);
        
        createDisplay(); //creates a window anytime an object of this is created
    }
    
    private void createDisplay(){
        //frame initialisation
        frame = new JFrame(windowTitle);
        
        frame.setSize(windowDimension);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // show the window in the center of screen
        frame.setVisible(true); // by default, frame objects are not visible heheey
        //___________________________
        
        //canvas initialisation
        canvas = new Canvas();
        canvas.setPreferredSize(windowDimension);
        canvas.setMaximumSize(windowDimension);
        canvas.setMinimumSize(windowDimension);
        canvas.setFocusable(false);//this is essential for the keyListener to focus on the frame rather than the canvas
        //_____________________________
        
        
        JPanel panel=new JPanel();
        JLabel label = new JLabel("score");
        Icon image = new ImageIcon( "/path/picture.jpg" );
        panel.add(label, BorderLayout.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER); 
        label.setBounds(150, 300, 200, 30); 
        frame.add(panel);
        frame.pack(); // ??
        frame.add(canvas);
        frame.pack(); // ??
    }
    
    
    //getters & setters:
    //____________________________________________________________________________________
    public void printIm() {
    
    }
    public Canvas getCanvas(){
        return canvas;
    }
    
    public JFrame getFrame(){
        return frame;
    }
    
    //___________________________________________________________________________________
}
