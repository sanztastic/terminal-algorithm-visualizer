package com.example.algorithms;

public class InsertionSort extends SortingAlgorithm {
    @Override
    protected void processAlgorithm() throws InterruptedException {
        for (int i = 1; i < array.length; i++) {
            int k = i;
            int j = i-1;
            renderFrames(-1, k, -1);
            Thread.sleep(200);
            while (j>=0 && array[j]>array[k]) {
                int temp = array[k];
                array[k] = array[j];
                array[j] = temp;
                renderFrames(-1, j, k);
                Thread.sleep(200);
                j--;
                k--;
            }
            renderFrames(-1, j, k);
            Thread.sleep(200);
        }
        renderFrames(-1, -1, -1);
        Thread.sleep(200);
    }

}
