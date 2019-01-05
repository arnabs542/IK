package com.company.strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateArray {
  public void rotate(int[] nums, int k) {
    int n = nums.length;

    // Rotate only once for elements of k relative to the length.
    k = k%n;

    // Reverse n chars
    reverse(nums, 0, n-1);

    // Reverse initial 0,k chars
    reverse(nums, 0, k-1);

    // reverse the k-n chars
    reverse(nums, k, n-1);
  }

  public void reverse(int[] arr, int start, int end){
    while(start<end){
      int tmp = arr[start];
      arr[start] = arr[end];
      arr[end] = tmp;
      start++;
      end--;
    }
  }

  @Test
  public void rotate(){
    int[] input = {1,2,3,4,5,6,7};
    int[] expected = {5,6,7,1,2,3,4};
    rotate(input, 3);
    System.out.println("Rotated is "+Arrays.toString(input));
    assertArrayEquals(expected, input);
  }
  @Test
  public void testReverse(){
    int[] input = {1,2,3,4,5,6,7};
    int[] expected = {1,2,7,6,5,4,3};
    reverse(input, 2, input.length-1);
    System.out.println(Arrays.toString(input));
    assertArrayEquals(expected, input);
  }
}
