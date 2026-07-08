package com.example;

import java.util.Scanner;

public class AlgorithmVisualizer {
    public void start(){
        int choice = typeOfAlgorithmSelection();
        selectRespectiveAlgorithm(choice);
    }

    private int typeOfAlgorithmSelection() {
        System.out.println("Select which algorithm to visualize: ");
        System.out.println("1. Sorting Algorithms");
        System.out.println("2. Path Finding Algorithms");
        System.out.print("\nSelect the type of algorithm to visualize: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    private void selectRespectiveAlgorithm(int choice) {
        System.out.println("================================");
        switch (choice) {
            case 1:
                System.out.println("Select which sorting algorithm to visualize: ");
                System.out.println("1. Bubble Sort");
                System.out.println("2. Insertion Sort");
                System.out.println("3. Selection Sort");
                System.out.println("4. Merge Sort");
                System.out.print("\nSelect the sorting algorithm to visualize: ");
                Scanner scanner = new Scanner(System.in);
                int sortingChoice = scanner.nextInt();
                break;
            case 2:
                System.out.println("Select which path finding algorithm to visualize: ");
                System.out.println("1. Dijkstra's Algorithm");
                System.out.println("2. A* Algorithm");
                System.out.println("3. Breadth-First Search (BFS)");
                System.out.println("4. Depth-First Search (DFS)");
                System.out.print("\nSelect the path finding algorithm to visualize: ");
                Scanner scanner2 = new Scanner(System.in);
                int pathFindingChoice = scanner2.nextInt();
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                start(); 
        }
    }

}
