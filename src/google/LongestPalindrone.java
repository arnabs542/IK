package google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LongestPalindrone {
  int maxLen = 0;
  int lo = 0;

  public String longestPalindrome(String s) {
    if(s==null || s.length()<2)
      return s;

    int n = s.length();
    for(int i=1; i<n-1; i++){
      getMaxPalindrone(s, i, i);
      getMaxPalindrone(s, i, i+1);
    }

    return s.substring(lo, lo+maxLen);
  }

  public void getMaxPalindrone(String s, int i, int j){
    while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
      i--; j++;
    }
    if (maxLen < j - i - 1) {
      lo = i + 1;
      maxLen = j - i - 1;
    }
  }

  @Test
  public void test(){
    String input = "madamimadam";
    String expected = "madamimadam";
    assertEquals(expected, longestPalindrome(input));
  }
}
