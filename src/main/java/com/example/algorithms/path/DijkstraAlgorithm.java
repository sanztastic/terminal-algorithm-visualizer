package com.example.algorithms.path;

import java.util.PriorityQueue;
import com.example.algorithms.PathFindingAlgorithm;
import com.example.algorithms.path.helper.Node;
import com.example.constants.PathConstants;

public class DijkstraAlgorithm extends PathFindingAlgorithm {

    @Override
    protected void processAlgorithm() throws InterruptedException {
        PriorityQueue<Node> nodesToVisit = new PriorityQueue<>(
                (node1, node2) -> Integer.compare(node1.distance, node2.distance));
        addStartPointToPriorityQueue(nodesToVisit);
        Node current = null;
        while (!nodesToVisit.isEmpty()) {
            current = nodesToVisit.poll();
            if (current.isVisited) continue;
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

    private void addStartPointToPriorityQueue(PriorityQueue<Node> nodesToVisit) {
        Node startNode = gridNodes[startRow][startCol];
        startNode.distance = 0;
        nodesToVisit.offer(startNode);
    }

    private void checkAndOfferNeighbours(Node current, PriorityQueue<Node> nodesToVisit) {
        /** move distance from current node to get to 
         * adjacent neighbours and offer to priority queue.
         **/
        for (int i = 0;i < D_ROW.length; i++) {
            int nRow = current.row + D_ROW[i];
            int nCol = current.column + D_COL[i];
            int cell = grid[nRow][nCol];
            Node neighbour = gridNodes[nRow][nCol];
            //check if the neighbour is wall if not is already visited or not
            if (cell != PathConstants.WALL && !neighbour.isVisited ) {
                //create detail to neighbour and offer it to queue since it's discovered
                int newDistance = current.distance + 1;
                if (newDistance < neighbour.distance) {
                    neighbour.distance = newDistance;
                    neighbour.parent = current;
                    //adding to original grid as well for visualization
                    if (cell != PathConstants.END_POINT)
                        grid[nRow][nCol] = PathConstants.DISCOVERED;
                    nodesToVisit.offer(neighbour);
                }
            }
        }
    }
}

