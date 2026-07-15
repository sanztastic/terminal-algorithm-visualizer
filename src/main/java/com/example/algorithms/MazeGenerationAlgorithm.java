package com.example.algorithms;

import com.example.constants.ANSIEscape;
import com.example.constants.PathConstants;

public abstract class MazeGenerationAlgorithm extends Algorithm {
    protected int[][] grid;

    @Override
    protected void generateRandomArray() {
        //just filling up the borders area of array with walls
        try {
            int row = grid.length;
            int col = grid[0].length;
            for(int i=0; i<row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i==0 || j==0 || i == row-1 || j == col-1) {
                        grid[i][j] = PathConstants.WALL;
                        renderGrid();
                        Thread.sleep(ANIMATION_SPEED);
                    } 
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    protected void renderGrid() {
        int row = grid.length;
        int col = grid[0].length;
        System.out.print(ANSIEscape.CLEAR_AND_HOME);
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                chooseColorOfGrid(grid, i, j);
            }
            System.out.println();
        }
    }

    private void chooseColorOfGrid(int[][] grid, int i, int j) {
        String color = switch(grid[i][j]) {
            case PathConstants.WALL -> ANSIEscape.SILVER + "██" + ANSIEscape.RESET;
            case PathConstants.START_POINT -> ANSIEscape.RED + "██" + ANSIEscape.RESET;
            case PathConstants.END_POINT -> ANSIEscape.BLUE + "██" + ANSIEscape.RESET;
            default -> "  ";
        };

        System.out.print(color);
    }

}
