package com.example.mike.lowestcost;

public class Path {

    public static PathResult navigate(int[][] grid) {
        PathResult pathResult = new PathResult();
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        pathResult = validateRowLength(rowLength, pathResult);
        pathResult = validateColumnLength(columnLength, pathResult);
        if (!pathResult.getIsValidRows() || !pathResult.getIsValidColumns()) {
            return pathResult;
        }

        pathResult = pathTotals(grid);
        int[][] gridPathTotals = pathResult.getGridPathTotals();

        pathResult = getPathResultForGrid(gridPathTotals, rowLength, columnLength, pathResult);

        return pathResult;
    }

    public static PathResult pathTotals (int[][] grid) {
        int[][] gridPathTotals = new int[grid.length][grid[0].length];
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        boolean[] isRowPathEnded = initializeRowBoolForEachRow(rowLength);

        //populate the first column
        for (int i = 0; i < rowLength; i++) {
            gridPathTotals[i][0] = grid[i][0];
        }

        for (int column = 1; column < columnLength; column++) {

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

        boolean ispathComplete = oneOrMorePathsCompleted(isRowPathEnded, rowLength);

        PathResult pathResult = new PathResult();
        pathResult.setPathComplete(ispathComplete);
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

    private static boolean[] initializeRowBoolForEachRow(int rowLength) {
        boolean[] isRowPathEnded = new boolean[rowLength];
        for (int i = 0; i < rowLength; i++) {
            isRowPathEnded[i] = false;
        }
        return isRowPathEnded;
    }

    private static boolean oneOrMorePathsCompleted(boolean[] isRowPathEnded, int rowLength) {
        boolean ispathComplete = false;
        if (!ispathComplete) {
            for (int row = 0; row < rowLength; row++) {
                if (isRowPathEnded[row] == false) {
                    ispathComplete = true;
                }
            }
        }
        return ispathComplete;
    }

    private static PathResult validateRowLength(int rowLength, PathResult pathResult) {
        if (rowLength > 10) {
            boolean isValidRows = false;
            pathResult.setIsValidRows(isValidRows);
        }
        return pathResult;
    }

    private static PathResult validateColumnLength(int columnLength, PathResult pathResult) {
        if (columnLength < 5 || columnLength > 100) {
            boolean isValidColumns = false;
            pathResult.setIsValidColumns(isValidColumns);
        }
        return pathResult;
    }

    private static PathResult getPathResultForGrid(int[][] gridPathTotals, int rowLength, int columnLength, PathResult pathResult) {
        int leastCostSumForRow = gridPathTotals[0][columnLength - 1];
        int leastCostSumForGrid = leastCostSumForRow;
        int finalRowOfLowestCostPath = 0;

        for (int row = 1; row < rowLength; row++) {
            if (gridPathTotals[row][columnLength - 1] < leastCostSumForRow) {
                leastCostSumForGrid = gridPathTotals[row][columnLength - 1];
                finalRowOfLowestCostPath = row;
            }
        }
        int[] pathTaken = getPathTakenForLowestCostPath(finalRowOfLowestCostPath, gridPathTotals, rowLength, columnLength);

        pathResult.setLeastCostSum(leastCostSumForGrid);
        pathResult.setPathTaken(pathTaken);

        return pathResult;
    }

    private static int[] getPathTakenForLowestCostPath(int finalRowOfLowestCostPath, int[][] gridPathTotals, int rowLength, int columnLength) {
        int[] pathTaken = new int[columnLength];

        int nextRow = finalRowOfLowestCostPath;

        pathTaken[columnLength - 1] = finalRowOfLowestCostPath;
        for (int column = columnLength - 2; column >= 0; column--) {
            nextRow = backTrackThroughGridToUpdatePathTaken(nextRow, column, gridPathTotals, pathTaken);
        }
        return pathTaken;
    }

    private static int backTrackThroughGridToUpdatePathTaken(int currentRow, int column, int[][] gridPathTotals, int[] pathTaken) {
        int row = currentRow;

        int previousRowToAdd = getPreviousRowToAdd(gridPathTotals, row);
        int previousRowToSubtract = getPreviousRowToSubtract(gridPathTotals, row);

        int upperLeft = gridPathTotals[previousRowToSubtract][column];
        int upperLeftCellRow = previousRowToSubtract;

        int left = gridPathTotals[row][column];
        int leftCellRow = row;

        int lowerLeft = gridPathTotals[previousRowToAdd][column];
        int lowerLeftCellRow = previousRowToAdd;

        int lowestCellValue = Math.min(upperLeft, Math.min(left, lowerLeft));

        if (lowestCellValue == upperLeft) {
            currentRow = upperLeftCellRow;
        } else if (lowestCellValue == left) {
            currentRow = leftCellRow;

        } else if (lowestCellValue == lowerLeft) {
            currentRow = lowerLeftCellRow;
        }

        pathTaken[column] = currentRow;
        return currentRow;
    }
}
