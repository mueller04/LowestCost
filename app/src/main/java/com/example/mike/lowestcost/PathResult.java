package com.example.mike.lowestcost;

public class PathResult {

    boolean isValidColumns;
    int leastCostSum;

    public PathResult(boolean isValidColumns) {
        this.isValidColumns = isValidColumns;
    }

    public PathResult(int leastCostSum) {
        this.leastCostSum = leastCostSum;
    }

    public boolean getIsValidColumns() {
        return isValidColumns;
    }

    public void setIsValidColumns(boolean isValidColumns) {
        this.isValidColumns = isValidColumns;
    }

    public int getLeastCostSum() {
        return leastCostSum;
    }

    public void setIsValidColumns(int leastCostSum) {
        this.leastCostSum = leastCostSum;
    }

}
