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
        while (!nodesToVisit.isEmpty()) {
            Node current = nodesToVisit.poll();

            if (current.isVisited) continue;

            current.isVisited = true;

            if (grid[current.row][current.column] == PathConstants.END_POINT) 
                break;

            if (grid[current.row][current.column] != PathConstants.START_POINT) {
                //render frames
            }
            checkAndOfferNeighbours(current, nodesToVisit);
            //renderframes
        }
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
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        for (int i = 0;i < dRow.length; i++) {
            int nRow = current.row + dRow[i];
            int nCol = current.column + dCol[i];
            int cell = grid[nRow][nCol];
            Node neighbour = gridNodes[nRow][nCol];
            //check if the neighbour is wall if not is already visited or not
            if (cell != PathConstants.WALL && !neighbour.isVisited ) {
                //create detail to neighbour and offer it to queue since it's discovered
                int newDistance = current.distance + 1;
                if (newDistance < neighbour.distance) {
                    neighbour.distance = current.distance + 1;
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

