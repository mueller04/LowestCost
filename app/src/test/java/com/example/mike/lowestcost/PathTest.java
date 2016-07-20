package com.example.mike.lowestcost;

import org.junit.Test;

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

}