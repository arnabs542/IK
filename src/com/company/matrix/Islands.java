package com.company.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.geeksforgeeks.org/find-number-of-islands/
public class Islands {
  int countIslands(int[][] nums){
    int m = nums.length;
    int n = nums[0].length;
    int count = 0;
    boolean[][] visited = new boolean[m][n];
    for(int i=0; i<m ; i++){
      for(int j=0;j<n;j++){
        if(nums[i][j]==1 && !visited[i][j]){
          DFS(nums, visited, i, j);
          ++count;
        }
      }
    }

    return count;
  }

  private void DFS(int[][] nums, boolean[][] visited, int i, int j) {
    int[] rowOffsets = {-1,-1,-1,0,0,1,1,1};
    int[] colOffsets = {-1,0,1,1,-1,-1,0,1};
    visited[i][j] = true;
    for(int k=0; k<8; k++){
      if(isValid(nums, i+rowOffsets[k], j+colOffsets[k], visited))
        DFS(nums, visited, i+rowOffsets[k], j+colOffsets[k]);
    }
  }

  private boolean isValid(int[][] nums, int i, int j, boolean[][] visited) {
    if(i>=0 && i<nums.length && j>=0 && j<nums[0].length && !visited[i][j] && nums[i][j]==1)
      return true;

    return false;
  }

  @Test
  public void test() {
    int[][] input =
        {{1, 1, 0, 1},
            {1, 0, 0, 1},
            {0, 0, 0, 0},
            {1, 0, 0, 0}};

    int expected = 3;
    assertEquals(expected, countIslands(input));
  }

}
