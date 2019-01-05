package dp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Problem Statement:
 *
 *
 *
 * Given a phone keypad as shown below:
 *
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *   0
 *
 *
 * How many different phone numbers of given length can be formed starting from the given digit? The constraint is that the movement from one digit to the next is similar to the movement of the Knight in a chess game.
 *
 * For eg. if we are at 1 then the next digit can be either 6 or 8 if we are at 6 then the next digit can be 1, 7 or 0.
 *
 * Repetition of digits are allowed - 1616161616 is a valid number.
 * The problem requires us to just give the count of different phone numbers and not necessarily list the numbers.
 * Find a polynomial-time solution, based on Dynamic Programming.
 *
 *
 * Input Format:
 *
 *
 *
 * You will be given 2 integer values, startdigit and phonenumberlength, denoting starting digit and the required length respectively.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return a long integer denoting the total number of possible numbers that can be formed.
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 0 <= startdigit <= 9
 *
 * 1 <= phonenumberlength <= 30
 *
 *
 *
 * Sample Test Case:
 *
 *
 *
 * Sample Input-1:
 *
 *
 *
 * startdigit = 1
 *
 * phonenumberlength = 2
 *
 *
 *
 * Sample Output-1:
 *
 *
 *
 * 2
 *
 *
 *
 * Explanation-1:
 *
 *
 *
 * Two possible numbers of length 2: 16, 18
 *
 *
 *
 * Sample Input-2:
 *
 *
 *
 * startdigit = 1
 *
 * phonenumberlength = 3
 *
 *
 *
 * Sample Output-2:
 *
 *
 *
 * 5
 *
 *
 *
 * Explanation-2:
 *
 *
 *
 * Possible numbers of length 3: 160, 161, 167, 181, 183
 *  * 1 2 3
 *  * 4 5 6
 *  * 7 8 9
 *  *   0
 */
public class KnightsTour {
  static List<List<Integer>> numList = new ArrayList<>();
  static{
    numList.add(Arrays.asList(4, 6));
    numList.add(Arrays.asList(6,8));
    numList.add(Arrays.asList(7, 9));
    numList.add(Arrays.asList(4, 8));
    numList.add(Arrays.asList(0, 3, 9));
    numList.add(Arrays.asList());
    numList.add(Arrays.asList(0, 1, 7));
    numList.add(Arrays.asList(2, 6));
    numList.add(Arrays.asList(1, 3));
    numList.add(Arrays.asList(2, 4));
  }

  static long numPhoneNumbers(int startdigit, int phonenumberlength) {
    long[][] table = new long[10][phonenumberlength];
    for(long[] row : table){
      Arrays.fill(row, -1);
    }
    return numPhoneNumbers(startdigit, phonenumberlength, table);
  }

  static long numPhoneNumbers(int startdigit, int phonenumberlength, long[][] table) {
    long numPhones = table[startdigit][phonenumberlength-1];
    if(numPhones!=-1)
      return numPhones;

    if(phonenumberlength==0 || phonenumberlength==1)
      return table[startdigit][phonenumberlength-1] = phonenumberlength;

    long results = 0;
    List<Integer> pairs = numList.get(startdigit);
    for(int pair : pairs){
      results += numPhoneNumbers(pair, phonenumberlength-1);
    }

    table[startdigit][phonenumberlength-1] = results;
    return results;
  }

  @Test
  public void testKnightsTour(){
    long expected = 5;
    assertEquals(expected, numPhoneNumbers(1, 3));

  }

}
