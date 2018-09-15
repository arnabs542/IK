package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void subSetMain(char[] a){
        char[] s = new char[a.length];
        List<String> result = new ArrayList<>();
        subset(a, 0, s, 0, result);
        System.out.println(result);
    }

    public static void subset(char[] a, int i, char[] s, int j, List<String> result){
        if(i==a.length) {
            result.add(new String(s,0, j));
            return;
        }

        subset(a, i+1, s, j, result);
        s[j] = a[i];
        subset(a, i+1, s, j+1, result);
    }

    public static void main(String[] args) {
        subSetMain("tcdo".toCharArray());
    }
}
