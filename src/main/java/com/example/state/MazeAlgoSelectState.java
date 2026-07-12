package com.example.state;

import java.util.Scanner;
import com.example.algorithms.Algorithm;

public class MazeAlgoSelectState implements UIState {
    private Algorithm pathFindingAlgorithm; 
    
    public MazeAlgoSelectState(Algorithm pathFindingAlgorithm) {
        this.pathFindingAlgorithm = pathFindingAlgorithm;
    }

    @Override
    public String printScreen() {
        System.out.println("Before finding the shortest path please select the algorithm to generate maze:");
        System.out.println("1. Recursive Division");
        System.out.println("2. Randomized DFS (Recursive Backtracker)");
        System.out.println("3. Randomized Prim's Algorithm");
        System.out.println("4. Randomized Kruskal's Algorithm");
        System.out.println("5. Return to Main Menu");
        System.out.print("\nSelect the Maze Generation algorithm to visualize: ");
        Scanner scanner2 = new Scanner(System.in);
        String choice = scanner2.nextLine();
        return choice;
    }

    @Override
    public void handleInput(String input) {
    }
    
}
