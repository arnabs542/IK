package com.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PivotIndex {
  public int pivotIndex(int[] nums) {
    int[] sums = new int[nums.length];
    int total = 0;
    for(int i=0;i<nums.length;i++){
      total += nums[i];
      sums[i] = total;
    }
    int totalSum = sums[sums.length-1];
    for(int i=1;i<sums.length; i++){
      int rightHalfSum = totalSum - (sums[i]);
      int leftHalfSum = sums[i-1];

      if(rightHalfSum==leftHalfSum)
        return i;
    }

    return -1;
  }

  public int pivotIndex2(int[] nums) {
    if(nums.length==0 || nums.length==1)
      return nums.length-1;
    int total = 0;
    for(int i=0;i<nums.length; i++) total+=nums[i];
    int sum = 0;
    for(int i=0;i<nums.length; i++){
      if(sum*2 == total-nums[i])
        return i;
      sum += nums[i];
    }
    return -1;
  }

  @Test
  public void testPI(){
    int[] nums = {1,7,3,6,5,6};
    assertEquals(3, pivotIndex(nums));
  }
}