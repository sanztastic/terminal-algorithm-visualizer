package com.example.algorithms.maze;

import java.util.Random;
import com.example.algorithms.MazeGenerationAlgorithm;
import com.example.constants.PathConstants;

public class RecursiveDivision extends MazeGenerationAlgorithm {
    private Random random = new Random();

    @Override
    protected void processAlgorithm() throws InterruptedException {
        int nRow = grid.length;
        int nCol = grid[0].length;
        recursiveDivision(1, 1, nRow-2, nCol-2);
    }

    private void recursiveDivision(int x, int y, int nRow, int nCol) throws InterruptedException {
        if (nRow < 3 || nCol < 3) {
            return;
        }
        if (nRow == 3 && nCol == 3) return;
        
        boolean isHorizontal = isHorizontal(nRow, nCol);
        //check where the wall will be drawn from
        int wx = x + (isHorizontal? 0: random.nextInt(1, nCol - 2)); 
        int wy = y + (isHorizontal? random.nextInt(1,nRow - 2): 0);
        if (isHorizontal && wy % 2 != 0) {
            if (wy+1 < x + nRow - 1) wy++;
            else if (wy-1 > x) wy--;
        } 
        if (!isHorizontal && wx % 2 != 0) {
            if (wx+1 < y + nCol - 1) wx++;
            else if (wx-1 > y) wx--;
        } 
            
        //check where will be the passage through the wall exist
        int px = wx + (isHorizontal? random.nextInt(nCol-1): 0);
        int py = wy + (isHorizontal? 0: random.nextInt(nRow-1));
        if (isHorizontal && px % 2 == 0 ) {
            if (px + 1 <= nRow) px++;
            else if (px - 1 >= x) px--;
        } 
        if (!isHorizontal && py % 2 == 0) {
            if (py + 1 <= nCol) py++;
            else  if (py - 1 >= y) py--;
        }
        //what direction the wall will be drawn to
        int dx = isHorizontal? 1: 0;
        int dy = isHorizontal? 0: 1;

        int length = isHorizontal? nCol: nRow;

        for (int i = 0; i < length; i++) {
           if ((wx != px ||wy != py) && grid[wy][wx] != PathConstants.START_POINT
                 && grid[wy][wx] != PathConstants.END_POINT
                 ) {
               grid[wy][wx] = PathConstants.WALL;
           } 
           renderGrid();
           Thread.sleep(ANIMATION_SPEED);
           wx += dx;
           wy += dy;
        }
        wx -= dx;
        wy -= dy;

        int nx = x, ny = y;
        int newCol = isHorizontal? length: wx - x;
        int newRow = isHorizontal? wy - y: nRow;
        recursiveDivision(nx, ny, newRow, newCol);
            
        int nx1 = isHorizontal? x: wx + 1;
        int ny1 = isHorizontal? wy + 1: y;
        int newCol1 = isHorizontal? nCol: Math.abs((wx - x) - nCol) - 1;
        int newRow1 = isHorizontal? Math.abs((wy - y) - nRow) - 1: nRow;
        recursiveDivision(nx1, ny1, newRow1, newCol1);
    } 

    private boolean isHorizontal(int nRow, int nCol) {
        if (nRow > nCol) {
            return true;     
        } else if (nCol > nRow) {
            return false;
        } else {
            Random random = new Random();
            return random.nextInt(2) == 0;
        }
    }

}
