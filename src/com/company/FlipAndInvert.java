package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

// learning: use xor to invert any bit
public class FlipAndInvert {
    public static int[][] flipAndInvertImage(int[][] A) {
      for(int num=0;num<A.length;num++) {
        int C = A[num].length;
        int[] row = A[num];
        for (int i = 0; i < (C + 1) / 2; ++i) {
          int tmp = row[i] ^ 1;
          row[i] = row[C - 1 - i] ^ 1;
          row[C - 1 - i] = tmp;
        }
      }
      return A;
    }

    @Test
    public void testSol(){
      int[][] A = new int[][]{{1,1,0},{0,1,0},{1,0,0}};
      int[][] B = flipAndInvertImage(A);
      for(int[] arr : B){
        System.out.println(Arrays.toString(arr));
      }
    }
}
