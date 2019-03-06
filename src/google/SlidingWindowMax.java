package google;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayDeque;
import org.junit.jupiter.api.Test;

class SlidingWindowMax {
  ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
  int [] nums;

  public void clean_deque(int i, int k) {
    // remove indexes of elements not from sliding window
    if (!deq.isEmpty() && deq.getFirst() == i - k)
      deq.removeFirst();

    // remove from deq indexes of all elements
    // which are smaller than current element nums[i]
    while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
      deq.removeLast();
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n * k == 0) return new int[0];
    if (k == 1) return nums;

    // init deque and output
    this.nums = nums;
    int max_idx = 0;
    for (int i = 0; i < k; i++) {
      clean_deque(i, k);
      deq.addLast(i);
      // compute max in nums[:k]
      if (nums[i] > nums[max_idx]) max_idx = i;
    }
    int [] output = new int[n - k + 1];
    output[0] = nums[max_idx];

    // build output
    for (int i  = k; i < n; i++) {
      System.out.println("Deque before is "+deq);
      clean_deque(i, k);
      System.out.println("Deque after is "+deq);
      deq.addLast(i);
      output[i - k + 1] = nums[deq.getFirst()];
    }
    return output;
  }

  @Test
  public void test(){
    int[] input = new int[]{1,3,-1,-3,5,3,6,7};
    int k = 3;
    int[] expected = {3,3,5,5,6,7};

    assertArrayEquals(expected, maxSlidingWindow(input, k));
  }
}