package google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import org.junit.jupiter.api.Test;

public class MaxConsecutives2 {
  public int findMaxConsecutiveOne(int[] nums) {
    int flipped = 0;
    int max = 0;
    int i=0, j=0, k=0;
    while(j<nums.length){
      while(j<nums.length && nums[j]==0){
        j++;
        flipped++;
      }

      if(flipped==1)
        k=j;
      else if(flipped==0)
        i = j;
      else i = k;

      flipped = 0;
      while(j<nums.length && nums[j]==1){
        max = Math.max(max, j-i+1);
        j++;
      }

    }
    return max;
  }

  public int findMaxConsecutiveOnesGood(int[] nums) {

    if(nums == null || nums.length == 0){
      return 0;
    }

    boolean fliped = false;
    int left = 0;
    int right = 0;
    int flipedLocation = 0;
    int result = Integer.MIN_VALUE;

    for(right = 0;right < nums.length;right++){
      if(nums[right] == 1){
        continue;
      }

      if(nums[right] == 0){
        if(fliped == false){
          fliped = true;
          flipedLocation = right;
          continue;
        }else{
          result = Math.max(result, right - left);
          // fliped = false;
          left = flipedLocation + 1;
          flipedLocation = right;
        }
      }
    }

    result = Math.max(result, right - left);

    return result;

  }

  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0, zero = 0, k = 1; // flip at most k zero
    for (int l = 0, h = 0; h < nums.length; h++) {
      if (nums[h] == 0)
        zero++;
      while (zero > k)
        if (nums[l++] == 0)
          zero--;
      max = Math.max(max, h - l + 1);
    }
    return max;
  }

  /*
  Now let's deal with follow-up, we need to store up to k indexes of zero within the window [l, h] so that we know where
   to move l next when the window contains more than k zero. If the input stream is infinite, then the output could be
   extremely large because there could be super long consecutive ones. In that case we can use BigInteger for all
   indexes. For simplicity, here we will use int Time: O(n) Space: O(k)
   */
  public int findMaxConsecutiveOnesFollowup(int[] nums) {
    int max = 0, k = 1; // flip at most k zero
    Queue<Integer> zeroIndex = new LinkedBlockingDeque<>();
    for (int l = 0, h = 0; h < nums.length; h++) {
      if (nums[h] == 0)
        zeroIndex.offer(h);
      if (zeroIndex.size() > k)
        l = zeroIndex.poll() + 1;
      max = Math.max(max, h - l + 1);
    }
    return max;
  }

  public int findMaxConsecutiveOnes(int[] nums, int k){
    int i=0, j=0;
    while(j<nums.length){
      if(nums[j++]==0)
        k-- ;
      if(k<0 && nums[i++]==0){
        k++;
      }
    }
    return j-i;
  }

  @Test
  public void test(){
    int[] nums = {1,1,1,0,1,1,0,0,1,1,1,1};
    int expected = 12;
    int k = 3;
    assertEquals(expected, findMaxConsecutiveOnes(nums, k));
  }
}
