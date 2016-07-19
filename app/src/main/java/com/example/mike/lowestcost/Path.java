package com.example.mike.lowestcost;

public class Path {

    public static int navigate(int[][] grid) {
        int leastCostSum = 0;


        for (int row = 0; row < grid.length; row++) {

            for (int column = 0; column < grid[0].length; column++) {
                
                if (grid[row + 1][column] > grid[row][column]) {
                    leastCostSum += grid[row + 1][column];
                } else {
                    leastCostSum += grid[row][column];
                }

                leastCostSum += grid[row][column];

            }
        }


        return leastCostSum;
    }

}
