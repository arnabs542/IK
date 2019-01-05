package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
 *
 * For example, with A = "abcd" and B = "cdabcdab".
 *
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 *
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {
  public int repeatedStringMatchBkup(String A, String B) {
    int aLen = A.length();
    int bLen = B.length();
    int times = bLen/aLen +1 ;

    for(int i=times-1;i<=times; i++){
      StringBuffer newA = new StringBuffer(A);
      for(int j=1;j<i; j++){
        newA.append(A);
      }
      if(newA.toString().indexOf(B)!=-1)
        return i;
    }

    return -1;
  }

  public int repeatedStringMatch(String A, String B) {
    StringBuilder S = new StringBuilder(A);
    int q = 1;
    for(;S.length() < B.length();q++)
      S.append(A);
    if(S.indexOf(B)>=0) return q;
    if(S.append(A).indexOf(B) >= 0) return q+1;

    return -1;
  }

  @Test
  public void test(){
    String[] inputs = {"abcd","cdabcdab"};
    int expected = 3;
    assertEquals(expected, repeatedStringMatch(inputs[0], inputs[1]));
  }
}
