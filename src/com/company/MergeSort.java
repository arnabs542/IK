package com.company;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int arr[], int start, int end){
        if(start>=end)
            return;
        int mid = start+(end-start)/2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end){
        int n1 = mid-start+1;
        int n2 = end-mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy contents to left and right array
        for(int i=start, count=0;i<=mid;i++){
            leftArr[count++] = arr[i];
        }
        for(int j=mid+1, count=0;j<=end;j++){
            rightArr[count++] = arr[j];
        }

        int i=0,j = 0, k=start;
        while(i<n1 && j<n2){
            if(leftArr[i]<=rightArr[j]){
                arr[k] = leftArr[i];
                k++; i++;
            }else{
                arr[k] = rightArr[j];
                k++; j++;
            }
        }

        // Copy left over elements
        while(i<n1){
            arr[k] = leftArr[i];
            k++; i++;
        }
        while(j<n2){
            arr[k] = rightArr[j];
            k++; j++;
        }
    }

    public static void main(String args[]){
        int[] arr = {1,10,23,1,3,4,2,33,42,22,11};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}