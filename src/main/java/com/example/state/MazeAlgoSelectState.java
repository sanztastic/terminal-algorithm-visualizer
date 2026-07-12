package com.example.state;

import java.util.Scanner;
import com.example.AlgorithmVisualizer;
import com.example.algorithms.Algorithm;
import com.example.algorithms.PathFindingAlgorithm;
import com.example.algorithms.PathVisualizationAlgorithm;
import com.example.constants.ANSIEscape;
import com.example.facade.AlgorithmRunnerFacade;

public class MazeAlgoSelectState implements UIState {
    private AlgorithmVisualizer algorithmVisualizer;
    private PathFindingAlgorithm pathFindingAlgorithm; 
    
    public MazeAlgoSelectState(AlgorithmVisualizer algorithmVisualizer,
            PathFindingAlgorithm pathFindingAlgorithm) {
        this.algorithmVisualizer = algorithmVisualizer;
        this.pathFindingAlgorithm = pathFindingAlgorithm;
    }

    @Override
    public String printScreen(Scanner scanner) {
        System.out.print(ANSIEscape.CLEAR_AND_HOME);
        System.out.println("Before finding the shortest path please select the algorithm to generate maze:");
        System.out.println("1. Recursive Division");
        System.out.println("2. Randomized DFS (Recursive Backtracker)");
        System.out.println("3. Randomized Prim's Algorithm");
        System.out.println("4. Randomized Kruskal's Algorithm");
        System.out.println("5. Return to Main Menu");
        System.out.print("\nSelect the Maze Generation algorithm to visualize: ");
        String choice = scanner.nextLine();
        return choice;
    }

    @Override
    public void handleInput(String input) {
        Algorithm algorithm = null;
        switch (input) {
            case "1" -> {}
            case "5" -> {
                System.out.print(ANSIEscape.CLEAR_AND_HOME);
                algorithmVisualizer.setState(new PathFindingAlgoSelectState(algorithmVisualizer));
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
        new AlgorithmRunnerFacade(new PathVisualizationAlgorithm(algorithm, pathFindingAlgorithm), algorithmVisualizer);
    }    
}
