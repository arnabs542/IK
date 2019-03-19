package google;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LongestSubstring {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int[] count = new int[256];
    int num = 0, i = 0, res = 0;
    for (int j = 0; j < s.length(); j++) {
      if (count[s.charAt(j)]++ == 0) num++;
      if (num > k) {
        while (--count[s.charAt(i++)] > 0);
        num--;
      }
      res = Math.max(res, j - i + 1);
    }
    return res;
  }

  public int lengthOfLongestSubstringKDistinctBest(String s, int k) {
    int[] nums = new int[256];
    int i=0, j=0;
    for(;j<s.length();){
      if(nums[s.charAt(j++)]++ == 0)
        k--;
      if(k<0){
        if(--nums[s.charAt(i++)] == 0)
          k++;
      }
    }
    return j-i;
  }

  public int lengthOfLongestSubstringKDistinctMine(String s, int k) {
    int l = 0, r = 0;
    int max = 0;
    if(k<=0 || s.length()==0)
      return 0;

    Map<Character, Integer> map = new HashMap<>();
    while(r<s.length()){
      // Increase the window size while map size is less than equal to k
      while(r<s.length() && map.size()<=k){
        char rc = s.charAt(r);
        System.out.println(rc);
        int rCount = map.getOrDefault(rc, 0);
        map.put(rc, ++rCount);
        System.out.println(String.format("rightChar=%s, map=%s, maxLength=%d", rc, map, r-l+1));
        if(map.size()<=k)
          max = Math.max(max, r-l+1);
        r++;
      }

      // Shrink size while size > k
      while(l<r && map.size()>k){
        char lc = s.charAt(l);
        int freq = map.get(lc);
        System.out.println(String.format("leftChar=%s, map=%s", lc, map));
        if(freq==1)
          map.remove(lc);
        else
          map.put(lc, --freq);
        l++;
      }
    }

    return max;
  }

  @Test
  public void test(){
    String input = "aaaabcddddd";
    int expected = 6;
    assertEquals(expected, lengthOfLongestSubstringKDistinctBest(input, 2));
  }
}
