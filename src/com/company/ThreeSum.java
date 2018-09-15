package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class ThreeSum {
    private static final Scanner scan = new Scanner(System.in);

    /*
     * Complete the function below.
     */
    static String[] findZeroSum(int[] arr) {
        // Write your code here.
        Arrays.sort(arr);
        Set<String> matchSet = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            int first = arr[i];
            int remainingSum = -1*first;
            int start = i+1;
            int end = arr.length-1;

            while(start<end){
                int sum = arr[start] + arr[end];
                if(sum==remainingSum){
                    String matched = first+","+arr[start]+","+arr[end];
                    if(!matchSet.contains(matched))
                        matchSet.add(matched);
                }
                if(sum<remainingSum)
                    start++;
                else
                    end--;
            }
        }

        return matchSet.toArray(new String[0]);

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrSize = Integer.parseInt(scan.nextLine().trim());

        int[] arr = new int[arrSize];

        for (int arrItr = 0; arrItr < arrSize; arrItr++) {
            int arrItem = Integer.parseInt(scan.nextLine().trim());
            arr[arrItr] = arrItem;

        }

        String[] res = findZeroSum(arr);

        for (int resItr = 0; resItr < res.length; resItr++) {
            bw.write(res[resItr]);

            if (resItr != res.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}
