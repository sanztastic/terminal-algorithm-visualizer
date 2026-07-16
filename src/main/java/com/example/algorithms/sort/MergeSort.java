package com.example.algorithms.sort;

import java.util.Arrays;
import com.example.algorithms.SortingAlgorithm;
import com.example.constants.ANSIEscape;

public class MergeSort extends SortingAlgorithm {

    @Override
    protected void processAlgorithm() throws InterruptedException {
        int n = array.length;
        int start = 0;
        int end = n - 1;
        mergeSort(start, end);
        renderFrames(-1, -1, -1);
        Thread.sleep(ANIMATION_SPEED);
    }

    private void mergeSort(int start, int end) throws InterruptedException {
        if (start < end) {
            int mid = ( start + ( end - 1 ) ) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    private void merge(int start, int mid, int end) throws InterruptedException {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        renderFrames(start, end, -1);
        Thread.sleep(ANIMATION_SPEED);

        int[] leftArray = Arrays.copyOfRange(array, start, mid+1);
        int[] rightArray = Arrays.copyOfRange(array, mid+1, end+1);

        int leftIndex = 0, rightIndex = 0;
        int arrayIndex = start;

        while (leftIndex < n1 && rightIndex < n2) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[arrayIndex] = leftArray[leftIndex];
                renderFrames(start, end, arrayIndex);
                Thread.sleep(ANIMATION_SPEED);
                leftIndex++;
            } else {
                array[arrayIndex] = rightArray[rightIndex];
                 renderFrames(start, end, arrayIndex);
                Thread.sleep(ANIMATION_SPEED);
                rightIndex++;
            }
            arrayIndex++;
        }

        while (leftIndex < n1) {
            array[arrayIndex++] = leftArray[leftIndex++];
        }

        while (rightIndex < n2) {
            array[arrayIndex++] = rightArray[rightIndex++];
        }
        renderFrames(start, end, arrayIndex);
        Thread.sleep(ANIMATION_SPEED);
    }

  @Override
  protected void colorBarAccordingToCondition(int col, int ptr1, int ptr2, int sortedIndex) {
       if ( col >= ptr1 && col <= ptr2)
          System.out.print(ANSIEscape.YELLOW + "██ " + ANSIEscape.RESET);
      else
          System.out.print(ANSIEscape.SILVER + "██ " +ANSIEscape.RESET);

  }
}
