package com.example.mike.lowestcost;

public class Path {

    public static int navigate(int[][] grid) {

        int[][] gridPathTotals = pathTotals(grid);
        int columnLength = grid[0].length - 1;
        int leastCostSum = gridPathTotals[0][columnLength];

        for (int i = 1; i < grid.length; i++) {
            if (gridPathTotals[i][columnLength] < leastCostSum) {
                leastCostSum = gridPathTotals[i][columnLength];
            }
        }
        return leastCostSum;
    }

    public static int[][] pathTotals (int[][] grid) {
        int[][] gridPathTotals = grid;

        for (int column = 1; column < grid[0].length; column++) {

            for (int row = 0; row < grid.length; row++) {
                int previousRowToAdd = 0;

                if (row < grid.length - 1 && grid[row][column - 1] < grid[row + 1][column - 1]) {
                    previousRowToAdd = row;
                }

                if (row < grid.length - 1  && grid[row][column - 1] > grid[row + 1][column - 1]) {
                    previousRowToAdd = row + 1;
                }

                gridPathTotals[row][column] = grid[row][column] + grid[previousRowToAdd][column - 1];
            }
        }

        return gridPathTotals;
    }


}
