package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatternMatch {
  public static boolean pattern_matcher(String s, String pattern){
    if(s.length()==0 && pattern.length()==0)
      return false;
    if(s.length()==0)
      return false;
    if(pattern.length()==0)
      return true;
    return matches(s, pattern, 0, 0, false);
  }

  private static boolean matches(String s, String pattern, int i, int j, boolean starred) {
    if(s.length()==i && (pattern.length()==j || (starred)))
      return true;

    if(i > s.length()-1 || j > pattern.length()-1 || (starred && j > pattern.length()-2)) {
      System.out.println("returning false for "+s+", p="+pattern+", i="+i+", j="+j);
      return false;

    }

    // Look ahead one char in pattern. If it has not been marked as starred, do so.
    if(j+1<pattern.length() && pattern.charAt(j+1)=='*' && !starred)
      return matches(s, pattern, i, j, true);

    System.out.printf("Comparing %s == %s, starred=%s, i=%d, j=%d, s=%s, p=%s \n", s.charAt(i), pattern.charAt(j), starred, i, j, s, pattern );
    if(s.charAt(i)==pattern.charAt(j) || pattern.charAt(j)=='.') {
      // if starred, 0 or more matches
      if(starred) {
        boolean zeroMatches = matches(s, pattern, i, j + 2, false);
        boolean moreMatches = matches(s, pattern, i + 1, j, true);
        return zeroMatches || moreMatches;
      }else
        return matches(s, pattern, i + 1, j + 1, false);
    }

    System.out.printf("Returning false: Comparing %s == %s, starred=%s, i=%d, j=%d, s=%s, p=%s \n", s.charAt(i), pattern.charAt(j), starred, i, j, s, pattern );
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
