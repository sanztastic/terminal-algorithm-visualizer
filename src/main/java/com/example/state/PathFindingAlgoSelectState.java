package com.example.state;

import java.util.Scanner;
import com.example.AlgorithmVisualizer;

public class PathFindingAlgoSelectState implements UIState {

    private AlgorithmVisualizer algorithmVisualizer;

    public PathFindingAlgoSelectState(AlgorithmVisualizer algorithmVisualizer) {
        this.algorithmVisualizer = algorithmVisualizer;
    }

    @Override
    public int printScreen() {
        System.out.println("Select which path finding algorithm to visualize: ");
        System.out.println("1. Dijkstra's Algorithm");
        System.out.println("2. A* Algorithm");
        System.out.println("3. Breadth-First Search (BFS)");
        System.out.println("4. Depth-First Search (DFS)");
        System.out.print("\nSelect the path finding algorithm to visualize: ");
        Scanner scanner2 = new Scanner(System.in);
        int choice = scanner2.nextInt();
        return choice;
    }

    @Override
    public void handleInput(int input) {
        // TODO Auto-generated method stub
        
    }

}
