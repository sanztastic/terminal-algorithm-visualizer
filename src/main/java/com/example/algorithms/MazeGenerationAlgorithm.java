package com.example.algorithms;

import com.example.algorithms.path.helper.Node;
import com.example.algorithms.renderer.GridRenderer;
import com.example.constants.PathConstants;

public abstract class MazeGenerationAlgorithm extends Algorithm {
    protected final GridRenderer gridRenderer;
    protected int[][] grid;
    private boolean fillUpBorder;
    protected Node[][] gridNodes;
    //for finding the neighbour for current 
    //Note: for maze generation skip one row/col for neighbour
    protected int[] D_ROW = {0, 0, -2, 2};
    protected int[] D_COL = {-2, 2, 0, 0};
    
    public MazeGenerationAlgorithm(boolean fillUpBorder) {
        gridRenderer = new GridRenderer();
        this.fillUpBorder = fillUpBorder;
    }

    @Override
    protected void generateRandomArray() {
        if (this.fillUpBorder) fillUpBorder();
        else fillUpGridAndCreateNodeGrid();  
    }

    private void fillUpBorder() {
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

    private void fillUpGridAndCreateNodeGrid() {
        gridNodes = new Node[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != PathConstants.START_POINT && grid[i][j] != PathConstants.END_POINT)
                    grid[i][j] = PathConstants.WALL;
                gridNodes[i][j] = new Node(i, j);
            }
        }
    }

    protected void renderFrame() throws InterruptedException {
        gridRenderer.renderGrid(grid);
        Thread.sleep(ANIMATION_SPEED);
    }

}
