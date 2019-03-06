package google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115819/Summary-of-solutions-for-problems-%22reducible%22-to-LeetCode-378
public class SortedMatrixkth {
  // Binary search
  // Time complexity: n log(MAX-MIN), space complexity: O(1)
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;

    int l = matrix[0][0];               // minimum element in the matrix
    int r = matrix[n - 1][n - 1];       // maximum element in the matrix

    for (int cnt = 0; l < r; cnt = 0) { // this is the binary search loop
      int m = l + (r - l) / 2;

      for(int i = 0, j = n - 1; i < n; i++)  {
        while (j >= 0 && matrix[i][j] > m) j--;  // the pointer j will only go in one direction
        cnt += (j + 1);
      }

      if (cnt < k) {
        l = m + 1;   // cnt less than k, so throw away left half
      } else {
        r = m;       // otherwise discard right half
      }
    }

    return l;
  }

  // Heap based
  // Time complexity: O(max(n, k) * log n)
  // Space: O(n)
  public int findKthElement(int[][] matrix, int k){
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) ->  Integer.compare(matrix[a[0]][a[1]], matrix[b[0]][b[1]]));
    // Put all first col elements
    for(int i=0; i<matrix.length; i++)
      pq.offer(new int[]{i, 0});

    while(--k > 0 ){
      int[] p = pq.poll();

      if(++p[1]<matrix[0].length){
        pq.offer(p);
      }
    }

    return matrix[pq.peek()[0]][pq.peek()[1]];
  }

  public int findK(int[] arr, int k){
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for(int num : arr){
      pq.add(num);
      if(pq.size()>k)
        pq.poll();
    }

    return pq.peek();
  }

  @Test
  public void test(){
    int[][] input = new int[][]{
        {1,2,3,4,5},
        {6,7,8,9,10},
        {11,12,13,15,19},
        {29,32,43,44,50}};
    int position = 14;
    int expected = 15;
    assertEquals(expected, findKthElement(input, position));
  }

  @Test
  public void testFindK(){
    int[] arr = new int[]{1,2,3,8,5,9};
    int k = 4;
    int expected = 5;
    assertEquals(expected, findK(arr, k));
  }
}
