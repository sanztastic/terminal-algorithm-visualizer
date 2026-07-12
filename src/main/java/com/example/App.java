package com.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            AlgorithmVisualizer visualizer = new AlgorithmVisualizer(scanner);
            visualizer.start();
        }
    }
}
