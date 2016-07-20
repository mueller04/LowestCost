package com.example.mike.lowestcost;

public class Path {

    public static PathResult navigate(int[][] grid) {

        if (grid.length > 10) {
            boolean isValidRows = false;
            PathResult pathResult = new PathResult();
            pathResult.setIsValidRows(isValidRows);
            return pathResult;
        }

        if (grid[0].length < 5 || grid[0].length > 100) {
            boolean isValidColumns = false;
            PathResult pathResult = new PathResult();
            pathResult.setIsValidColumns(isValidColumns);
            return pathResult;
        }

        PathResult pathResult = pathTotals(grid);
        int[][] gridPathTotals = pathResult.getGridPathTotals();
        int columnLength = grid[0].length - 1;
        int leastCostSum = gridPathTotals[0][columnLength];

        for (int i = 1; i < grid.length; i++) {
            if (gridPathTotals[i][columnLength] < leastCostSum) {
                leastCostSum = gridPathTotals[i][columnLength];
            }
        }

        pathResult.setLeastCostSum(leastCostSum);
        return pathResult;
    }

    public static PathResult pathTotals (int[][] grid) {
        int[][] gridPathTotals = new int[grid.length][grid[0].length];
        int rowLength = grid.length;
        boolean[] isRowPathEnded = new boolean[rowLength];
        for (int i = 0; i < rowLength; i++) {
            isRowPathEnded[i] = false;
        }

        //populate the first column
        for (int i = 0; i < grid.length; i++) {
            gridPathTotals[i][0] = grid[i][0];
        }

        for (int column = 1; column < grid[0].length; column++) {

            for (int row = 0; row < rowLength; row++) {

                if (isRowPathEnded[row] == false) {
                    int previousRowToAdd = getPreviousRowToAdd(grid, row);
                    int previousRowToSubtract = getPreviousRowToSubtract(grid, row);

                    int upperLeft = gridPathTotals[previousRowToSubtract][column - 1];
                    int left = gridPathTotals[row][column -1];
                    int lowerLeft = gridPathTotals[previousRowToAdd][column - 1];

                    int lowestCellValue = Math.min(upperLeft ,Math.min(left, lowerLeft));

                    int tentativePathTotal = lowestCellValue + grid[row][column];

                    if (tentativePathTotal <= 50) {
                        gridPathTotals[row][column] = tentativePathTotal;
                    } else {
                        isRowPathEnded[row] = true;
                    }
                }
            }
        }

        boolean pathComplete = true;
        int columnLength = grid[0].length - 1;
        for (int row = 0; row < rowLength; row++) {
            if (gridPathTotals[row][columnLength] == 0) {
                pathComplete = false;
            }
        }

        PathResult pathResult = new PathResult();
        pathResult.setPathComplete(pathComplete);
        pathResult.setGridPathTotals(gridPathTotals);
        return pathResult;
    }

    private static int getPreviousRowToSubtract(int[][] grid, int currentRow) {
        if (currentRow == 0) {
            return grid.length - 1;
        } else {
            return currentRow - 1;
        }
    }

    private static int getPreviousRowToAdd(int[][] grid, int currentRow) {
        if (currentRow == grid.length - 1) {
            return 0;
        } else {
            return currentRow + 1;
        }
    }


}
