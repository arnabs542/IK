package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PlusOne {
  public int[] plusOne(int[] digits) {
    int carry = 0;
    digits[digits.length-1]++;
    for(int i=digits.length-1; i>=0; i--){
      int num = digits[i]+carry;
      carry = num/10;
      num = num%10;
      digits[i] = num;
    }
    if(carry==1){
      int[] result = new int[digits.length+1];
      result[0] = 1;
      for(int i=1; i<result.length;i++)
        result[i] = digits[i-1];
      return result;
    }
    return digits;
  }

  @Test
  public void test(){
    int[] expected = {1,0};
    int[] input = {9};
    assertArrayEquals(expected, plusOne(input));
  }
}
