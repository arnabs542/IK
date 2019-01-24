package google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSelect {
    static int getRank(int[] arr, int k, int start, int end){
        int pi = partition(arr, start, end);
        if(pi==k-1) return arr[k-1];
        if(pi>k-1) return getRank(arr, k, start, pi-1);
        else     return getRank(arr, k, pi+1, end);
    }

    @Test
    public void test() {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        assertEquals(4, getRank(arr, 6, 0, arr.length-1));
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
