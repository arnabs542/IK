package com.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DiagonalMatrix {
  public int[] findDiagonalOrder(int[][] matrix) {
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

  @Test
  public void testSpiral(){
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    int[] expected = {1,2,4,7,5,3,6,8,9};
    assertArrayEquals(expected, findDiagonalOrder(matrix));
  }
}
