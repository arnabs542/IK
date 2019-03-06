package google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class QuickSelect {
    int getRank(int[] arr, int k){
        return getRank(arr, arr.length-k, 0, arr.length-1);
    }
    int getRank(int[] arr, int k, int start, int end){
        int pi = partition(arr, start, end);
        if(pi==k-1) return arr[k-1];
        if(pi>k-1) return getRank(arr, k, start, pi-1);
        else     return getRank(arr, k, pi+1, end);
    }

    @Test
    public void test() {
        int[] arr = {3,2,1,5,6,4};
        assertEquals(4, getRank(arr, 2));
    }

    int partition(int arr[], int start, int end){
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

    public int findKthLargest(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition2(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }

}
