package com.example.state;

import java.util.Scanner;
import com.example.AlgorithmVisualizer;

public class SortAlgoSelectState implements UIState {

    private AlgorithmVisualizer algorithmVisualizer;

    public SortAlgoSelectState(AlgorithmVisualizer algorithmVisualizer) {
        this.algorithmVisualizer = algorithmVisualizer;
    }

    @Override
    public int printScreen() {
        System.out.println("================================");
        System.out.println("Select which sorting algorithm to visualize: ");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Merge Sort");
        System.out.print("\nSelect the sorting algorithm to visualize: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    @Override
    public void handleInput(int input) {
    }

}
