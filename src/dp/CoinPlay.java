package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *     F(i, j)  = Max(Vi + min(F(i+2, j), F(i+1, j-1) ),
 *                    Vj + min(F(i+1, j-1), F(i, j-2) ))
 * Base Cases
 *     F(i, j)  = Vi           If j == i
 *     F(i, j)  = max(Vi, Vj)  If j == i+1
 *     REFERENCE:
 * 1. http://www.geeksforgeeks.org/dynamic-programming-set-31-optimal-strategy-for-a-game/
 * 2. https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/NPotGold.java
 * 3. http://stackoverflow.com/questions/22195300/understanding-solution-to-finding-optimal-strategy-for-game-involving-picking-po
 * 4. http://ideone.com/ug1DOx
 * 5. https://github.com/harishvc/challenges/blob/master/images/dp-game-play.jpg
 */
public class CoinPlay {
  // Complete the maxWin function below.
  static int maxWin(int[] v) {
    int n = v.length;
    int[][] table = new int[n][n];
    maxWinMemo(v, 0, n-1, table);
    return table[0][n-1];
  }


  static int maxWin(int[] v, int start, int end) {
    if (start > end)
      return 0;

    // If p1 chooses start and p2 can choose either start+1 (P1 has range start+2, end) or can choose end (P1 has range start+1, end-1)
    int minStart = Math.min(maxWin(v, start+2, end), maxWin(v, start+1, end-1));
    // If p1 chooses end and p2 chooses start (P1 range is start+1, end-1), p2 chooses end (p1 range is start, end-2)
    int minEnd = Math.min(maxWin(v, start+1, end-1), maxWin(v, start, end-2));

    return Math.max(v[start] + minStart, v[end] + minEnd);
  }

  static int maxWinMemo(int[] v, int start, int end, int[][] table) {
    if (table[start][end] != 0)
      return table[start][end];
    if(start==end)
      return table[start][end] = v[start];
    if(start+1==end)
      return table[start][end] = Math.max(v[start], v[end]);


    // If p1 chooses start and p2 can choose either start+1 (P1 has range start+2, end) or can choose end (P1 has range start+1, end-1)
    int minStart = Math.min(maxWinMemo(v, start+2, end, table), maxWinMemo(v, start+1, end-1, table));
    // If p1 chooses end and p2 chooses start (P1 range is start+1, end-1), p2 chooses end (p1 range is start, end-2)
    int minEnd = Math.min(maxWinMemo(v, start+1, end-1, table), maxWinMemo(v, start, end-2, table));

    return table[start][end] = Math.max(v[start] + minStart, v[end] + minEnd);
  }

  @Test
  public void testMaxWin(){
    int[] arr = {8,15,3,7};
    int result = maxWin(arr);
    assertEquals(22, result);
  }
}
