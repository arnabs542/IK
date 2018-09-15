package recursion;

import java.util.Arrays;

public class PermutationAlternate{
    public static void main(String args[]){
        printPermsMain(new int[]{2,3,4,6});
    }

    public static void printPermsMain(int[] arr){
        printPerm(arr, 0);
    }

    static void printPerm(int[] arr, int i){
        if(i==arr.length-1) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for(int j=i; j<arr.length; j++){
            if(checkNumber(arr, i)){
                swap(arr, i, j);
                printPerm(arr, i+1);
                swap(arr, i, j);
            }
        }

    }

    static void swap(int[] arr, int n1, int n2){
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    static boolean checkNumber(int[] arr, int pos){
        if(pos%2==0 && arr[pos]%2==1)
            return true;
        if(pos%2==1 && arr[pos]%2==0)
            return true;

        return false;
    }
}
