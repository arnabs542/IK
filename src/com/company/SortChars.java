package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SortChars {

    /*
     * Complete the function below.
     */
    static String sortCharacters(String inString) {
        int[] asciis = new int[256];
        Arrays.fill(asciis, 0);
        char[] chars = inString.toCharArray();
        for(char c : chars){
            asciis[c] = asciis[c]+1;
        }

        int j = 0;
        for(int i=0; i<asciis.length;i++){
            int c = asciis[i];
            while(c-->0)
                chars[j++] = (char) i;
        }

        return new String(chars);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String res;
        String inString;
        try {
            inString = in.nextLine();
        } catch (Exception e) {
            inString = null;
        }

        res = sortCharacters(inString);
        bw.write(res);
        bw.newLine();

        bw.close();
    }
}
