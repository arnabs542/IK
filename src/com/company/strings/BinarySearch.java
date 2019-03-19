package com.company.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearch {
  public int binarySearch(int[] input, int num){
    int l = 0;
    int r = input.length;
    while(l<r){
      int m = l+(r-l)/2;
      if(num == input[m])
        return m;
      if(num < input[m])
        r = m;
      else
        l = m+1;
    }

    return -1;
  }

  @Test
  public void testBinarySearch(){
    int[] input = new int[]{1,2,2,2,3,4,5,6,7,8,9};
    int num = 2;
    int expected = 1;
    assertEquals(expected, binarySearch(input, num));
  }
}
