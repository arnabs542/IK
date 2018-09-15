package com.company;

public class QuickSelect {
    static int getRank(int[] arr, int k, int start, int end){
        int pi = partition(arr, start, end);
        if(pi==k-1) return arr[k-1];
        if(pi>k-1) return getRank(arr, k, start, pi-1);
        else     return getRank(arr, k, pi+1, end);
    }

    public static void main(String[] args) {
        int[] arr = {10,2,3,4,19,33};
        System.out.println(getRank(arr, 3, 0, arr.length-1));
    }

    static int partition(int arr[], int start, int end){
        int pivot = arr[start];
        while(start<=end){
            while(arr[start] < pivot)
                start++;
            while(arr[end] > pivot)
                end--;

            if(start<=end){
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                start++; end--;
            }
        }

        return start;
    }

}
