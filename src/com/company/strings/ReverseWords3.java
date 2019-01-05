package com.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWords3 {
  public String reverseWords(String s) {
    char[] a = s.toCharArray();
    int n = s.length();
    int i=0, j=0;

    while(i<n){
      // Skip spaces
      while(i<j || i<n && a[i]==' ') i++;
      // Skip non spaces
      while(j<i || j<n && a[j] != ' ') j++;
      // reverse word
      reverse(a, i, j-1);
      // Skip spaces. Start again
    }

    return new String(a);
  }

  public void reverse(char[] input, int start, int end){
    while(start<end){
      char tmp = input[start];
      input[start++] = input[end];
      input[end--] = tmp;
    }
  }

  @Test
  public void testReverse(){
    String input = "Let's take LeetCode contest";
    String expected = "s'teL ekat edoCteeL tsetnoc";
    assertEquals(expected, reverseWords(input));
  }

}
