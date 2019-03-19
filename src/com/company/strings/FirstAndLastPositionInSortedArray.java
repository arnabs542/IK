package com.company.strings;
/*
https://leetcode.com/explore/featured/card/uber/289/array-and-string/1683/
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
public class FirstAndLastPositionInSortedArray {
  public static int lowerBound(int[] nums, int target) {
    int first = 0, last = nums.length;
    while(first < last) {
      int mid = first + (last - first) / 2;
      if(nums[mid] < target) {
        first = mid + 1;
      }
      else last = mid;
      System.out.println(String.format("Lower bound: mid:%d, first:%d. last:%d", mid, first, last));
    }
    return first;
  }

  public static int upperBound(int[] nums, int target) {
    int first = 0, last = nums.length;
    while(first < last) {
      int mid = first + (last - first) / 2;
      if(nums[mid] <= target) {
        first = mid + 1;
      }
      else last = mid;
      System.out.println(String.format("Upper bound: mid:%d, first:%d. last:%d", mid, first, last));
    }
    return first;
  }

  public int[] searchRange(int[] nums, int target) {
    int lb = lowerBound(nums, target);
    int ub = upperBound(nums, target);
    if(lb < nums.length && nums[lb] == target) {
      return new int[]{lb, ub - 1};
    }
    else return new int[]{-1, -1};
  }
}
