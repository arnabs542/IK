package com.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWords {


  String reverseWords(String input){
    if(input==null)
      return null;

    char[] inputArr = input.toCharArray();
    int n = inputArr.length;

    // Reverse the whole string
    reverse(inputArr, 0, n-1);

    // Reverse the words
    reverseWords(inputArr, n);

    // Cleanup spaces
    return cleanupSpaces(inputArr);
  }

  void reverseWords(char[] a, int n) {
    int i = 0, j = 0;

    while (i < n) {
      while (i < j || i < n && a[i] == ' ') i++; // skip spaces
      while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
      reverse(a, i, j - 1);                      // reverse the word
    }
  }

  String cleanupSpaces(char[] a){
    int n = a.length;
    int i = 0, j=0;
    while(j<n){
      while(j<n && a[j]==' ') j++;
      while(j<n && a[j]!=' ') a[i++] = a[j++];
      while(j<n && a[j]==' ') j++;
      if(j<n) a[i++] = ' ';
    }

    return new String(a).substring(0, i);
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
    String input = "the sky    is blue";
    String expected = "blue is sky the";
    assertEquals(expected, reverseWords(input));
  }
}
