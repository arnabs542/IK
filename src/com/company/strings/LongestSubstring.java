package com.company.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {

  public static int lengthOfLongestSubstring(String s) {
    int longest = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int left = 0, right = 0; right < s.length() && left <= right; right++) {

      int length = right - left;
      if (length > longest)
        longest = length;
      char c = s.charAt(right);
      if (map.containsKey(c)) {
        left = map.get(c) + 1;
      }

      map.put(c, right);
    }

    return longest;
  }

  @Test
  public void testLongestSubstring(){
    String input = "abcabcbb";
    int result = lengthOfLongestSubstring(input);
    assertEquals(3, result);
  }
}
