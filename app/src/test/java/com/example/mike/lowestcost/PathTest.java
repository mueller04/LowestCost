package com.example.mike.lowestcost;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathTest {

    @Test
    public void lowestSumFoundFromTwoRows() {
        //arrange
        int[][] grid = {{1, 3},
                        {2, 1}};

        //act
        int pathSumResult = Path.navigate(grid);

        //assert
        assertEquals(2, pathSumResult);
    }

    @Test
    public void lowestSumFoundFromThreeRows() {
        //arrange
        int[][] grid = {{1, 3},
                        {2, 2},
                        {0, 1}};

        //act
        int pathSumResult = Path.navigate(grid);

        //assert
        assertEquals(1, pathSumResult);
    }

    @Test
    public void lowestSumFoundWithUpperWrapping() {
        //arrange
        int[][] grid = {{1, 3},
                        {2, 2},
                        {8, 2},
                        {7, 0}};

        //act
        int pathSumResult = Path.navigate(grid);

        //assert
        assertEquals(1, pathSumResult);
    }

    @Test
    public void lowestSumFoundWithLowerWrapping() {
        //arrange
        int[][] grid = {{4, 2},
                        {2, 2},
                        {8, 4},
                        {1, 0}};

        //act
        int pathSumResult = Path.navigate(grid);

        //assert
        assertEquals(3, pathSumResult);
    }

}