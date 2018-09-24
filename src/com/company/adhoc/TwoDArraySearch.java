package com.company.adhoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoDArraySearch {
  /*
   * Complete the isPresent function below.
   */
  static String isPresent(int[][] arr, int x) {
    /*
     * Write your code here.
     */
    // set indexes for
    // bottom left element
    int m = arr.length;
    int n = arr[0].length;
    int i = m - 1, j = 0;
    while (i >= 0 && j < n)
    {
      if (arr[i][j] == x)
        return "present";
      if (arr[i][j] > x)
        i--;
      else // if mat[i][j] < x
        j++;
    }

    return "not present";
  }

  @Test
  public void testArray(){
    int[][] arr = new int[][]{{1,2,3,12},{4,5,6,45},{7,8,9,78}};
    assertEquals("present", isPresent(arr, 6));
    assertEquals("not present", isPresent(arr, 10));
  }
}
