package dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

//https://leetcode.com/problems/house-robber/
public class HouseRobber {
  public int rob(int[] nums){
    int incl = 0;
    int excl = 0;
    for(int i=0; i<nums.length; i++){
      int sum = Math.max(excl, nums[i]+incl);
      incl = excl;
      excl = sum;
    }

    return excl;
  }


  @ParameterizedTest
  @MethodSource("getArgs")
  public void test(int[] nums, int expected){
    assertEquals(expected, rob(nums));
  }

  public static Stream<Arguments> getArgs(){
    return Stream.of(
        Arguments.of(new int[]{1,2,3,4,5}, 9)
    );
  }

  // https://leetcode.com/problems/house-robber-ii/
  public int rob2(int[] nums) {
    if (nums.length == 1) return nums[0];
    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
  }

  private int rob(int[] num, int lo, int hi) {
    int i = 0, e = 0;
    for (int j = lo; j <= hi; j++) {
      int sum = Math.max(e, i + num[j]);
      i = e;
      e = sum;
    }
    return Math.max(i, e);
  }
  ///



}
