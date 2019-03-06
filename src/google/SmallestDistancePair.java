package google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/*
https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/439/
Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.

*/
public class SmallestDistancePair {

  public int smallestDistancePair2(int[] nums, int k) {
    Arrays.sort(nums);

    int lo = 0;
    int hi = nums[nums.length - 1] - nums[0];
    while (lo < hi) {
      int mi = (lo + hi) / 2;
      int count = 0, left = 0;
      for (int right = 0; right < nums.length; ++right) {
        while (nums[right] - nums[left] > mi) left++;
        count += right - left;
      }
      //count = number of pairs with distance <= mi
      if (count >= k) hi = mi;
      else lo = mi + 1;
    }
    return lo;
  }

  public int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);

    int n = nums.length;
    int l = 0;
    int r = nums[n - 1] - nums[0];

    while(l<r) {
      int cnt=0;
      int m = l + (r - l) / 2;

      for (int i = 0, j = 0; i < n; i++) {
        while (j < n && nums[j]<= nums[i]+m) j++;
        cnt += j - i - 1;
      }

      if (cnt < k) {
        l = m + 1;
      } else {
        r = m;
      }
    }

    return l;
  }

  public int smallestDistancePair1(int[] nums, int k) {
    Arrays.sort(nums);
    int l = 0, r = 1000000, m, best = -1;

    while (l <= r) {
      m = l + (r-l)/2;
      int cnt = pairsWithDistLessOrEq(m, nums);
      // System.out.println("m = " + m + ", cnt = " + cnt);
      if (cnt < k) {
        l = m+1;
      } else {
        best = m;
        r = m-1;
      }
    }
    return best;
  }

  private int pairsWithDistLessOrEq(int dist, int[] nums) {
    int result = 0;
    int l = 0, r = 0;
    while (r < nums.length) {
      while (r+1 < nums.length && nums[r+1] - nums[l] <= dist) {
        result += r-l+1;
        r++;
      }
      l++;
      if (r < l) r = l;
    }
    return result;
  }

  @Test
  public void test(){
    assertEquals(2, smallestDistancePair(new int[]{3,5,1,8,7},3));
  }
}
