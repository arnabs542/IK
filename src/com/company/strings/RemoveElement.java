package com.company.strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RemoveElement {
  public int removeElement(int[] nums, int val) {
    int i = 0;
    int count = 0;
    for(int j=0; j<nums.length; j++){
      if(nums[j]!=val){
        nums[i++] = nums[j];
      }
    }

    return i;

  }
  @Test
  public void testRemove(){

    int[] input = {0,1,2,2,3,0,4,2};
    removeElement(input,2);
    System.out.println(Arrays.toString(input));
    assertArrayEquals(new int[]{0,1,3,0,4,0,4,2}, input);
  }
}
