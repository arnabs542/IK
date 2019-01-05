package com.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddBinaryStrings {
  public String addBinary(String a, String b) {
    char[] aArr = a.toCharArray();
    char[] bArr = b.toCharArray();
    int m = aArr.length-1;
    int n = bArr.length-1;
    int carry = 0;
    char[] result = new char[m>n ? m+1:n+1];
    int k = result.length-1;
    while(k>=0 || m>=0 || n>=0 ){
      int ai = m>=0 ? aArr[m--] - '0' == 0 ? 0 : 1 : 0;
      int bi = n>=0 ? bArr[n--] - '0' == 0 ? 0 : 1 : 0;
      int ci = (ai+bi+carry)%2;
      carry = (ai+bi+carry)/2;
      result[k--] = (char)ci;
    }

    if(carry==1){
      char[] newResult = new char[result.length+1];
      newResult[0] = 1;
      for(int i=0;i<result.length;i++)
        newResult[i+1] = result[i];

      result = newResult;
    }
    return String.valueOf(result);
  }

  @Test
  public void testBinary(){
    String expected = "100";
    assertEquals(expected, addBinary("10","10"));
  }
}
