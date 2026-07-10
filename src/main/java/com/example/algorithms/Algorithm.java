package com.example.algorithms;

import com.example.constants.ANSIEscape;

public abstract class Algorithm {
    public void visualize() throws InterruptedException {
        generateRandomArray();
        System.out.print(ANSIEscape.CLEAR_AND_HOME);
        System.out.flush();
        processAlgorithm();
        System.out.println();
        System.out.println("Visualization completed!!");
    }

    protected abstract void generateRandomArray();
    protected abstract void processAlgorithm() throws InterruptedException;
}
