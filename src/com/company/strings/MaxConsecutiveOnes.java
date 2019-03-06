package com.company.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


// For questions with windows, keep on increasing window until you go beyond the window
// and then shrink it until the window becomes normal.
public class MaxConsecutiveOnes {

  public int longestOnes(int[] A, int K){
    int l =0, r=0;
    for(; r<A.length; r++){
      if(A[r]==0) K--;

      if(K < 0 && A[l++]==0){
        K++;
      }
    }

    return r-l;
  }

  // Longest window of substring with all unique chars
  public static int lengthLongestSub(String s){
    int l=0, r=0;
    int[] map = new int[26];
    int dup = 0;

    for(; r<s.length();){
      if(map[s.charAt(r++)-'a']++ > 0)
        dup++;

      if(dup>0){
        if(map[s.charAt(l++)-'a']-- > 1)
          dup--;
      }
    }

    return r-l;
  }

  /*
  Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
   */
  public static String minWindow(String s, String t){
    int d=Integer.MAX_VALUE;
    int counter=t.length();
    int head = 0;
    int[] map = new int[128];
    for(Character c : t.toCharArray())
      map[c]++;

    for(int r=0, l=0; r<s.length();){
      if(map[s.charAt(r++)]-- > 0) counter--;

      while(counter==0){
        if(r-l < d) {
          d = r - l;
          head = l;
        }
        if(map[s.charAt(l++)]++ == 0) counter++;
      }
    }

    return d == Integer.MAX_VALUE ? "" : s.substring(head, head+d);
  }

  @Test
  public void testLongestSubstring(){
    String input = "abcdefghijabcbbdefghxyzmn";
    int result = lengthLongestSub(input);
    assertEquals(11, result);
  }

  @Test
  public void testLongestConsecutiveOnes(){
    int[] input = {1,1,0,0,0,1,1,1};
    int k = 2;
    int expected = 5;
    assertEquals(expected, longestOnes(input, k));
  }
}
