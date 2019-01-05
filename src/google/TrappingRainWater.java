package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrappingRainWater {
  public int trap(int[] A){
    int left=0;
    int right=A.length-1;
    int result=0;
    int leftmax=0;
    int rightmax=0;
    while(left<=right){
      leftmax=Math.max(leftmax,A[left]);
      rightmax=Math.max(rightmax,A[right]);
      if(leftmax<rightmax){
        result+=(leftmax-A[left]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
        left++;
      }
      else{
        result+=(rightmax-A[right]);
        right--;
      }
    }
    return result;
  }

  // 7 ms
  public int trapBest(int[] height) {
    if (height == null || height.length <= 2) {
      return 0;
    }

    int left = 0;
    int right = height.length - 1;

    int leftHighest = Integer.MIN_VALUE;
    int rightHighest = Integer.MIN_VALUE;

    int count = 0;

    while (left < right) {
      if (leftHighest < rightHighest) {
        while (left < right && leftHighest >= height[left]) {
          count += leftHighest - height[left];
          left++;
        }
        if (left >= right) break;
        else leftHighest = height[left];
      } else {

        while (left < right && rightHighest >= height[right]) {
          count += rightHighest - height[right];
          right--;
        }
        if (left >= right) break;
        else rightHighest = height[right];
      }
    }

    return count;
  }

  public int trap3(int A[]) {
    int n = A.length;
    int left=0; int right=n-1;
    int res=0;
    int maxleft=0, maxright=0;
    while(left<=right){
      if(A[left]<=A[right]){
        if(A[left]>=maxleft) maxleft=A[left];
        else res+=maxleft-A[left];
        left++;
      }
      else{
        if(A[right]>=maxright) maxright= A[right];
        else res+=maxright-A[right];
        right--;
      }
    }
    return res;
  }

  public int trap2(int[] height) {
    int curr = 0;
    int n = height.length;
    if(n<3)
      return 0;

    while(height[curr]==0)
      curr++;
    int start = curr;
    int water = 0;
    int currentStore = 0;
    while(++curr<n){
      if(height[start] > height[curr]) {
        currentStore += height[start] - height[curr];
        if(curr+1==n && curr-start>1){
          currentStore = 0;
          start++;
          curr = start;
        }
      }
      else{
        start = curr;
        water += currentStore;
        currentStore = 0;
      }
    }
    return water;
  }

  @Test
  public void test(){
    int expected = 1;
    int[] input = new int[]{0,1,0,2,1,0,1,3,1,1,3,1};
    int[] input2 = new int[]{0,0,0};
    assertEquals(9, trap(input));
    assertEquals(0,trap(input2));
  }
}
