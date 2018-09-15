package com.company.strings;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MinimizeWrites {
    /*
     * Complete the move_letters_to_left_side_with_minimizing_memory_writes function below.
     */
    static String move_letters_to_left_side_with_minimizing_memory_writes(String s) {
        /*
         * Write your code here.
         */
        char[] sc = s.toCharArray();
        int left=0, right=1;
        int n = sc.length;
        while(left<right && right<n){
            while(!isDigit(sc[left]))
                left++;
            right = left+1;
            while(right<n && isDigit(sc[right])){
                right++;
            }
            sc[left] = sc[right];
            left++; right++;
        }

        return new String(sc);
    }

    static boolean isDigit(char c){
        return c-'0'<10;
    }

    static void swap(char[] sc, int digit, int alpha){
        sc[digit] = sc[alpha];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String res = move_letters_to_left_side_with_minimizing_memory_writes(s);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
