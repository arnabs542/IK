package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SortOddEven {

    static int[] solve(int[] arr) {
        if(arr.length==0 || arr.length==1)
            return arr;
        int start=0;
        int end = arr.length-1;
        while(end>=0 && start<=end){
            while(arr[start]%2==0)
                start++;
            while(end>=0 && arr[end]%2==1)
                end--;

            if(start<=end){
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
        }

        return arr;

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] res;
        int arr_size = 0;
        arr_size = Integer.parseInt(in.nextLine().trim());

        int[] arr = new int[arr_size];
        for(int i = 0; i < arr_size; i++) {
            int arr_item;
            arr_item = Integer.parseInt(in.nextLine().trim());
            arr[i] = arr_item;
        }

        res = solve(arr);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }
}