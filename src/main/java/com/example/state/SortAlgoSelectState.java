package com.example.state;

import java.util.Scanner;
import com.example.AlgorithmVisualizer;
import com.example.algorithms.Algorithm;
import com.example.algorithms.sort.BubbleSortAlgorithm;
import com.example.algorithms.sort.InsertionSort;
import com.example.algorithms.sort.MergeSort;
import com.example.algorithms.sort.SelectionSort;
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
        Algorithm algorithm = null;
        switch (input) {
            case "1":
                algorithm = new BubbleSortAlgorithm();
                break;
            case "2":
                algorithm = new  InsertionSort();
                break;
            case "3":
                algorithm = new SelectionSort();
                break;
            case "4":
                algorithm = new MergeSort();
                break;
            case "5":
                System.out.print(ANSIEscape.CLEAR_AND_HOME);
                algorithmVisualizer.setState(new AlgorithmTypeSelectionState(algorithmVisualizer));
                algorithmVisualizer.start();
                return;
            default:
                System.out.print(ANSIEscape.CLEAR_AND_HOME);
                System.out.println("Invalid input. Please try again.");
                printScreen();
                return;
        }
        new AlgorithmRunnerFacade(algorithm, algorithmVisualizer).runAlgorithm();
    }

}
