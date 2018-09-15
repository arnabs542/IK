package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    static String[] generate_all_subsets(String s){
        List<String> result = subset(s, 0);
        return result.toArray(new String[0]);
    }

    static List<String> subset(String arr, int i){
        if(i==arr.length()) {
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }

        char firstChar = arr.charAt(i);
        List<String> restSubset = subset(arr, i+1);
        List<String> newList = new ArrayList<>();
        for(String subSet : restSubset){
            String newSet = firstChar+subSet;
            newList.add(newSet);
        }
        restSubset.addAll(newList);

        return restSubset;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(generate_all_subsets("Atul")));
    }
}
