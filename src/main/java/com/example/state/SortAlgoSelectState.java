package com.example.state;

import java.util.Scanner;
import com.example.AlgorithmVisualizer;
import com.example.algorithms.BubbleSortAlgorithm;
import com.example.algorithms.InsertionSort;
import com.example.algorithms.SelectionSort;
import com.example.constants.ANSIEscape;
import com.example.facade.AlgorithmRunnerFacade;

public class SortAlgoSelectState implements UIState {

    private AlgorithmVisualizer algorithmVisualizer;

    public SortAlgoSelectState(AlgorithmVisualizer algorithmVisualizer) {
        this.algorithmVisualizer = algorithmVisualizer;
    }

    @Override
    public String printScreen() {
        System.out.println("================================");
        System.out.println("Select which sorting algorithm to visualize: ");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Back to Main Menu");
        System.out.print("\nSelect the sorting algorithm to visualize: ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return choice;
    }

    @Override
    public void handleInput(String input) {
        AlgorithmRunnerFacade facade = null;
        switch (input) {
            case "1":
                facade = new AlgorithmRunnerFacade(new BubbleSortAlgorithm(), algorithmVisualizer);
                facade.runAlgorithm();
                break;
            case "2":
                facade = new AlgorithmRunnerFacade(new InsertionSort(), algorithmVisualizer);
                facade.runAlgorithm();
                break;
            case "3":
                facade = new AlgorithmRunnerFacade(new SelectionSort(), algorithmVisualizer);
                facade.runAlgorithm();
                break;
            case "4":
                break;
            case "5":
                System.out.print(ANSIEscape.CLEAR_AND_HOME);
                algorithmVisualizer.setState(new AlgorithmTypeSelectionState(algorithmVisualizer));
                algorithmVisualizer.start();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                printScreen();
                break;
        }
    }

}
