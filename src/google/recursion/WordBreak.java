package google.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class WordBreak {

  // 3ms solution
  public boolean wordBreak3(String s, List<String> wordDict) {
    int max = 0;
    for(String str: wordDict)
      max = Math.max(max, str.length());


    Set<String> set = new HashSet<>(wordDict);
    boolean[] end = new boolean[s.length() + 1];
    end[0] = true;

    for(int i=1; i<=s.length(); i++) {
      for(int j=Math.max(0, i - max); j<i; j++) {
        if(end[j] && set.contains(s.substring(j, i))){
          end[i] = true;
          break;
        }
      }
    }

    return end[s.length()];
  }

  //6ms
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean dp[]=new boolean[s.length()+1];
    dp[0]=true;
    for(int i=1;i<=s.length();i++){
      for(int j=0;j<i;j++){
        System.out.println(String.format("j=%d, i=%d, substr=%s", j, i, s.substring(j, i)));
        if(dp[j] && wordDict.contains(s.substring(j,i))){
          dp[i]=true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  @Test
  public void test(){
    boolean expected = true;
    List<String> dict = Arrays.asList("apple","pen");
    String s = "applepenapple";
    assertEquals(expected, wordBreak(s, dict));
  }
}
