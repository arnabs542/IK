package com.company.strings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    int rows = matrix.length;
    List<Integer> output = new ArrayList<>();
    if(rows==0)
      return new ArrayList<Integer>();
    int cols = matrix[0].length;
    int rowStart = 0;
    int rowEnd = rows-1;
    int colStart = 0;
    int colEnd = cols-1;
    while(rowEnd>=rowStart && colEnd>=colStart){
      for(int i=colStart;i<=colEnd;i++){
        output.add(matrix[rowStart][i]);
      }
      rowStart++;
      for(int i=rowStart; i<=rowEnd; i++){
        output.add(matrix[i][colEnd]);
      }
      colEnd--;
      if(rowStart<=rowEnd) {
        for (int i = colEnd; i >= colStart; i--) {
          output.add(matrix[rowEnd][i]);
        }
      }
      rowEnd--;

      if(colStart<=colEnd) {
        for (int i = rowEnd; i >= rowStart; i--) {
          output.add(matrix[i][colStart]);
        }
      }
      colStart++;
    }

    return output;
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

  @Test
  public void testSpiral(){
    List expected = Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7);
    int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    assertEquals(expected, spiralOrder2(matrix));
  }
}