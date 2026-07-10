package com.example.state;

import java.util.Scanner;
import com.example.AlgorithmVisualizer;
import com.example.constants.ANSIEscape;

public class AlgorithmTypeSelectionState implements UIState {
    private AlgorithmVisualizer visualizer;

    public AlgorithmTypeSelectionState(AlgorithmVisualizer visualizer) {
        this.visualizer = visualizer;
    }

    @Override
    public String printScreen() {
        System.out.println("Select which algorithm to visualize: ");
        System.out.println("1. Sorting Algorithms");
        System.out.println("2. Path Finding Algorithms");
        System.out.println("3. Exit");
        System.out.print("\nSelect the type of algorithm to visualize: ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return choice;
    }

    @Override
    public void handleInput(String input) {
        switch (input) {
            case "1":
                System.out.print(ANSIEscape.CLEAR_AND_HOME);
                visualizer.setState(new SortAlgoSelectState(visualizer));
                visualizer.start();
                break;
            case "2":
                System.out.print(ANSIEscape.CLEAR_AND_HOME);
                visualizer.setState(new PathFindingAlgoSelectState(visualizer));
                visualizer.start();
                break;
            case "3":
                System.out.println("Exiting the application.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                printScreen();
                break;
        }
    }
}
