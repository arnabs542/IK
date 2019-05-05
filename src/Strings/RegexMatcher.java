package Strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/*
Regex Matcher





Problem Statement:



Given a text string containing characters only from lowercase alphabetic characters and a pattern string containing characters only from lowercase alphabetic characters and two other special characters '.' and '*'.



Your task is to implement pattern matching algorithm that returns true if pattern is matched with text otherwise returns false. The matching must be exact, not partial.



Explanation of the special characters:



1) '.' - Matches a single character from lowercase alphabetic characters.

2) '*' - Matches zero or more preceding character. It is guaranteed that '*' will have one preceding character which can be any lowercase alphabetic character or special character '.'. But '*' will never be the preceding character of '*'. (That means "**" will never occur in the pattern string.)



'.' = "a", "b", "c", ... , "z".

a* = "a","aa","aaa","aaaa",... or empty string("").

ab* = "a", "ab", "abb", "abbb", "abbbb",...



Input Format:



There are two arguments, first one is string denoting text and second one is string denoting pattern.



Output Format:



Return boolean, true if text and pattern matches exactly, otherwise return false.



Constraints:



0 <= text length, pattern length <= 1000

Text string containing characters only from lowercase alphabetic characters.

Pattern string containing characters only from lowercase alphabetic characters and two other special characters '.' and '*'

In pattern string, It is guaranteed that '*' will have one preceding character which can be any lowercase alphabetic character or special character '.'. But '*' will never be the preceding character of '*'.



Sample Test Cases:



Sample Test Case 1:



Sample Input 1:



text = "abbbc" and pattern = "ab*c"



Sample Output 1:



true



Explanation 1:



Given pattern string can match:

"ac", "abc", "abbc", "abbbc", "abbbbc", ...



Sample Test Case 2:



Sample Input 2:



text = "abcdefg" and pattern = "a.c.*.*gg*"



Sample Output 2:



true



Explanation 2:



".*" in pattern can match  "", ".", "..", "...", "....", ...

"g*" in pattern can match "", "g", "gg", "ggg", "gggg", ...



Now, consider:

   '.' at position 2 as 'b',

   '.*'  at position {4,5} as "...",

   '.*' at position {6,7} as "" and

   [g*] at position {8,9} as "".



So, "a.c.*gg*" = "abc...g" where we can write "..." as "def". Hence, both matches.



Sample Test Case 3:



Sample Input 3:



text = "abc" and pattern = ".ab*.."



Sample Output 3:



false



Explanation 3:



If we take 'b*' as "" then also, length of the pattern will be 4 (".a.."). But, given text's length is only 3. Hence, they can not match.




 */
public class RegexMatcher {
  public boolean isMatch(String s, String p) {
    return isMatch(s.toCharArray(), p.toCharArray(), 0, 0, new Boolean[s.length()+1][p.length()+1]);
  }

  public boolean isMatch(char[] s, char[] p, int i, int j){
    if(j==p.length)
      return i==s.length;

    boolean firstMatch = false;
    if(i<s.length && (s[i]==p[j] || p[j]=='.'))
      firstMatch = true;

    if(j+1<p.length && p[j+1]=='*'){
      return (firstMatch && isMatch(s, p, i+1, j)) || isMatch(s, p, i, j+2);
    }else
      return firstMatch && isMatch(s, p, i+1, j+1);
  }

  public boolean isMatch(char[] s, char[] p, int i, int j, Boolean[][] memo){
    if(memo[i][j]!=null)
      return memo[i][j];

    if(j==p.length)
      return i==s.length;

    boolean firstMatch = false;
    boolean result = false;
    if(i<s.length && (s[i]==p[j] || p[j]=='.'))
      firstMatch = true;

    if(j+1<p.length && p[j+1]=='*'){
      memo[i][j] = (firstMatch && isMatch(s, p, i+1, j, memo)) || isMatch(s, p, i, j+2, memo);
    }else
      memo[i][j] = firstMatch && isMatch(s, p, i+1, j+1, memo);

    return memo[i][j];
  }

  public boolean isMatchdp(char[] s, char[] p){
    boolean[][] memo = new boolean[s.length+1][p.length+1];
    memo[s.length][p.length] = true;

    for(int i=s.length; i>=0; i--){
      for(int j=p.length-1; j>=0; j--){
        boolean firstMatch = false;
        if(i<s.length && (s[i]==p[j] || p[j]=='.'))
          firstMatch = true;

        if(j+1<p.length && p[j+1]=='*'){
          memo[i][j] = (firstMatch && memo[i+1][j]) || memo[i][j+2];
        }else
          memo[i][j] = firstMatch && memo[i+1][j+1];
      }
    }


    return memo[0][0];
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  public void test(String s, String p, boolean expected){
    assertEquals(expected, isMatchdp(s.toCharArray(), p.toCharArray()));
  }

  public static Stream<Arguments> getArgs(){
    return Stream.of(
        Arguments.of("aa","a*", true),
        Arguments.of("aa",".*", true),
        Arguments.of("","a*", true),
        Arguments.of("","c*c*", true),
        Arguments.of("aaaa","aaa", false)
    );
  }

}
