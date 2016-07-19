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

}