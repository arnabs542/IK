package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatternMatching {
  public static boolean pattern_matcher(String s, String pattern){
    if(s.length()==0 && pattern.length()==0)
      return false;
    if(s.length()==0)
      return false;
    if(pattern.length()==0)
      return true;
    return matches(s, pattern, 0, 0);
  }

  /*
  abbc
  ac*b*c
  p[j]==s[i] continue to next;
  p[j]==* &&
    p[j-1]==s[i] continue; then continue until we get the previous character. Match previous character p(j-1)
  p[j]==. && p[j-1]==
   */
  private static boolean matches(String s, String p, int i, int j){
    if(i==s.length() && j==p.length())
      return true;

    if(i==s.length()){
      if(p.charAt(j)=='*')
        return true;
      return false;
    }

    if(j==p.length())
      return false;

    if(j==p.length()-1){
      if (p.charAt(j)=='*')
        if(s.charAt(i)==p.charAt(j-1))
          return true;
        else
          return false;
    }

    if(s.charAt(i)==p.charAt(j))
      return matches(s, p, i+1, j+1);

    if(p.charAt(j)=='*'){
      if(p.charAt(j-1)=='.')
        return matches(s, p, i+1, j);
      else{
        if(s.charAt(i)==p.charAt(j-1))
          return matches(s,p, i+1, j);
        return matches(s,p, i, j+1);
      }
    }

    if(p.charAt(j)=='.')
      return matches(s, p, i+1, j+1);

    return false;
  }

  public String[][] getData(){
    String[][] data = new String[][]{{"abcd","a*", "false"}, {"aa","a*","true"},{"abcd","a*..d","true"},
        {"aaa",".a*..", "true"}, {"abcde","....", "false"}, {"aaa",".*b", "false"}};
    return data;
  }

  @Test
  public void testPattern(){
    for(String[] data : getData()){
      boolean expected = data[2]=="true";
      assertEquals(expected, pattern_matcher(data[0], data[1]) , String.format("checking %s:%s",data[0],data[1]));
    }
  }
}
