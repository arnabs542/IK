package com.company;

public class IsSubset {
    public static boolean isSubset(int[] a, int[] b, int m, int n){
        int i=0,j=0,matches = 0;
        while(i<m && j<n){
            if(a[i] == b[j]){
                i++; j++; matches++;
            }else if(a[i] < b[j])
                i++;
            else
                j++;
        }

        return matches==Math.min(m,n);
    }

    public static void main(String[] args) {
        int[] arr1 = {100,200,300};
        int[] arr2 = {1,2,3,4,100,200,201,300,400};
        System.out.println(isSubset(arr1, arr2, arr1.length, arr2.length));
    }
}
