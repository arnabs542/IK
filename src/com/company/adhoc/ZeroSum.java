package com.company.adhoc;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZeroSum {
  // Complete the sumZero function below.
  static int[] sumZero(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    int total = 0;
    for(int i=0;i<arr.length;i++){
      total = total+arr[i];
      if(total==0)
        return new int[]{0,i};
      if(map.get(total)!=null)
        return new int[]{map.get(total)+1, i};
      if(arr[i]==0)
        return new int[]{i,i};

      map.put(total, i);

    }

    return new int[]{-1};
  }

  @Test
  public void testZeroSum(){
    int[] arr = {1,2,3,-1,-4,-1, 0};
    int[] result = sumZero(arr);
    int[] expected = {1,4};
    assertEquals(expected[0], result[0]);
    assertEquals(expected[1], result[1]);
  }

}
