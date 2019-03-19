package Strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


/*
Longest Substring With Exactly Two Distinct Characters





Problem Statement:



Given a string s of length n, find the length of the longest substring ss, that contains exactly two distinct characters.

There will be t test cases.



Input/Output Format For The Function:



Input Format:



There is only one argument s, denoting the input string.



Output Format:



Return an integer len, denoting length of ss.

(If there are no such substrings, then return 0)



Input/Output Format For The Custom Input:



Input Format:



The first line of the input should contain an integer t, denoting no. of test cases.

In the next t lines, ith line should contain a string si, denoting an input string s for ith test case.



If t = 3, s for 1st test case = “ababababa”, s for 2nd test case = “e” and s for 3rd test case = “baabcbab”, then input should be:



3

ababababa

e

baabcbab



Output Format:



There will be t lines for output, where ith line contains an integer leni, denoting resultant value len for ith test case.



For input t = 3, s for 1st test case = “ababababa”, s for 2nd test case = “e” and s for 3rd test case = “baabcbab”, output will be:



9

0

4



Constraints:



1 <= t <= 80
1 <= n <= 10^5
s may contain upper case alphabets, lower case alphabets and numerical values.


Sample Test Cases:



Sample Input 1:



2

eceba

abcdef



Sample Output 1:



3

2



Explanation 1:



In first case, 'ece' is the largest substring with exactly 2 distinct characters.

In second case, 'ab' is the largest substring with exactly 2 distinct characters. Also, 'bc', 'cd', 'de', 'ef' can be considered as substring with exactly 2 distinct characters.



Sample Input 2:



3

ababababa

e

baabcbab



Sample Output 2:



9

0

4



Explanation 2:



In first case, whole string 'ababababa' is the largest substring with exactly 2 distinct characters.

In second case, there is no substring with exactly 2 distinct characters.

In third case, 'baab' is the largest substring with exactly 2 distinct characters.


 */
public class LongestSubstringWithTwoDistinctChars {
  static int getLongestSubstringLengthExactly2DistinctChars(String str) {
    int[] map = new int[256];
    int k = 2, i = 0, j=0;
    if(str.length()==1)
      return 0;
    while(i<str.length()){
      if(map[str.charAt(i++)]++ == 0)
        k--;
      if(k<0){
        if(map[str.charAt(j++)]-- == 1)
          k++;
      }
    }
    System.out.println("K="+k);
    return k<=0 ? i-j : 0;
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  public void test(String input, int expected){
    assertEquals(expected, getLongestSubstringLengthExactly2DistinctChars(input));
  }

  private static Stream<Arguments> getArgs(){
    return Stream.of(
        Arguments.of("aaaa",0),
        Arguments.of("abcd", 2),
        Arguments.of("abbbcd", 4)
        );
  }

}
