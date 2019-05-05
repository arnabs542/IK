package Strings;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class Anagrams {
  public List<Integer> findAnagrams(String s, String p) {
    int[] map = new int[26];
    int count = p.length();
    List<Integer> result = new ArrayList<>();

    for(char c : p.toCharArray())
      map[c-'a']++;

    for(int i=0, j=0; j<s.length();){
      if(map[s.charAt(j++)-'a']-- >= 1)
        count--;

      while(count==0){
        if(j-i==p.length())
          result.add(i);
        if(map[s.charAt(i++)-'a']++ == 0)
          count++;
      }

    }

    return result;
  }
}
