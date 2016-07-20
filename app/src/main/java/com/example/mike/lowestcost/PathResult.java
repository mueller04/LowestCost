package com.example.mike.lowestcost;

public class PathResult {

    boolean isPathComplete;
    boolean isValidColumns;
    boolean isValidRows;
    int leastCostSum;

    int[][] gridPathTotals;

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

}
