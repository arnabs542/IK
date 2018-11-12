package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RearrangeDuplicates {
  static void rearrange(int[] input){
    int write = -1;
    int read = 1;
    int previous = 0;
    while(read<input.length){

      if((input[read] > input[previous]) && write!=-1) {
        // If write is waiting, swap it
        int temp = input[read];
        input[read] = input[write];
        input[write] = temp;
        read=write;
        previous=read-1;
        write = -1;
      }
      else if(input[read] <= input[previous] && write==-1){
        write = read;
      }

      previous++;
      read++;

    }
  }

  public int re(int[] num){
    int write = 0;
    int read = 1;
    while(read<num.length){
      if(num[read]!=num[write]){
        write++;
        if(write!=read){
          int temp = num[read];
          num[read] = num[write];
          num[write] = temp;
        }
      }
      read++;
    }
    return write+1;
  }

  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {

        nums[++i] = nums[j];
      }
    }
    return i + 1;
  }

  public int removeDuplicates2(int[] nums) {
    int i = 0;
    for(int n : nums)
      if(i < 1 || n > nums[i - 1])
        nums[i++] = n;
    return i;
  }

  //Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
  public int removeTwiceDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    boolean duplicated = false;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
        duplicated = false;
      }else{
        if(!duplicated){
          i++;
          duplicated = true;
          continue;
        }
      }
    }
    return i + 2;
  }


  @Test
  public void testRearrangeWithDuplicates(){
    int[] input = {1,2,3,4,4,4,5,5,5,6,7,7};

    int[] expected = {1,2,3,4,4,5,5,6,7,7, 4,5,5,7};
    int uniques = removeTwiceDuplicates(input);
    System.out.println(Arrays.toString(input));
  }

  @Test
  public void testRearrange(){
    int[] input = {1,2,3,4,4,5,5,5,6,7,7};

    int[] expected = {1,2,3,4,5,6,7,4,5,5,7};
    int uniques = removeDuplicates(input);
    System.out.println(Arrays.toString(input));
    assertArrayEquals(new int[]{1,2,3,4,5,6,7,5,6,7,7}, input);
    assertEquals(7, uniques);
  }
}
