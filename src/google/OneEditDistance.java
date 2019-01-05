package google;

import org.junit.jupiter.api.Test;

public class OneEditDistance {
  public boolean isOneEditDistance(String s, String t) {
    int sLen = s.length();
    int tLen = t.length();

    if(Math.abs(sLen-tLen)>1)
      return false;

    for(int i=0;i<Math.min(sLen, tLen); i++){
      if(s.charAt(i)!=t.charAt(i)){
        // If length is equal char need to be replaced
        if(sLen==tLen)
          return s.substring(i+1).equals(t.substring(i+1));
        if(sLen>tLen)
          return s.substring(i+1).equals(t.substring(i));
        else
          return s.substring(i).equals(t.substring(i+1));
      }
    }
    return Math.abs(sLen-tLen)==1;
  }

  @Test
  public void test(){
    String[] inputs = {"abc", "adc"};
    assert(isOneEditDistance(inputs[0], inputs[1]));

    String inputs2[] = {"abcd", "ab"};
    assert(isOneEditDistance(inputs2[0], inputs[1]));
  }
}
