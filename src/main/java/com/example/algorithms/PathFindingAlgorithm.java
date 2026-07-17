package com.example.algorithms;

import java.util.Stack;
import com.example.algorithms.path.helper.Node;
import com.example.algorithms.renderer.GridRenderer;
import com.example.constants.PathConstants;

public abstract class PathFindingAlgorithm extends Algorithm {
    protected final GridRenderer gridRenderer;
    protected int[][] grid;
    protected Node[][] gridNodes;
    protected int startRow;
    protected int startCol;
    protected int endRow;
    protected int endCol;
    //for getting adjacent neighbour node of current node
    protected static final int[] D_ROW = {-1, 1, 0, 0};
    protected static final int[] D_COL = {0, 0, -1, 1}; 

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

    /**
     * This method is called to print the path once the algorithm find the 
     * path from start to end.
     **/ 
    protected void processAndVisualizePath(Node current) throws InterruptedException {
        Stack<Node> pathStack = new Stack<>();
        while (current != null) {
            pathStack.push(current);
            current = current.parent;
        }
        //once the path is stored opposite form end to start on stack now you pop it and store and visualize the grid
        while (!pathStack.isEmpty()) {
            Node pathNode = pathStack.pop();
            int cell = grid[pathNode.row][pathNode.column];
            if(cell != PathConstants.START_POINT && cell != PathConstants.END_POINT) {
                grid[pathNode.row][pathNode.column] = PathConstants.PATH;
                renderFrame();
            }
        }
    }

    protected void renderFrame() throws InterruptedException {
        gridRenderer.renderGrid(grid);
        Thread.sleep(ANIMATION_SPEED);
    }
}
