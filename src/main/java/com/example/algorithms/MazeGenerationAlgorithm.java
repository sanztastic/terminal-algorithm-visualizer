package com.example.algorithms;

import com.example.algorithms.renderer.GridRenderer;
import com.example.constants.PathConstants;

public abstract class MazeGenerationAlgorithm extends Algorithm {
    protected final GridRenderer gridRenderer;
    protected int[][] grid;
    
    public MazeGenerationAlgorithm() {
        gridRenderer = new GridRenderer();
    }

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
                        gridRenderer.renderGrid(grid);
                        Thread.sleep(ANIMATION_SPEED);
                    } 
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


}
