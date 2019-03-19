package Strings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/*
Generate Numeronyms

Given a string word of length n, generate all possible numeronyms.

What is a Numeronym?

A numeronym is a word where a number is used to form an abbreviation.

For a given string word, a numeronym is a string with few or more contiguous letters between the first letter and last letter of word replaced with a number representing the count of letters omitted. Only one set of contiguous letters are replaced by a number.

e.g. “L10n” is called a numeronym of the word “Localization”, where 10 stands for the count of letters between the first

letter 'L' and the last letter 'n' in the word.

Input Format:
Only one argument denoting input string word.

Output Format:
Return strings array containing all possible numeronyms of given string word.

You need not to worry about order of strings in your output array. For words = "aaaaa", arrays ["a2aa", "aa2a", "a3a"], ["a3a", "aa2a", "a2aa"] etc will be considered as valid answer.

In case of no possible numeronym string, return empty list.

Constraints:
String will be composed of characters [a-z], [A-Z], [0-9] only.
1 <= n <= 120 where n is length of given string word.

Sample Test Case:
Sample Input:
word = “nailed”
Sample Output:
["n4d", "na3d", "n3ed", "n2led", "na2ed", "nai2d"]

Explanation:
“n4d” is abbreviated string of given string “nailed” where “aile” string letters are omitted and replaced by count of letters i.e. 4.
“na3d” is abbreviated string of given string “nailed” where “ile” string letters are omitted and replaced by count of letters i.e. 3.
Similarly for remaining generate numeronyms.
  nailed
  i=0, j=5 n4d 4-1+1
  i=1, j=5 na3d 4-2+1
  i=0, j=4 3-1+1 n3ed
  i=0, j=3 2-1+1 n2led
  i=1, j=4 3-2+1 na2ed
  i=2, j=5 5-2+1 nai2d

 */
public class GenerateNeuronyms {


  String[] getAllNeuronyms(String word) {
    List<String> result = new ArrayList<>();
    int n = word.length();
    for (int i = 0; i < n-2; i++) {
      String prefix = word.substring(0, i+1);
      for (int j = n-1 ; j > i+2; j--) {
        int count = j - i - 1;
        String suffix = word.substring(j);
        result.add(prefix + count + suffix);
      }
    }

    return result.toArray(new String[0]);
  }

  @Test
  public void test(){
    String input = "nailed";
    String[] expected = new String[]{"n4d", "n3ed", "n2led", "na3d", "na2ed", "nai2d"};
    assertArrayEquals(expected, getAllNeuronyms(input));
  }
}
