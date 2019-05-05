package Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Max2 {
  public int maxSubArrayLen(int[] nums, int k) {
    if (nums == null || nums.length == 0)
      return 0;
    int n = nums.length;
    for (int i = 1; i < n; i++)
      nums[i] += nums[i - 1];
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1); // add this fake entry to make sum from 0 to j consistent
    int max = 0;
    for (int i = 0; i < n; i++) {
      if (map.containsKey(nums[i] - k))
        max = Math.max(max, i - map.get(nums[i] - k));
      if (!map.containsKey(nums[i])) // keep only 1st duplicate as we want first index as left as possible
        map.put(nums[i], i);
    }
    return max;
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  public void test(int expected, int[] nums, int k){
    assertEquals(expected, maxSubArrayLen(nums, k));
  }

  public static Stream<Arguments> getArgs(){
    return Stream.of(
        Arguments.of(4, new int[]{1, -1, 5, -2, 3}, 3)
    );
  }
}
