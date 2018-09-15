package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void queensMain(int size){
        int[] queensArr = new int[size];
        Arrays.fill(queensArr, -1);
        if(isNQueen(queensArr, 0))
            System.out.println("array s "+Arrays.toString(queensArr));

    }

    public static boolean isNQueen(int[] qArr, int row) {
        if (row == qArr.length)
            return true;
        List<int[]> solutions = new ArrayList<>();
        for (int col = 0; col < qArr.length; col++){
            if(isPosValid(qArr, row, col) && isNQueen(qArr, row + 1)){
                solutions.add(Arrays.copyOf(qArr, qArr.length));
            }else
                Arrays.fill(qArr, -1);

        }

        if(solutions.size()>1){
            System.out.println(solutions);
            return true;
        }

        return false;
    }

    private static boolean isPosValid(int[] qArr, int currRow, int col) {
        for(int row=0;row<currRow;row++){
            if(qArr[row]==col)
                return false;
            int slope = (col-qArr[row])/(currRow-row);
            if(Math.abs(slope)==1)
                return false;
        }
        qArr[currRow] = col;
        return true;
    }

    public static void main(String[] args) {
        queensMain(4);
    }
}
