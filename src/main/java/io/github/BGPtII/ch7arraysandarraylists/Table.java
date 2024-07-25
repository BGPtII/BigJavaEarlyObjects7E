package io.github.BGPtII.ch7arraysandarraylists;

public class Table
{

    private int[][] values;

    public Table(int rows, int columns) {
        values = new int[rows][columns];
    }

    public void set(int row, int column, int wholeNum) {
        values[row][column] = wholeNum;
    }

    private boolean isValidIndex(int row, int column) {
        return row >= 0 && row < values.length && column >= 0 && column < values[0].length;
    }

    /**
     * Computes the average of the neighbouring elements - 8 maximum
     */
    public double neighbourAverage(int row, int column) {
        double sum  = 0;
        int count = 0;
        int rowSearchStart = (row - 1 < 0 ) ? row : row - 1;
        int rowSearchEnd = (row + 1 > values.length - 1) ? row : row + 1;
        int colSearchStart = (column - 1 < 0) ? column : column - 1;
        int colSearchEnd = (column + 1 > values[0].length - 1) ? column : column + 1;
        for (int i = rowSearchStart; i <= rowSearchEnd; i++) {
            for (int j = colSearchStart; j <= colSearchEnd; j++) {
                if (i != row || j != column) {
                    sum += values[i][j];
                    count++;
                }
            }
        }
        return count != 0 ? sum / count : 0;
    }

    public int sum(int index, boolean horizontal) {
        int sum = 0;
        if (horizontal) {
            for (int i = 0; i < values[0].length; i++) {
                sum += values[index][i];
            }
        }
        else {
            for (int j = 0; j < values.length; j++) {
                sum += values[j][index];
            }
        }
        return sum;
    }

}
