package com.example.algorithms;

public abstract class PathFindingAlgorithm extends Algorithm {
    private int[][] grid;

    @Override
    protected void generateRandomArray() {
        throw new UnsupportedOperationException();
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

}
