package com.example.mike.lowestcostpathandroid;

public class PathResult {

    boolean isPathComplete;
    boolean isValidColumns;
    boolean isValidRows;
    int leastCostSum;

    int[][] gridPathTotals;

    int[] pathTaken;

    public PathResult() {
        isValidColumns = true;
        isValidRows = true;
        isPathComplete = true;
    }

    public boolean getIsPathComplete() {
        return isPathComplete;
    }

    public void setPathComplete(boolean isPathComplete) {
        this.isPathComplete = isPathComplete;
    }

    public boolean getIsValidColumns() {
        return isValidColumns;
    }

    public void setIsValidColumns(boolean isValidColumns) {
        this.isValidColumns = isValidColumns;
    }

    public boolean getIsValidRows() {
        return isValidRows;
    }

    public void setIsValidRows(boolean isValidRows) {
        this.isValidRows = isValidRows;
    }

    public int getLeastCostSum() {
        return leastCostSum;
    }

    public void setLeastCostSum(int leastCostSum) {
        this.leastCostSum = leastCostSum;
    }

    public int[][] getGridPathTotals() {
        return gridPathTotals;
    }

    public void setGridPathTotals(int[][] gridPathTotals) {
        this.gridPathTotals = gridPathTotals;
    }

    public int[] getPathTaken() {
        return pathTaken;
    }

    public void setPathTaken(int[] pathTaken) {
        this.pathTaken = pathTaken;
    }

    @Override
    public String toString() {

        int[] pathTaken = getPathTaken();
        String pathTakenString = "";

        for (int i = 0; i < pathTaken.length; i++) {
            pathTakenString += String.valueOf(pathTaken[i]);

            if (i < pathTaken.length - 1) {
                pathTakenString += " ";
            }
        }

        String pathCompleteString;
        if (isPathComplete) {
            pathCompleteString = "Yes";
        } else {
            pathCompleteString = "No";
        }

        return pathCompleteString + "\n" + getLeastCostSum() + "\n" + pathTakenString;
    }

}