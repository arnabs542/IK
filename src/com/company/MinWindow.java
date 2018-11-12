package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinWindow {
  public static String minWindow(String s, String t) {
    int left = 0, right = 0;
    int length = s.length();
    if(s.equals(t))
      return s;

    int[] minWindow = new int[2];
    minWindow[0] = 0; minWindow[1] = length-1;
    Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
    // Put all characters of pattern in map with 0 frequency
    for(char c : t.toCharArray()){
      frequencyMap.put(c,0);
    }

    while(right<length){
      // Increase the right pointer until we find all chars
      while(right<length && !isMapFull(frequencyMap)){
        char c = s.charAt(right);
        if(frequencyMap.get(c)!=null){
          Integer value = frequencyMap.get(c);
          frequencyMap.put(c, ++value);

        }
        right++;
      }

      // Increase the left pointer until we have a character with 0 frequency
      // This will be one of the candidates. Store the candidate and then continue next iteration.
      while(left<right && isMapFull(frequencyMap)){
        char c = s.charAt(left);
        if(frequencyMap.get(c)!=null){
          Integer value = frequencyMap.get(c);
          frequencyMap.put(c, value-1);
        }
        left++;
      }

      if(minWindow[1]-minWindow[0] > right-left){
        minWindow[0] = left-1;
        minWindow[1] = right;
      }
    }
    if(minWindow[1]-minWindow[0]==length-1)
      return "";

    return s.substring(minWindow[0], minWindow[1]);
  }

  private static boolean isMapFull(Map<Character, Integer> map){
    for(int value : map.values()){
      if(value<=0)
        return false;
    }

    return true;
  }

  public Collection<String[]> data() {
    return Arrays.asList(new String[][] {
        {"ab", "a", "a"}, {"a","a","a"}, { "ADOBECODEBANCZ", "Z", "Z" }, { "ADOBECODEBANC", "ABC", "BANC" } });
  }

  @Test
  public void testMinWindow(){
    for(String[] testCase: data()){
      String testString = testCase[0];
      String pattern = testCase[1];
      String result = minWindow(testString, pattern);
      assertEquals(testCase[2], result);
    }
  }

}
