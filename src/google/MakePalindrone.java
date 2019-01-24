package google;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MakePalindrone {
  public String shortestPalindrome(String s) {
    char[] sc = s.toCharArray();
    List<Character> list = new ArrayList<>();
    int left = 0;
    int right = sc.length-1;
    while(left<right){
      if(sc[left]==sc[right]){
        left++; right--;
      }else{
        list.add(sc[right]);
        right--;
      }
    }
    char[] pal = new char[sc.length+list.size()];
    int i=0;
    for(char lc : list)
      pal[i++] = lc;

    for(int j=i;j<i+sc.length;j++)
      pal[j] = sc[j-i];

    return new String(pal);
  }

  @Test
  public void test(){
    String input = "aaacecaaaa";
    String expected = "aaaacecaaaa";
    assertEquals(expected, shortestPalindrome(input));
  }
}
