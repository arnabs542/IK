package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZeroes {
  public void moveZeroesBest(int[] nums) {
    for(int i=0, j=1; j<nums.length; j++) {
      if(nums[i] == 0){
        if(nums[j] == 0){
          // do nothing and move the j pointer
        }else{
          int temp = nums[j];
          nums[j] = nums[i];
          nums[i] = temp;
          i++;
        }
      }else{
        i++;
      }
    }
  }

  public void moveZeroes(int[] nums) {
    for(int i = 0, j = 0; j < nums.length; j++) {
      if(nums[j] != 0) {
        swap(nums, i, j);
        i++;
      }
    }
  }

  public void moveZeroes2(int[] nums) {
    int zero = 0;
    int non = 0;
    int n = nums.length;
    while(non<n && zero<n){
      while(zero<n && nums[zero]!=0) zero++;
      non = zero+1;
      while(non<n && nums[non]==0) non++;
      if(non<n && zero<n && non>zero) swap(nums, non, zero);
    }
  }

  private void swap(int[] nums, int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  @Test
  public void test(){
    int[] input = {1,0,2,3,4};
    int[] expected = {1,2,3,4,0};
    moveZeroes(input);
    assertArrayEquals(expected, input);
  }
}
