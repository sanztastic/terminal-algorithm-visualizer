package com.example.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.example.constants.ANSIEscape;

public abstract class SortingAlgorithm extends Algorithm {

    protected int[] array;
    protected Map<Integer, Boolean> isIndexSortedMap;

    public SortingAlgorithm() {
        array = new int[15];
        isIndexSortedMap = new HashMap<>();
    }

    @Override
    protected void generateRandomArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20) + 1;
        }
    }

    protected void renderFrames(int ptr1, int ptr2, int sortedIndex) {
        System.out.print(ANSIEscape.HOME);
        System.out.println();
        /**
         * maximum value inside the array is 20, as I have generated random number
         * between 1 and 20, so just hardcoding the value for now.
        **/
        int maxVal = 20; 
        //Rendering the array vertically from top to bottom to create bar.
        for (int row = maxVal; row > 0; row--) {
            for (int col = 0; col < array.length; col++) {
                if(array[col] >= row) {
                    if (ptr1 == -1 && ptr2 == -1 && sortedIndex == -1 ) {
                        System.out.print(ANSIEscape.GREEN + "██ " + ANSIEscape.RESET);
                        continue;
                    }
                    colorBarAccordingToCondition(col, ptr1, ptr2, sortedIndex);
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    private void colorBarAccordingToCondition(int col, int ptr1, int ptr2, int sortedIndex) {
        if (col == ptr1 || col == ptr2)
            System.out.print(ANSIEscape.YELLOW + "██ " + ANSIEscape.RESET);
        else if (col == sortedIndex ||isIndexSortedMap.containsKey(col) ) {
            System.out.print(ANSIEscape.GREEN + "██ " + ANSIEscape.RESET);
            if(sortedIndex != -1) isIndexSortedMap.put(sortedIndex, Boolean.TRUE);
        }
        else
            System.out.print(ANSIEscape.SILVER + "██ " +ANSIEscape.RESET);
    }
}
