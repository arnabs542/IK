package recursion;

public class Permutation {
    public static void main(String[] args) {
        Permutation perm = new Permutation();
        String input = "abcd";
        perm.permuteMain(input.toCharArray());
    }
    void permuteMain(char[] arr){
        permute(arr, 0);
        System.out.println(total);
    }
    int total = 0;
    void permute(char[] arr, int i){
        if(i==arr.length-1) {
            total++;
            System.out.println(arr);
            return;
        }

        for(int j=i; j<arr.length; j++) {
            swap(arr, i, j);
            permute(arr, i+1);
            swap(arr, j, i);
        }
    }

    void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
