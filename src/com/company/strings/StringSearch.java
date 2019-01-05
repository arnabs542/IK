package com.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringSearch {
  public int naiveMatch(char[] s, char[] p){
    int sRunner=0, pRunner=0, start = 0;
    while(sRunner<s.length && pRunner<p.length){
      while(sRunner<s.length && pRunner<p.length && s[sRunner]==p[pRunner]){
        sRunner++; pRunner++;
        return start;
      }
      start++; sRunner = start; pRunner=0;
    }
    return -1;
  }

  public int kmp(char[] s, char[] p){
    return 0;
  }

  @Test
  public void test(){
    String input = "This is a super cool cool test";
    String pattern = "cool";
    int expected = 16;
    assertEquals(expected, naiveMatch(input.toCharArray(), pattern.toCharArray()));
  }
}
