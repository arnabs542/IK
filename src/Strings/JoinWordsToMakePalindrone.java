package Strings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/*
Join Words To Make A Palindrome



Problem Statement:



Given a list of strings words, of size n, check if there is any pair of words, that can be joined (in any order) to form a palindrome then return the pair of words forming palindrome.



Input Format:



Only argument for function, list of strings words.



Output Format:



Return a pair of words (i.e. list of string result of size 2 such that result[0] + result[1] is a palindrome).

In case of multiple answer return any one of them.

In case of no answer return list [“NOTFOUND”, “DNUOFTON”].



Constraints:



Length l for each word of words list, 1<= l <= 30.

Size of list words n, 2 <= n <= 20000.

Characters for each word can be from [a-z], [A-Z], [0-9].



Sample Test Case:



Sample Input 1:



words = [ “bat”, “tab”, “zebra” ]



Sample Output 1:



result = [ “bat”, “tab” ]



Explanation 1:



As “bat” + “tab” = “battab”, which is a palindrome.



Sample Input 2:



words = [ “ant”, “dog”, “monkey” ]



Sample Output 2:



result = [ “NOTFOUND”, “DNUOFTON” ]



Explanation 2:



As for each 6 combinations of string of words, there is no single generated word which is a palindrome hence result list will be [ “NOTFOUND”, “DNUOFTON” ].


 */
public class JoinWordsToMakePalindrone {

  static String[] join_words_to_make_a_palindrome(String[] words) {
    /*
     * Write your code here.
     */
    String[] result = new String[]{"NOTFOUND","DNUOFTON"};
    for(String word1 : words){
      int m = word1.length();
      for(String word2 : words){
        if(word1.equals(word2))
          continue;

        String pal = word1+word2;
        int n = pal.length();
        int i=0, j=n-1;
        while(i<j && pal.charAt(i++)==pal.charAt(j--));
        if(j==i || i-j==1){
          result[0] = word1;
          result[1] = word2;
          return result;
        }
      }
    }
    return result;
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  public void test(String[] input, String[] expected){
    assertArrayEquals(expected, join_words_to_make_a_palindrome(input));
  }

  private static Stream<Arguments> getArgs(){
    return
        Stream.of(
            Arguments.of(new String[]{"abcd","dcba"}, new String[]{"abcd","dcba"}),
            Arguments.of(new String[]{"abcd","cba"}, new String[]{"abcd","cba"}),
            Arguments.of(new String[]{"a","dcba"}, new String[]{"FOUND","DNUOFTON"}),
            Arguments.of(new String[]{"indee","addf","deedni"}, new String[]{"indee","deedni"})
    );
  }

}
