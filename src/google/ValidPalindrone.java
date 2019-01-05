package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidPalindrone {
  public boolean isPalindrome(String s) {
    if(s.isEmpty())
      return true;

    int left = 0;
    int right = s.length()-1;
    while(left<=right){
      char leftChar = Character.toLowerCase(s.charAt(left));
      char rightChar = Character.toLowerCase(s.charAt(right));
      if( !Character.isLetterOrDigit(leftChar) ) {
        left++; continue;
      }
      if(!Character.isLetterOrDigit(rightChar)){
        right--; continue;
      }
      if(leftChar!=rightChar)
        return false;

      left++; right--;
    }

    return true;
  }

  // Best 1 ms
  private static final char[]charMap = new char[256];
  static{
    for(int i=0;i<10;i++){
      charMap[i+'0'] = (char)(1+i);  // numeric
    }
    for(int i=0;i<26;i++){
      charMap[i+'a'] = charMap[i+'A'] = (char)(11+i);  //alphabetic, ignore cases
    }
  }
  public boolean isPalindromeBest(String s) {
    char[]pChars = s.toCharArray();
    int start = 0,end=pChars.length-1;
    char cS,cE;
    while(start<end){
      cS = charMap[pChars[start]];
      cE = charMap[pChars[end]];
      if(cS!=0 && cE!=0){
        if(cS!=cE)return false;
        start++;
        end--;
      }else{
        if(cS==0)start++;
        if(cE==0)end--;
      }
    }
    return true;
  }

  @Test
  public void test(){
    String input = "A man, a plan, a canal: Panama";
    assertTrue(isPalindrome(input));

    String input2 = "aA";
    assertTrue(isPalindrome(input2));
  }
}
