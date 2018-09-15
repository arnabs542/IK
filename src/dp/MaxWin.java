package dp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MaxWin {
    // Complete the maxWin function below.
    static int maxWin(int[] v) {
        return maxWin(v, 0, v.length-1, true);

    }

    static int p1Max = 0;
    static int p2Max = 0;
    static int maxWin(int[] v, int start, int end, boolean p1){
        if(start>=end)
            return 0;
        if(p1) {
            p1Max = Math.max(p1Max, v[start]);
            p1Max += maxWin(v, start+1, end, false);
        }
        else {
            p2Max = Math.max(p2Max, v[start + 1]);
            p2Max += maxWin(v, start+1, end, false);
        }

        return p1Max;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int vCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] v = new int[vCount];

        for (int i = 0; i < vCount; i++) {
            int vItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            v[i] = vItem;
        }

        int res = maxWin(v);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
