package com.company;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class DutchFLag {
    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the dutch_flag_sort function below.
     */
    static String dutch_flag_sort(String balls) {
        /*
         * Write your code here.
         */
        char[] arr = balls.toCharArray();
        int redPointer = 0;
        int bluePointer = arr.length-1;
        int current = 0;
        while(current<=bluePointer ){
            if(arr[current]=='R'){
                swap(arr, redPointer, current);
                current++;
                redPointer++;
            }
            else if(arr[current]=='B'){
                swap(arr, bluePointer, current);
                bluePointer--;
            }
            else
                current++;
        }

        return new String(arr);
    }

    static void swap(char[] arr, int p1, int p2){
        char temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    static void partition(char[] balls, int start, int end, char pivot){
        while(start<=end){
            while(balls[start]>pivot)
                start++;
            while(balls[end]<pivot)
                end--;
            if(start<=end){
                int temp = balls[start];
                balls[start] = balls[end];
                balls[end] = (char)temp;
                start++; end--;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String balls = scanner.nextLine();

        String res = dutch_flag_sort(balls);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
