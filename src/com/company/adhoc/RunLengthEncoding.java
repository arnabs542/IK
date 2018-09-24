package com.company.adhoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunLengthEncoding {
  static String RLE(String strinput) {
    char[] strChars = strinput.toCharArray();
    int anchor = 0;
    int write = 0;
    for(int read=0;read<strChars.length;read++){
      char currChar = strChars[read];
      if(read==strChars.length-1 || currChar != strChars[read+1]){

        if(read>anchor) {
          for(char c : ("" + (read - anchor + 1)).toCharArray())
          strChars[write++] = c;
        }

        strChars[write++] = currChar;
        anchor = read+1;
      }
    }

    return new String(strChars).substring(0, write);

  }

  @Test
  public void testRLE(){
    String[][] input = {{"AASHVII","2ASHV2I"},{"AAA","3A"},{"aa","2a"}};
    for(int i=0;i<input.length;i++) {
      assertEquals(input[i][1], RLE(input[i][0]));
    }

  }
}
