package com.company;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int start, int end){
        int pivot = arr[start];
        int partition = partition(arr, start, end, pivot);
        if(start<partition-1)
            quickSort(arr, start, partition-1);

        if(partition<end)
            quickSort(arr, partition, end);
    }

    static int partition(int[] arr, int left, int right, int pivotValue){
        while(left<=right){
            while(arr[left]<pivotValue)
                left++;
            while(arr[right]>pivotValue)
                right--;

            if(left<=right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++; right--;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        //int[] arr = {1,19,2,77,32,1,3,8,8};
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
