package com.huligang;
import java.util.ArrayList;

/**
 * 顺时针打印矩阵，画图理清思路
 */
public class PrintMatrixClockwisely {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return result;
        PMC(matrix, 0, 0, matrix.length-1, matrix[0].length-1, result);
        return result;
    }
    private void PMC(int [][] matrix, int startRow, int startCol, int endRow, int endCol, ArrayList<Integer> result) {
        if (startRow<endRow && startCol<endCol) {
            for (int j = startCol; j <= endCol; j++)
                result.add(matrix[startRow][j]);
            for (int i = startRow + 1; i<= endRow; i++)
                result.add(matrix[i][endCol]);
            for (int j = endCol - 1; j >= startCol; j--)
                result.add(matrix[endRow][j]);
            for (int i = endRow - 1; i >= startRow + 1; i--)
                result.add(matrix[i][startCol]);
            PMC(matrix, startRow + 1, startCol + 1, endRow - 1, endCol -1, result);
        } else if (startRow == endRow && startCol < endCol){
            for (int j = startCol; j <= endCol; j++)
                result.add(matrix[startRow][j]);
        } else if (startRow < endRow && startCol == endCol){
            for (int i = startRow; i <= endRow; i++)
                result.add(matrix[i][startCol]);
        } else if (startRow == endRow && startCol == endCol)
            result.add(matrix[startRow][startCol]);
        else return ;
    }
}