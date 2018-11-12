package dp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Scanner;

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
