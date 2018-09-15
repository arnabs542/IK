package dp;

import java.util.Arrays;

public class EditDistance {
    /*
     * Complete the levenshteinDistance function below.
     */

    public static void main(String[] args) {
        System.out.println(ed("pizza".toCharArray(), "yolo".toCharArray()));
        System.out.println(ed2("pizza".toCharArray(), "yolo".toCharArray(), 0, 0));
    }

    static int ed(char[] s1, char[] s2){
        int[][] table = new int[s1.length+1][s2.length+1];
        for(int i=0;i<=s1.length;i++){
            for(int j=0;j<=s2.length;j++){
                if(i==0) {
                    table[i][j] = j;
                    continue;
                }
                if(j==0){
                    table[i][j] = i;
                    continue;
                }
                int result = Integer.MAX_VALUE;
                if(s1[i-1]==s2[j-1]) {
                    table[i][j] = Math.min(result, table[i - 1][j - 1]);
                    continue;
                }
                // Delete
                result = Math.min(result, table[i-1][j]);
                // Add
                result = Math.min(result, table[i][j-1]);
                // Replace
                result = Math.min(result, table[i-1][j-1]);

                table[i][j] = result+1;
            }
        }

        return table[s1.length][s2.length];
    }

    static int ed2(char[] s1, char[] s2, int i, int j){
        if(i==s1.length && j==s2.length)
            return 0;

        if(i==s1.length)
            return s2.length-j;
        if(j==s2.length)
            return s1.length-i;

        int result = Integer.MAX_VALUE;
        if(s1[i]==s2[j])
            result = Math.min(result, ed2(s1, s2, i+1, j+1));
        // Delete
        result = Math.min(result, 1+ed2(s1, s2, i+1, j));
        // Add
        result = Math.min(result, 1+ed2(s1,s2, i, j+1));
        // Replace
        result = Math.min(result, 1+ed2(s1, s2, i+1, j+1));

        return result;

    }
}
