package google.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class NumberOfSubstrings {
  Set<String> set = new HashSet<>();

  public int numSub(String s){
    return numSub(s, 0, s.length()-1);
  }

  public int numSub(String s, int i, int j){
    System.out.println(s.substring(i, j+1));

    if(set.contains(s.substring(i, j+1)))
      return 0;
    if(i==j){
      set.add(s.substring(i, j+1));
      return 1;
    }

    return 1+numSub(s, i+1, j) + numSub(s, i, j-1);
  }

  @Test
  public void test(){
    int expected = 24;
    String s = "abcd";
    assertEquals(expected, numSub(s));
  }

}
