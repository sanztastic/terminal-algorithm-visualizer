package com.example.algorithms;

import com.example.algorithms.path.helper.Node;
import com.example.algorithms.renderer.GridRenderer;

public abstract class PathFindingAlgorithm extends Algorithm {
    protected final GridRenderer gridRenderer;
    protected int[][] grid;
    protected Node[][] gridNodes;
    protected int startRow;
    protected int startCol;
    protected int endRow;
    //for getting adjacent neighbour node of current node
    protected static final int[] D_ROW = {-1, 1, 0, 0};
    protected static final int[] D_COL = {0, 0, -1, 1};  protected int endCol;

    public PathFindingAlgorithm() {
        this.gridRenderer = new GridRenderer();
    }

    @Override
    protected void generateRandomArray() {
        int row = grid.length;
        int col = grid[0].length;
        gridNodes = new Node[row][col];
        loadGridNode();
    }

    private void loadGridNode() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                gridNodes[i][j] = new Node(i, j);
            }
        }
    }
}
