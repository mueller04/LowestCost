package com.example.mike.lowestcost;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathTest {
    @Test
    public void pathSumFoundFromASingleRow() {
        //arrange
        int[] row = {1, 3};

        //act
        int pathSumResult = Path.navigate(row);

        //assert
        assertEquals(4, pathSumResult);
    }
}