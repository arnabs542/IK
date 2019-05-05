package Strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WildcardMatching {
  public boolean isMatch(String s, String p, int i, int j){
    if((i==s.length() && j==p.length()) || (i==s.length() && j==p.length()-1 && p.charAt(j)=='*')){
      System.out.println("both same");
      return true;
    }
    if(i==s.length() || j==p.length()){
      System.out.println("both not same");
      return false;
    }

    if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
      return isMatch(s, p, i+1, j+1);

    if(p.charAt(j)=='*')
      return isMatch(s, p, i+1, j) || isMatch(s, p, i, j+1);

    return false;
  }

  public boolean isMatch(String s, String p) {
    return isMatch(s, p , 0, 0);
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  public void test(String s, String p, boolean expected){
    assertEquals(expected, isMatch(s, p));
  }

  public static Stream<Arguments> getArgs(){
    return Stream.of(
        Arguments.of("aa","*", true)
//        Arguments.of("aa",".*", true),
//        Arguments.of("","a*", true),
//        Arguments.of("","c*c*", true),
//        Arguments.of("aaaa","aaa", false)
    );
  }

}
