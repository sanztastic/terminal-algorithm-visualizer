package com.example.algorithms;

public class BubbleSortAlgorithm extends SortingAlgorithm {

    @Override
	protected void processAlgorithm() throws InterruptedException {
        int endIndex = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                endIndex = j;
                //render frames showing the current state with selected ptr to be compared
                renderFrames(j, j+1, -1);
                Thread.sleep(200);
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    //render frames after the swap has taken place between 2 pointers
                    renderFrames(j, j+1, -1);
                    Thread.sleep(200);
                }
                endIndex = j+1;
            }
            renderFrames(-1, -1, endIndex);
        }
        // Finish the array sort so last print
        renderFrames(-1, -1, -1);
		
	}
}
