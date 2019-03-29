package google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinWindow {
  public static String minWindowBack(String s, String t){
    int begin=0, end=0, d=Integer.MAX_VALUE, counter=t.length(), head = 0;
    int[] map = new int[128];
    for(Character c : t.toCharArray())
      map[c]++;

    while(end<s.length()){
      System.out.println("Array :"+Arrays.toString(map));
      if(map[s.charAt(end)]-- > 0){
        counter--;
      }
      end++;

      while(counter==0){
        if(end-begin < d) {
          d = end - begin;
          head = begin;
        }
        if(map[s.charAt(begin++)]++ == 0) counter++;
      }
    }

    return d == Integer.MAX_VALUE ? "" : s.substring(head, head+d);
  }

  static String minWindow(String strText, String strChars) {
    int count = Integer.MAX_VALUE;
    int i=0, head = 0;
    int[] map = new int[256];
    int k = strChars.length();
    for(char c : strChars.toCharArray())
      map[c] ++;
    for(int j=0; j<strText.length(); ){
      if(map[strText.charAt(j++)]-- > 0)
        k--;
      while(k==0){
        if(j-i<count){
          count = j-i;
          head = i;
        }
        if(map[strText.charAt(i++)]++ == 0)
          k++;

      }
    }

    return count==Integer.MAX_VALUE ? "":strText.substring(head, head+count);

  }

  public static String minWindow1(String s, String t) {
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

      if(minWindow[1]-minWindow[0]+1 > right-left-1){
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

  @ParameterizedTest
  @MethodSource("getArgs")
  public void test(String input1, String input2, String expected){
    assertEquals(expected, minWindow(input1, input2));
  }

  public static Stream<Arguments> getArgs(){
    return Stream.of(
        Arguments.of("ADOBECODEBANC", "ABC", "BANC"),
        Arguments.of("ABRACADABRA","BRC","BRAC")
    );
  }

}
