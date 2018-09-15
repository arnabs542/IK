package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
    static int getMinCoins(int target, int[] denoms){
        if(target==0)
            return 0;
        if(target<0)
            return Integer.MAX_VALUE;
        int minimum = Integer.MAX_VALUE;
        for(int i=0;i<denoms.length; i++){
            int num = getMinCoins(target-denoms[i], denoms);
            minimum = 1+Math.min(minimum, num);
        }
        return minimum;
    }

    static int getMinCoinsDP(int target, int[] d){
        int[] table = new int[target+1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;
        for(int a=1 ; a<table.length;a++){
            for(int i=0;i<d.length;i++){
                if(a >= d[i])
                    table[a] = Math.min(table[a-d[i]], table[a]);
            }

            if(table[a] != Integer.MAX_VALUE)
                table[a] = table[a]+1;
        }

        return table[target];
    }

    static Integer[] getMinCoinsShapeDP(int target, int[] d){
        int[] table = new int[target+1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;
        List<Integer> result = new ArrayList<>();
        for(int a=1 ; a<table.length;a++){
            for(int i=0;i<d.length;i++){
                if(a >= d[i]) {
                    table[a] = Math.min(table[a - d[i]], table[a]);
                    if(a==table.length-1) result.add(d[i]);
                }
            }

            if(table[a] != Integer.MAX_VALUE)
                table[a] = table[a]+1;
        }

        return result.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        System.out.println(getMinCoinsDP(10, new int[]{3,5,6}));
        System.out.println(Arrays.toString(getMinCoinsShapeDP(10, new int[]{3,5,6})));
    }
}
