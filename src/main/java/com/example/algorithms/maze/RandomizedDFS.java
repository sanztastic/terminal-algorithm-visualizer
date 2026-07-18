package com.example.algorithms.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import com.example.algorithms.MazeGenerationAlgorithm;
import com.example.algorithms.path.helper.Node;
import com.example.constants.PathConstants;

public class RandomizedDFS extends MazeGenerationAlgorithm {
    
    private Random random;

    public RandomizedDFS(boolean fillUpBorder) {
        super(fillUpBorder);
        this.random = new Random();
    }

    protected void processAlgorithm() throws InterruptedException {
        Stack<Node> nodesToVisit = new Stack<>();
        Node startNode = selectRandomNodeToStart();
        setGridWithEmptyPath(startNode.row, startNode.column);
        nodesToVisit.push(startNode);
        startNode.isVisited = true;
        startGeneratingMaze(nodesToVisit);
    }

    /**
     * generate random value for row and column to select random node first
     **/
    private Node selectRandomNodeToStart() {
        int row = random.nextInt(1, grid.length - 2);
        row += row % 2 == 0 ? 1 : 0; 
        int column = random.nextInt(1, grid[0].length - 2);
        column += column % 2 == 0 ? 1 : 0; 
        return gridNodes[row][column];
    }

    private void startGeneratingMaze(Stack<Node> nodesToVisit) throws InterruptedException {
        Node current;
        while (!nodesToVisit.isEmpty()) {
            current = nodesToVisit.peek();
            List<Node> currentNeighbours = findNotVisitedNeighbours(current);
            if (!currentNeighbours.isEmpty()) {
                Node neighbour = currentNeighbours.get(random.nextInt(currentNeighbours.size()));
                removeWallInBetween(current, neighbour);
                renderFrame();
                neighbour.isVisited = true;
                nodesToVisit.push(neighbour);
            } else {
                nodesToVisit.pop();
            }
        }
    }

    private List<Node> findNotVisitedNeighbours(Node current) {
        List<Node> notVisitedNeighbours = new ArrayList<>();
        for (int i = 0; i < D_ROW.length; i++) {
            int nRow = current.row + D_ROW[i];
            int nCol = current.column + D_COL[i];
            if (nRow < 0 || nCol < 0 || nRow >= grid.length-1 || nCol >= grid[0].length-1) continue;
            Node neighbour = gridNodes[nRow][nCol];
            if (!neighbour.isVisited)
                notVisitedNeighbours.add(neighbour);
        }
        return notVisitedNeighbours;
    }

    private void removeWallInBetween(Node current, Node neighbour) {
        int midRow = (current.row + neighbour.row) / 2;
        int midCol = (current.column + neighbour.column) / 2;
        setGridWithEmptyPath(neighbour.row, neighbour.column);
        setGridWithEmptyPath(midRow, midCol);
    }

    private void setGridWithEmptyPath(int row, int column) {
        if (grid[row][column] != PathConstants.START_POINT 
            && grid[row][column] != PathConstants.END_POINT) {
            grid[row][column] = PathConstants.EMPTY;
        }
    }
}
