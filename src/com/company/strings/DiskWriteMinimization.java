package com.company.strings;

import java.util.Scanner;

/**
 * Created by hitarth.k on 10/06/18.
 */
public class DiskWriteMinimization {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] a = s.toCharArray();
        int op = transform(a);
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]);
        }
        System.out.println();
        System.out.println(op);
    }

    public static boolean isDigit(char x) {
        return x - '0' >= 0 && x - '0' <= 9;
    }

    public static char read(char[] a, int pos) {
        return a[pos];
    }

    public static void write(char[] a, int pos, char val) {
        a[pos] = val;
    }

    public static int transform(char[] a) {
        int readPointer = 0;
        int writePointer = 0;
        int operations = 0;
        for (; readPointer < a.length; readPointer++) {
            char c = read(a, readPointer);
            if (!isDigit(c)) {
                char cw = read(a, writePointer);
                if (c != cw) {
                    write(a, writePointer, c);
                    operations++;
                }
                writePointer++;
            }
        }
        return operations;
    }
}
//a0b
