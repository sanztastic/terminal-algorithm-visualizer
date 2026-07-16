package com.example.algorithms.renderer;

import com.example.constants.ANSIEscape;
import com.example.constants.PathConstants;

public class GridRenderer {

    public void renderGrid(int[][] grid) {
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
