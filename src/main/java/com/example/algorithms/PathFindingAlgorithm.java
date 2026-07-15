package com.example.algorithms;

import com.example.algorithms.path.helper.Node;

public abstract class PathFindingAlgorithm extends Algorithm {
    protected int[][] grid;
    protected Node[][] gridNodes;
    protected int startRow;
    protected int startCol;
    protected int endRow;
    protected int endCol;

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
