package com.example.algorithms.path;

import java.util.Stack;
import com.example.algorithms.PathFindingAlgorithm;
import com.example.algorithms.path.helper.Node;
import com.example.constants.PathConstants;

public class DFSAlgorithm extends PathFindingAlgorithm {

	@Override
	protected void processAlgorithm() throws InterruptedException {
        Stack<Node> nodesToVisit = new Stack<>();
        addStartPointToStack(nodesToVisit);
        Node current = null;
        while (!nodesToVisit.isEmpty()) {
            current = nodesToVisit.pop();
            if (current.isVisited) 
                continue;
            current.isVisited = true;
            int cell = grid[current.row][current.column];
            if (cell == PathConstants.END_POINT)
                break;
            if (cell != PathConstants.START_POINT) {
                grid[current.row][current.column] = PathConstants.VISITED;
                gridRenderer.renderGrid(grid);
                Thread.sleep(ANIMATION_SPEED);
            }
            checkAndPushNeighbours(current, nodesToVisit);
            gridRenderer.renderGrid(grid);
            Thread.sleep(ANIMATION_SPEED);
        }
        processAndVisualizePath(current);
	}

    private void addStartPointToStack(Stack<Node> nodesToVisit) {
        Node startNode = gridNodes[startRow][startCol];
        nodesToVisit.push(startNode);
    }

    private void checkAndPushNeighbours(Node current, Stack<Node> nodesToVisit) {
        for (int i = 0; i < D_COL.length; i++) {
            int nRow = current.row + D_ROW[i];
            int nCol = current.column + D_COL[i];
            int cell = grid[nRow][nCol];
            if (cell == PathConstants.DISCOVERED) 
                continue;
            Node neighbour = gridNodes[nRow][nCol];
            if (cell != PathConstants.WALL && !neighbour.isVisited) {
                neighbour.parent = current;
                if (cell != PathConstants.END_POINT)
                    grid[nRow][nCol] = PathConstants.DISCOVERED;
                nodesToVisit.push(neighbour);
            }
        }
    }

    private void processAndVisualizePath(Node current) throws InterruptedException {
        Stack<Node> pathStack = new Stack<>();
        while (current != null) {
            pathStack.push(current);
            current = current.parent;
        }

        while (!pathStack.isEmpty()) {
            Node pathNode = pathStack.pop();
            int cell = grid[pathNode.row][pathNode.column];
            if (cell != PathConstants.START_POINT && cell != PathConstants.END_POINT) {
                grid[pathNode.row][pathNode.column] = PathConstants.PATH;
                gridRenderer.renderGrid(grid);
                Thread.sleep(ANIMATION_SPEED);
            }
        }
    }
    
}
