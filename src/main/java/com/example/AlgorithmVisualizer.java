package com.example;

import java.awt.Toolkit;
import javax.swing.JFrame;

public class AlgorithmVisualizer extends JFrame {
    public void drawScreen(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width; 
        
        this.setSize(screenWidth, screenHeight);


    }
}
