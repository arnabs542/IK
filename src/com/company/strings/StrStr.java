package com.company.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StrStr {
  public int strStr(String haystack, String needle) {
    if(needle.isEmpty())
      return 0;

    for(int i=0, j=0; i<haystack.length()-needle.length()+1 ;i++){
      for(j=0; j<needle.length(); j++){
        if(haystack.charAt(i+j) != needle.charAt(j))
          break;
      }
      if(j==needle.length())
        return i;
    }

    return -1;
  }

  public int strStr1(String haystack, String needle) {
    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        if (j == needle.length()) return i;
        if (i + j == haystack.length()) return -1;
        if (needle.charAt(j) != haystack.charAt(i + j)) break;
      }
    }
  }

  @Test
  public void test(){
    assertEquals(2, strStr1("hello", "ll"));
  }
}
