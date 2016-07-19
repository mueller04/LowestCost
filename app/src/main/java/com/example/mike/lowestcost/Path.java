package com.example.mike.lowestcost;

public class Path {

    public static int navigate(int[] row) {
        int leastCostSum =0 ;
        for (int i = 0; i < row.length; i++) {
            leastCostSum += row[i];
        }
        return leastCostSum;
    }

}
