package com.example.mike.lowestcost;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class PathTest {


    @Test
    public void lowestSumFoundWithUpperWrapping() {
        //arrange
        int[][] grid = {{1, 3, 5, 5, 5},
                        {2, 2, 5, 5, 5},
                        {8, 2, 5, 5, 5},
                        {7, 0, 1, 1, 1}};

        //act
        PathResult pathSumResult = Path.navigate(grid);

        //assert
        assertEquals(4, pathSumResult.getLeastCostSum());
    }

    @Test
    public void lowestSumFoundWithLowerWrapping() {
        //arrange
        int[][] grid = {{4, 2, 1, 1, 1},
                        {2, 2, 5, 5, 5},
                        {8, 4, 5, 5, 5},
                        {1, 8, 5, 5, 5}};

        //act
        PathResult pathSumResult = Path.navigate(grid);

        //assert
        assertEquals(6, pathSumResult.getLeastCostSum());
    }

    @Test
    public void lessThan5ColumnsNotAccepted() {
        //arrange
        int[][] grid = {{4, 2, 2},
                        {2, 2, 1},
                        {8, 4, 5},
                        {1, 8, 3}} ;

        //act
        PathResult pathResult = Path.navigate(grid);

        //assert
        assertEquals(false, pathResult.getIsValidColumns());
    }


    @Test
    public void moreThan100ColumnsNotAccepted() {
        //arrange
        int[][] grid = createGrid(5, 101);

        //act
        PathResult pathResult = Path.navigate(grid);

        //assert
        assertEquals(false, pathResult.getIsValidColumns());
    }

    @Test
    public void onehundredColumnsAccepted() {
        //arrange
        int[][] grid = createGrid(5, 100);

        //act
        PathResult pathResult = Path.navigate(grid);

        //assert
        assertEquals(true, pathResult.getIsValidColumns());
    }

    @Test
    public void moreThan10RowsNotAccepted() {
        //arrange
        int[][] grid = createGrid(11, 5);

        //act
        PathResult pathResult = Path.navigate(grid);

        //assert
        assertEquals(false, pathResult.getIsValidRows());
    }

    @Test
    public void tenRowsAccepted() {
        //arrange
        int[][] grid = createGrid(10, 5);

        //act
        PathResult pathResult = Path.navigate(grid);

        //assert
        assertEquals(true, pathResult.getIsValidRows());
    }

    @Test
    public void falseIfNoPathCompletedDueToCostOver50() {
        //arrange
        int[][] grid = {{10, 39, 2, 1, 9},
                        {10, 39, 2, 5, 9},
                        {10, 39, 2, 5, 9},
                        {10, 39, 2, 5, 9}};

        //act
        PathResult pathResult = Path.navigate(grid);

        //assert
        assertEquals(false, pathResult.getIsPathComplete());
    }

    @Test
    public void trueIfAtLeast1PathCompleted() {
        //arrange
        int[][] grid = {{10, 39, 2, 1, 9},
                        {10, 39, 2, 5, 9},
                        {1, 10, 5, 1, 9},
                        {10, 39, 2, 5, 9}};

        //act
        PathResult pathResult = Path.navigate(grid);

        //assert
        assertEquals(false, pathResult.getIsPathComplete());
    }


    //Test Methods
    public int[][] createGrid(int numRows, int numColumns) {
        int[][] grid = new int[numRows][numColumns];
        Random random = new Random();

        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column < numColumns; column++) {
                int randomInt = random.nextInt();
                grid[row][column] = randomInt;
            }
        }
        return grid;
    }

}