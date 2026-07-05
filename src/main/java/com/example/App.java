package com.example;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            AlgorithmVisualizer visualizer = new AlgorithmVisualizer();
            visualizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            visualizer.setVisible(true);
        });
    }
}
