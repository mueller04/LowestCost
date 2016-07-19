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
        int[][] gridPathTotals = new int[grid.length][grid[0].length];

        //populate the first column
        for (int i = 0; i < grid[0].length; i++) {
            gridPathTotals[i][0] = grid[i][0];
        }

        for (int column = 1; column < grid[0].length; column++) {

            for (int row = 0; row < grid.length; row++) {
                int previousRowToAdd;
                int previousRowToSubtract;

                if (row == 0) {
                    previousRowToSubtract = grid.length - 1;
                } else {
                    previousRowToSubtract = row;
                }

                if (row == grid.length - 1) {
                    previousRowToAdd = 0;
                } else {
                    previousRowToAdd = row;
                }

                int upperLeft = gridPathTotals[previousRowToAdd + 1][column - 1];
                int left = gridPathTotals[row][column -1];
                int lowerLeft = gridPathTotals[previousRowToSubtract - 1][column - 1];

                int lowestCellValue = Math.min(upperLeft ,Math.min(left, lowerLeft));

                gridPathTotals[row][column] = lowestCellValue + grid[row][column];
            }
        }
        return gridPathTotals;
    }


}
