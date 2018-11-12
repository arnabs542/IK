package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromicDecomposition {
  /*
   * Complete the function below.
   */
  static String[] generate_palindromic_decompositions(String s) {
    return generate_palindromic_decompositions(s, 0);
  }

  static String[] generate_palindromic_decompositions(String s, int index) {
    for(int i=0;i<s.length();i++){

    }

    return null;
  }

  static boolean isPalindrone(String s){
    int start = 0;
    int end = s.length()-1;
    while(start<=end){
      if(s.charAt(start) != s.charAt(end))
        return false;
      start++; end--;
    }
    return true;
  }

  @Test
  public void testPal(){
    String word =  "nitin";
    assertTrue(isPalindrone(word));
  }
}
