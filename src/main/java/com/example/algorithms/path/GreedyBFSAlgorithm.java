package com.example.algorithms.path;

import java.util.Comparator;
import java.util.PriorityQueue;
import com.example.algorithms.PathFindingAlgorithm;
import com.example.algorithms.path.helper.Node;
import com.example.constants.PathConstants;

public class GreedyBFSAlgorithm extends PathFindingAlgorithm {

	@Override
	protected void processAlgorithm() throws InterruptedException {
        PriorityQueue<Node> nodesToVisit = new PriorityQueue<>(Comparator
                .comparingInt(node -> node.heuristic));
        addStartPointToPriorityQueue(nodesToVisit);
        Node current = null;
        while (!nodesToVisit.isEmpty()) {
            current = nodesToVisit.poll();
            if (current.isVisited) 
                continue;
            current.isVisited = true;
            int cell = grid[current.row][current.column];
            if (cell == PathConstants.END_POINT) 
                break;
            if (cell != PathConstants.START_POINT) {
                grid[current.row][current.column] = PathConstants.VISITED;
                renderFrame();
            }
            checkAndOfferNeighbours(current, nodesToVisit);
            renderFrame();
        }
        processAndVisualizePath(current);
	}

    private void checkAndOfferNeighbours(Node current, PriorityQueue<Node> nodesToVisit) {
        for (int i = 0; i < D_COL.length; i++) {
            int nRow = current.row + D_ROW[i];
            int nCol = current.column + D_COL[i];
            int cell = grid[nRow][nCol];
            Node neighbour = gridNodes[nRow][nCol];
            if (cell != PathConstants.WALL && !neighbour.isVisited) {
                neighbour.parent = current;
                neighbour.heuristic = calculateManhattanDistance(neighbour);
                if (cell != PathConstants.END_POINT) 
                    grid[nRow][nCol] = PathConstants.DISCOVERED;
                nodesToVisit.offer(neighbour);
            }
        }
    }

    private void addStartPointToPriorityQueue(PriorityQueue<Node> nodesToVisit) {
        Node startNode = gridNodes[startRow][startCol];
        nodesToVisit.offer(startNode);
    }

    private int calculateManhattanDistance(Node neighbour) {
        int dRow = Math.abs(endRow - neighbour.row);
        int dCol = Math.abs(endCol - neighbour.column);
        return dRow + dCol;
    }
}
