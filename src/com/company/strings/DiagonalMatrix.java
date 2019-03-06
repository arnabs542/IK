package com.company.strings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DiagonalMatrix {
  public int[] findDiagonalOrder1(int[][] matrix) {
    int maxRows = matrix.length;
    if(maxRows==0)
      return new int[0];
    int maxCols = matrix[0].length;

    int row = 0, col = 0;
    int[] result = new int[maxRows*maxCols];
    int index = 0;
    while(row>=0 && col>=0 && row<maxRows && col<maxCols){
      // Traversing diagonally up. Row decremnting, col incrementing
      while(row>=0 && col<maxCols){
        result[index++] = matrix[row][col];
        row--; col++;
      }
      row++;
      if(col>=maxCols) {
        row++; col--;
      }

      if(row<maxRows && col>=0)
        // Traversing diagonally down. Row incrementing, col decrementing
        while(col>=0 && row<maxRows){
          result[index++] = matrix[row][col];
          row++; col--;
        }
      col++;
      if(row>=maxRows){
        row--; col++;
      }
    }

    return result;
  }

  public List<Integer> spiralOrder2(int[][] matrix) {
    int rowMin = 0;
    int rowMax = matrix.length-1;
    int colMin = 0;
    int colMax = matrix[0].length-1;
    List<Integer> result = new ArrayList<Integer>();
    while(rowMin<=rowMax && colMin<=colMax){

      for(int i=colMin;i<=colMax; i++)
        result.add(matrix[rowMin][i]);
      rowMin++;

      for(int i=rowMin; i<=rowMax; i++)
        result.add(matrix[i][colMax]);
      colMax--;

      if(rowMin<=rowMax){
        for(int i=colMax; i>=colMin; i--)
          result.add(matrix[rowMax][i]);
        rowMax--;
      }


      if(colMin<=colMax){
        for(int i=rowMax; i>=rowMin; i--)
          result.add(matrix[i][colMin]);
        colMin++;
      }


    }
    return result;

  }

  public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix.length == 0) return new int[0];
    int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = matrix[r][c];
      if ((r + c) % 2 == 0) { // moving up
        if      (c == n - 1) { r++; }
        else if (r == 0)     { c++; }
        else            { r--; c++; }
      } else {                // moving down
        if      (r == m - 1) { c++; }
        else if (c == 0)     { r++; }
        else            { r++; c--; }
      }
    }
    return arr;
  }

  @Test
  public void testSpiral(){
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    int[] expected = {1,2,4,7,5,3,6,8,9};
    assertArrayEquals(expected, findDiagonalOrder(matrix));
  }
}
