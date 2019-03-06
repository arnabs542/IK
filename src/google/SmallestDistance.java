package google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

/*
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
public class SmallestDistance {

  // Naive solution
  public int smallestDistancePairNaive(int[] nums, int k) {
    PriorityQueue<Integer> distances = new PriorityQueue<>(k);
    for(int i=0; i<nums.length-1; i++){
      for(int j=i+1; j<nums.length; j++){
        int diff = Math.abs(nums[i]-nums[j]);
        if(distances.isEmpty()){
          distances.add(diff);
        }else{
          if(distances.peek()>diff && distances.size()==k)
            distances.poll();

          distances.add(diff);
        }
      }
    }

    if(k>distances.size())
      return -1;
    int distance = 0;
    for(int i=0; i<k; i++){
      distance = distances.poll();
    }

    return distance;
  }

  //https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/109082/Approach-the-problem-using-the-%22trial-and-error%22-algorithm
  public int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);

    int n = nums.length;
    int l = 0;
    int r = nums[n - 1] - nums[0];

    for (int cnt = 0; l < r; cnt = 0) {
      int m = l + (r - l) / 2;

      for (int i = 0, j = 0; i < n; i++) {
        while (j < n && nums[j] <= nums[i] + m) j++;
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

  @Test
  public void test(){
    int[] input = {1,6,1};
    int expected = 5;
    assertEquals(expected, smallestDistancePair(input, 3));
  }
}
