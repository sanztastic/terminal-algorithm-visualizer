package com.example.state;

import java.util.Scanner;
import com.example.AlgorithmVisualizer;
import com.example.algorithms.PathFindingAlgorithm;
import com.example.algorithms.path.AStarAlgorithm;
import com.example.algorithms.path.BFSAlgorithm;
import com.example.algorithms.path.DFSAlgorithm;
import com.example.algorithms.path.DijkstraAlgorithm;
import com.example.algorithms.path.GreedyBFSAlgorithm;
import com.example.constants.ANSIEscape;

public class PathFindingAlgoSelectState implements UIState {

    private AlgorithmVisualizer algorithmVisualizer;

    public PathFindingAlgoSelectState(AlgorithmVisualizer algorithmVisualizer) {
        this.algorithmVisualizer = algorithmVisualizer;
    }

    @Override
    public String printScreen(Scanner scanner) {
        System.out.println("Select which path finding algorithm to visualize: ");
        System.out.println("1. Dijkstra's Algorithm");
        System.out.println("2. A* Algorithm");
        System.out.println("3. Greedy Best-First Search");
        System.out.println("4. Breadth-First Search (BFS)");
        System.out.println("5. Depth-First Search (DFS)");
        System.out.println("6. Return to Main Menu");
        System.out.print("\nSelect the path finding algorithm to visualize: ");
        String choice = scanner.nextLine();
        return choice;
    }

    @Override
    public void handleInput(String input) {
        PathFindingAlgorithm algorithm = null; 

        switch (input) {
            case "1" -> algorithm = new DijkstraAlgorithm();
            case "2" -> algorithm = new AStarAlgorithm();
            case "3" -> algorithm = new GreedyBFSAlgorithm();
            case "4" -> algorithm = new BFSAlgorithm();
            case "5" -> algorithm = new DFSAlgorithm();
            case "6" -> {
                System.out.print(ANSIEscape.CLEAR_AND_HOME);
                algorithmVisualizer.setState(new AlgorithmTypeSelectionState(algorithmVisualizer));
                algorithmVisualizer.start();
                return;
            }
            default -> {
                System.out.print(ANSIEscape.CLEAR_AND_HOME);
                System.out.println("Invalid input. Please try again.");
                algorithmVisualizer.start();
                return;
            }
        }

        System.out.print(ANSIEscape.CLEAR_AND_HOME);
        algorithmVisualizer.setState(new MazeAlgoSelectState(algorithmVisualizer, algorithm));
        algorithmVisualizer.start();
    }

}
