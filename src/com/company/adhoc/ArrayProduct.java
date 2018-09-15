package com.company.adhoc;

public class ArrayProduct {
    /*
     * Complete the getProductArray function below.
     */
    static int[] getProductArray2(int[] nums) {
        /*
         * Write your code here.
         */
        int total = 1;
        for(int i=1;i<nums.length;i++){
            total *= nums[i];
        }
        int[] out = new int[nums[0]];
        for(int i=1; i<nums.length; i++){
            out[i-1] = total/nums[i];
        }

        return out;

    }

    static int[] getProductArray(int[] nums) {
        int n = nums.length-1;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] product = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        // Fill all values in left array with the product of all numbers before that.
        for(int i=1; i<n;i++){
            left[i] = nums[i+1-1]*left[i-1];
        }

        // Fill all right values with product of all nums right to each index
        for(int i=n-2;i>=0;i--){
            right[i] = nums[i+1+1]*right[i+1];
        }

        for(int i=0;i<n;i++){
            product[i] = left[i] * right[i];
        }

        return product;
    }


    public static void main(String[] args) {
        int[] nums = {3,4,9,10};
        int[] productsArray = getProductArray(nums);
        for(int i=0;i<productsArray.length;i++){
            System.out.println(productsArray[i]);
        }
    }
}
