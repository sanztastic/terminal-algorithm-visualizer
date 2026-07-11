package com.example.algorithms;

public class SelectionSort extends SortingAlgorithm {
    @Override
    protected void processAlgorithm() throws InterruptedException {
        for (int i = 0; i < array.length; i++) {
            int key = i;
            renderFrames(key, i+1 , i-1);
            Thread.sleep(ANIMATION_SPEED);

            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[key]) {
                   key = j;
                }
                renderFrames(key, j, -1);
                Thread.sleep(ANIMATION_SPEED);
            }
            renderFrames(key, -1 , -1);
            Thread.sleep(ANIMATION_SPEED);
            int temp = array[key];
            array[key] = array[i];
            array[i] = temp;
        }
        renderFrames(-1, -1, -1);
    }
}
