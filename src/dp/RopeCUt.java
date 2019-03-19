package dp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Scanner;
/*
Cut The Rope



Problem Statement:



Given a rope with length n, find the maximum value maxProduct, that can be achieved for product len[0] * len[1] * ... * len[m - 1], where len[] is the array of lengths obtained by cutting the given rope into m parts.



Note that

there should be atleast one cut, i.e. m >= 2.
All m parts obtained after cut should have non-zero integer valued lengths.


Input/Output Format For The Function:



Input Format:



There is only one argument, an integer denoting n.



Output Format:



Return a number maxProduct, denoting maximum possible product as asked in the problem.



Input/Output Format For The Custom Input:



Input Format:



There should be only one line, containing an integer n, denoting length of rope.



If n = 5, then input should be:



5



Output Format:



There will be one line, containing an integer maxProduct.



For input n = 5, output will be:



6



Constraints:

2 <= n <= 111
We have to cut at least once. (2 <= m).
Length of the rope, as well as the length of each part are in positive integer value. (i.e. can't do partial cuts.)


Sample Test Case:



Sample Input:



4



Sample Output:



4



Explanation:

For n = 4, there are two cuts possible: 1 + 3 and 2 + 2.

We'll pick 2 + 2, because their product 2 * 2 = 4 is greater than product of the first one 1 * 3 = 3.

(So our m = 2, n[0] = 2 and n[1] = 2 and product is n[0] * n[1] = 4.)


 */
    public class RopeCUt {
        /*
         * Complete the max_product_from_cut_pieces function below.
         */
        static long max_product_from_cut_pieces(int n) {
            /*
             * Write your code here.
             */
            int[] dp = new int[n+1];
            dp[2] = 2;
            dp[3] = 3;
            for(int i=4;i<=n;i++){
                int max = 0;
                for(int j=1; j<i; j++){
                    int value = dp[i-j] * j;
                    max = value > max ? value : max;
                }

                dp[i] = max;
            }

            return dp[n];

        }

        static long maxProductFromCut(List<Integer> prices, int n){
            long maxSum = Integer.MIN_VALUE;
            if(n==0)
                return 0;
            long result = prices.get(n);
            for(int i=1; i < n; i++){
                result = Math.max(result, prices.get(i)+maxProductFromCut(prices, n-i));
            }

            return result;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(scanner.nextLine().trim());

            long res = max_product_from_cut_pieces(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();

            bufferedWriter.close();
        }

}
