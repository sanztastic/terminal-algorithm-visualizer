package com.example.algorithms.path.helper;

public class Node {
    public int row;
    public int column;
    public int distance = Integer.MAX_VALUE;
    public Node parent = null;
    public boolean isVisited = false;
    public int heuristic = 0;

    public Node(int row, int column) {
        this.row = row;
        this.column = column;
    }

    //calculate f for A*
    public int getF() {
        return distance + heuristic;
    }

}
