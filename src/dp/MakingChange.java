package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given n types of coin denominations of values v(1) < v(2) < ... < v(n) (all integers). Give an algorithm which makes change for an amount of money C with as few coins as possible.
 *
 *
 *
 * * Assume there are multiple coins of every denomination.
 *
 * * Assume v(1) = 1, (i.e. there is always a combination that leads to C).
 *
 * * There may be multiple ways of reaching C. We want a solution that leads to the method using least number of coins.
 *
 * * Input: C and Denominations Array
 *
 *
 *
 * In order to solve the problem you should try to:
 *
 * 1. Find the minimum number of coins needed (a correct, but inefficient recursive solution).
 *
 * 2. Optimize the solution with DP or caching.
 *
 * 3. Adjust the solution of part 2 so that instead of finding the minimum number of coins, find which coins those are.
 *
 * 4. Adjust the solution of part 3 to output all such combinations. (Hint: You'll need to do recursion on the DP table.)
 *
 *
 *
 * Input:
 *
 * Denominations: 1,2,3
 *
 * C: 4
 *
 * Output on two lines:
 *
 * 1,3
 *
 * 2,2
 *
 *
 *
 * Note that test-case output is for the extra-credit case. If you're not doing that (at first, you should ignore extra credit), then read the output appropriately.
 *
 *
 *
 * Note:
 *
 *
 *
 * This problem is under development according to IK standards. If you'd like to contribute, then please feel free to email soham@interviewkickstart.com
 *
 *
 *
 * Till we finish developing this problem, you can look at:
 *
 * https://leetcode.com/problems/coin-change/
 *
 * Solution with explanation: https://discuss.leetcode.com/topic/35720/easy-to-understand-recursive-dp-solution-using-java-with-explanations
 *
 * More efficient solution, but with no explanation: https://discuss.leetcode.com/topic/32475/c-o-n-amount-time-o-amount-space-dp-solution/4
 *
 * More solutions can be found in our Github Repo: https://github.com/InterviewKickstart/CodingProblemsIK/tree/master/DynamicProgramming
 *
 * No solution is provided for extra credit. Run it by the TA or the instructor :-) It's harder than what is expected in interviews.
 */
public class MakingChange {
  public static int minCoinsToMakeChange(int target, int[] coins){
    if(target==0)
      return 0;
    int minCoins = Integer.MAX_VALUE;
    for(int coin : coins){
      if(target >= coin)
        minCoins = Math.min(minCoins, 1+minCoinsToMakeChange(target-coin, coins));
    }

    System.out.println(String.format("Target:%d, MinCoin:%d", target, minCoins));
    return minCoins;
  }

  public void testMinChange(){
    int[] denoms = {1,2,3};
    int expected = 2;
    assertEquals(expected, minCoinsToMakeChange(4, denoms));
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int denomsLength = scanner.nextInt();
    int[] denoms = new int[denomsLength];
    int i=0;
    while(i<denoms.length && scanner.hasNext()){
      denoms[i++] = scanner.nextInt();
    }
    int target = scanner.nextInt();
    int expected = scanner.nextInt();
    int result = minCoinsToMakeChange(target, denoms);
    assertEquals(expected, result);
  }
}
