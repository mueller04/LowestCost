package com.example.mike.lowestcostpathandroid;

import java.util.Random;

public class Grid {

    String gridStr;
    int[][] grid;

    public Grid(String gridStr, int[][] grid) {
        this.gridStr = gridStr;
        this.grid = grid;
    }

    public static Grid createGrid(int numRows, int numColumns) {
        int[][] grid = createGridIntArray(numRows, numColumns);
        String gridStr = createGridString(numRows, numColumns, grid);
        return new Grid(gridStr, grid);
    }

    public static int[][] createGridIntArray(int numRows, int numColumns) {
        int[][] grid = new int[numRows][numColumns];
        Random random = new Random();

        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column < numColumns; column++) {
                int randomInt = random.nextInt(20);
                grid[row][column] = randomInt;
            }
        }
        return grid;
    }

    public static String createGridString(int numRows, int numColumns, int[][] grid) {
        String gridStr = "";

        int rowLength = numRows;
        int columnLength = numColumns;

        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                String numberString = String.valueOf(grid[row][column] + "  ");

                if (numberString.length() == 3) {
                    numberString += "   ";
                } else {
                    numberString += " ";
                }

                gridStr += numberString;
            }
            gridStr += "\n";
        }
        return  gridStr;
    }

    public String getGridString() {
        return gridStr;
    }

    public int[][] getGridArray() {
        return grid;
    }
}
