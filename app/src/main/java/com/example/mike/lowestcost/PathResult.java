package com.example.mike.lowestcost;

public class PathResult {

    boolean isValidColumns;
    boolean isValidRows;
    int leastCostSum;

    public PathResult() {
    }

    public PathResult(int leastCostSum) {
        this.leastCostSum = leastCostSum;
        isValidColumns = true;
        isValidRows = true;
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

    public void setIsValidRows(boolean isValidColumns) {
        this.isValidRows = isValidRows;
    }

    public int getLeastCostSum() {
        return leastCostSum;
    }

}
