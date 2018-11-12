package dp;

/**
 * Given a list of positive numbers, divide it into two equal halves
 *
 * Sol: We can create one array with half sum.
 */
public class TestForTie {
  public static boolean testRecursionMain(int[] nums){
    int sum = computeSum(nums);
    if(sum%2!=0)
      return false;

    return testRecursion(nums, 0, sum/2);
  }

  private static int computeSum(int[] nums) {
    int sum = 0;
    for(int num : nums){
      sum += num;
    }
    return sum;
  }

  static boolean testRecursion(int[] nums, int i, int sum){
    if(sum==0)
      return true;
    if(i==nums.length)
      return false;

    return sum-nums[i]>0 && testRecursion(nums, i+1, sum-nums[i]) || testRecursion(nums, i+1, sum);
  }

  static boolean testDP(int[] nums){
    boolean dp[][] = new boolean[computeSum(nums)/2+1][nums.length+1];
    for(int i=0;i<dp[0].length;i++)
      dp[0][i] = true;
    for(int i=0; i<dp.length;i++)
      dp[i][0] = false;
    for(int i=nums.length-1 ; i>0 ; i--){

    }
    return false;
  }
}
